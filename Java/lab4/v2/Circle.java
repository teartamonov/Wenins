import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Circle extends JComponent {
    JLabel small_circle = new JLabel();
    JLabel big_circle = new JLabel();
    int xs, ys, xb, yb, small_size, big_size;

    /*Circle(int a, int b, int c, int d, int e, int f) {
        xs = a;
        ys = b;
        xb = c;
        yb = d;
        small_size = e;
        big_size = f;

        small_circle.setIcon(new ImageIcon("pics/circle_small.png"));
        big_circle.setIcon(new ImageIcon("pics/circle_big.png"));
        small_circle.setBounds(xs,ys,small_size,small_size);
        big_circle.setBounds(xb,yb,big_size,big_size);
    }*/
    Circle (JFrame frame){
        Random rng = new Random();
        xs = 150 + rng.nextInt(350);
        ys = 150 + rng.nextInt(350);
        xb = xs - 100;
        yb = ys - 100;
        small_size = 100;
        big_size = 300;
        small_circle.setIcon(new ImageIcon("pics/circle_small.png"));
        big_circle.setIcon(new ImageIcon("pics/circle_big.png"));
        small_circle.setBounds(xs,ys,small_size,small_size);
        big_circle.setBounds(xb,yb,big_size,big_size);
        frame.add(small_circle);
        frame.add(big_circle);
        //Circle c = new Circle(xs, ys, xb, yb, small_size, big_size);
    }

    void add(JFrame frame){
        frame.add(small_circle);
        frame.add(big_circle);
    }
    void hide(JFrame frame){
        frame.remove(small_circle);
        frame.remove(big_circle);


    }
    void change(){
        big_circle.setBounds(xb,yb,big_size,big_size);
    }

}
