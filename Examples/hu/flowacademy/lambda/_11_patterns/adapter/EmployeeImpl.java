package hu.flowacademy.lambda._11_patterns.adapter;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeImpl implements Employee {
    private int employeeId;
    private String name;
    private LocalDate dateOfBirth;

    public EmployeeImpl(int employeeId, String name, LocalDate dateOfBirth) {
        this.employeeId = employeeId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
