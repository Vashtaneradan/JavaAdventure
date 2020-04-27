public class Main {

    public static final int FOREGROUND_BLACK = 30;
    public static final int FOREGROUND_RED = 31;
    public static final int FOREGROUND_GREEN = 32;
    public static final int FOREGROUND_YELLOW = 33;
    public static final int FOREGROUND_BLUE = 34;
    public static final int FOREGROUND_MAGENTA = 35;
    public static final int FOREGROUND_CYAN = 36;
    public static final int FOREGROUND_WHITE = 37;

    public static void setColor(int colorCode) {
        System.out.print("\033[" + colorCode + "m");
    }

    public static void printWithColor(String text, int color) {
        setColor(color);
        System.out.print(text);
    }

    public static void printlnWithColor(String text, int color) {
        setColor(color);
        System.out.println(text);
    }

    public static void printInfo(String name, int healthPoints) {
        printWithColor("Name: ", FOREGROUND_WHITE);
        printlnWithColor(name, FOREGROUND_CYAN);
        printWithColor("Healthpoints: ", FOREGROUND_WHITE);
        printlnWithColor(healthPoints + "", FOREGROUND_RED);
        System.out.println();
    }

    public static void printHealthPointSword(int healthPoint) {

        int coloredEqualSigns = healthPoint / 4;

        printlnWithColor("            //", FOREGROUND_WHITE);
        printWithColor("()=========>>", FOREGROUND_WHITE);

        // print green Sword part
        for (int i = 0; i < coloredEqualSigns; i ++) {

            printWithColor("=", FOREGROUND_GREEN);
        }

        // print remaining part in red
        for (int i = 0; i < 25 - coloredEqualSigns; i ++) {

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

    public static void main(String[] args) {
        String name = "Andrea";
        int healthPoints = 100;

        printInfo(name, healthPoints);
        printHealthPointSword(healthPoints);

        while (healthPoints > 0) {
            int damage = (int) (- 10 * Math.random()) -1;
            printWithColor("Damage: ", FOREGROUND_MAGENTA);
            printlnWithColor(damage + "", FOREGROUND_RED);
            healthPoints = calculateNewHealthPoints(healthPoints, damage);
            printInfo(name, healthPoints);
            printHealthPointSword(healthPoints);
            System.out.println();
        }

        System.out.println(name + " ist tot!!!");
    }

}
