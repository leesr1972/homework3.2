package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Student;

import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private Long lastIdOfStudent = 1L;

    public Student addStudent(Student student) {
        student.setId(++lastIdOfStudent);
        students.put(lastIdOfStudent, student);
        return student;
    }

    public Student findStudent(Long id) {
        if (students.containsKey(id)) {
            return students.get(id);
        }
        return null;
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id) {
        if (students.containsKey(id)) {
            return students.remove(id);
        }
        return null;
    }

    public Collection<Student> getStudentsByAge(int age) {
        return students.values().stream().
                filter(e -> e.getAge() == age).toList();
    }
}
