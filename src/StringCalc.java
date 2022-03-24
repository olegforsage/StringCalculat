import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalc {

    private static String PATTERN_STRINGS = "(\")([\\w\\s\\W]{0,10})(\")(\\s+)([+-])(\\s+)(\")([\\w\\s\\W]{0,10})(\")";
    private static String PATTERN_STRING_DIGIT = "(\")([\\w\\s\\W]{0,10})(\")(\\s+)([\\\\*/])(\\s+)(\\d{0,10})";

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String result = "";

        if (scanner.hasNext()) {
            String command = scanner.nextLine();
            Matcher matcherStrings = Pattern.compile(PATTERN_STRINGS).matcher(command);
            Matcher matcherStringDigit = Pattern.compile(PATTERN_STRING_DIGIT).matcher(command);
            if (matcherStrings.matches()) {
                result = Processing.processStrings(
                        matcherStrings.group(2),
                        matcherStrings.group(5),
                        matcherStrings.group(8)
                );

            } else if (matcherStringDigit.matches()) {
                result = Processing.processStringDigit(
                        matcherStringDigit.group(2),
                        matcherStringDigit.group(5),
                        Integer.parseInt(matcherStringDigit.group(7))
                );
            } else {
                throw new Exception("Введен неверный набор данных");
            }
        }

        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }

        System.out.println("\"" + result + "\"");

    }
}
