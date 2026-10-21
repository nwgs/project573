import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster{

    BigMonster(int boardSize) {
        super(boardSize);
    }
    @Override
    public boolean taskMonster(int difficultGame){
        if ( difficultGame== 1 || difficultGame == 2) {
            return taskMonster();
        }else {
            System.out.println("Решите задачу...");
        }

        Random random = new Random();

        int z = random.nextInt(10 * difficultGame);
        int o = random.nextInt( 10 * difficultGame);
        int v = random.nextInt(100 * difficultGame);
        int trueAnswer = z * o - v;

        System.out.println("Реши пример:" + z + "*" + o + "-" + v + "= ?");

        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        if (answer == trueAnswer) {
            System.out.println("Верно! ты победил монстра!");
            return true;
        }else {
            System.out.println("Ты проиграл эту битву...");
            return false;
        }

    }
    public boolean taskMonster() {
        return super.taskMonster(1);
    }
}
