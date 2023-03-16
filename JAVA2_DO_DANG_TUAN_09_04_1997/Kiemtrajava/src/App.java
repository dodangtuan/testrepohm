import Service.StudentService;

import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StudentService stdSv = new StudentService();

        boolean cond = true;
        do {
            System.out.println("                                    ");
            System.out.println("***✿ ❀ ❁  QUAN LY DIEM ✿ ❀ ❁ ***:");
            System.out.println("1. Them moi sinh vien.");
            System.out.println("2. Cap nhat thong tin sinh vien.");
            System.out.println("3. Xoa sinh vien.");
            System.out.println("4. In danh sach sinh vien.");
            System.out.println("5. Tim kiem sinh vien theo id.");
            System.out.println("6. Tim kiem sinh vien theo ten sinh vien.");
            System.out.println("7. Sap xem sinh vien theo diem GPA tang dan.");
            System.out.println("8. Tim sinh vien co GPA lon hon 8.");
            System.out.println("9. Tim sinh vien co GPA lon hon 8 trong lop D01.");
            System.out.println("10. Thoat chuong trinh.");
            System.out.println("===========================");
            System.out.print("Mời nhập lựa chọn : ");

            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    stdSv.insert();
                    break;
                case 2:
                    stdSv.update();
                    break;
                case 3:
                    stdSv.delete();
                    break;
                case 4:
                    stdSv.showAll();
                    break;
                case 5:
                    stdSv.showById();
                    break;
                case 6:
                    stdSv.showByName();
                    break;
                case 7:
                    stdSv.showSortedByGPA();
                    break;
                case 8:
                    stdSv.showGPAhight8();
                    break;
                case 9:
                    System.out.println("Dung chuong trinh");
                    System.exit(0);
                    cond = false;
                    break;

            }
        } while (cond);
    }
}

