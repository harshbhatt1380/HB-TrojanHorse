import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.text.FlowView;
class Mp
{
    public static void operate(int key)
    {
        JFileChooser filehb=new JFileChooser();
        filehb.showOpenDialog(null);
        File nf = filehb.getSelectedFile();

        //File Exceptions 

        try{
             FileInputStream fis=new FileInputStream(nf);
             byte data[]=new byte[fis.available()];
             fis.read(data);


             int i=0;
             for(byte b:data)
             {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
             }

             FileOutputStream fos=new FileOutputStream(nf);
             fos.write(data);
             fos.close();
             fis.close();
             JOptionPane.showMessageDialog(null,"File Encrypted Successfully!!");
           }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        JFrame f=new JFrame();
        f.setTitle("Trojan Horse");
        f.setSize(300,350);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
        //Created button

        JButton button=new JButton();
        Font font=new Font("Roboto",Font.ITALIC,25);
        button.setText("Press me");
        button.setFont(font);

        // Creating text field

        JTextField textf=new JTextField(10);
        textf.setFont(font);
        f.setLayout(new FlowLayout(0, 0, 0));

        f.add(button);
        f.add(textf);

        //Button Functionality 

        button.addActionListener(e->{
        System.out.println("Jai Shree Ram!!");
        String text=textf.getText();
        int temp=Integer.parseInt(text);
        operate(temp);

    });
    f.setVisible(true);
 }
}