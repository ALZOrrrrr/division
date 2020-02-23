package gitlab.foxminded.task4;
import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {
    private static final DivisionFormating format = new DivisionFormating();

    private static int validate(Integer divident, Integer divider) {
        if (divider == null || divident == null) {
            throw new IllegalArgumentException("null division");
        } else if (divider == 0) {
            throw new IllegalArgumentException("division by 0");
        } else if (divident < 0 || divider < 0) {
            throw new UnsupportedOperationException("negative values are not supported");
        } else if (divident < divider) {
            return 0;
        }
        else {
            return 0;
        }
    }

    private static int add(int a, int b) {
        if (a == 0) {
            return b;
        }
        String str = Integer.toString(a);
        str += Integer.toString(b);
        return Integer.parseInt(str);
    }

    private int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static List<Integer> digitsInNumber(int number) {
        String n = Integer.toString(number);
        char[] charArray = n.toCharArray();
        ArrayList<Integer> cia = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            int c = Character.getNumericValue(charArray[i]);
            cia.add(c);
        }
        return cia;
    }

    private static String calculate(int minuend, int divider, int resultNumberCoef, int dividentNumCoef, List<Integer> resultNums, List<Integer> dividentNums) {

        StringBuilder result = new StringBuilder();

        result.append(format.addSecondPart(minuend, divider, resultNumberCoef, resultNums));

        resultNumberCoef++;
        if (resultNumberCoef < resultNums.size()) {

            if (minuend >= resultNums.get(resultNumberCoef - 1) * divider) {
                minuend = minuend - resultNums.get(resultNumberCoef - 1) * divider;

                if (minuend < resultNums.get(resultNumberCoef) * divider) {
                    minuend = add(minuend, dividentNums.get(dividentNumCoef));
                }
            }
            dividentNumCoef++;
            result.append(calculate(minuend, divider, resultNumberCoef, dividentNumCoef, resultNums, dividentNums));
        } else {
            result.append(format.addResidue(minuend, divider, resultNumberCoef, resultNums));
        }
        return result.toString();
    }

    public String division(Integer divident, Integer divider) {

        validate(divident, divider);

        StringBuilder mystring = new StringBuilder();
        final int result = divident / divider;

        List<Integer> dividentNums = digitsInNumber(divident);
        List<Integer> resultNums = digitsInNumber(result);

        mystring.append(format.addFirstPart(divident, divider, resultNums, dividentNums));

        int minuendDivident = dividentNums.get(0);
        int dividentNumberCoef = 1;

        while (minuendDivident < resultNums.get(0) * divider) {
            minuendDivident = add(minuendDivident, dividentNums.get(dividentNumberCoef));
            dividentNumberCoef++;
        }
        minuendDivident = minuendDivident - resultNums.get(0) * divider;

        if (getCountsOfDigits(result) == 1) {
            format.addSpaces(mystring, 1);
            mystring.append(minuendDivident);
            return mystring.toString();
        } else {
            while (minuendDivident < resultNums.get(1) * divider) {
                minuendDivident = add(minuendDivident, dividentNums.get(dividentNumberCoef));
                dividentNumberCoef++;
            }
            mystring.append(calculate(minuendDivident, divider, 1, dividentNumberCoef, resultNums, dividentNums));
            return mystring.toString();
        }
    }
}

