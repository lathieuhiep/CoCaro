import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // mở 1 kết nối đến bàn phím
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số A = ");
        int a = sc.nextInt();

        System.out.print("Nhập số B = ");
        int b = sc.nextInt();
        sc.nextLine();

        System.out.println("Tổng =  " + (a + b));

        System.out.print("Xin cho cái tên của bro: ");
        String ten = sc.nextLine();
        System.out.println("Thanks " + ten);

        // Đóng kết nối
        sc.close();
    }
}
