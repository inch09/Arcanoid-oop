import java.awt.*;

public class Platform{
    private int X;
    private int Y;
    private int width;
    private int height;
    private int velX;
    private Color color;

    Platform(int width, int height,int X,int Y,int velX){
        this.width = width;
        this.height = height;
        this.X = X;
        this.Y = Y;
        this.velX = velX;
        this.color = new Color(150, 150, 80);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void updateWidth(int update){
        this.width+=update;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }
    public void izmenitX(int izm){
        this.X+=izm;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
