// name of the package
// you can import the codes in the file as `import static jets.Jets.*;`
package jets;

import java.util.Scanner;

/**
 * Implementation of the methods described in the IB Java Examination Tool Subset
 * for the IB DP Computer Science course.
 */
public final class Jets {
    private static final Scanner scanner = new Scanner(System.in);

    private Jets() {
        throw new UnsupportedOperationException(
                "Do not instantiate this class! " +
                        "Instead, call the methods from the class directly, e.g., Jest.output(...);"
        );
    }

    /**
     * Reads a line of input from the user on the console.
     *
     * @return A string containing the user's input.
     */
    public static String input() {
        return scanner.nextLine();
    }

    /**
     * Prompts the user with a message and reads a line of input on the console.
     *
     * @param prompt A string message displayed as a prompt.
     * @return A string containing the user's input.
     */
    public static String input(String prompt) {
        System.out.print(prompt);
        return input();
    }

    public static String inputString(String prompt) {
        return input(prompt);
    }

    /**
     * Prompts the user with a message and reads a single character from the input.
     *
     * @param prompt A string message displayed as a prompt.
     * @return The first character of the user's input. Defaults to a null character.
     */
    public static char inputChar(String prompt) {
        String userInput = input(prompt);
        if (userInput.isEmpty()) {
            return (char) 0;
        } else {
            return userInput.charAt(0);
        }
    }

    /**
     * Prompts the user with a message and reads a boolean value from the input.
     *
     * @param prompt A string message displayed as a prompt.
     * @return `true` if the user inputs "true", "True", or "1", otherwise `false`.
     */
    public static boolean inputBoolean(String prompt) {
        String userInput = input(prompt);
        return userInput.equals("true") || userInput.equals("True") || userInput.equals("1");
    }

    /**
     * Prompts the user with a message and reads a byte value from the input.
     *
     * @param prompt A string message displayed to the user as a prompt.
     * @return The byte value of the user's input.
     */
    public static byte inputByte(String prompt) {
        while (true) {
            try {
                String userInput = input(prompt);
                return Byte.parseByte(userInput);
            } catch (NumberFormatException e) {
                output("Invalid input given!");
            }
        }
    }

    /**
     * Prompts the user with a message and reads an integer value from the input.
     *
     * @param prompt A string message displayed to the user as a prompt.
     * @return The integer value of the user's input.
     */
    public static int inputInt(String prompt) {
        while (true) {
            try {
                String userInput = input(prompt);
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                output("Invalid input given!");
            }
        }
    }

    /**
     * Prompts the user with a message and reads a long value from the input.
     *
     * @param prompt A string message displayed to the user as a prompt.
     * @return The long value of the user's input.
     */
    public static long inputLong(String prompt) {
        while (true) {
            try {
                String userInput = input(prompt);
                return Long.parseLong(userInput);
            } catch (NumberFormatException e) {
                output("Invalid input given!");
            }
        }
    }

    /**
     * Prompts the user with a message and reads a double value from the input.
     *
     * @param prompt A string message displayed to the user as a prompt.
     * @return The double value of the user's input.
     */
    public static double inputDouble(String prompt) {
        while (true) {
            try {
                String userInput = input(prompt);
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                output("Invalid input given!");
            }
        }
    }

    /**
     * Displays the value on the console.
     *
     * @param value A printable value (string, boolean, byte, int, long, or double)
     */
    public static void output(String value) {
        System.out.println(value);
    }

    public static void output(boolean value) {
        System.out.println(value);
    }

    public static void output(byte value) {
        System.out.println(value);
    }

    public static void output(int value) {
        System.out.println(value);
    }

    public static void output(long value) {
        System.out.println(value);
    }

    public static void output(double value) {
        System.out.println(value);
    }
}