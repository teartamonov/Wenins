import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.Random;



class Game implements Runnable{
Pic top_bar;
Pic bot_bar;
Pic bird;
float ay = 0;

Game( JFrame frame){
top_bar = new Pic("../1.jpg");
frame.add(top_bar);
bot_bar = new Pic("../2.jpg");
frame.add(top_bar);
bird = new Pic("../3.jpg");

bird.setBounds(80, 150, 20, 20);
frame.add(bird);
gen_bars();

}



void gen_bars(){
	Random rng = new Random();
	int h = 50 - rng.nextInt(100);
	top_bar.setBounds(200, 0, 50, 200-h);
	bot_bar.setBounds(200, 300-h, 50, h);
	
}

public void run(){
	//AI ai = new AI (new float[] {});
	
	int delay = 100;
	while(true){
		bird.setLocation(bird.getX(), (int)(bird.getY() + ay + delay/1000));
		ay += 3;
		top_bar.setLocation(top_bar.getX()-1, top_bar.getY()-1);
		bot_bar.setLocation(bot_bar.getX()-1, bot_bar.getY()-1);
		
		if(bird.getBounds().intersects(top_bar.getBounds()) || bird.getBounds().intersects(bot_bar.getBounds()) || bird.getY() <= 0 || bird.getY() >= 280){
			return;
		}
		
		if(top_bar.getX() < -50){
			gen_bars();
		}
		try{
			Thread.sleep(delay);
		}
		catch(Exception e){
			return;
		}

}

}
}
