package hu.flowacademy.lambda._11_patterns.adapter;

import java.time.LocalDate;
import java.time.ZoneId;

public class StudentToEmployeeAdapter implements Employee {

    private final Student student;

    public StudentToEmployeeAdapter(Student student) {
        this.student =student;
    }

    @Override
    public int getEmployeeId() {
        return student.getRollNumber();
    }

    @Override
    public String getName() {
        return student.getName();
    }

    @Override
    public LocalDate getDateOfBirth() {
        return student.getDob()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
