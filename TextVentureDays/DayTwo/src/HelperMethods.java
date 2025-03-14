import java.io.IOException;
import java.util.Scanner;

public class HelperMethods {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printDecorations(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("~");
        }
        System.out.println();
    }

    public static void defaultHeaderGenerator(String title) {
        printDecorations(30);
        System.out.println(title);
        printDecorations(30);
    }

    public static void headerGenerator(String title, int decorationCount) {
        printDecorations(decorationCount);
        System.out.println(title);
        printDecorations(decorationCount);
    }

    public static void printTwoChoices(String choice1, String choice2) {
        System.out.print("(1) " + choice1 + "\n(2) " + choice2 + "\n");
    }

    public static String getStringInput() {
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Must enter an integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    public static void anythingToContinue() {
        System.out.println("Press Enter to continue");
        try {
            System.in.read();  // Wait for user input
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
