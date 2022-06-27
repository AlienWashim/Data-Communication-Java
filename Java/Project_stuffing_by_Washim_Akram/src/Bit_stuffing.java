import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class Bit_stuffing extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JTextField field1=new JTextField(20);
    JTextField field2=new JTextField(20);
    JTextField field3=new JTextField(10);
    JLabel label1=new JLabel("<html><center><b>Welcome</b><br>To<br>Bit Stuffing</center></html>");
    JLabel label2=new JLabel("Enter your input:                ");
    JLabel label3=new JLabel("Here is your Output:           ");
    JLabel label4=new JLabel("Enter Extra bit:                ");
    JButton button1=new JButton("Output");
    Bit_stuffing(){
        super("Bit Stuffing by Washim Akram");
    
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,600);
        
        add(panel);
        panel.setBackground(Color.cyan);
        
        label1.setFont(new Font("Times New Roman", 1, 38));
        label2.setForeground(Color.white);
        
        panel.add(label1);
        panel.add(label4);
        panel.add(field3);
        field3.setBounds(100, 160, 200, 40);
        field3.setLocation(230,100);
        field3.setFont(new Font("Times New Roman", 1, 28));
        field3.setPreferredSize(new Dimension(400, 50));
        
        label2.setFont(new Font("Times New Roman", 1, 38));
        panel.add(label2);
        panel.add(field1);
        
        field1.setBounds(100, 160, 200, 40);
        field1.setLocation(230,100);
        field1.setFont(new Font("Times New Roman", 1, 28));
        field1.setPreferredSize(new Dimension(400, 50));
        
        label3.setFont(new Font("Times New Roman", 1, 38));
        label3.setForeground(Color.white);
        
        label4.setFont(new Font("Times New Roman", 1, 38));
        label4.setForeground(Color.white);
        
        panel.add(label3);
        label3.setFont(new Font("Times New Roman", 1, 38));
        panel.add(label3);
        panel.add(field2);
        
        field2.setBounds(100, 160, 200, 40);
        field2.setLocation(230,100);
        field2.setFont(new Font("Times New Roman", 1, 28));
        field2.setPreferredSize(new Dimension(400, 50));
        
        button1.setFont(new Font("Times New Roman", 1, 28));
        button1.setPreferredSize(new Dimension(400, 50));
        button1.setBackground(Color.green);
        
        panel.add(button1);       
        button1.addActionListener(this);
    }
    String calculate(String exb, String in){
        //System.out.println(exb+" "+in);
        char output[] = new char[1000];
        char extra[] = exb.toCharArray();
        char input[] = in.toCharArray();
        char c = extra[0];
        System.out.println(c+" ");

        //extra bit insertion at the startup
        for(int i = 0; i < extra.length; i++)
        {
            output[i] = extra[i];
        }

    int flag = 0, n = extra.length;
    for(int i = 0; i < input.length;i++)
    {
        if('1' == input[i])
        {
            flag++;
            output[n] = input[i];
            n++;
        }
        else
        {
            flag = 0;
            output[n] = input[i];
            n++;
        }
        if(flag == 5)
        {
            output[n] = '0';
            n++;
            flag = 0;
        }
    }
    //extra bit insertion at the end point
    for(int i = n; i < n+extra.length; i++)
    {
        output[i] = extra[i];
    }
        System.out.println(output.toString());    
    return output.toString();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String input=a.getActionCommand();
        if("Output".equals(input)){
           Bit_stuffing obj=new Bit_stuffing();
           String output = obj.calculate(field3.getText(),field1.getText());
           field2.setText(output);
        }
    }
    
}
