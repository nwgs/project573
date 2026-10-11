
import java.util.Random;
import java.util.Scanner;
public class Main {
    static final int boardSize = 5; //размер поля 5 x 5

    public static void main(String[] args) {
        int step = 0; //переменная для хода персонажа
        int personX = boardSize / 2; //размещение гг на 3 по абсцизе
        int personY = boardSize / 2; //размещение гг на 3 по оординате
        int difficultGame = 1;
        int personLive = 3; //кол-во жизней гг

        String[][] board = new String[boardSize][boardSize];
        int castleY = 0;
        int castleX = 0;
        // здесь инициализуруется кол-во монстров
        int countMonster = boardSize * boardSize - boardSize - 1;

        // начало игры
        System.out.println("Количество жизней:" + personLive);
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

        // todo проверка введенного значения
        System.out.println("Выбери сложность игры (от 1 до 5):");
        difficultGame = scanner.nextInt();
        System.out.println("Выбранная сложность:\t" + difficultGame);
        // поле
        String person = "Г ";
        String monster = "Мм";
        String castle = "З ";

        Random random = new Random();
        castleX = random.nextInt(boardSize);

        while (true) {
            // очистка карты
            for (int y = 0; y < boardSize; y++) {
                for (int x = 0; x < boardSize; x++) {
                    board[y][x] = "  ";
                }
            }
            // выовдим монстров
            for (int i = 0; i < countMonster; ++i) {
                int monsterX = random.nextInt(boardSize);
                int monsterY = random.nextInt(boardSize);
                board[monsterX][monsterY] = monster;
            }

            board[personX][personY] = person;
            board[castleX][castleY] = castle;

            outputBoard(board, personLive);

            if (personX == castleX && personY == castleY) {
                System.out.println("Поздравляю! Вы прошли игру!");
                break;
            }
            if (personLive == 0) {
                System.out.println("Вы проиграли!");
                System.exit(0);
            }

            System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
            System.out.println("Координаты персонажа - (x:" + (personX + 1) + ", y: " + (personY + 1) + ")");
            int new_pos_x = scanner.nextInt();
            int new_pos_y = scanner.nextInt();
            --new_pos_x;
            --new_pos_y;

            if ((new_pos_x >= boardSize || new_pos_x < 0 || new_pos_y >= boardSize || new_pos_y < 0)
                    || Math.abs(new_pos_x - personX) > 1 || Math.abs(new_pos_y - personY) > 1) {
                System.out.println("Некорректный ход");
                continue;
            }

            if (board[personX][personY] == monster)
            {
                System.out.println("Реши задачу...");
                // дополнение начинается тут
                if (taskMonster(difficultGame)) {
                    board[personY][personX] = "  ";
                    personX = new_pos_x;
                    personY = new_pos_y;
                    step++;
                } else {
                    personLive--;
                }
            }
        }
    } // end main

    /* *******************************************************************
    *  место для функций
    * ******************************************************************** * */

    static boolean taskMonster(int difftGame) {
        if (difftGame == 1) {
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

    /* @breif вывод карты
    @param board - карта
    @param live - жизни персонажа
    * */
    static void outputBoard(String[][] board, int live) {
        String leftblock = "|  ";
        String rightblock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        System.out.println(wall);
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
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














