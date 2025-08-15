package act25;

import java.util.Calendar;
import java.util.Random;

public class Date {
    private int year = 1970;
    private int month = JANUARY;
    private int day = 1;
    private static final int FIRST_MONTH_NO = 0;
    public static final int JANUARY = FIRST_MONTH_NO;
    public static final int FEBRUARY = FIRST_MONTH_NO + 1;
    public static final int MARCH = FIRST_MONTH_NO + 2;
    public static final int APRIL = FIRST_MONTH_NO + 3;
    public static final int MAY = FIRST_MONTH_NO + 4;
    public static final int JUNE = FIRST_MONTH_NO + 5;
    public static final int JULY = FIRST_MONTH_NO + 6;
    public static final int AUGUST = FIRST_MONTH_NO + 7;
    public static final int SEPTEMBER = FIRST_MONTH_NO + 8;
    public static final int OCTOBER = FIRST_MONTH_NO + 9;
    public static final int NOVEMBER = FIRST_MONTH_NO + 10;
    public static final int DECEMBER = FIRST_MONTH_NO + 11;
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    public final int FIRST_YEAR;
    public final int FIRST_MONTH;
    public final int FIRST_DAY;
    
    // Constructores
    public Date() {
        Calendar c = Calendar.getInstance();
        setYear(c.get(Calendar.YEAR));
        setMonth(c.get(Calendar.MONTH) - FIRST_MONTH_NO);
        setDay(c.get(Calendar.DAY_OF_MONTH));
        FIRST_YEAR = year;
        FIRST_MONTH = month;
        FIRST_DAY = day;
    }
    
    public Date(int epochDate) {
        setEpochDate(epochDate);
        FIRST_YEAR = year;
        FIRST_MONTH = month;
        FIRST_DAY = day;
    }
    
    public Date(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
        FIRST_YEAR = this.year;
        FIRST_MONTH = this.month;
        FIRST_DAY = this.day;
    }


    
    public void setYear(int year) throws RuntimeException {
        if (isValid(year, month, day))
            this.year = year;
        else
            throw new RuntimeException("InvalidYear");
    }
    
    public void setMonth(int month) throws RuntimeException {
        if (isValid(year, month, day))
            this.month = month;
        else
            throw new RuntimeException("InvalidYear");
    }
    
    public void setDay(int day) throws RuntimeException {
        if (isValid(year, month, day))
            this.day = day;
        else
            throw new RuntimeException("InvalidYear");
    }
    
    public int getYear() {
        return year;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    
    public String getMonthName() {
        return getMonthName(month);
    }
    
    public static String getMonthName(int month) {
        String monthName = null;
        switch (month) {
            case JANUARY:
                monthName = "January";
                break;
            case FEBRUARY:
                monthName = "February";
                break;
            case MARCH:
                monthName = "March";
                break;
            case APRIL:
                monthName = "April";
                break;
            case MAY:
                monthName = "May";
                break;
            case JUNE:
                monthName = "June";
                break;
            case JULY:
                monthName = "July";
                break;
            case AUGUST:
                monthName = "August";
                break;
            case SEPTEMBER:
                monthName = "September";
                break;
            case OCTOBER:
                monthName = "October";
                break;
            case NOVEMBER:
                monthName = "November";
                break;
            case DECEMBER:
                monthName = "December";
        }
        return monthName;
    }
    
    private static int daysPerMonth(int year, int month) {
        int daysPerMonth = 0;
        if (month == JANUARY || month == MARCH || month == MAY || month == JULY || month == AUGUST || month == OCTOBER || month == DECEMBER)
            daysPerMonth = 31;
        if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
            daysPerMonth = 30;
        if (month == FEBRUARY && !isLeap(year))
            daysPerMonth = 28;
        if (month == FEBRUARY && isLeap(year))
            daysPerMonth = 29;
        return daysPerMonth;
    }
    
    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    
    public boolean isValid() {
        return isValid(year, month, day);
    }
    
    public static boolean isValid(int year, int month, int day) {
        return year >= 1900 && year <= 9999 && day >= 1 && day <= daysPerMonth(year, month);
    }
    
    public int getDayOfWeek() {
        return getDayOfWeek(year, month, day);
    }
    
    public static int getDayOfWeek(int year, int month, int day) {
        int yy00 = year / 100;
        int centuryBase = 6 - 2 * (yy00 % 4);
        int yy = year % 100;
        int leapDays = yy / 4;
        int[] monthBase = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int result = centuryBase + yy + leapDays + monthBase[month-FIRST_MONTH_NO] + day;
        if (isLeap(year) && month < MARCH)
            result--;
        return result % 7;
    }
    
    public String getDayOfWeekName() {
        return getDayOfWeekName(this.getDayOfWeek());
    }
    
    public static String getDayOfWeekName(int dow) {
        String dayOfWeekName = null;
        switch (dow) {
            case SUNDAY:
                dayOfWeekName = "Sunday";
                break;
            case MONDAY:
                dayOfWeekName = "Monday";
                break;
            case TUESDAY:
                dayOfWeekName = "Tuesday";
                break;
            case WEDNESDAY:
                dayOfWeekName = "Wednesday";
                break;
            case THURSDAY:
                dayOfWeekName = "Thursday";
                break;
            case FRIDAY:
                dayOfWeekName = "Friday";
                break;
            case SATURDAY:
                dayOfWeekName = "Saturday";
                break;
        }
        return dayOfWeekName;
    }
    
    public static String getDayOfWeekName(int year, int month, int day) {
        return getDayOfWeekName(getDayOfWeek(year, month, day));
    }
    
    private int getDaysFrom1900() {
        return getDaysFrom1900(this);
    }
    
    private static int getDaysFrom1900(Date d) {
        int[] daysTranscurredInYear = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int days = 365 * (d.year - 1900) + (d.year - 1900) / 4 - (d.year - 1900) / 100 + (d.year - 1600) / 400 +
                daysTranscurredInYear[d.month - FIRST_MONTH_NO] + d.day - 1;
        if (isLeap(d.year) && d.month < MARCH)
            days--;
        return days;
    }
    
    private void setDaysFrom1900(int daysFrom1900) {
        if (daysFrom1900 > 0 && daysFrom1900 <= 2958464) {
            int year = 1900;
            int month = JANUARY;
            while (daysFrom1900 >= daysPerMonth(year, month)) {
                daysFrom1900 = daysFrom1900 - daysPerMonth(year, month);
                month++;
                if (month > DECEMBER) {
                    year++;
                    month = JANUARY;
                }
            }
            this.year = year;
            this.month = month;
            this.day = daysFrom1900 + 1;
        }
    }
    
    public static int getEpochDate(Date d) {
        return getDaysFrom1900(d) - 25568;
    }
    
    public int getEpochDate() {
        return getEpochDate(this);
    }
    
    public void setEpochDate(int daysFrom1970) {
        setDaysFrom1900(daysFrom1970 + 25568);
    }
    
    public void add(int days) {
        setDaysFrom1900(getDaysFrom1900() + days);
    }
    
    public int difference(Date d) {
        return difference(this, d);
    }
    
    public static int difference(Date d1, Date d2) {
        return getDaysFrom1900(d1) - getDaysFrom1900(d2);
    }
    
    public static int compareTo(Date d1, Date d2) {
        return difference(d1, d2);
    }
    
    public int compare(Date d) {
        return difference(d);
    }
    
    public static boolean equals(Date d1, Date d2) {
        return difference(d1, d2) == 0;
    }
    
    public boolean equals(Date d) {
        return equals(this, d);
    }
    
    public Date clone() {
        return new Date(year, month, day);
    }
    
    public void print() {
        System.out.print(toString());
    }
    
    public String toString() {
        return "Date:{\"year\":" + year +
                ",\"monthName\":\"" + getMonthName() + "\"" + ",\"day\":" + day +
                ",\"dayOfWeekName\":\"" + getDayOfWeekName() + "\"" +
                ",\"epochDate\":" + getEpochDate() +
                "}";
    }


    public int hashCode() {
        System.out.println("Llamada a hashCode()");
        return 5;
    }

}
