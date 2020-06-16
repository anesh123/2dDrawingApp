
package pkg2dapplication;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

/**
 *
 * @avp5603
 */
public class oval extends Shape2D {
   public oval(int x, int y, Stroke stroke, Paint paint,boolean filled) {
        super(x,y,stroke,paint,filled);
    }

    
    @Override
    public void draw(Graphics2D g2d) { 
        g2d.setPaint(super.getPaint());
        g2d.setStroke(super.getStroke());
        if(getFilled()) {
            g2d.fillOval(getTopX(),getTopY(),getWidth(),getHeight());
        }
        else {
            g2d.drawOval(getTopX(),getTopY(),getWidth(),getHeight());
        }
     
    }
}
