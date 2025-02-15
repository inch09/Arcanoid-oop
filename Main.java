import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arcanoid");
        int boardWidth = 800;
        int boardHeight = 800;
        frame.setVisible(true);
        frame.setLocation(500,50);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Arcanoid arcanoid = new Arcanoid(boardWidth, boardHeight);
        frame.add(arcanoid);
        frame.pack();
        arcanoid.requestFocus();

    }
}