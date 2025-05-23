import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    public static String[] parseCommand(String input) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        int len = input.length();

        while (i < len && input.charAt(i) == ' ') i++;
        StringBuilder sb = new StringBuilder();
        while (i < len && input.charAt(i) != ' ') {
            sb.append(input.charAt(i++));
        }
        tokens.add(sb.toString());

        while (i < len) {
            while (i < len && input.charAt(i) == ' ') i++;
            if (i >= len) break;

            // get key 
            sb.setLength(0);
            while (i < len && input.charAt(i) != ' ') {
                sb.append(input.charAt(i++));
            }
            tokens.add(sb.toString());

            // get value
            // looking for opening "
            while (i < len && input.charAt(i) == ' ') i++;
            if (i >= len || input.charAt(i) != '"') {
                throw new IllegalArgumentException("Expected quoted value after key: " + tokens.get(tokens.size() - 1));
            }
            i++; 
            sb.setLength(0);
            // Looking for value as well as closing "
            while (i < len && input.charAt(i) != '"') {
                sb.append(input.charAt(i++));
            }
            if (i >= len || input.charAt(i) != '"') {
                throw new IllegalArgumentException("Missing closing quote for value of key: " + tokens.get(tokens.size() - 1));
            }
            i++; 
            tokens.add(sb.toString());
        }

        return tokens.toArray(new String[0]);
    }
}
