import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    /**
     *
     * @param args
     * @author Sergey Piunov
     *
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter expression: ");
        try {
            System.out.println(calc(in.nextLine()));
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        in.close();
    }

    public static String calc(String input) throws Exception {
        boolean isMatches = input.matches("(?:\\b(?:I{1,3}[VX]?|[VX]|VI{1,3})\\b\\s?[-+*/]\\s?\\b(?:I{1,3}[VX]?|[VX]|VI{1,3})\\b|\\b(?:[0-9]|10)\\b\\s?[-+*/]\\s?\\b(?:[0-9]|10)\\b)");
        if (!isMatches) {
            throw new Exception("incorrect input");
        }
        boolean isRoman = false;
        String[] data = input.split(" ");
        int opLeft, opRight;
        String operation = data[1];

        try {
            opLeft = Integer.parseInt(data[0]);
            opRight = Integer.parseInt(data[2]);
        } catch (NumberFormatException ex) {
            isRoman = true;
            opLeft = RomanNumeral.romanToArabic(data[0]);
            opRight = RomanNumeral.romanToArabic(data[2]);
        }

        switch (operation) {
            case "+":
                return checkedOperation((opLeft + opRight), isRoman);
            case "-":
                return checkedOperation((opLeft - opRight), isRoman);
            case "*":
                return checkedOperation((opLeft * opRight), isRoman);
            case "/":
                return checkedOperation((opLeft / opRight), isRoman);
            default:
                throw new IllegalArgumentException("Bad operation:");
        }
    }

    public static String checkedOperation(int value, boolean flag) {
        if (!flag) {
            return String.valueOf(value);
        } else {
            return RomanNumeral.arabicToRoman(value);
        }
    }

    //Class convert numbers
    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }

        public static int romanToArabic(String input) {
            String romanNumeral = input.toUpperCase();
            int result = 0;

            List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

            int i = 0;

            while ((!romanNumeral.isEmpty()) && (i < romanNumerals.size())) {
                RomanNumeral symbol = romanNumerals.get(i);
                if (romanNumeral.startsWith(symbol.name())) {
                    result += symbol.getValue();
                    romanNumeral = romanNumeral.substring(symbol.name().length());
                } else {
                    i++;
                }
            }

            if (!romanNumeral.isEmpty()) {
                throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
            }

            return result;
        }

        public static String arabicToRoman(int number) {
            if ((number <= 0) || (number > 4000)) {
                throw new IllegalArgumentException(number + " is not in range (0,4000]");
            }

            List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

            int i = 0;
            StringBuilder sb = new StringBuilder();

            while ((number > 0) && (i < romanNumerals.size())) {
                RomanNumeral currentSymbol = romanNumerals.get(i);
                if (currentSymbol.getValue() <= number) {
                    sb.append(currentSymbol.name());
                    number -= currentSymbol.getValue();
                } else {
                    i++;
                }
            }

            return sb.toString();
        }
    }
}