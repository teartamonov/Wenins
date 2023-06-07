import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    Main () {
        super("UWU");
        Cursor cursor = getCursor();
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setSize(1000,600);
        setDefaultCloseOperation(3);
        setLayout(null);
        Game game = new Game(this);
        Thread g = new Thread(game);

        JLabel deadge = new JLabel("YOU'RE DEADGE");
        deadge.setBounds(100,100,800,100);
        deadge.setFont(new Font("Serif", Font.BOLD, 30));
        add(deadge);
        deadge.setVisible(false);
        g.start();
        if (game.a_score<=0) {
            g.interrupt();
            deadge.setVisible(true);
            System.exit(0);
        }
        //game.playMusic(); раскомментить для показа

        game.playMusic();
        setVisible(true);

    }
    public static void main(String[] args) { Main main = new Main();}
}
