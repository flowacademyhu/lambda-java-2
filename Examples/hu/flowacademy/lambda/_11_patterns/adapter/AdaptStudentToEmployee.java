package hu.flowacademy.lambda._11_patterns.adapter;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class AdaptStudentToEmployee {

    public static void main(String[] args) {
        Employee employee = new EmployeeImpl(114, "Mr. Anderson",
                LocalDate.of(1999, Month.AUGUST, 5));
        printEmployeeData(employee);

        Student student = new Student();
        student.setDob(new Date(2000, 0, 9));
        student.setName("Malcolm Wilkerson");
        student.setRollNumber(2344);
        printEmployeeData(new StudentToEmployeeAdapter(student));

    }

    private static void printEmployeeData(Employee employee) {
        System.out.println("ID: " + employee.getEmployeeId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Date of birth: " + employee.getDateOfBirth());
    }

}
