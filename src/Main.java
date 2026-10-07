
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int step = 0; //переменная для хода персонажа
        int personX; //переменная для координат по оси абсциз
        int personY; //переменная для координат по оси ординат
        int personLive = 3; //кол-во жизней гг
        int boardSize = 5; //размер поля 5 x 5
        String[] board = new String[boardSize * boardSize];
        int castleY = 1;
        int castleX = 1;

        personX = 1 + boardSize / 2; //размещение гг на 3 по абсцизе
        personY = 1 + boardSize / 2; //размещение гг на 3 по оординате
        step += 1; //счетчик ходов
        String person = "Г";
        String monster = "Мм";
        String castle = "З";
        String gameField =
                "+ —— + —— + —— + —— + —— +\n"
                        + "| " + castle + " |    |    |    |    |\n"
                        + "+ —— + —— + —— + —— + —— +\n"
                        + "|    |    |    |    |    |\n"
                        + "+ —— + —— + —— + —— + —— +\n"
                        + "|    |    | " + monster + " |    |    |\n"
                        + "+ —— + —— + —— + —— + —— +\n"
                        + "|    |    |    |    |    |\n"
                        + "+ —— + —— + —— + —— + —— +\n"
                        + "| " + person + " |    |    |    |    |\n"
                        + "+ —— + —— + —— + —— + —— +";

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
        }


        String leftblock = "|   ";
        String rightblock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        Random random = new Random();
        castleX = 1 + random.nextInt(boardSize);


        while (true) {
            // 0. ход персонажа

            System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
            System.out.println("Координаты персонажа - (x:" + personX + ", y: " + personY + ")");
            int new_pos_x = scanner.nextInt();
            int new_pos_y = scanner.nextInt();

            if ((new_pos_x > boardSize || new_pos_x < 1 || new_pos_y > boardSize || new_pos_y < 1)
                    || Math.abs(new_pos_x - personX) > 1 || Math.abs(new_pos_y - personY) > 1) {
                System.out.println("Некорректный ход");
                continue;
            } else {
                personX = new_pos_x;
                personY = new_pos_y;
            }


            // 1. обнуляем массив
            for (int oy = 0; oy < boardSize; oy++) {
                for (int ox = 0; ox < boardSize; ox++) {
                    board[(oy) * boardSize + ox] = " ";
                }
            }
            // 1.1 помещаем замок и персонажа на карту
            board[(castleY - 1) * boardSize + castleX - 1] = castle;
            board[(personY - 1) * boardSize + personX - 1] = person;

            // 2. выводим карту на экран
            for (int oy = 0; oy < boardSize; oy++) {
                System.out.println(wall);
                for (int x = 0; x < boardSize; x++) {
                    System.out.print(leftblock);
                    System.out.print(board[oy * boardSize + x]); //отрисовка поля
                }

                System.out.println(rightblock);
            }

            System.out.println(wall);

            if (castleX == personX && castleY == personY) {
                System.out.println("Поздравляю вы в домике вас не съел Монст!!!");
                break;
            }
        }
    }
}










