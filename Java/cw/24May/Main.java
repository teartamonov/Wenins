	

import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Main extends JFrame {
JButton button;
int x=40,y=40,w=250,h=250; int angle = 0;
Image img;


Main(){
super("Name");
setLayout(null);
img = new ImageIcon("../visual/lab2/miku_pic/cute.jpg").getImage();
PIc piic = new PIc("../visual/lab2/miku_pic/cute.jpg");
piic.setBounds(x,y,w,h);
add(piic);
Parallel p = new Parallel(piic);
Thread th = new Thread(p);
th.start();


setDefaultCloseOperation(3);
setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height);

button = new JButton("+");
button.setBounds(x,y,w,h);
add(button);
Timer timer = new Timer(60, new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
x+=1;
angle += 130;
repaint();
}
});

ArrayList<PIc> meteora = new ArrayList<PIc>(10);
for (int i = 0; i < 10; i ++){
meteora.add(createMeteor());
}

button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                meteora.add(createMeteor());

            }
        });

Thread rotateThread = new Thread(new Runnable() {
	@Override
	public void run(){
		while(true){
			for(PIc pic : meteora){
				pic.angle += 10;
				pic.repaint();}
				try{
		Thread.sleep(10);
	}
	catch(Exception e){
		return;
		}}}});
	rotateThread.start();
timer.start();
setVisible(true);
}

/*
@Override
public void paint(Graphics g){
super.paint(g);
g.drawRect(x,y,250,250);
Graphics2D g2 = (Graphics2D) g;
AffineTransform at = g2.getTransform();
g2.drawImage(img,x,y+100,w,h,null);
at.rotate(Math.toRadians(angle),x + w/2, y + h/2);
g2.setTransform(at);
g2.drawImage(img,x, y, w, h, null);
g2.drawImage(img,x+200, y+200, w, h, null);
g2.drawImage(img,x+400, y+200, w, h, null);
}
*/
PIc createMeteor(){
Random rng = new Random();
PIc pic = new PIc("../visual/lab2/miku_pic/cute.jpg");
pic.setBounds(rng.nextInt(getWidth()),rng.nextInt(getHeight()),100+rng.nextInt(20), 100+rng.nextInt(20));
add(pic);
return pic;
}

public static void main (String[]args){
new Main();
}
}


