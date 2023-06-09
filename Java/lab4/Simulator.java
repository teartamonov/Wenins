import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class Simulator{
    protected static int score = 0;
    protected static int  a_score = 600;
    int small_size = 100;
    JFrame help;
    ArrayList<Circle> circles = new ArrayList<Circle>();
    int time = 0;
    Random rng = new Random();
    Cursor cursor = new Cursor();
    Pic score_bar;
    ArrayList<Circle> cc;
    AI ai;
    Simulator(AI ai){
        this.ai = ai;

    }
    boolean isCircle(int x, int y){
        for(Circle c: circles){
            if((x < c.xs + c.small_size) && (x > c.xs)){
                if((y < c.ys + c.small_size) && (y > c.ys)){
                         return true;
                }
            }
        }
        return false;
    }

    public int run(){

        circles.add(new Circle(help, score, a_score, cc, score_bar));
        int total_time = 0;
        int time_left;
        while(score<100000) {
            //every 25 ms: -20pixels

            if (a_score <= 0) {
                return total_time;
            }
            ArrayList<Circle> cc = new ArrayList<Circle>();
            Circle round = circles.get(0);
            time_left = (round.xs - round.xb) * 5;
            if (time % 500 == 0) circles.add(new Circle(help, score, a_score, cc, score_bar));
            int[] tmp = ai.shouldClick(cursor.curs.getX()+10, cursor.curs.getY()+10, round.xs+50, round.ys+50, time_left);
            cursor.move(tmp[1],tmp[2]);
            if ((tmp[0] == 1) && (isCircle(cursor.curs.getX()+10,cursor.curs.getY()+10))){
                if (((round.xs - round.xb) < 15)) {
                    score += 300;
                    a_score += 40;
                } else if (round.xs - round.xb < 25) {
                    score += 200;
                    a_score += 20;
                } else if (round.xs - round.xb < 40) {
                    score += 100;
                    a_score += 10;
                } else if (round.xs - round.xb < 60) {
                    a_score -= 20;
                } else {
                    a_score -= 50;
                }
                cc.add(round);
            }

            for (Circle c : circles) {

                if ((c.xs - c.xb < -15)) {
                    cc.add(c);
                    a_score -= 50;
                }
                c.big_size -= 10;
                c.xb += 5;
                c.yb += 5;
                c.change();

            }
            for (Circle c : cc) {
                //c.hide(help);
                circles.remove(c);

            }
            time += 25;
            total_time += 25;
        }
        return total_time;

    }
    static void setScore(int value){
        score = value;
    }
    static void setA_score(int value){
        a_score = value;
    }
}
