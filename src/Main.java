
import java.util.Random;
import java.util.Scanner;
public class Main {
    static final int boardSize = 5; //размер поля 5 x 5
    public int difficultGame;
    public static void main(String[] args) {
        int step = 0; //переменная для хода персонажа

        int countMonster = boardSize * boardSize - boardSize - 1;
        Random random = new Random();

        Person person = new Person(boardSize);

        BigMonster[] bigmnstr = new BigMonster[20];
        for (int i = 0; i < 20; i ++){
            bigmnstr[i] = new BigMonster(boardSize);
        }

        SmallMonster[] smallmnstr = new SmallMonster[18];
        for (int i = 0; i < 18; i ++){
            smallmnstr[i] = new SmallMonster(boardSize);
        }

        Monster[] monsters = new Monster[19];
        for (int i  = 0; i < 19; i ++)
        {
            monsters[i] = new Monster(boardSize);
        }

        String[][] board = new String[boardSize][boardSize];
        int castleY = 0;
        int castleX = 0;
        // здесь инициализуруется кол-во монстров


        // начало игры
        System.out.println("Количество жизней:" + person.getLive());
        System.out.println("Привет! Ты готов начать игру? (Напиши: ДА или НЕТ)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        if (answer.equalsIgnoreCase("ДА")) {
            System.out.println("Начинаем играть");
        } else {
            System.out.println("Почему ты не захотел со мной играть? :(");
            System.out.println("Приходи еще!");
            System.exit(0);
        }
        //проверка сложности
        System.out.println("Выбери сложность игры (от 1 до 5):");
        int DifficultGame = scanner.nextInt();
        switch (DifficultGame) {
            case 1 :
                System.out.println("Выбранная сложность:\t" + DifficultGame);
                break;
            case 2:
                System.out.println("Выбранная сложность:\t" + DifficultGame);
                break;
            case 3:
                System.out.println("Выбранная сложность:\t" + DifficultGame);
                break;
            case 4:
                System.out.println("Выбранная сложность:\t" + DifficultGame);
                break;
            case 5:
                System.out.println("Выбранная сложность:\t" + DifficultGame);
                break;
            default:
                System.out.println("Некорректная сложность.");
                System.exit(0);
                break;
        }


        // поле

        String castle = "\uD83C\uDFF0";

        castleX = random.nextInt(boardSize);

        while (true) {
            // очистка карты
            for (int y = 0; y < boardSize; y++) {
                for (int x = 0; x < boardSize; x++) {
                    board[y][x] = "  ";
                }
            }
            // выовдим монстров
            if (DifficultGame == 1) {
                for (int i = 0; i < monsters.length; ++i) {
                    board[monsters[i].getx()][monsters[i].getY()] = Monster.monimage;
                }
            } else if (DifficultGame == 2) {
                for (int i = 0; i < smallmnstr.length; ++i) {
                    board[smallmnstr[i].getx()][smallmnstr[i].getY()] = Monster.monimage;
                }
            } else {
                for (int i = 0; i < bigmnstr.length; ++i) {
                    board[bigmnstr[i].getx()][bigmnstr[i].getY()] = Monster.monimage;
                }
            }
            board[person.getx()][person.getY()] = person.getImage();
            board[castleX][castleY] = castle;

            outputBoard(board, person.getLive());

            if (person.getx() == castleX && person.getY() == castleY) {
                System.out.println("Поздравляю! Вы прошли игру!");
                break;
            }
            if (person.getLive() == 0) {
                System.out.println("Вы проиграли!");
                System.exit(0);
            }

            System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
            System.out.println("Координаты персонажа - (x:" + (person.getx() + 1) + ", y: " + (person.getY() + 1) + ")");
            int new_pos_x = scanner.nextInt();
            int new_pos_y = scanner.nextInt();
            --new_pos_x;
            --new_pos_y;
            // проверка корректности хода
            if (! person.isMoveCorrect(new_pos_x, new_pos_y)) {
                System.out.println("Некорректный ход");
                continue;
            }
            person.move(new_pos_x, new_pos_y);
            //монстры и все про них
            if (board[person.getx()][person.getY()] == Monster.monimage) {
                System.out.println("Реши задачу...");

                // дополнение начинается тут
                if (DifficultGame == 1) {
                    if (!monsters[18].taskMonster(DifficultGame)) {
                        person.decLives();
                    } else {
                        board[person.getY()][person.getx()] = "  ";
                        step++;
                    }
                } else if (DifficultGame == 2) {
                    if (!smallmnstr[17].taskMonster(DifficultGame)) {
                        person.decLives();
                    } else {
                        board[person.getY()][person.getx()] = "  ";
                        step++;
                    }
                }else {
                    if (!bigmnstr[18].taskMonster(DifficultGame)) {
                        person.decLives();
                    } else {
                        board[person.getY()][person.getx()] = "  ";
                        step++;
                    }
                    }
                 if (person.getLive() == 0){
                     System.out.println("Так уж и быть, я тебя помилую, если отгадаешь чило от 1 до 10");
                     int num = random.nextInt(1, 10);
                     int ansn = scanner.nextInt();
                     if (num == ansn){
                         System.out.println("Ох, не думал, что ты отгадаешь... Ладно, свободен!");
                         person.plsLives();
                     } else {
                         System.out.println("Вы проиграли!");
                         System.exit(0);
                     }
                 }
                }
            }


 } // end main
    /* *******************************************************************
    *  место для функций
    * ******************************************************************** * */



    /* @breif вывод карты
    @param board - карта
    @param live - жизни персонажа
    * */
    static void outputBoard(String[][] board, int live) {
        String leftblock = "|  ";
        String rightblock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        System.out.println(wall);
        for (int y = 0; y < Main.boardSize; y++) {
            for (int x = 0; x < Main.boardSize; x++) {
                System.out.print(leftblock);
                System.out.print(board[x][y]);
                if (x == 4)
                    System.out.print(rightblock);
            }
            System.out.println();
            System.out.println(wall);
        }
        System.out.println("Количество жизней:\t" + live + "\n");
    }

} // end class main













