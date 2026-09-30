import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int step = 0; //переменная для хода персонажа
        int personX; //переменная для координат по оси абсциз
        int personY; //переменная для координат по оси ординат
        int personLive = 3; //кол-во жизней гг
        int boardSize = 5; //размер поля 5 x 5
        personX = 1 + boardSize / 2; //размещение гг на 3 по абсцизе
        personY = 1 + boardSize / 2; //размещение гг на 3 по оординате
        step += 1; //счетчик ходов
        String person = "Г";
        String monster = "Мм";
        String gameField = "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    | " + monster + " |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "| " + person + " |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +";
        System.out.println("Привет! Ты готов начать игру? (Напиши: ДА или НЕТ)");
        System.out.println("Количество жизней:" + personLive);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);
        personX = 1;
        personY = boardSize;
        answer.equals("ДА");
        if (answer.equals("ДА")) {
            System.out.println("Начинаем играть");
        } else {
            System.out.println("Почему ты не захотел со мной играть? :(");
            System.out.println("Приходи еще!");
        }
        System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
        System.out.println("Координаты персонажа - (x:" + personX + ", y: " + personY + ")");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Math.abs(x - personX);
        if (x != personX && y != personY) {
            System.out.println("Некорректный ход");

        } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
            personX = x;
            personY = y;
            step += 1;
            System.out.println("Ход корректный; новые координаты: " + personX + ", " + personY +"/nХод номер: " + step);
        } else {
            System.out.println("Координаты не изменены"); //система проверки ходов, построенная на иф элсе
        }
        switch (answer) {
            case "ДА": //сверяем ответ с утыердительным
                // ...
                break;
            case "НЕТ":
                System.out.println("Жаль, приходи еще!");
                break;
            default:
                System.out.println("Данные введены некорректно");
        }
        if (answer.equals("ДА")) {
            System.out.println("Выбери сложность игры (от 1 до 5):");
            int difficultGame = scanner.nextInt();
            System.out.println("Выбранная сложность:\t" + difficultGame);
        }
    }
}





