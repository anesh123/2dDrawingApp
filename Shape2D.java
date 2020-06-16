
package pkg2dapplication;

import java.awt.Paint;
import java.awt.Stroke;


public abstract class Shape2D extends shape {
    private boolean filled;
    
    public Shape2D (int x,int y,Stroke stroke,Paint paint,boolean filled) {
        super(x,y,stroke,paint);
        this.filled = filled;
    }
    
    public int getTopX() {
        return Math.min(super.getStartPointX(), super.getEndPointX());
    }
    
    public int getTopY() {
        return Math.min(super.getStartPointY(), super.getEndPointY());
    }
    
    public int getWidth() {
        return Math.abs(getStartPointX() - getEndPointX());
    }
    
    public int getHeight() {
        return Math.abs(getStartPointY() - getEndPointY());
    }
    
    public void setFilled (boolean filled) {
        this.filled = filled;
    }
    
    public boolean getFilled () {
        return this.filled;
    }
}
