import java.awt.*;
import java.util.Random;

public class Bonus {
    private Color color;
    private boolean estliseichas;
    private int X;
    private int Y;
    private int diameter;
    private String str;
    private BonusType bonusType;
    private int vremyazhizni;

    Bonus() {
        diameter = 30;
        vremyazhizni = 500;
    }


    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }

    public void spawn() {
        Random random = new Random();
        X = random.nextInt(100, 400);
        Y = random.nextInt(100, 400);
        int c = random.nextInt(1, 12);
        if (c <= 2) {
            color = new Color(1, 1, 1);
            str = "plusochki";
            bonusType = BonusType.PLUSOCHIKI2;
        } else if (c <= 4) {
            color = Color.GREEN;
            str = "pluslife";
        } else if (c <= 6) {
            color = Color.BLUE;
            str = "uvelichenieplatform";
        } else if (c <= 8) {
            color = new Color(245, 87, 66);
            str = "minuszhizn";
        }
        estliseichas = true;
    }

    public void ubratbonus() {
        estliseichas = false;
    }

    public boolean isEstliseichas() {
        return estliseichas;
    }

    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public void setEstliseichas(boolean estliseichas) {
        this.estliseichas = estliseichas;
    }


    public String getStr() {
        return str;
    }

    public int getVremyazhizni() {
        return vremyazhizni;
    }

    public void setVremyazhizni(int vremyazhizni) {
        this.vremyazhizni = vremyazhizni;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
