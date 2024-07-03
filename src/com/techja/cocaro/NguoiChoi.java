package com.techja.cocaro;

import java.util.ArrayList;

public class NguoiChoi {
    private char loaiQC;
    private ArrayList<QuanCo> listQC;
    private String ten;

    public NguoiChoi(char loaiQC, String ten) {
        this.loaiQC = loaiQC;
        this.ten = ten;
        this.listQC = new ArrayList<QuanCo>();
    }

    public boolean danhCo(int x, int y, NguoiChoi nguoiChoi2) {
        if (x < 0 || y < 0 || x > BanCo.SO_COT * BanCo.SIZE || y > BanCo.SO_HANG * BanCo.SIZE) {
            System.out.println("Vị trí đánh không phù hợp");
            return false;
        }

        int cot = x / BanCo.SIZE;
        int hang = y / BanCo.SIZE;

        x = cot * BanCo.SIZE + BanCo.SIZE / 2;
        y = hang * BanCo.SIZE + BanCo.SIZE / 2;

        QuanCo qc = new QuanCo(x, y, loaiQC);
        int viTri = listQC.indexOf(qc);
        if (viTri >= 0) {
            System.out.println("Lỗi: vị trí đã có quân cờ " + x + "," + y);
            return false;
        }

        viTri = nguoiChoi2.listQC.indexOf(qc);
        if (viTri >= 0) {
            System.out.println("Lỗi: vị trí đã có quân cờ " + x + "," + y);
            return false;
        }

        listQC.add(qc);
        return true;
    }

    public void xoaCo() {
        listQC.clear();
    }

    public ArrayList<QuanCo> getListQC() {
        return listQC;
    }

    public String getTen() {
        return ten;
    }

    public char getLoaiQC() {
        return loaiQC;
    }
}
