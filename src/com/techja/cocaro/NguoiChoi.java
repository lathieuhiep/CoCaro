package com.techja.cocaro;

import javax.swing.*;
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
        if (x < BanCo.PADDING || y < BanCo.PADDING || x > BanCo.SO_COT * BanCo.SIZE + BanCo.PADDING || y > BanCo.SO_HANG * BanCo.SIZE + BanCo.PADDING) {
            System.out.println("Vị trí đánh không phù hợp");

            JOptionPane.showMessageDialog(null, "Vị trí đánh không phù hợp");

            return false;
        }

        int cot = (x - BanCo.PADDING) / BanCo.SIZE;
        int hang = (y - BanCo.PADDING) / BanCo.SIZE;

        x = cot * BanCo.SIZE + BanCo.SIZE / 2 + BanCo.PADDING;
        y = hang * BanCo.SIZE + BanCo.SIZE / 2 + BanCo.PADDING;

        QuanCo qc = new QuanCo(x, y, loaiQC);
        int viTri = listQC.indexOf(qc);
        if (viTri >= 0) {
            JOptionPane.showMessageDialog(null, "Lỗi: vị trí đã có quân cờ " + x + "," + y);

            return false;
        }

        viTri = nguoiChoi2.listQC.indexOf(qc);
        if (viTri >= 0) {
            JOptionPane.showMessageDialog(null, "Lỗi: vị trí đã có quân cờ " + x + "," + y);

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
