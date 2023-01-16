package view;

import allobject.object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class lihatgui {
    JFrame lihatframe = new JFrame();
    JTable tablebuku = new JTable();
    JButton dashboard;
    JScrollPane scrolbuku = new JScrollPane(tablebuku);

    public lihatgui() {
        lihatframe.setSize(600,550);
        lihatframe.setLayout(null);
        lihatframe.getContentPane().setBackground(Color.PINK);
        lihatframe.setTitle("Menu View Buku");

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(240,470,120,20);
        dashboard.setFont(new Font("Times New Roman",Font.BOLD,14));
        dashboard.setBackground(Color.gray);
        lihatframe.add(dashboard);

        scrolbuku.setBounds(50,62,500,400);
        scrolbuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        tablebuku.setModel(object.controllerbuku.listbuku());
        tablebuku.setBackground(Color.LIGHT_GRAY);
        tablebuku.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,14));
        lihatframe.add(scrolbuku);

        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    lihatframe.dispose();
                }catch(Exception exception){
                    System.out.println(exception);
                }
            }
        });

        lihatframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lihatframe.setLocationRelativeTo(null);
        lihatframe.setVisible(true);

    }
}
