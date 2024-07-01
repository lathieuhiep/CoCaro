package com.techja.cocaro;

import java.util.ArrayList;

public class NguoiChoi {
    private char loaiQC;
    private ArrayList<QuanCo> listQC;
    private String ten;

    public NguoiChoi(char loaiQC, String ten) {
        this.loaiQC = loaiQC;
        this.listQC = new ArrayList<QuanCo>();
        this.ten = ten;
    }

    public void danhCo(int x, int y) {
        // todo
    }
}
