package employee;

public class Employee {
//    id, tên, tuổi, giới tính
    private int id;
    private String name;
    private int age;
    private String gender;

    public Employee(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
