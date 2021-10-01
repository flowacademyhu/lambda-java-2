package hu.flowacademy.lambda._11_patterns.adapter;

import java.time.LocalDate;

public interface Employee {
    int getEmployeeId();

    String getName();

    LocalDate getDateOfBirth();
}
