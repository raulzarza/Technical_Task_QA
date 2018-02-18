package rz.ciklum.utils;

/**
 * Year validation
 */
public class LeapYearValidator {

    public boolean validateYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
