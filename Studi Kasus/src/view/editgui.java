package view;

import allobject.object;
import entity.entity_buku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class editgui {
    JLabel no_buku,namabuku,penerbit,tahun,top;
    JTextField nomer,judul, penulis, tahunterbit;
    JButton edit,dashboard;
    JFrame editframe = new JFrame();
    JTable tablebuku = new JTable();
    JScrollPane scrolbuku = new JScrollPane(tablebuku);
    public editgui() {
        editframe.setSize(900,600);
        editframe.setLayout(null);
        editframe.setTitle("Menu Edit Buku");
        editframe.getContentPane().setBackground(Color.YELLOW);

        top = new JLabel("Menu Edit Buku");
        top.setBounds(335,5,400,50);
        top.setFont(new Font("Times New Roman",Font.BOLD,30));
        editframe.add(top);

        no_buku = new JLabel("No Buku");
        no_buku.setBounds(30,50,100,50);
        no_buku.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(no_buku);

        namabuku = new JLabel("Judul");
        namabuku.setBounds(30,100,50,50);
        namabuku.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(namabuku);

        penerbit = new JLabel("Penulis");
        penerbit.setBounds(30,150,70,50);
        penerbit.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(penerbit);

        tahun = new JLabel("Tahun Terbit");
        tahun.setBounds(30,200,120,50);
        tahun.setFont(new Font("Times New Roman",Font.BOLD,20));
        editframe.add(tahun);

        nomer = new JTextField();
        nomer.setBounds(160,63,120,25);
        nomer.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(nomer);

        judul = new JTextField();
        judul.setBounds(160,113,120,25);
        judul.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(judul);

        penulis = new JTextField();
        penulis.setBounds(160,163,120,25);
        penulis.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(penulis);

        tahunterbit = new JTextField();
        tahunterbit.setBounds(160,213,120,25);
        tahunterbit.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,20));
        editframe.add(tahunterbit);

        edit = new JButton("Update");
        edit.setBounds(160,250,120,20);
        edit.setFont(new Font("Times New Roman",Font.BOLD,14));
        edit.setBackground(Color.GREEN);
        editframe.add(edit);

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(160,300,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        dashboard.setBackground(Color.GREEN);
        editframe.add(dashboard);

        scrolbuku.setBounds(300,62,500,400);
        scrolbuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablebuku.setModel(object.controllerbuku.listbuku());
        tablebuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablebuku.setBackground(Color.GREEN);
        editframe.add(scrolbuku);

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nmr = Integer.parseInt(nomer.getText());
                    String jdl = judul.getText();
                    String pnls = penulis.getText();
                    int thn = Integer.parseInt(tahunterbit.getText());
                    object.controllerbuku.editbuku(nmr,new entity_buku(jdl,pnls,thn));
                    tablebuku.setModel(object.controllerbuku.listbuku());
                    kosong();
                    JOptionPane.showMessageDialog(null, "Berhasil Mengupdate Data Buku", "Information", JOptionPane.INFORMATION_MESSAGE);
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
                    editframe.dispose();
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

        editframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editframe.setLocationRelativeTo(null);
        editframe.setVisible(true);
    }

    void kosong(){
        nomer.setText(null);
        judul.setText(null);
        penulis.setText(null);
        tahunterbit.setText(null);
    }
}
