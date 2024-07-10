package com.techja.cocaro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

public class BanCo extends JPanel {
    private static final long serialVersionUID = 1;
    public static final int SO_HANG = 10;
    public static final int SO_COT = 10;
    public static final int SIZE = 50;
    private static final String RESET = "0:0";
    public static final int PADDING = 30;

    private Color mauSac;
    private String tySo;
    private NguoiChoi nguoiChoi1;
    private NguoiChoi nguoiChoi2;
    private char loaiQC = 'X';

    public BanCo(Color mauSac, String ten1, String ten2) {
        this.mauSac = mauSac;
        nguoiChoi1 = new NguoiChoi(QuanCo.X, ten1);
        nguoiChoi2 = new NguoiChoi(QuanCo.O, ten2);
        tySo = RESET;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                char type = danhCo(e.getX(), e.getY(), loaiQC);
                kiemTraThangCuoc();
                loaiQC = type;
            }
        });

        requestFocus();
    }

    private Comparator<QuanCo> sxNgang = new Comparator<QuanCo>() {
        @Override
        public int compare(QuanCo qc1, QuanCo qc2) {
            return qc1.getX() - qc2.getY();
        }
    };

    public void veBanCo() {}

    public void veBanCo2(Graphics2D g) {
        setBackground(mauSac);
        g.setColor(Color.yellow);

        for (int i = 0; i <= SO_HANG; i++) {
            g.drawLine(PADDING, i * SIZE + PADDING, SO_COT * SIZE + PADDING, i * SIZE + PADDING);
            g.drawLine(i * SIZE + PADDING, PADDING, i * SIZE + PADDING, SO_COT * SIZE + PADDING);
        }

        Font f = new Font("Tahoma", Font.BOLD, 30);
        g.setFont(f);

        int h = getFontMetrics(f).getHeight();
        int w = getFontMetrics(f).stringWidth("X");

        for (int i = 0; i <= SO_HANG; i++) {
            for (int j = 0; j <= SO_COT; j++) {
                int x = j * SIZE + SIZE / 2;
                int y = i * SIZE + SIZE / 2;

                QuanCo qc = new QuanCo(x + PADDING, y + PADDING, ' ');

                if (nguoiChoi1.getListQC().indexOf(qc) >= 0) {
                    g.setColor(Color.yellow);
                    g.drawString("X", x + PADDING - w / 2, y + PADDING + h / 3);
                } else if (nguoiChoi2.getListQC().indexOf(qc) >=0) {
                    g.setColor(Color.CYAN);
                    g.drawString("O", x + PADDING - w / 2, y + PADDING + h / 3);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        veBanCo2((Graphics2D)g);
    }

    public char danhCo(int x, int y, char loaiQC) {
        if (loaiQC == nguoiChoi1.getLoaiQC()) {
            if (nguoiChoi1.danhCo(x, y, nguoiChoi2)) {
                repaint();
                return nguoiChoi2.getLoaiQC();
            }
        } else {
            if (nguoiChoi2.danhCo(x, y, nguoiChoi1)) {
                repaint();
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

    public void kiemTraThangCuoc() {
        if ( nguoiChoi1.getListQC().size() + nguoiChoi1.getListQC().size() < 9 ) {
            return;
        }

        if ( kiemTraThangNgang(nguoiChoi1) || kiemTraThangDoc(nguoiChoi1) || kiemTraThangCheo(nguoiChoi1)
        ) {
            String[] item = tySo.split(":");
            tySo = Integer.parseInt(item[0]) + 1 + ":" + item[1];

            JOptionPane.showMessageDialog(null, "Người chơi 1 thắng: " + tySo);

            xoaBanCo();
        } else if (kiemTraThangNgang(nguoiChoi2) || kiemTraThangDoc(nguoiChoi2) || kiemTraThangCheo(nguoiChoi2)) {
            String[] item = tySo.split(":");
            tySo = item[0] + ":" + (Integer.parseInt(item[1]) + 1);

            JOptionPane.showMessageDialog(null, "Người chơi 2 thắng: " + tySo);

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
        nguoiChoi.getListQC().sort(sxNgang);

        for (int i = 0; i < nguoiChoi.getListQC().size(); i++) {
            int demQC = 1;
            QuanCo qcTruoc = nguoiChoi.getListQC().get(i);

            for (int j = i + 1; j < nguoiChoi.getListQC().size() - 1; j++) {
                QuanCo qcSau = nguoiChoi.getListQC().get(j);

                if ( qcSau.getX() == qcTruoc.getX() + 50 && qcSau.getY() == qcTruoc.getY() ) {
                    demQC ++;
                    qcTruoc = qcSau;
                }

                if (demQC >= 5) {
                    return true;
                }
            }
        }

        return false;
    }
}
