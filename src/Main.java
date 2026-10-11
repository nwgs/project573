
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int step = 1; //переменная для хода персонажа
        int boardSize = 5; //размер поля 5 x 5
        int personX = boardSize / 2; //размещение гг на 3 по абсцизе
        int personY = boardSize / 2; //размещение гг на 3 по оординате
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
        // String answer = scanner.nextLine();
        String answer = "да";
        System.out.println("Ваш ответ:\t" + answer);

        if (answer.equalsIgnoreCase("ДА")) {
            System.out.println("Начинаем играть");
        } else {
            System.out.println("Почему ты не захотел со мной играть? :(");
            System.out.println("Приходи еще!");
            System.exit(0);
        }

        // todo проверка введенного значения
//        System.out.println("Выбери сложность игры (от 1 до 5):");
//        int difficultGame = scanner.nextInt();
//        System.out.println("Выбранная сложность:\t" + difficultGame);
        // поле
        String person = "Г ";
        String monster = "Мм";
        String castle = "З ";

        String leftblock = "|  ";
        String rightblock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

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
            } else {
                personX = new_pos_x;
                personY = new_pos_y;
            }

            if (board[personX][personY] == monster) {
                System.out.println("Реши задачу...");
                // todo задача
            }

//            for (String[] row : board) {
//                System.out.println(wall);
//
//                for (String cell : row) {
//                    System.out.print(leftblock);
//                    System.out.print(cell);
//                }
//
//                System.out.println(rightblock);
//            }
//
//            System.out.println(wall);
//
//            System.out.println("Количество жизней:\t" + personLive + "\n");
//
//            System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
//                    "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + ")");
//
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//
//            System.out.println(x + ", " + y);
//
//            if (x != personX && y != personY) {
//                System.out.println("Некорректный ход");
//            } else if (
//                    Math.abs(x - personX) == 1
//                            || Math.abs(y - personY) == 1
//            ) {
//                if (board[y - 1][x - 1].equals("  ")) {
//                    board[personY - 1][personX - 1] = "  ";
//
//                    personX = x;
//                    personY = y;
//                    step++;
//
//                    System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY + "\nХод номер: " + step);
//
//                } else if (
//                        board[y - 1][x - 1].equals(castle)
//                ) {
//                    System.out.println("Вы прошли игру!");
//                    break;
//                } else {
//                    System.out.println("Решите задачу.");
//                }
//            } else {
//                System.out.println("Координаты не изменены");
//            }
//
//            if (personLive <= 0) {
//                break;
//            }
//
//
//            if (personLive <= 0) {
//                System.out.println(
//                        "Закончились жизни. Итог: ..."
//                );
//                break;
//
//            }
//            if (personLive > 0) {
//
//            }
        }
    }
}

// 0. ход персонажа

                    /*
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
                    for (int y = 1; y <= boardSize; y++) {
                        for (int x = 1; x <= boardSize; x++) {
                            board[y - 1][x - 1] = "  ";
                        }
                    }
                    for (int oy = 0; oy < boardSize; oy++) {
                        for (int ox = 0; ox < boardSize; ox++) {

                            for (int y = 1; y <= boardSize; y++) {
                                for (int x = 1; x <= boardSize; x++) {
                                    board[y - 1][x - 1] = "  ";
                                }
                            }
                        }
                    }

                    //1.1 помещаем замок и персонажа и монстров на карту
                    board[castleY - 1][castleX - 1] = castle;

                    for (int i = 0; i < countMonster; i++) {
                        board[random.nextInt(boardSize - 1)][random.nextInt(boardSize)] = monster;
                    }
                    // 2. выводим карту на экран
                    for (int y = 1; y <= boardSize; y++) {
                        for (int x = 1; x <= boardSize; x++) {
                            board[y - 1][x - 1] = "  ";
                            System.out.println(rightblock);
                        }
                        System.out.println(wall);
                    }

                    //отрисовка поля
//отрисовка поля
//отрисовка поля


                    //System.out.println(rightblock);

                    //System.out.println(wall);

                    if (castleX == personX && castleY == personY) {
                        System.out.println("Поздравляем, вы прошли игру!!!");
                        break;

*/














