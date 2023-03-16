package qlnhanvien.Model;

public class Employee {
    private int id;
    private String fullName;
    private String address;
    private double salary;
    private int age;
    private String gender;

    public Employee(String fullName, String address, double salary, int age, String gender) {
        this.fullName = fullName;
        this.address = address;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
    }
    public Employee(int id, String fullName, String address, double salary, int age, String gender) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

