import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.Random;

public class Main extends JFrame
{
    Main(){
        super("App");
        setSize(200, 300);
        setDefaultCloseOperation(3);
        setLayout(null);
        
        Game game = new Game(this);
        new Thread(game).start();
        
        addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					game.ay = -15;
					}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
        
        setVisible(true);
}

public static void main(String[] args) {
		new Main();
	}
}
