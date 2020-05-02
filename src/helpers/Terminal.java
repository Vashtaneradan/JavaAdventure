package helpers;

public class Terminal {
    public static void setCursor(int y, int x) {
        System.out.print("\033[" + y + ";" + x + "f");
    }

    public static void clearScreen() {
        System.out.println("\033[2J");
    }

    public static void disableCursor() {
        System.out.print("\033[?25l");
    }

    public static void resetColors() {
        System.out.println("\033[0m");
    }

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

}
