package db;
import models.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class DBManager {
    private static ArrayList<Employee> employees = new ArrayList<>();

    static{
        employees.add(new Employee("Dean","Winchester", 1000000, "Monster hunt"));
        employees.add(new Employee("Sam","Winchester", 1000000, "Monster hunt"));
    }

    public static ArrayList<Employee> getEmployees(){
        return employees;
    }
}
