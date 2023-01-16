package view;

import allobject.object;
import entity.entity_buku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tambahgui {
    JLabel namabuku,penerbit,tahun,top;
    JTextField judul, penulis, tahunterbit;
    JButton tambah,dashboard;
    JFrame tambahframe = new JFrame();
    JTable tablebuku = new JTable();
    JScrollPane scrolbuku = new JScrollPane(tablebuku);
    public tambahgui() {
        tambahframe.setSize(900,600);
        tambahframe.setLayout(null);
        tambahframe.setTitle("Menu Tambah Buku");
        tambahframe.getContentPane().setBackground(Color.GRAY);

        top = new JLabel("Menu Tambah Buku");
        top.setBounds(280,20,600,50);
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        tambahframe.add(top);

        namabuku = new JLabel("Judul");
        namabuku.setBounds(30,90,50,50);
        namabuku.setFont(new Font("Times New Roman",Font.BOLD,20));
        tambahframe.add(namabuku);

        penerbit = new JLabel("Penulis");
        penerbit.setBounds(30,140,70,50);
        penerbit.setFont(new Font("Times New Roman",Font.BOLD,20));
        tambahframe.add(penerbit);

        tahun = new JLabel("Tahun Terbit");
        tahun.setBounds(30,190,120,50);
        tahun.setFont(new Font("Times New Roman",Font.BOLD,20));
        tambahframe.add(tahun);

        judul = new JTextField();
        judul.setBounds(160,103,120,25);
        judul.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        tambahframe.add(judul);

        penulis = new JTextField();
        penulis.setBounds(160,153,120,25);
        penulis.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        tambahframe.add(penulis);

        tahunterbit = new JTextField();
        tahunterbit.setBounds(160,203,120,25);
        tahunterbit.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        tambahframe.add(tahunterbit);

        tambah = new JButton("Create");
        tambah.setBounds(160,250,120,20);
        tambah.setFont(new Font("Times New Roman",Font.BOLD,14));
        tambah.setBackground(Color.cyan);
        tambahframe.add(tambah);

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(160,300,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        dashboard.setBackground(Color.cyan);
        tambahframe.add(dashboard);

        scrolbuku.setBounds(300,103,500,400);
        scrolbuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablebuku.setModel(object.controllerbuku.listbuku());
        tablebuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablebuku.setBackground(Color.cyan);
        tambahframe.add(scrolbuku);

        tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String jdl = judul.getText();
                    String pnls = penulis.getText();
                    int thn = Integer.parseInt(tahunterbit.getText());
                    object.controllerbuku.tambahbuku(new entity_buku(jdl,pnls,thn));
                    tablebuku.setModel(object.controllerbuku.listbuku());
                    kosong();
                    JOptionPane.showMessageDialog(null, "Berhasil Menambah Data Buku", "Information", JOptionPane.INFORMATION_MESSAGE);
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Inputan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(exception);
                }
            }
        });

        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    tambahframe.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        tablebuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablebuku.getSelectedRow();
                int index=i;
                judul.setText(object.controllerbuku.listbuku().getValueAt(i, 1).toString());
                penulis.setText(object.controllerbuku.listbuku().getValueAt(i, 2).toString());
                tahunterbit.setText(object.controllerbuku.listbuku().getValueAt(i, 3).toString());

            }
        });
        tambahframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tambahframe.setLocationRelativeTo(null);
        tambahframe.setVisible(true);
    }

    void kosong(){
        judul.setText(null);
        penulis.setText(null);
        tahunterbit.setText(null);
    }
}
