
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class home extends JFrame implements ActionListener{
    JPanel panel=new JPanel();
    JButton button1=new JButton("Bit Stuffing");
    JButton button2=new JButton("Bit De-stuffing");
    JButton button3=new JButton("Character Stuffing");
    JButton button4=new JButton("Character De-stuffing");
    JButton button5=new JButton("Exit");
    
    JLabel label1=new JLabel("<html><b>Welcome</b><br>Created by Washim Akram");
    
    home(){
    super("Project Stuffing by Washim Akram");
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500,600);
    add(panel);
    panel.setBackground(Color.green);
        
        label1.setBackground(Color.cyan);
        label1.setFont(new Font("Times New Roman", 1, 38));
        
    
        button1.setBounds(100, 160, 200, 40);
        button1.setFocusable(false);
        button1.setLocation(230,100);
        button1.setFont(new Font("Times New Roman", 1, 18));
        button1.setPreferredSize(new Dimension(400, 50));
        
        button2.setBounds(100, 160, 200, 40);
        button2.setFocusable(false);
        button2.setLocation(230,100);
        button2.setFont(new Font("Times New Roman", 1, 18));
        button2.setPreferredSize(new Dimension(400, 50));
        
        button3.setBounds(100, 160, 200, 40);
        button3.setFocusable(false);
        button3.setLocation(230,100);
        button3.setFont(new Font("Times New Roman", 1, 18));
        button3.setPreferredSize(new Dimension(400, 50));
        
        button4.setBounds(100, 160, 200, 40);
        button4.setFocusable(false);
        button4.setLocation(230,100);
        button4.setFont(new Font("Times New Roman", 1, 18));
        button4.setPreferredSize(new Dimension(400, 50));
        
        button5.setBounds(100, 160, 200, 40);
        button5.setFocusable(false);
        button5.setLocation(230,100);
        button5.setFont(new Font("Times New Roman", 1, 18));
        button5.setPreferredSize(new Dimension(400, 50));
        
        panel.add(label1);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
}
  
    public static void main(String[] args) {
        home obj = new home();
        obj.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String input=a.getActionCommand();
        //System.out.println(input);
        if("Bit Stuffing".equals(input)){
           Bit_stuffing obj=new Bit_stuffing();
           obj.setVisible(true);
        }
        else if("Bit De-stuffing".equals(input)){
            Bit_destuffing obj=new Bit_destuffing();
           obj.setVisible(true);
        }
        else if("Character Stuffing".equals(input)){
            Character_stuffing obj=new Character_stuffing();
            obj.setVisible(true);
        }
        else if("Character De-tuffing".equals(input)){
            Character_destuffing obj=new Character_destuffing();
            obj.setVisible(true);
        }
        else if("Exit".equals(input)){
            dispose();
        }
    }
    
}
