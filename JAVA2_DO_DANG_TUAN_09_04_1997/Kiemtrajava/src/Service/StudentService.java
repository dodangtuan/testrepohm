package Service;

import DAO.StudentDAO;
import Model.Student;

import java.util.*;

public class StudentService {
    public StudentDAO studentDAO;
    public static Scanner sc = new Scanner(System.in);

    public StudentService() {
        studentDAO = new StudentDAO();
    }


    public void showAll() {
        List<Student> ls = studentDAO.showAll();
        for (Student item : ls) {
            System.out.println(item.toString());
        }
    }

    public void insert() {
        List<Student> students = new ArrayList<>();
        System.out.print("Name: ");
        String stdname = sc.nextLine();
        System.out.print("Age: ");
        Integer stdage = Integer.parseInt(sc.nextLine());
        System.out.print("Class: ");
        String stdclass = sc.nextLine();
        System.out.print("GPA: ");
        Double stdgpa = Double.parseDouble(sc.nextLine());
        System.out.print("Gender: ");
        String stdgender = sc.nextLine();
        Student s = new Student(stdname, stdage, stdclass, stdgpa, stdgender);
        students.add(s);
        studentDAO.insert(students);
    }


    public void showById() {
        System.out.print("Nhap ma sinh vien: ");
        Integer id = Integer.parseInt(sc.nextLine());
        Student std = studentDAO.showById(id);
        if (std == null) {
            System.out.println("Khong ton tai nhan vien co ma " + id);
            return;
        }

        System.out.println(std.toString());
    }


    public void update() {
        System.out.print("Nhap ma sinh vien can cap nhat : ");
        Integer id = Integer.parseInt(sc.nextLine());

        Student std = studentDAO.showById(id);
        if (std == null) {
            System.out.println("Khong ton tai sinh vien co ma " + id);
            return;
        }

        // nếu sinh viên không tồn tại trong database
        System.out.println("Thong tin sinh vien co ma " + id + ":");
        System.out.println(std.toString());

        System.out.println("Nhap lua chon: ");
        boolean cond = true;
        do {
            System.out.println("1. Name.");
            System.out.println("2. Age.");
            System.out.println("3. Class.");
            System.out.println("4. Gpa.");
            System.out.println("5. Gender.");
            System.out.println("6. Exit.");
            int choice;
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String stdname = sc.nextLine();
                    std.setStdName(stdname);
                    break;
                case 2:
                    System.out.print("Age: ");
                    int stdage = Integer.parseInt(sc.nextLine());
                    std.setStdAge(stdage);
                    ;
                    break;
                case 3:
                    System.out.print("Class: ");
                    String stdclass = sc.nextLine();
                    std.setStdClass(stdclass);
                    break;
                case 4:
                    System.out.print("Gpa: ");
                    Double stdgpa = sc.nextDouble();
                    std.setStdGPA(stdgpa);
                    break;
                case 5:
                    System.out.print("Gender: ");
                    String stdgender = sc.nextLine();
                    std.setStdGender(stdgender);
                    break;
                case 6:
                    System.out.println("Exit.");
                    cond = false;
                    break;
                default:
                    System.out.println("Re-enter your choice.");
                    break;
            }

        } while (cond == true);

        Student rs = studentDAO.update(id, std);
        System.out.println(rs.toString());
    }

    public void delete() {
        System.out.print("Nhap ma sinh vien can xoa : ");
        Integer id = Integer.parseInt(sc.nextLine());
        Student std = studentDAO.delete(id);
    }


    public void showByName() {
        System.out.print("Nhap ten sinh vien can tim kiem: ");
        String name = sc.nextLine();
        Student std = studentDAO.showByName(name);
        if (std == null) {
            System.out.println("Khong ton tai sinh vien ten la: " + name);
            return;
        }

        System.out.println(std.toString());
    }

    public void showGPAhight8() {
        List<Student> ls = studentDAO.showGPAhight8();
        if (ls.isEmpty()) {
            System.out.println("Khong co sinh vien nao GPA cao hon 8 .");
        } else {
            for (Student item : ls) {
                System.out.println(item.toString());
            }
        }
    }

    public void showSortedByGPA() {
        List<Student> students = studentDAO.showAll();
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return Double.compare(s1.getStdGPA(), s2.getStdGPA());
                }
            });
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }



//    public void showStudentsByGPAAndClass() {
//        List<Student> ls = studentDAO.findStudentsByGPAAndClass(8 ,"D01");
//        if (ls.isEmpty()) {
//            System.out.println("Khong co sinh vien nao GPA cao hon 8 .");
//        } else {
//            for (Student item : ls) {
//                System.out.println(item.toString());
//            }
//        }
//    }
}

