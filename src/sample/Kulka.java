package sample;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Kulka {
    private final double R = 10;
    protected double ySpeed;
    protected double xSpeed;
    protected double xPos;
    protected double yPos;
    private Color color;

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    Kulka(double xPos,double yPos, double xSpeed, double ySpeed)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        color = Color.WHITESMOKE;
    }

    Kulka(double xPos,double yPos, double xSpeed, double ySpeed, Color color)
    {
        this(xPos,yPos,xSpeed,ySpeed);
        this.color = color;
    }

    public void checkBoundaryCollision(double xLeft, double yTop, double xRight, double yBottom)
    {
        if ((xPos <= xLeft+R) || (xPos >= xRight-R))
            xSpeed=-xSpeed;
        if ((yPos <= yTop+R) || (yPos >= yBottom-R))
            ySpeed=-ySpeed;
    }

    public void draw(GraphicsContext gc)
    {
        gc.setFill(color);
        gc.fillOval(xPos-R,yPos - R,2*R,2*R);
    }

    public void update()
    {
        xPos += xSpeed;
        yPos += ySpeed;
    }
}
