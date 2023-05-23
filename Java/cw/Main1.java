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
img = new ImageIcon("pie.png").getImage();
setDefaultCloseOperation(3);
setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height);

button = new JButton("+");
button.setBounds(x,y,w,h);
add(button);
Timer timer = new Timer(17, new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
x+=1;
angle += 10;
repaint();
}
});
timer.start();
setVisible(true);
}
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

public static void main (String[]args){
new Main();
}
}
