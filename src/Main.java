import static helpers.Terminal.*;

public class Main {

    // javac -sourcepath src src/Main.java -d ./out/production/JavaAdventure/ ; java -cp ./out/production/JavaAdventure/ Main

    public static final int FOREGROUND_BLACK = 30;
    public static final int FOREGROUND_RED = 31;
    public static final int FOREGROUND_GREEN = 32;
    public static final int FOREGROUND_YELLOW = 33;
    public static final int FOREGROUND_BLUE = 34;
    public static final int FOREGROUND_MAGENTA = 35;
    public static final int FOREGROUND_CYAN = 36;
    public static final int FOREGROUND_WHITE = 37;

    public static void printInfo(String name, int healthPoints) {
        printWithColor("Name: ", FOREGROUND_WHITE);
        printlnWithColor(name, FOREGROUND_CYAN);
        printWithColor("Healthpoints: ", FOREGROUND_WHITE);
        printlnWithColor(healthPoints + "", FOREGROUND_RED);
        System.out.println();
    }

    public static void printHealthPointSword(int healthPoint) {

        int greenEqualSigns = (healthPoint + 3) / 4;

        printlnWithColor("            //", FOREGROUND_WHITE);
        printWithColor("()=========>>", FOREGROUND_WHITE);

        // print green Sword part
        for (int i = 0; i < greenEqualSigns; i++) {

            printWithColor("=", FOREGROUND_GREEN);
        }

        // print remaining part in red
        for (int i = 0; i < 25 - greenEqualSigns; i++) {

            printWithColor("=", FOREGROUND_RED);
        }
        printlnWithColor("--", FOREGROUND_WHITE);
        printlnWithColor("            \\\\", FOREGROUND_WHITE);
    }

    public static int calculateNewHealthPoints(int currentHealthPoints, int healthPointChange) {
        int result = currentHealthPoints + healthPointChange;
        if (result > 100) {
            return 100;
        } else if (result < 0) {
            return 0;
        } else {
            return result;
        }
    }

    public static void shortDelay() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String name = "Andrea";
//        int healthPoints = 100;
//
//        printInfo(name, healthPoints);
//        printHealthPointSword(healthPoints);


//        while (healthPoints > 0) {
//            int damage = (int) (- 10 * Math.random()) -1;
//            printWithColor("Damage: ", FOREGROUND_MAGENTA);
//            printlnWithColor(damage + "", FOREGROUND_RED);
//            healthPoints = calculateNewHealthPoints(healthPoints, damage);
//            printInfo(name, healthPoints);
//            printHealthPointSword(healthPoints);
//            System.out.println();
//        }
//
//        System.out.println(name + " ist tot!!!");

        clearScreen();
        disableCursor();

        boolean[] isWall = new boolean[20];
        isWall[1] = true;
        isWall[10] = true;
        isWall[19] = true;

        int position = 4;
        while (true) {
            //process input
            int speed = (int) (Math.random() * 3) - 1;

            //game logic
            if (speed == -1) {
                if (!isWall[position - 1]) {
                    position = position - 1;
                }
            } else if (speed == 1) {
                if (!isWall[position + 1]) {
                    position = position + 1;
                }
            }

            //render Game
            setColor(FOREGROUND_WHITE);
            setCursor(1, 1);
            for (int i = 1; i < isWall.length; i++) {
                if (isWall[i]) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }


            setCursor(1, position);
            printWithColor("W", FOREGROUND_GREEN);

            shortDelay();
        }


//        resetColors();

    }

}
