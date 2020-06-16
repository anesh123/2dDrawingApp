
package pkg2dapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @avp5603
 */
public class DrawWindow extends JPanel{
    private ArrayList<shape> shapes = new ArrayList();
    private int shapeType = 3;
    private shape currentS;
    private Color currentC1 = Color.WHITE;
    private Color currentC2 = Color.WHITE;
    private Paint currentClr = Color.WHITE;
    private boolean gradient = false;
    private Stroke s = new BasicStroke(0,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    private boolean filledS;
    private JLabel statusLabel;
    private DrawingApplication sft;
    float [] dx = new float[1];
    
    public DrawWindow(DrawingApplication da) {
        super();
        setBackground(Color.WHITE);
        statusLabel = new JLabel("(0,0)");
        setLayout(new BorderLayout());
        add(statusLabel,BorderLayout.SOUTH);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
        this.sft = da;
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        for (shape thisShape : shapes) {
            thisShape.draw(g2d);
        }
    }
    
        public void undo () {
        if (shapes.size()>0) {
            shapes.remove(shapes.size()-1);
            repaint();
        }
    }
        
    public void clear () {
        if (shapes.size()>0) {
            shapes.clear();
            repaint();
        }
    }

    
    private class MouseHandler extends MouseAdapter implements MouseMotionListener {

        private boolean gradient;
        @Override
        public void mousePressed(MouseEvent e) {
            currentClr = new GradientPaint(0,0,sft.getcolor1Button(),50,50,sft.getcolor2Button(),sft.getGradient());
            if (sft.getDashed()) {
                dx[0] = sft.getDashedLength();
                s = new BasicStroke(sft.getStrokeWidth(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dx,0);
                
            }
            else {
                s = new BasicStroke(sft.getStrokeWidth(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
               
            }
            if (shapeType == 1) {
                currentS = new line(e.getX(),e.getY(), s, currentClr);
                shapes.add(currentS);
            }
            else if (shapeType == 2){
                currentS = new rectangle(e.getX(),e.getY(), s, currentClr, sft.getfilledIn());
                shapes.add(currentS);
            }
            
            else if (shapeType == 3) {
                currentS = new oval(e.getX(),e.getY(), s, currentClr, sft.getfilledIn());
                shapes.add(currentS);
            }
            repaint();
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            
                shapes.get(shapes.size()-1).setEndPoint (e.getX(), e.getY());
                repaint();
        
        }
        
        @Override
        public void mouseMoved (MouseEvent e) {
            statusLabel.setText(String.format("(%d,%d)",e.getX(),e.getY()));
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            currentS = null;
        }
        
        
    }
    
    
     public void setShapeType(int type) {
        this.shapeType = type;
    }
     

}
