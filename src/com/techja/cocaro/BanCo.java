package com.techja.cocaro;

public class BanCo {
    public static final int SO_HANG = 10;
    public static final int SO_COT = 10;
    public static final int SIZE = 50;
    private static final String RESET = "0:0";

    private String mauSac;
    private String tySo;
    private NguoiChoi nguoiChoi1;
    private NguoiChoi nguoiChoi2;

    public BanCo(String mauSac, String ten1, String ten2) {
        this.mauSac = mauSac;
        nguoiChoi1 = new NguoiChoi(QuanCo.X, ten1);
        nguoiChoi2 = new NguoiChoi(QuanCo.O, ten2);
        tySo = RESET;
    }

    public void veBanCo() {
        for (int i = 0; i < SO_HANG; i++) {
            for (int j = 0; j < SO_COT; j++) {
                int x = j * SIZE + SIZE / 2;
                int y = i * SIZE + SIZE / 2;

                QuanCo qc = new QuanCo(x, y, '-');
                if (nguoiChoi1.getListQC().indexOf(qc) >= 0) {
                    System.out.print("|x");
                } else if (nguoiChoi2.getListQC().indexOf(qc) >=0) {
                    System.out.print("|o");
                } else {
                    System.out.print("| ");
                }
            }

            System.out.println("|");
        }
    }

    public char danhCo(int x, int y, char loaiQC) {
        if (loaiQC == nguoiChoi1.getLoaiQC()) {
            if (nguoiChoi1.danhCo(x, y, nguoiChoi2)) {
                veBanCo();
                return nguoiChoi2.getLoaiQC();
            }
        } else {
            if (nguoiChoi2.danhCo(x, y, nguoiChoi1)) {
                veBanCo();
                return nguoiChoi1.getLoaiQC();
            }
        }

        return loaiQC;
    }

    public void xoaBanCo() {
        nguoiChoi1.xoaCo();
        nguoiChoi2.xoaCo();
    }

    public void choiLai() {
        xoaBanCo();
        tySo = RESET;
    }

    public char getLoaiQCNC1() {
        return nguoiChoi1.getLoaiQC();
    }

    public void kiemTraThangcuoc() {
        if ( nguoiChoi1.getListQC().size() + nguoiChoi1.getListQC().size() < 9 ) {
            return;
        }

        if ( kiemTraThangNgang(nguoiChoi1)
                || kiemTraThangDoc(nguoiChoi1)
                || kiemTraThangCheo(nguoiChoi1)
        ) {
            String[] item = tySo.split(":");
            tySo = Integer.parseInt(item[0]) + 1 + ":" + item[1];
            System.out.println("Người chơi 1 thắng!");
            System.out.println("Tỷ số: " + tySo);

            xoaBanCo();
        } else if (kiemTraThangNgang(nguoiChoi2)
                || kiemTraThangDoc(nguoiChoi2)
                || kiemTraThangCheo(nguoiChoi2)) {
            String[] item = tySo.split(":");
            tySo = item[0] + ":" + (Integer.parseInt(item[1]) + 1);
            System.out.println("Người chơi 2 thắng!");
            System.out.println("Tỷ số: " + tySo);

            xoaBanCo();
        }
    }

    private boolean kiemTraThangCheo(NguoiChoi nguoiChoi) {
        return false;
    }

    private boolean kiemTraThangDoc(NguoiChoi nguoiChoi) {
        return false;
    }

    private boolean kiemTraThangNgang(NguoiChoi nguoiChoi) {
        return false;
    }
}
