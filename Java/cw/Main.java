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
 
 
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);
 
		
        
        JPanel game_panel = new JPanel();
        game_panel.setBounds(50, 50, getWidth(), getHeight());
        game_panel.setLayout(null);
        add(game_panel);
        
        JButton game_button = new JButton("NEW GAME");
        game_button.setBounds(0, 0, getWidth(), 50);
        add(game_button);
        
        JButton button = new JButton("Click!!!!");
        button.setBounds(25, 25, 500, 100);
        game_panel.add(button);
        Listener listener1 = new Listener(button);
        button.addActionListener(listener1);
        //setVisible(true);
        
        game_button.addActionListener(new ActionListener(){
        boolean visible = true;
			@Override
			public void actionPerformed(ActionEvent a){
			visible = !visible;
			game_panel.setVisible(visible);}
			
			});
			 
        
        JButton running_button = new JButton("ALO");
        running_button.setBounds(getWidth()/2-60, getHeight()/2-20, 200, 200);
        game_panel.add(running_button);
        running_button.setVisible(true);
        running_button.addActionListener(new ActionListener(){
        
			@Override
			public void actionPerformed(ActionEvent a){
			Random rng = new Random();
			running_button.setBackground(new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256)));
			}			
		});
		
		running_button.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {


			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				int dx = running_button.getWidth()/2 - e.getX();
				int dy = running_button.getHeight()/2 - e.getY();
				/*Random rng = new Random();
				int x = 30 + rng.nextInt(60);
				int y = 50 + rng.nextInt(100);
				running_button.setLocation(x, y);*/
				int x = running_button.getX() + dx;
				int y = running_button.getY() + dy;
				
				if (x < 0) x = 0;
				if (y < 0) y = 0;
				if (x + running_button.getWidth() > game_panel.getWidth()) x = -running_button.getWidth() + game_panel.getWidth();
				if (y + running_button.getHeight() > game_panel.getHeight()) y = -running_button.getHeight() + game_panel.getHeight();
				running_button.setLocation(x, y);
				
				
				if(running_button.getBounds().intersects(button.getBounds())) 
					button.setEnabled(false);
				else 
					button.setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
				
        
        
        
        
        
        JButton button2 = new JButton("Click!!!!");
        button2.setBounds(25, 130, 500, 100);
        game_panel.add(button2);
        Listener listener2 = new Listener(button2);
        button2.addActionListener(listener2);

		JTextArea textArea = new JTextArea();
        textArea.setBounds(25, 230, 500, 100);
        game_panel.add(textArea);
        //~textArea.Font(new Font("dddd", Font.BOLD, 20)); 
        
        
        JTextField textField = new JTextField();
        textField.setBounds(25, 330, 500, 100);
        game_panel.add(textField);
        
        JLabel label = new JLabel(new ImageIcon("swain.png"));
        label.setBounds(25, 430, 500, 100);
        game_panel.add(label);
        
        Controller control = new Controller(label);
        button.addKeyListener(control); 
        
        Chat chat = new Chat(textField, textArea);
        textField.addActionListener(chat);
        
        
        Timer timer = new Timer(10, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent a){
		label.setLocation(label.getX() + 1, label.getY() + 1);
		}
		
		});
        
        timer.start();
        
        setVisible(true);
    }
    class Controller implements KeyListener{
		JLabel label;
		Controller(JLabel label){
		this.label = label;
	}
	
		@Override
		public void keyTyped(KeyEvent a){}
		@Override
		public void keyPressed(KeyEvent a){
			switch(a.getKeyCode()){
				case KeyEvent.VK_W:
					label.setLocation(label.getX(), label.getY() - 5);
					break;
				case KeyEvent.VK_S:
					label.setLocation(label.getX(), label.getY() + 5);
					break;	
				case KeyEvent.VK_A:
					label.setLocation(label.getX() - 5, label.getY());
					break;	
				case KeyEvent.VK_D:
					label.setLocation(label.getX() + 5, label.getY());
					break;
						
				
				
	
				
				}
			}
		@Override
		public void keyReleased(KeyEvent a){}
		
		
	}

    
    class Listener implements ActionListener{
		int i = 0;
		JButton button;
		Listener (JButton button){
			this.button = button;
			}
		
	@Override
	public void actionPerformed(ActionEvent a){
		i++;
		button.setText("Clicked " + i + " times");
	}
}

class Chat implements ActionListener{
	JTextField input;
	JTextArea output;
	Chat(JTextField input, JTextArea output){
		this.input = input;
		this.output = output;
}
@Override
public void actionPerformed(ActionEvent a){
		output.setText(input.getText());
	}
}
public static void main(String[] args) {
		new Main();
	}
}
