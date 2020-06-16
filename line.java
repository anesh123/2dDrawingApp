
package pkg2dapplication;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;


public class line extends shape {

    public line(int x, int y, Stroke stroke, Paint paint) {
        super(x,y,stroke,paint);
    }

    
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(super.getPaint());
        g2d.setStroke(super.getStroke());
        g2d.drawLine(super.getStartPointX(),super.getStartPointY(),super.getEndPointX(),super.getEndPointY()); 
    }
}
