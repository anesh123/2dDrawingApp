
package pkg2dapplication;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;



public abstract class shape {

    private int startPointX;
    private int startPointY;
    private int endPointX;
    private int endPointY;
    private Stroke stroke;
    private Paint paint;
    
    public shape(int x, int y, Stroke stroke, Paint paint) {
        startPointX = x;
        startPointY = y;
        endPointX = x;
        endPointY = y;
        this.stroke= stroke;
        this.paint = paint;
    }
    
    public void setEndPoint (int x, int y) {
        this.endPointX = x;
        this.endPointY = y;
    }
    
    public int getStartPointX() {
        return startPointX;
    }
    
    public int getStartPointY() {
        return startPointY;
    }
    
    public int getEndPointX() {
        return endPointX;
    }
    
    public int getEndPointY() {
        return endPointY;
    }
    
    public Paint getPaint() {
        return paint;
    }
    
    public Stroke getStroke() {
        return stroke;
    }
    
    public void setPaint(Paint p) {
       this.paint = p;
    }
    
    public void setStroke(Stroke s) {
        this.stroke = s;
    }
    public abstract void draw(Graphics2D g2d);

    
}
