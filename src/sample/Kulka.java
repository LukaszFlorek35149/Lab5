package sample;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Kulka {
    protected double ySpeed;
    protected double xSpeed;
    protected double xPos;
    protected double yPos;
    private Color color;
    private double radius;

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    Kulka(double xPos,double yPos, double xSpeed, double ySpeed)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        color = Color.WHITESMOKE;
        radius = 10;

    }

    Kulka(double xPos,double yPos, double xSpeed, double ySpeed, Color color)
    {
        this(xPos,yPos,xSpeed,ySpeed);
        this.color = color;
    }
    Kulka(double xPos,double yPos, double xSpeed, double ySpeed, Color color,double radius)
    {
        this(xPos,yPos,xSpeed,ySpeed);
        this.color = color;
        this.radius = radius;
    }


    public void checkBoundaryCollision(double xLeft, double yTop, double xRight, double yBottom)
    {
        if ((xPos <= xLeft+radius) || (xPos >= xRight-radius))
            xSpeed=-xSpeed;
        if ((yPos <= yTop+radius) || (yPos >= yBottom-radius))
            ySpeed=-ySpeed;
    }

    public void draw(GraphicsContext gc)
    {
        gc.setFill(color);
        gc.fillOval(xPos-radius,yPos - radius,2*radius,2*radius);
    }

    public void update()
    {
        xPos += xSpeed;
        yPos += ySpeed;
    }
}
