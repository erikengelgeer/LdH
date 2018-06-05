/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Gebruiker
 */
public class Frame {
    
    Query query;
    
public Frame() throws SQLException{
    this.query = new Query();
    genereerFrame();
}

    public void genereerFrame() {
        
        JFrame frame = new JFrame();
        frame.setSize(1000, 1200);
        frame.setTitle("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6= new JPanel();

        JButton button1 = new JButton("connectie database");
        JButton button2 = new JButton("afwijkingen zoeken");
        JButton button3 = new JButton("afwijkingen tonen");
        JButton button4 = new JButton("afwijkingen schrijven");
        JButton button5 = new JButton("export");
        JButton button6 = new JButton("reset");
        
        JCheckBox checkbox1 = new JCheckBox("vergelijk profit met AD");
        JCheckBox checkbox2 = new JCheckBox("vergelijk clever met AD");
        JCheckBox checkbox3 = new JCheckBox("vergelijk profit met celever");
        
        JTextArea textarea1 = new JTextArea("\n Business Rules:");
        
        textarea1.setFont(new Font("Serif", Font.BOLD, 19));
        
        JTextArea textarea3 = new JTextArea("\n  1. RDS user naam in profit bestaat niet in AD "
                + "\n  2. Medewerker uit dienst in Profit, account is in AD actief"
                + "\n  3. AD Account, onbekend in Profit"
                + "\n  4. RDS naam in Clevernew is niet ingevuld"
                + "\n  5. RDS naam in CleverNew bestaat niet in AD"
                + "\n  6. Medewerker uit dienst in CleverNew, account in AD actief"
                + "\n  7. Ad account, onbekend in Clever"
                + "\n  8. RDS User naam in Profit bestaat niet in Clever"
                + "\n  9. Medewerker uit dienst in Profit, account is in Clever actief"
                + "\n  10.RDS User naam in Clever bestaat niet in Afas Profit");
        
        textarea3.setFont(new Font("Serif", Font.PLAIN, 19));
        
        JTextArea textarea2 = new JTextArea("\t impact");

        JTable table1 = query.getTable();
        JScrollPane scrollPane = new JScrollPane(table1);

        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(scrollPane);
        panel1.add(textarea2);
                
        panel2.setLayout(new BorderLayout());
        panel2.add(panel4, BorderLayout.WEST);
        panel2.add(panel5, BorderLayout.NORTH);
        panel2.add(panel6, BorderLayout.CENTER);
        
        panel5.setLayout(new GridLayout(1,2));
        panel5.add(button5);
        panel5.add(button6);
        
        panel4.setLayout(new GridLayout(4,1));
        panel4.add(button2);
        panel4.add(button1);
        panel4.add(button3);
        panel4.add(button4);
        
        panel3.setLayout(new BorderLayout());
        panel3.add(textarea1, BorderLayout.NORTH);
        panel3.add(textarea3, BorderLayout.CENTER);
        
        panel6.setLayout(new GridLayout(12,1));                
        panel6.add(checkbox1);
        panel6.add(checkbox2);
        panel6.add(checkbox3);

        frame.add(panel1);
        frame.setVisible(true);
        
    }

}
