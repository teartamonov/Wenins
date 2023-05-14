import java.util.Random;
import java.util.Scanner;

class Field {
    int w, h;
    char [][] matrix;
    Field(int w, int h){
        this.w = w;
        this.h = h;
        matrix = new char[w][h];

    }

    void fill(){
        Random rng = new Random();
        for(int i=0; i<w; i++)
            for(int j=0; j<h; j++) {
                int dice = rng.nextInt(100);
                if (dice<50) matrix[i][j] = '_';
                else if (dice<70) matrix[i][j] = '$';
                else if (dice<90) matrix[i][j] = '|';
                else matrix[i][j] = '*';
            }
        matrix[0][0] = '_';
    }

    void output(Unit unit){
        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++) {
                if (unit.x==j && unit.y==i){
                    System.out.print("&  ");
                }
                else {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("HP: "+unit.hp+"     Score: "+unit.score);
    }

    boolean canGo(int x, int y){
        if (x<0||x>=w||y<0||y>=h) {
            return false;
        }
        return true;
    }
}


class Unit {
    int hp, score;
    int x, y;
    Field field;
    Unit(Field field, int x, int y){
        this.field = field;
        this.x = x;
        this.y = y;
        hp = 10;
        score = 0;
    }
    void move(char key){
        int nx = x, ny = y;
        switch (key) {
            case 'w': ny--; break;
            case 's': ny++; break;
            case 'a': nx--; break;
            case 'd': nx++; break; //d
            default: System.out.println("Unknown key."); return;
        }
        if(!field.canGo(nx,ny)) {
            System.out.println("IDI NAHUI!");
            nx = x;
            ny = y;
            return;
        }
        if(field.matrix[ny][nx]=='|') {
            System.out.println("There is a wall!");
            nx = x;
            ny = y;
            return;
        }
        if(field.canGo(nx,ny)&&field.matrix[ny][nx]=='$'){
            score++;
            field.matrix[ny][nx] = '_';
        }
        if(field.canGo(nx,ny)&&field.matrix[ny][nx]=='*'){
            hp--;
        }
        x = nx;
        y = ny;
        System.out.println(nx+"       "+ny);
    }
}
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[]arcs) {
        Field field = new Field(10,10);
        field.fill();
        Unit unit = new Unit (field, 0, 0);
        field.output(unit);
        char key;
        Scanner reader = new Scanner(System.in);
        do {
            key = reader.next().charAt(0);
            unit.move(key);
            field.output(unit);
        }while(key!='e' && unit.hp > 0);

    }
}
