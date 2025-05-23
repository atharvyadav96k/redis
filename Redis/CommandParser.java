import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    public static String[] parseCommand(String input) {
        List<String> tokens = new ArrayList<>();
        int i = 0, len = input.length();

        while (i < len) {
            // Skip leading spaces
            while (i < len && input.charAt(i) == ' ') i++;
            if (i >= len) break;

            char ch = input.charAt(i);
            StringBuilder sb = new StringBuilder();

            if (ch == '"') {
                // Start of a quoted value
                i++; // skip the opening quote
                while (i < len && input.charAt(i) != '"') {
                    sb.append(input.charAt(i++));
                }
                if (i == len || input.charAt(i) != '"') {
                    throw new IllegalArgumentException("Missing closing quote");
                }
                i++; // skip the closing quote
            } else {
                // Unquoted value
                while (i < len && input.charAt(i) != ' ') {
                    sb.append(input.charAt(i++));
                }
            }

            tokens.add(sb.toString());
        }

        return tokens.toArray(new String[0]);
    }
}
