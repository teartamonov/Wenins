import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.nio.file.Files;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JLabel textLabel;
    private JLabel pic;
    private JLabel label;
    private JLabel picture;
    private Clip badEndingMusic;
    private Clip baddestEndingMusic;
    public Main() {
        super("Hatsune Miku: Yandere Love");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);

        JPanel game = new JPanel();
        game.setBounds(0, 0, getWidth(), getHeight());
        game.setLayout(null);
        add(game);

        JPanel mainMenu = new JPanel();
        mainMenu.setBounds(0, 0, getWidth(), getHeight());
        mainMenu.setLayout(null);
        add(mainMenu);

        JButton start_game = new JButton("Начать игру");
        start_game.setBounds(getWidth() - 520, getHeight() - 680, 400, 100);
        mainMenu.add(start_game);

        JButton close_game = new JButton("Покинуть игру");
        close_game.setBounds(getWidth() - 520, getHeight() - 560, 400, 100);
        mainMenu.add(close_game);

        JLabel startLabel = new JLabel(new ImageIcon("miku_pic/start.jpeg"));
        startLabel.setBounds(0, 0, getWidth(), getHeight());
        mainMenu.add(startLabel);

        JLabel home_l = new JLabel(new ImageIcon("miku_pic/home.jpeg"));
        home_l.setBounds(0, 0, getWidth(), getHeight());

        JButton game_menu = new JButton("Меню");
        game_menu.setBounds(0, 44, 228, 63);
        game.add(game_menu);

        JPanel gameMenu = new JPanel();
        gameMenu.setBounds(0, 0, 1920, 1080);
        gameMenu.setLayout(null);
        add(gameMenu);

        JButton continue_game = new JButton("Продолжить игру");
        continue_game.setBounds(getWidth() - 1160, getHeight() - 680, 400, 100);
        gameMenu.add(continue_game);

        JButton leave_game = new JButton("Покинуть игру");
        leave_game.setBounds(getWidth() - 1160, getHeight() - 560, 400, 100);
        gameMenu.add(leave_game);

        JLabel pauseLabel = new JLabel(new ImageIcon("miku_pic/pause.jpg"));
        pauseLabel.setBounds(0, 0, getWidth(), getHeight());
        gameMenu.add(pauseLabel);

        String filePath = "text/home_1.txt";
        String[] lines = null;
        final int[] i = {1};
        final int[] j = {1};

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            lines = text.toString().split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final String[] ls = lines;
        ArrayList<Pic> triangles = new ArrayList<Pic>(10);
        triangles.add(createTriangle(1150, 900));
        triangles.add(createTriangle(1180, 900));
        triangles.add(createTriangle(1165, 875));

        Thread rotateThread = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    for(Pic pic : triangles){
                        pic.angle += 4;
                        pic.repaint();}
                    try{
                        Thread.sleep(13);
                    }
                    catch(Exception e){
                        return;
                    }}}});
        rotateThread.start();


        JLabel pic = new JLabel(new ImageIcon("miku_pic/blood.png"));
        JLabel label = new JLabel("Я: - Мику, ты скоро? Мы так опоздаем в кино!");
        pic.setBounds(550, 750, 697, 230);
        label.setBounds(550, 750, 697, 230);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        game.add(label);
        game.add(pic);
        JLabel picture = new JLabel(new ImageIcon("miku_pic/" + String.valueOf(i[0]) + ".jpeg"));
        picture.setBounds(0, 0, getWidth(), getHeight());
        game.add(picture);


        pic.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                final String[] endg = {""};
                j[0] += 1;


                if (ls[j[0]].equals("end")) j[0] += 1;
                if (ls[j[0]].equals("new")) {
                    j[0] += 1;
                    i[0] += 1;}

                JButton alive = new JButton("Сбежать");
                alive.setBounds(getWidth() - 1160, getHeight() - 680, 400, 100);


                JButton deadge = new JButton("Возмутиться");
                deadge.setBounds(getWidth() - 1160, getHeight() - 560, 400, 100);


                alive.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent a) {
                        i[0] += 3;
                        j[0] += 12;
                        alive.setVisible(false);
                        deadge.setVisible(false);
                    }
                });

                deadge.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent a){
                        alive.setVisible(false);
                        deadge.setVisible(false);
                    }
                });

                if (ls[j[0]].equals("choice")) {
                    game.add(deadge);
                    game.add(alive);
                    game.setComponentZOrder(deadge, 0);
                    game.setComponentZOrder(alive, 0);
                }

                if (ls[j[0]].equals("song1")) {
                    playBaddestMusic();
                    rotateThread.interrupt();
                    hide_triangles(triangles);
                }

                if (ls[j[0]].equals("song2")) {
                    playBadMusic();
                    rotateThread.interrupt();
                    hide_triangles(triangles);
                }

                picture.setIcon(new ImageIcon("miku_pic/" + String.valueOf(i[0]) + ".jpeg"));
                pic.setIcon(new ImageIcon("miku_pic/blood.png"));
                label.setText(ls[j[0]]);
                pic.setBounds(550, 750, 697, 230);
                label.setBounds(550, 750, 697, 230);
                label.setFont(new Font("Arial", Font.BOLD, 14));
                label.setForeground(Color.WHITE);
                picture.setBounds(0, 0, getWidth(), getHeight());
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });

        start_game.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                mainMenu.setVisible(false);
                game.setVisible(true);
            }
        });


        close_game.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                System.exit(0);
            }
        });

        leave_game.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                System.exit(0);
            }
        });

        game_menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                game_menu.setVisible(false);
                game.setVisible(false);
                gameMenu.setVisible(true);
                }
        });

        continue_game.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                game_menu.setVisible(true);
                game.setVisible(true);
                gameMenu.setVisible(false);
            }
        });





        getContentPane().add(game);
        setVisible(true);
        game.setVisible(false);
        gameMenu.setVisible(false);
        }
    Pic createTriangle(int x, int y){
        Random rng = new Random();
        Pic pic = new Pic("miku_pic/blade.png");
        pic.setBounds(x,y, 50, 50);
        add(pic);
        return pic;
    }

    void hide_triangles(ArrayList <Pic> triangles){
        for(Pic pic : triangles){
            pic.setVisible(false);
            //pic.repaint();
            }
    }

    public void playBadMusic() {
        try {
            badEndingMusic = AudioSystem.getClip();
            badEndingMusic.open(AudioSystem.getAudioInputStream(new File("music/realhero.wav")));
            badEndingMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playBaddestMusic() {
        try {
            baddestEndingMusic = AudioSystem.getClip();
            baddestEndingMusic.open(AudioSystem.getAudioInputStream(new File("music/nightcall.wav")));
            baddestEndingMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    String readFile(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return new String(bytes);
    }

    public static void main (String[]args){
        new Main();

    }
}