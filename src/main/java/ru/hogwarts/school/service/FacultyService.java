package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Faculty;

import java.util.Collection;
import java.util.HashMap;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastIdOfFaculty = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++lastIdOfFaculty);
        faculties.put(lastIdOfFaculty, faculty);
        return faculty;
    }

    public Faculty findFaculty (long id){
        if (faculties.containsKey(id)) {
            return faculties.get(id);
        }
        return null;
    }

    public Faculty editFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty (long id){
        if (faculties.containsKey(id)) {
            return faculties.remove(id);
        }
        return null;
    }

    public Collection<Faculty> getFacultiesByColor(String color) {
        return faculties.values().stream().
                filter(e -> e.getColor().equals(color)).toList();
    }
}
