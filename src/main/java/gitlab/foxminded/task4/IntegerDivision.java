package gitlab.foxminded.task4;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {
    private final Formatter format = new Formatter();
    private final List<Integer> myNumsList = new ArrayList<>();

    private static int validate(Integer divident, Integer divider) {
        if (divider == null || divident == null) {
            throw new IllegalArgumentException("null division");
        } else if (divider == 0) {
            throw new IllegalArgumentException("division by 0");
        } else if (divident < 0 || divider < 0) {
            throw new UnsupportedOperationException("negative values are not supported");
        } else if (divident < divider) {
            return 0;
        } else {
            return 0;
        }
    }

    private int add(int a, int b) {
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

    private List<Integer> digitsInNumber(int number) {
        String n = Integer.toString(number);
        char[] charArray = n.toCharArray();
        ArrayList<Integer> cia = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            int c = Character.getNumericValue(charArray[i]);
            cia.add(c);
        }
        return cia;
    }

    private void calculate(int minuend,
                           int divider,
                           int resultNumberCoef,
                           int dividentNumCoef,
                           List<Integer> resultNums,
                           List<Integer> dividentNums) {

        myNumsList.add(minuend);
        myNumsList.add(resultNums.get(resultNumberCoef) * divider);

        resultNumberCoef++;
        if (resultNumberCoef < resultNums.size()) {

            if (minuend >= resultNums.get(resultNumberCoef - 1) * divider) {
                minuend = minuend - resultNums.get(resultNumberCoef - 1) * divider;

                if (minuend < resultNums.get(resultNumberCoef) * divider) {
                    minuend = add(minuend, dividentNums.get(dividentNumCoef));
                }
            }
            dividentNumCoef++;
            calculate(minuend, divider, resultNumberCoef, dividentNumCoef, resultNums, dividentNums);
        } else {
            myNumsList.add(minuend - resultNums.get(resultNumberCoef - 1) * divider);
        }
    }

    public String division(Integer divident, Integer divider) {

        validate(divident, divider);

        StringBuilder mystring = new StringBuilder();
        final int result = divident / divider;


        List<Integer> dividentNums = digitsInNumber(divident);
        List<Integer> resultNums = digitsInNumber(result);

        myNumsList.add(divident);
        myNumsList.add(divider);
        myNumsList.add(resultNums.get(0) * divider);
        myNumsList.add(result);

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
            calculate(minuendDivident, divider, 1, dividentNumberCoef, resultNums, dividentNums);
            mystring.append(format.format(myNumsList));
            return mystring.toString();
        }
    }
}

