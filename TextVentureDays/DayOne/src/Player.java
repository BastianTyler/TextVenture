public class Player {
        private String name;
        private char gender;
        private int age;
        private int health;

        public Player(String name, char gender, int age){
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.health = 100;
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
}
