
package Packagee;

public class Classs {

    public static boolean isStudyHoursValid(String hours) {

        if (hours == null || hours.trim().isEmpty())
            return false;

        if (!hours.matches("[0-9]+"))
            return false;

        int num = Integer.parseInt(hours);

        return num > 0 && num <= 24;
    }

    public static boolean isRollValid(String roll) {

        if (roll == null || roll.trim().isEmpty())
            return false;

        return roll.matches("[0-9]+");
    }

    public static String getRecommendation(String difficulty) {

        if (difficulty.equals("Hard"))
            return "Study 3 Hours Daily";

        else if (difficulty.equals("Medium"))
            return "Study 2 Hours Daily";

        else
            return "Study 1 Hour Daily";
    }
}


