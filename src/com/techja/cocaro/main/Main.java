package com.techja.cocaro.main;

import com.techja.cocaro.BanCo;
import com.techja.cocaro.gui.GUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new GUI().setVisible(true);

//        // mở 1 kết nối đến bàn phím
//        Scanner sc = new Scanner(System.in);
//
//        BanCo bc = new BanCo("Đỏ", "Thành", "Tài");
//        char loaiQuanCo = '-';
//
//        for (int i = 0; i < 80; i++) {
//            System.out.print("Đánh cờ: ");
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//
//            if (loaiQuanCo == '-') {
//                loaiQuanCo = bc.getLoaiQCNC1();
//            }
//
//            loaiQuanCo = bc.danhCo(x,y, loaiQuanCo);
//
//            bc.kiemTraThangcuoc();
//        }
//
//        // Đóng kết nối
//        sc.close();
    }
}
