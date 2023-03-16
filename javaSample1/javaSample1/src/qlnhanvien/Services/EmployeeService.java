package qlnhanvien.Services;

import qlnhanvien.DAO.EmployeeDAO;
import qlnhanvien.Model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public EmployeeDAO employeeDAO;
    public static Scanner sc = new Scanner(System.in);
    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    public void insert() {
        List<Employee> employees = new ArrayList<>();
        System.out.println("Fullname: ");
        String fullName = sc.nextLine();
        System.out.println("Address: ");
        String address = sc.nextLine();
        System.out.println("Salary: ");
        Double salary = Double.parseDouble(sc.nextLine());
        System.out.println("Age: ");
        Integer age = Integer.parseInt(sc.nextLine());
        System.out.println("Gender: ");
        String gender = sc.nextLine();
        Employee e = new Employee(fullName,address,salary,age,gender);
        employees.add(e);
        employeeDAO.insert(employees);
    }


    public void insertnhieu() {
        System.out.print("Nhập n số lượng nhân viên cần nhập : ");
        int n = Integer.parseInt(sc.nextLine());
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            System.out.print("Fullname: ");
            String fullName = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = Double.parseDouble(sc.nextLine());
            System.out.print("Age: ");
            Integer age = Integer.parseInt(sc.nextLine());
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            Employee e = new Employee(fullName,address,salary,age,gender);
            employees.add(e);
        }
        employeeDAO.insert(employees);
    }
    public void showAll() {
            List<Employee> ls = employeeDAO.showAll();
            for (Employee item : ls) {
                System.out.println(item.toString());
            }
    }

    public void showById() {
        System.out.print("Nhap ma nhan vien: ");
        Integer id = Integer.parseInt(sc.nextLine());
        Employee e = employeeDAO.showById(id);
        if (e == null) {
            System.out.println("Khong ton tai nhan vien co ma " + id);
            return;
        }

        System.out.println(e.toString());
    }

    public void update() {
        System.out.print("Nhap ma nhan vien cần update : ");
        Integer id = Integer.parseInt(sc.nextLine());

        Employee e = employeeDAO.showById(id);
        if (e == null) {
            System.out.println("Khong ton tai nhan vien co ma " + id);
            return;
        }

        // Display the existing employee's information
        System.out.println("Thong tin nhan vien co ma " + id + ":");
        System.out.println(e.toString());

        System.out.println("Nhap lua chon: ");
        boolean cond = true;
        do {
            System.out.println("1. Fullname.");
            System.out.println("2. Address.");
            System.out.println("3. Age.");
            System.out.println("4. Gender.");
            System.out.println("5. Exit.");
            int choice;
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Fullname: ");
                    String fullName = sc.nextLine();
                    e.setFullName(fullName);
                    break;
                case 2:
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    e.setAddress(address);
                    break;
                case 3:
                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    e.setAge(age);
                    break;
                case 4:
                    System.out.print("Gender: ");
                    String gender = sc.nextLine();
                    e.setGender(gender);
                    break;
                case 5:
                    System.out.println("Exit.");
                    cond = false;
                    break;
                default:
                    System.out.println("Re-enter your choice.");
                    break;
            }

        } while (cond == true);

        Employee rs = employeeDAO.update(id, e);
        System.out.println(rs.toString());
    }
    public void delete() {
        System.out.print("Nhap ma nhan vien cần xóa : ");
        Integer id = Integer.parseInt(sc.nextLine());
        Employee e = employeeDAO.delete(id);

        //Bước 1: Nhập mã nhân viên
        //Bước 2: Gọi đến phương thức xóa trong EmployeeDAO
    }

    //Thêm các phương thức còn lại.
}
