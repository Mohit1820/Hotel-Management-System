
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
 

public class ManagerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    ManagerInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         
        
        JLabel I1 = new JLabel("Room Number");
        I1.setBounds(10,10,100,20);
        add(I1);
        
        JLabel I2 = new JLabel("Availability");
        I2.setBounds(120,10,100,20);
        add(I2);
        
        JLabel I3 = new JLabel("Status");
        I3.setBounds(230,10,100,20);
        add(I3);
        
        JLabel I4 = new JLabel("Price");
        I4.setBounds(330,10,100,20);
        add(I4);
        
        JLabel I5 = new JLabel("Bed Type");
        I5.setBounds(410,10,100,20);
        add(I5);
        
        table = new JTable();
        table.setBounds(0,40,1500,400);
        add(table);
        
        
        try{
          Conn c = new Conn(); 
          ResultSet rs = c.s.executeQuery("select *  from employee where job = 'Manager'");
          table.setModel(DbUtils.resultSetToTableModel(rs));
          
          
        } catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(650,500,120,30);
        add(back);
        
        setBounds(300,200,1500,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false); 
        new Reception();
    }
    
    public static void main(String[] args){
        new ManagerInfo();
    }
}

