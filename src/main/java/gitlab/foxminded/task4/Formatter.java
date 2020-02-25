package gitlab.foxminded.task4;

import java.util.List;

public class Formatter {

    private final String SPACE = " ";

    protected void addSpaces(StringBuilder string, int amount) {
        for (int i = 0; i < amount; i++) {
            string.append(SPACE);
        }
    }

    private int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }

    protected String format(List<Integer> myList) {
        int spaceIndex = 1;
        StringBuilder myString = new StringBuilder();
        myString.append("_" + myList.get(0) + "|" + myList.get(1) + "\n" + " " + myList.get(2));
        addSpaces(myString, getCountsOfDigits(myList.get(0)) - getCountsOfDigits(myList.get(2)));
        myString.append("|------" + "\n" + SPACE + "--");
        addSpaces(myString, getCountsOfDigits(myList.get(0)) - 2);
        myString.append("|" + myList.get(3) + "\n");

        for (int i = 4; i < myList.size() - 1; i++) {

            addSpaces(myString, spaceIndex);
            myString.append("_" + myList.get(i) + "\n");
            addSpaces(myString, spaceIndex + 1);
            myString.append(myList.get(i + 1) + "\n");
            addSpaces(myString, spaceIndex + 1);
            myString.append("--" + "\n");
            spaceIndex++;
            i++;
        }
        addSpaces(myString, spaceIndex);
        myString.append(myList.get(myList.size() - 1));


        return myString.toString();
    }
}



