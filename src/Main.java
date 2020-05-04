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

    public static final int WIDTH = 80;
    public static final int HEIGHT = 40;

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
            Thread.sleep(50);
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

        //Setup
        clearScreen();
        disableCursor();

        //create Wall
        TileType[][] tileType = new TileType[HEIGHT][WIDTH];
        for (int x = 0; x < WIDTH; x++) {
            tileType[0]         [x] = TileType.WALL;
            tileType[HEIGHT - 1][x] = TileType.WALL;
        }
        for (int y = 0; y < HEIGHT; y++) {
            tileType[y]        [0]= TileType.WALL;
            tileType[y][WIDTH - 1] = TileType.WALL;
        }

        // render Wall
        setColor(FOREGROUND_WHITE);
        for (int y = 0; y < HEIGHT; y++) {
            setCursor(y , 0);
            for (int x = 0; x < WIDTH; x++) {
                if (tileType[y][x] == TileType.WALL) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
        }


        int positionX = 4;
        int positionY = 8;

        boolean isPlaying = true;
        while (isPlaying) {

            //process input
            int speedX = 0;
            int speedY = 0;

            int direction = (int) (Math.random() * 4);

            //generate random direction
            switch (direction) {
                case 0: {
                    speedX = 1;
                    break;
                }
                case 1: {
                    speedX = -1;
                    break;
                }
                case 2: {
                    speedY = -1;
                    break;
                }
                default: {
                    speedY = 1;
                    break;
                }
            }

            //clear screen
            setCursor(positionY, positionX);
            printWithColor(" ", FOREGROUND_WHITE);

            //game logic
            int targetPositionX = positionX + speedX;
            int targetPositionY = positionY + speedY;

            switch (tileType[targetPositionY][targetPositionX]) {
                case EMPTY: {
                    //nothing will happen
                    break;
                }
                case WALL: {
                    targetPositionX = positionX;
                    targetPositionY = positionY;
                    break;
                }
                case LAVA: {
                    //TODO: burn
                    System.out.print("burn");
                    break;
                }
                case ICE: {
                    //TODO: set automatic slide velocity
                    System.out.print("slide.... huiiiiiii");
                    break;
                }
                case STAIRCASE: {
                    System.out.print("du bist da");
                    isPlaying = false;
                    break;
                }
            }

            positionX = targetPositionX;
            positionY = targetPositionY;

            //render Game
            setCursor(positionY, positionX);
            printWithColor("W", FOREGROUND_GREEN);

            shortDelay();
        }

        clearScreen();
        resetColors();

    }

}
