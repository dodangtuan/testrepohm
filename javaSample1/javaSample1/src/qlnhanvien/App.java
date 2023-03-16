package qlnhanvien;

import qlnhanvien.Services.EmployeeService;

import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Sửa thành menu

        EmployeeService es = new EmployeeService();

        boolean cond = true;
        do {
            System.out.println("                                           ");
            System.out.println("***✿ ❀ ❁  QUAN LY NGUOI DUNG ✿ ❀ ❁ ***:");
            System.out.println("1. Hien thi danh sach.");
            System.out.println("2. Them nguoi dung moi.");
            System.out.println("3. Thêm nhiều nguoi dung.");
            System.out.println("4. Xoa nguoi dung.");
            System.out.println("5. Sửa thông tin theo id.");
            System.out.println("6. Lấy thông tin theo id.");
            System.out.println("7. Thoat chuong trinh.");
            System.out.println("===========================");
            System.out.print("Mời nhập lựa chọn : ");

            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    es.showAll();
                    break;
                case 2:
                    es.insert();
                    break;
                case 3:
                    es.insertnhieu();
                    break;
                case 4:
                    es.delete();
                    break;
                case 5:
                    es.update();
                    break;
                case 6:
                    es.showById();
                    break;
                case 7:
                    System.out.println("Dung chuong trinh");
                    System.exit(0);
                    cond = false;
                    break;

            }
        } while (cond);
    }
}