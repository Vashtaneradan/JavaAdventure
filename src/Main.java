public class Main {

    public static int black = 30;
    public static int red = 31;
    public static int green = 32;
    public static int yellow = 33;
    public static int blue = 34;
    public static int magenta = 35;
    public static int cyan = 36;
    public static int white = 37;

    public static void setColor(int colorCode) {
        System.out.print("\033[" + colorCode + "m");
    }

    public static void printInfo(String name, int healthPoints) {
        setColor(white);
        System.out.print("name: ");
        setColor(red);
        System.out.println(name);
        setColor(white);
        System.out.print("Healthpoints: ");
        setColor(cyan);
        System.out.println(healthPoints);
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

        System.out.println();

        int healthPointChange = -10;
        healthPoints = calculateNewHealthPoints(healthPoints, healthPointChange);
        printInfo(name, healthPoints);

        System.out.println();

        healthPointChange = 15;
        healthPoints = calculateNewHealthPoints(healthPoints, healthPointChange);
        printInfo(name, healthPoints);

        System.out.println();

        healthPointChange = -200;
        healthPoints = calculateNewHealthPoints(healthPoints, healthPointChange);
        printInfo(name, healthPoints);
    }

}
