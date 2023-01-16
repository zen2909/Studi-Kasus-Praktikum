package view;

import allobject.object;
import entity.entity_buku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hapusgui {
    JLabel no_buku,top;
    JTextField nomor;
    JButton hapus,dashboard;
    JFrame hapusframe =new JFrame();
    JTable tablebuku = new JTable();
    JScrollPane scrolbuku = new JScrollPane(tablebuku);

    public hapusgui() {
        hapusframe.setSize(700,350);
        hapusframe.setLayout(null);
        hapusframe.getContentPane().setBackground(Color.orange);
        hapusframe.setTitle("Menu Hapus Buku");

        top = new JLabel("Menu Edit Buku");
        top.setBounds(245,0,400,50);
        top.setFont(new Font("Times New Roman",Font.BOLD,30));
        hapusframe.add(top);

        no_buku = new JLabel("No Buku");
        no_buku.setBounds(30,30,100,50);
        no_buku.setFont(new Font("Times New Roman",Font.BOLD,20));
        hapusframe.add(no_buku);

        nomor = new JTextField();
        nomor.setBounds(120,43,120,25);
        nomor.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE,20));
        hapusframe.add(nomor);

        hapus = new JButton("DELETE");
        hapus.setBounds(120,80,120,20);
        hapus.setFont(new Font("Times New Roman",Font.BOLD,14));
        hapus.setBackground(Color.YELLOW);
        hapusframe.add(hapus);

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(120,130,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        dashboard.setBackground(Color.YELLOW);
        hapusframe.add(dashboard);

        scrolbuku.setBounds(248,43,400,250);
        scrolbuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablebuku.setModel(object.controllerbuku.listbuku());
        tablebuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        hapusframe.add(scrolbuku);

        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nmr = Integer.parseInt(nomor.getText());
                    object.controllerbuku.hapusbuku(nmr);
                    tablebuku.setModel(object.controllerbuku.listbuku());
                    JOptionPane.showMessageDialog(null, "Berhasil Menambah Data Buku", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        });

        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    hapusframe.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        hapusframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hapusframe.setLocationRelativeTo(null);
        hapusframe.setVisible(true);

    }
}
