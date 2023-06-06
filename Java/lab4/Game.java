import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

class Game implements Runnable {
    int xs,ys;
    int xb,yb,ab = 50,bb = 50; //xbi, ybi;
    int score, a_score;
    int small_size = 100;
    int big_size = 300;
    int diff = 100;


    Pic circleSmall = new Pic("pics/circle_small.png"); //24x24
    Pic circleBig = new Pic("pics/circle_big.png");//50x50
    Pic score_bar_back = new Pic("pics/score_bar_back.png"); //50x50
    Pic score_bar = new Pic("pics/score_bar.png"); //30x30

    Random rng = new Random();

    /*void genBars(){
        Random rng = new Random();
        int h = 50 + rng.nextInt(100);
        //scoreBar.setBounds(200, 0, 50, 200-h);
    }*/
//пиздец вообще нихуя не понятно где что
    Game(JFrame frame){

        xs = 150 + rng.nextInt(350);
        ys = 150 + rng.nextInt(350);
        //xbi=xs-25; ybi=ys-25;
        score=0; a_score=10;

        xb = xs - diff;
        yb = ys - diff;


        score_bar_back.setBounds(10,10,600, 50);
        score_bar.setBounds(10,10,a_score, 50);
        //score_bar_back.setSize(600,50);
        //score_bar.setSize(a_score,30);

//                            250 250 25 25
                //            225 225 50 50
        circleSmall.setBounds(xs,ys,small_size,small_size);
        circleBig.setBounds(xb,yb,big_size,big_size);

        frame.add(circleSmall);
        frame.add(circleBig);
        frame.add(score_bar_back);
        frame.add(score_bar);

        //scoreBar = new PIc(""); //раз в полсекунды появл., сеукнда на схождение
        //когда большой круг = маленький круг - 300
        //когда большой круг внутри маленького круга - -очки
        //когда большой круг-маленький круг=50 - 50
        //когда большой круг-маленький круг = 25 - 100

    }

    public void run(){
        while(true){
                big_size -= 10;
                xb += 5;
                yb += 5;
                //ab = ab-4;
                //bb = bb-4;
                //вместо сет сайз добавляется новый элемент коллекции
            // если ты все еще спрашиваешь нахуя то отвечаю
            // 1 кружочек это скучная ебаная хуйня
                circleBig.setSize(big_size,big_size);
                circleBig.setLocation(xb,yb);


                circleBig.repaint();
                circleSmall.repaint();
                score_bar.repaint();
            //здесь и в мэйне они скрываются либо удаляются
                if (xs - xb == -15){
                    a_score -= 30;

                }

                try{
                    Thread.sleep(30);
                } catch(Exception e){
                    return;
                };

        }
    }

}
