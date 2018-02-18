package rz.ciklum.generator;

import java.util.Random;

import rz.ciklum.utils.LeapYearValidator;

/**
 * Generator of random dates
 */
public class DateGenerator {

    Random random = new Random();
    LeapYearValidator leapYearValidator = new LeapYearValidator();

    public String generateYear() {
        int year = random.nextInt(2015);
        if (year <= 1975) return Integer.toString(1975);
        else return Integer.toString(year);
    }

    public String generateMonth() {
        return Integer.toString(random.nextInt(12) + 1);
    }

    public String generateDay(String month, String year) {
        if (month.equals("2")) {
            if (leapYearValidator.validateYear(Integer.parseInt(year))) return Integer.toString(random.nextInt(28) + 1);
            else return Integer.toString(random.nextInt(29) + 1);
        }
        if (month.equals("4") ||
                month.equals("6") ||
                month.equals("9") ||
                month.equals("11")) return Integer.toString(random.nextInt(30) + 1);
        else return Integer.toString(random.nextInt(31) + 1);
    }
}
