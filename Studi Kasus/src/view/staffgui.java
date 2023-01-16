package view;

import allobject.object;
import entity.entity_staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class staffgui {
    JLabel username, pin;
    JTextField nama, kode;
    JButton btnregist,btnlogin;
    JFrame staff = new JFrame();
    JTable tablestaff = new JTable();
    JScrollPane scrolstaff = new JScrollPane(tablestaff);

    public staffgui() {
        staff = new JFrame();
        staff.setSize(500,300);
        staff.getContentPane().setBackground(Color.CYAN);
        staff.setLayout(null);

        JLabel login = new JLabel("Login Staff");
        login.setBounds(145,0,400,50);
        login.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,40));
        staff.add(login);

        JLabel username = new JLabel("Username");
        username.setBounds(20,50,300,50);
        username.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        staff.add(username);

        JLabel pin = new JLabel("Pin");
        pin.setBounds(20,80,100,50);
        pin.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        staff.add(pin);

        nama = new JTextField();
        nama.setBounds(120,65,120,20);
        nama.setFont(new Font("Times New Roman",Font.TRUETYPE_FONT,14));
        staff.add(nama);

        kode = new JTextField();
        kode.setBounds(120,95,120,20);
        kode.setFont(new Font("Times New Roman",Font.TRUETYPE_FONT,14));
        staff.add(kode);

        btnregist = new JButton("Register");
        btnregist.setBounds(20,130,90,20);
        btnregist.setBackground(Color.pink);
        staff.add(btnregist);

        btnlogin = new JButton("Login");
        btnlogin.setBounds(148,130,90,20);
        btnlogin.setBackground(Color.pink);
        staff.add(btnlogin);

        scrolstaff.setBounds(245,65,230,150);
        tablestaff.setModel(object.controllerstaff.liststaff());
        tablestaff.setBackground(Color.pink);
        staff.add(scrolstaff);

        btnregist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = nama.getText();
                    int pin = Integer.parseInt(kode.getText());
                    object.controllerstaff.tambahstaff(new entity_staff(username, pin));
                    tablestaff.setModel(object.controllerstaff.liststaff());
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Inputan salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dashboardgui dashboardgui = new dashboardgui();
                    staff.dispose();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "Format Inputan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tablestaff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablestaff.getSelectedRow();
                int index=i;
                nama.setText(object.controllerstaff.liststaff().getValueAt(i, 0).toString());
                pin.setText(object.controllerstaff.liststaff().getValueAt(i, 1).toString());
            }
        });

        staff.setVisible(true);
        staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staff.setLocationRelativeTo(null);
    }
    void kosong(){
        nama.setText(null);
        kode.setText(null);
    }
}
