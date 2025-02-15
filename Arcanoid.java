import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Arcanoid extends JPanel implements ActionListener, KeyListener {

    private int x = 0;
    private int score = 0;
    private int countLife = 1;
    private boolean gameOver;


    private int boardWidth;
    private int boardHeight;

    Platform platform = new Platform(150,20,300,700,0);
    Ball ball = new Ball(100,100,5,5,20);
    Brick brick = new Brick(100,10);
    Bonus bonus = new Bonus();



    Timer gameStart;

    Arcanoid(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(new Color(66, 167, 245));
        addKeyListener(this);
        setFocusable(true);
        JLabel centerLabel = new JLabel("Center");
        centerLabel.setText("213");



        gameStart = new Timer(10, this);
        gameStart.start();


    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // platform
        g.setColor(platform.getColor());
        g.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());
        //brick
        g.setColor(brick.getColor());
        g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        //ball
        g.setColor(Color.black);
        g.fillOval(ball.getX(),ball.getY(), ball.getDiameter(), ball.getDiameter());
        if (bonus.isEstliseichas()) {
            g.setColor(bonus.getColor());
            g.fillOval(bonus.getX(),bonus.getY(),bonus.getDiameter(),bonus.getDiameter());
        }
        if (gameOver) {
            g.setColor(Color.red);
            g.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());
            g.setColor(Color.red);
            g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
        }

    }

    public void move() {
        if (countLife <= 0) {
            gameOver = true;
        }
        if ((ball.getX() >= (bonus.getX() - ball.getDiameter()) && ball.getX() <= (bonus.getX() + bonus.getDiameter())) && (ball.getY() >= (bonus.getY() - ball.getDiameter()) && ball.getY() <= (bonus.getY() + bonus.getDiameter())) && (bonus.isEstliseichas())) {
            bonus.setEstliseichas(false);
            if (bonus.getStr().equals("plusochki")) {
                score += 5;
            }
            if (bonus.getStr().equals("pluslife")) {
                countLife++;
            }
            if (bonus.getStr().equals("uvelichenieplatform")) {
                platform.updateWidth(30);
            }
            if (bonus.getStr().equals("minuszhizn")) {
                countLife--;
            }


        }
        if (platform.getX() >= boardWidth - platform.getWidth()) {
            platform.setVelX(0);
            platform.setX(boardWidth -1 - platform.getWidth());
        } else if (platform.getX() <= 0) {
            platform.setVelX(0);
            platform.setX(1);
        }
        platform.izmenitX(platform.getVelX());
        if ((ball.getX() >= boardWidth-ball.getDiameter()) || ball.getX() <= 0) {
            ball.smenanapravleniyaX();
        }
        if (ball.getY() <= 0) {
            ball.smenanapravleniyaY();
        }
        if (ball.getY() >= (boardHeight-ball.getDiameter())) {
            countLife--;
            ball.smenanapravleniyaY();
            if (countLife == 0) {
                gameOver = true;
                System.out.println("Game Over");
                System.out.println("Score: " + score);
            }
        }
        if ((ball.getY() + ball.getDiameter() >= platform.getY() && ball.getY() <= platform.getY() + platform.getHeight()) && (ball.getX() + platform.getHeight() >= platform.getX() && ball.getX() <= platform.getX() + platform.getWidth()) && ball.getVelY() > 0) {
            ball.smenanapravleniyaY();
        }
        if ((ball.getY() + ball.getDiameter() >= brick.getY() && ball.getY() <= brick.getY() + brick.getHeight()) && (ball.getX() + brick.getHeight() >= brick.getX() && ball.getX() <= brick.getX() + brick.getWidth())) {
            ball.smenanapravleniyaY();
            score++;
            brick.replace();
            if (!bonus.isEstliseichas()) {
                bonus.spawn();
            }
        }
        ball.izmenitX(ball.getVelX());
        ball.izmenitY(ball.getVelY());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            platform.setVelX(-5);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            platform.setVelX(5);
        }
        // уменьшение или возрастание скорости мячика
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ball.setVelY(ball.getVelY() / Math.abs(ball.getVelY()) * (Math.abs(ball.getVelY()) + 1));
            ball.setVelX(ball.getVelX() / Math.abs(ball.getVelX()) * (Math.abs(ball.getVelX()) + 1));
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && Math.abs(ball.getVelY()) > 1) {
            ball.setVelY(ball.getVelY() / Math.abs(ball.getVelY()) * (Math.abs(ball.getVelY()) - 1));
            ball.setVelX(ball.getVelX() / Math.abs(ball.getVelX()) * (Math.abs(ball.getVelX()) - 1));

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        if (bonus.isEstliseichas()) {
            if (x == bonus.getVremyazhizni()) {
                bonus.setEstliseichas(false);
                x = 0;
            }
            x += 1;
        }
        repaint();

        if (gameOver) {
            gameStart.stop();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }
}