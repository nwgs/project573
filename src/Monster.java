import java.util.Random;
import java.util.Scanner;

public class Monster {
    public void setMonimage(String monimage) {
        Monster.monimage = monimage;
    }

    Random random = new Random();

    protected int x;
    protected int y;
    static String monimage = "\uD83E\uDDDF";
    private int live = 3;

    Monster(int boardSize) {
        x = random.nextInt(boardSize);
        y = random.nextInt(5);;
    }

    public int getx(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int trueAnswer = a + b;
            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else {
            // какой-то код
        }
        return false;
    }

    public String getMonimage() {
        return monimage;
    }



}
