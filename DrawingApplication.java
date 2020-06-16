package pkg2dapplication;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pkg2dapplication.DrawWindow;


public class DrawingApplication extends JFrame
{
    private final JButton undo;
    private final JButton clear;
    private JButton color1Button;
    private JButton color2Button;
    private final JComboBox<String> shapeComboBox;
    private final JTextField strokeWidth;
    private final JTextField strokeDashWidth;
    private final JLabel lineWidth;
    private final JLabel drawWidth;
    private final JCheckBox filledIn;
    private final JCheckBox gradient;
    private final JCheckBox dashedLine;
    private Color color1 = Color.BLACK;
    private Color color2 = Color.BLACK;
    DrawWindow window;
    

public DrawingApplication()
{
    super("Java 2D Drawings");
    setLayout(new BorderLayout());

    JPanel topPanel = new JPanel(new FlowLayout());
    JPanel bottomPanel = new JPanel(new FlowLayout());

    undo = new JButton("Undo");
    topPanel.add(undo);

    clear = new JButton("Clear");
    topPanel.add(clear);

    String [] drawItems = {"Line","Rectangle","Oval"};
    shapeComboBox = new JComboBox<String>(drawItems);
    shapeComboBox.setSelectedIndex(0);
    topPanel.add(shapeComboBox);

    filledIn = new JCheckBox("Filled");
    topPanel.add(filledIn);

    gradient = new JCheckBox("Use Gradient");
    bottomPanel.add(gradient);

    color1Button = new JButton("Color 1");
    bottomPanel.add(color1Button);

    color2Button = new JButton("Color 2");
    bottomPanel.add(color2Button);

    lineWidth = new JLabel("Line Width");
    bottomPanel.add(lineWidth);

    strokeWidth = new JTextField(4);
    bottomPanel.add(strokeWidth);

    drawWidth = new JLabel("Dash Length");
    bottomPanel.add(drawWidth);
    
    strokeDashWidth = new JTextField (4);
    bottomPanel.add(strokeDashWidth);

    dashedLine = new JCheckBox("Dashed");
    bottomPanel.add(dashedLine);

    JPanel container = new JPanel(new BorderLayout());
    container.add(topPanel,BorderLayout.NORTH);
    container.add(bottomPanel,BorderLayout.CENTER);
    
    
    add(container,BorderLayout.NORTH);
    
    window = new DrawWindow(this);
    window.setBackground(Color.white);
    add(window,BorderLayout.CENTER);
    
    
    actionHandler a1 = new actionHandler ();
    undo.addActionListener((ActionListener) a1);
    clear.addActionListener((ActionListener) a1);
    shapeComboBox.addActionListener((ActionListener) a1);
    filledIn.addActionListener((ActionListener) a1);
    gradient.addActionListener((ActionListener) a1);
    color1Button.addActionListener((ActionListener) a1);
    color2Button.addActionListener((ActionListener) a1);
    strokeWidth.addActionListener((ActionListener) a1);
    strokeDashWidth.addActionListener((ActionListener) a1);
}


    private class actionHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == undo) {
                window.undo();
            }
            else if (e.getSource() == clear) {
                window.clear();
            }
            else if (e.getSource() == shapeComboBox) {
                if (shapeComboBox.getSelectedItem() == "Oval") {
                    window.setShapeType(3);
                }
                else if (shapeComboBox.getSelectedItem() == "Rectangle") {
                    window.setShapeType(2);
                }
                else if (shapeComboBox.getSelectedItem() == "Line") {
                    window.setShapeType(1);
                }
            }
            else if (e.getSource() == color1Button) {
                color1 = JColorChooser.showDialog(DrawingApplication.this, "Choose a color", color1);
                if (color1==null) {
                    color1 = Color.lightGray;
                }
            }
            else if (e.getSource() == color2Button) {
                color2 = JColorChooser.showDialog(DrawingApplication.this, "Choose a color", color2);
                if (color2==null) {
                    color2 = Color.LIGHT_GRAY;
                }
            }
        }
    }
 
    public boolean getfilledIn() {
        if (filledIn.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean getGradient() {
        if (gradient.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Color getcolor1Button() {
        return color1;
    }
    
    public Color getcolor2Button() {
        return color2;
    }
    
    public boolean getDashed() {
        if (dashedLine.isSelected()) {
            return true;
        }
        else {
            return false;
        }
    } 
    public int getStrokeWidth() {
        try {
            int num = Integer.parseInt(strokeWidth.getText());
            return num;
        }
        catch (Exception ex) {
            return 1;
        }
    } 
    public int getDashedLength() {
        try {
            int num = Integer.parseInt(strokeDashWidth.getText());
            if (num!=0) {
                return num;
            }
            else {
            return 1;
            }
        }
        catch(Exception ex) {
                return 1;
        }
    } 
    
} 
