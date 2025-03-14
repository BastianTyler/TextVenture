public class Player {
    private String name;
    private char gender;
    private int age;
    private int health;

    private int x;

    private int y;

    public Player(String name, char gender, int age, int x, int y){
    this.name = name;
    this.gender = gender;
    this.age = age;
    this.health = 100;
    this.x = x;
    this.y = y;
 }

    public String getName() {
            return name;
        }

    public char getGender() {
            return gender;
        }

    public int getAge() {
            return age;
        }

     public int getHealth() {
            return health;
        }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
