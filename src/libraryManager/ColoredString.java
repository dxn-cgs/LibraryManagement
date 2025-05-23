package libraryManager;

public class ColoredString {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static String color(String prompt, String colorName) {
        StringBuilder sb = new StringBuilder();
        switch (colorName) {
            case "black":
                sb.append(ANSI_BLACK);
            case "red":
                sb.append(ANSI_RED);
            case "green":
                sb.append(ANSI_GREEN);
            case "yellow":
                sb.append(ANSI_YELLOW);
            case "blue":
                sb.append(ANSI_BLUE);
            case "purple":
                sb.append(ANSI_PURPLE);
            case "cyan":
                sb.append(ANSI_CYAN);
            case "white":
                sb.append(ANSI_WHITE);
            default:
                break;

        }
        sb.append(prompt);
        sb.append(ANSI_RESET);
        return sb.toString();
    }
}
