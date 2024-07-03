package com.techja.cocaro.main;

import com.techja.cocaro.BanCo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // mở 1 kết nối đến bàn phím
        Scanner sc = new Scanner(System.in);

        BanCo bc = new BanCo("Đỏ", "Thành", "Tài");
        char loaiQuanCo = '-';

        for (int i = 0; i < 80; i++) {
            System.out.print("Đánh cờ: ");
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (loaiQuanCo == '-') {
                loaiQuanCo = bc.getLoaiQCNC1();
            }

            loaiQuanCo = bc.danhCo(x,y, loaiQuanCo);

            bc.kiemTraThangcuoc();
        }

        // Đóng kết nối
        sc.close();


//        System.out.print("Nhập số A = ");
//        int a = sc.nextInt();
//
//        System.out.print("Nhập số B = ");
//        int b = sc.nextInt();
//        sc.nextLine();
//
//        System.out.println("Tổng =  " + (a + b));
//
//        System.out.print("Xin cho cái tên của bro: ");
//        String ten = sc.nextLine();
//        System.out.println("Thanks " + ten);


    }
}
