package gitlab.foxminded.task4;
import java.util.List;

public class DivisionFormating {

    private static final String SPACE = " ";

    protected void addSpaces(StringBuilder string, int amount) {
        for (int i = 0; i < amount; i++) {
            string.append(SPACE);
        }
    }

    private int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }

    String addFirstPart(int divident, int divider, List<Integer> resultNums, List<Integer> dividentNums) {

        final int result = divident / divider;


        StringBuilder mystring = new StringBuilder();

        mystring.append("_" + divident + "|" + divider + "\n" + " " + resultNums.get(0) * divider);

        addSpaces(mystring, dividentNums.size() - getCountsOfDigits(divider * resultNums.get(0)));

        mystring.append("|------" + "\n" + SPACE + "--");

        addSpaces(mystring, dividentNums.size() - 2);

        mystring.append("|" + result + "\n");


        return mystring.toString();
    }

    String addSecondPart(int minuend, int divider, int resultNumberCoef, List<Integer> resultNums) {

        StringBuilder result = new StringBuilder();
        addSpaces(result, resultNumberCoef);
        result.append("_" + minuend + "\n");
        addSpaces(result, resultNumberCoef + 1);
        result.append(resultNums.get(resultNumberCoef) * divider + "\n");
        addSpaces(result, resultNumberCoef + 1);
        result.append("--" + "\n");

        return result.toString();
    }

    String addResidue(int minuend, int divider, int resultNumberCoef, List<Integer> resultNums) {

        StringBuilder result = new StringBuilder();
        addSpaces(result, resultNumberCoef + 1);
        result.append(minuend - resultNums.get(resultNumberCoef - 1) * divider);
        return result.toString();
    }
}



