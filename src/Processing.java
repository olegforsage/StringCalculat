public class Processing {

    public static String processStrings(String left, String operator, String right) throws Exception {
        return switch (operator) {
            case "+" -> left + right;
            case "-" -> left.replaceFirst(right, "");
            default -> throw new Exception("Что-то пошло не так...");
        };
    }

    public static String processStringDigit(String left, String operator, int right) throws Exception {
        switch (operator) {
            case "*" -> {
                StringBuilder sb = new StringBuilder();
                sb.append(left.repeat(Math.max(0, right)));
                return sb.toString();
            }
            case "/" -> {
                int num = left.length() / right;
                return left.substring(0, num);
            }
            default -> throw new Exception("Что-то пошло не так...");
        }
    }
}
