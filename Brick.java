import java.awt.*;
import java.util.Random;

public class Brick {
    private int X;
    private int Y;
    private int width;
    private int height;
    private Color color;

    Brick(int width,int height){
        Random random = new Random();
        X = random.nextInt(600);
        Y = random.nextInt(400);
        this.width = width;
        this.height = height;
        this.color = new Color(245, 144, 66);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setX(int x) {
        X = x;
    }

    public void replace() {
        Random random = new Random();
        X = random.nextInt(600);
        Y = random.nextInt(400);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

