import java.util.ArrayList;
import java.util.List;

public class TextAligner {

    public static List<String> solution(String[][] paragraphs, String[] aligns, int width) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < paragraphs.length; i++) {
            String align = aligns[i];
            String[] words = paragraphs[i];
            StringBuilder line = new StringBuilder();
            int lineLength = 0;

            for (String word : words) {
                if (lineLength + word.length() <= width) {
                    line.append(word).append(" ");
                    lineLength += word.length() + 1;
                } else {
                    addLine(result, line, align, width, false);
                    line = new StringBuilder(word + " ");
                    lineLength = word.length() + 1;
                }
            }

            // Add the last line of the paragraph
            addLine(result, line, align, width, true);
        }

        return result;
    }

    private static void addLine(List<String> result, StringBuilder line, String align, int width, boolean isLastLine) {
        String formattedLine = line.toString().trim();
        int spacesToAdd = width - formattedLine.length();

        if (align.equals("RIGHT")) {
            result.add(generateLine(spacesToAdd) + formattedLine);
        } else {
            result.add(formattedLine + generateLine(spacesToAdd));
        }

        
    }

    private static String generateLine(int length) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append("*");
        }
        return line.toString();
    }

    public static void main(String[] args) {
        String[][] paragraphs = { { "hello", "world" }, { "How", "are", "you", "doing" },
                { "Please look", "and align", "to right" } };
        String[] aligns = { "LEFT", "RIGHT", "RIGHT" };
        int width = 16;

        List<String> result = solution(paragraphs, aligns, width);

        // Print the result
        for (String line : result) {
            System.out.println(line);
        }
    }
}
