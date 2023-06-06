import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.ArrayList;
class Game implements Runnable {
    int xs,ys;
    int xb,yb;
    int score, a_score;
    int small_size = 100;
    int big_size = 300;
    int diff = 100;
    JFrame help;
    ArrayList<Circle> circles = new ArrayList<Circle>();

    Pic circleSmall = new Pic("pics/circle_small.png"); //24x24
    Pic circleBig = new Pic("pics/circle_big.png");//50x50
    Pic score_bar_back = new Pic("pics/score_bar_back.png"); //50x50
    Pic score_bar = new Pic("pics/score_bar.png"); //30x30
    int time = 0;
    Random rng = new Random();

    Game(JFrame frame){
        help = frame;

        //xs = 150 + rng.nextInt(350);
        //ys = 150 + rng.nextInt(350);
        score = 0; a_score = 10;

        //xb = xs - diff;
        //yb = ys - diff;

        score_bar_back.setBounds(10,10,600, 50);
        score_bar.setBounds(33,10, a_score, 50);

        //circleSmall.setBounds(xs,ys,small_size,small_size);
        //circleBig.setBounds(xb,yb,big_size,big_size);

        //frame.add(circleSmall);
        //frame.add(circleBig);
        frame.add(score_bar_back);
        frame.add(score_bar);


    }

    public void run(){
        while(true){
            ArrayList<Circle> cc = new ArrayList<Circle>();
            if (time % 500 == 0) circles.add(new Circle(help));
            for (Circle c : circles) {

                if ((c.xs - c.xb < -15) || (c.big_size <= 0)) {
                    c.big_size = 10;
                    cc.add(c);
                    a_score -= 30;
                    score_bar.repaint();
                }
                c.big_size -= 10;
                c.xb += 5;
                c.yb += 5;
                c.change();
                help.repaint();
            }
            for (Circle c : cc) {
                c.hide(help);
                circles.remove(c);
            }
            try{
                time += 25;
                Thread.sleep(30);
            } catch(Exception e){
                return;
            };
        }
    }
}
