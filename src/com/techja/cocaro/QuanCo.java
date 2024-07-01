package com.techja.cocaro;

public class QuanCo {
    public static final char X = 'X';
    public static final char Y = 'Y';

    private int x, y;
    private char loai;

    public QuanCo(int x, int y, char loai) {
        this.x = x;
        this.y = y;
        this.loai = loai;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getLoai() {
        return loai;
    }
}
