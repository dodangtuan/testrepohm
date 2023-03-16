package employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicate {
    public static Predicate<Employee> isMoreThan21AndMale() {
        return e->e.getAge() > 21 && e.getGender().equalsIgnoreCase("Male");
    }

    public static Predicate<Employee> isMoreThanAge(int age) {
        return e->e.getAge() > age;
    }

    public static List<Employee> getEmployee(List<Employee> employees, Predicate<Employee> pre) {
        return employees.stream().filter(pre).collect(Collectors.toList());
    }
}
