public class Ball {
    private int X;
    private int Y;
    private int VelX;
    private int VelY;
    private int diameter;


    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getVelX() {
        return VelX;
    }

    public int getVelY() {
        return VelY;
    }

    public void setVelX(int VelX) {
        this.VelX = VelX;
    }

    public void setVelY(int VelY) {
        this.VelY = VelY;
    }
    Ball(int X,int Y,int VelX,int VelY,int diameter){
        this.X = X;
        this.Y = Y;
        this.VelX = VelX;
        this.VelY = VelY;
        this.diameter = diameter;
    }
    public void smenanapravleniyaX(){
        this.VelX*=-1;
    }
    public void smenanapravleniyaY(){
        this.VelY*=-1;
    }
    public void izmenitvelX(int izm){
        this.VelX+=izm;
    }
    public void izmenitvelY(int izm){
        this.VelY+=izm;
    }
    public void izmenitX(int izm){
        this.X+=izm;
    }
    public void izmenitY(int izm){
        this.Y+=izm;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }
}
