package gitlab.foxminded.task4;



import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {

    private static final String SPACE = " ";

    private static void validate( Integer divident, Integer divider){
        if(divider == null || divident == null){
            throw new IllegalArgumentException("null division");
        }
        else if(divider == 0){
            throw new IllegalArgumentException("division by 0");
        }
        else if(divident < 0 || divider <0 ){
            throw new UnsupportedOperationException("negative values are not supported");
        }
        else if(divident<divider){
            throw new UnsupportedOperationException("divider more than divident");
        }
    }

    private static void addSpaces(StringBuilder string, int amount) {
        for (int i = 0; i < amount; i++) {
            string.append(SPACE);
        }
    }

    private static int add(int a, int b) {
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
        addSpaces(result, resultNumberCoef);
        result.append("_" + minuend + "\n");
        addSpaces(result, resultNumberCoef + 1);
        result.append(resultNums.get(resultNumberCoef) * divider + "\n");
        addSpaces(result, resultNumberCoef + 1);
        result.append("--" + "\n");

        resultNumberCoef++;
        if (resultNumberCoef < resultNums.size()) {
            if (minuend > resultNums.get(resultNumberCoef - 1) * divider) {
                minuend = minuend - resultNums.get(resultNumberCoef - 1) * divider;

                if (minuend < resultNums.get(resultNumberCoef) * divider) {
                    minuend = add(minuend, dividentNums.get(dividentNumCoef));
                }
            }

            dividentNumCoef++;
            result.append(calculate(minuend, divider, resultNumberCoef, dividentNumCoef, resultNums, dividentNums));
        } else {
            addSpaces(result, resultNumberCoef + 2);
            result.append(minuend - resultNums.get(resultNumberCoef - 1) * divider);
        }
        return result.toString();
    }


    public String division(Integer divident, Integer divider) {

        validate(divident,divider);

            StringBuilder mystring = new StringBuilder();
            final int result = divident / divider;

            List<Integer> dividentNums = digitsInNumber(divident);
            List<Integer> resultNums = digitsInNumber(result);

            mystring.append("_" + divident + "|" + divider + "\n" + " " + resultNums.get(0) * divider);

            addSpaces(mystring, dividentNums.size() - getCountsOfDigits(divider * resultNums.get(0)));

            mystring.append("|------" + "\n" + SPACE + "--");

            addSpaces(mystring, dividentNums.size() - 2);

            mystring.append("|" + result + "\n");

            int minuendDivident = dividentNums.get(0);
            int dividentNumberCoef = 1;

            while (minuendDivident < resultNums.get(0) * divider) {
                minuendDivident = add(minuendDivident, dividentNums.get(dividentNumberCoef));
                dividentNumberCoef++;
            }
            minuendDivident = minuendDivident - resultNums.get(0) * divider;

            if (getCountsOfDigits(result) == 1) {
                addSpaces(mystring,1);
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

