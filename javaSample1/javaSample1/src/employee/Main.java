package employee;

import java.util.ArrayList;
import java.util.List;
import static employee.EmployeePredicate.isMoreThan21AndMale;
import static employee.EmployeePredicate.isMoreThanAge;
import static employee.EmployeePredicate.getEmployee;

public class Main {
    public static void main(String[] args) {
        List<Employee> ls = new ArrayList<Employee>();
        ls.add(new Employee(1, "A", 19, "Male"));
        ls.add(new Employee(2, "B", 18, "Male"));
        ls.add(new Employee(3, "C", 22, "Male"));
        ls.add(new Employee(4, "D", 23, "FeMale"));
        ls.add(new Employee(5, "E", 20, "Male"));
        ls.add(new Employee(6, "F", 25, "FeMale"));
        ls.add(new Employee(7, "G", 24, "Male"));
        ls.add(new Employee(8, "H", 27, "FeMale"));
        System.out.println(getEmployee(ls, isMoreThan21AndMale()));
        System.out.println(getEmployee(ls, isMoreThanAge(19)));
    }
}
