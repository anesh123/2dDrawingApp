
import java.awt.BorderLayout;
import javax.swing.JFrame;
import pkg2dapplication.DrawingApplication;
 

public class Pkg2dApplication {

     public static void main(String[] args)
   {
    DrawingApplication sft = new DrawingApplication();   
    sft.setSize(800, 800); 
    sft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    sft.setVisible(true);
}
}
