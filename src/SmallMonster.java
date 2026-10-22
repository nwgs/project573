import java.util.Random;
import java.util.Scanner;

public class SmallMonster extends Monster {

    SmallMonster(int boardSize) {
        Monster monster = new Monster(boardSize);
        monster.setMonimage("\uD83E\uDDCC");
        super(boardSize);
    }

    @Override

    public boolean taskMonster(int difficultGame){
        if ( difficultGame== 1) {
            return taskMonster();
        } else if (difficultGame == 2) {
            System.out.println(" ");
        }
        Random random = new Random();
        int c = random.nextInt(10);
        int m = random.nextInt(20);
        int truers = m * c;

        System.out.println("Реши пример:" + m + "*" + c + "= ?");

        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();

        if (an == truers) {
            System.out.println("Верно! ты победил монстра!");
            return true;
        } else {
            System.out.println("Ты проиграл эту битву...");

            return false;
        }
    }
   public boolean taskMonster() {
        return super.taskMonster(2);
    }
}
