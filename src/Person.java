import java.util.Random;

public class Person {

    public void setImage(String image) {
        this.image = image;
    }

    public void  downLive(){
        if (live <= 0) {
            live = 0;
        } else {
            live --;
        }
    }

    public String getImage(){
        return image;
    }

    public int getx(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getLive(){
        return live;
    }

    private int x;
    private int y;
    private String image = "\uD83E\uDDD9";
    private int live = 3;
    private int boardSize = 0;



    Person(int boardSize) {
        Random random = new Random();
        x = random.nextInt(boardSize);
        y = boardSize - 1;
        this.boardSize = boardSize;
    }

    void move(int x, int y) {
       this.x = x;
       this.y = y;
    }// end move method

    public boolean isMoveCorrect(int new_pos_x, int new_pos_y) {
        boolean res = (new_pos_x < boardSize) && (new_pos_x >= 0) && (new_pos_y < boardSize) && (new_pos_y >= 0) && Math.abs(new_pos_x - x) <= 1 && Math.abs(new_pos_y - y) <= 1;
        return  res;
    }
    public void decLives() {
      --live;
    }
    public void plsLives() {++live;}
}// end person class
