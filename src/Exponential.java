import java.util.Scanner;

public class Exponential {
    public static double findValue(double rate, int start, int end, double num) {
        if (start == end)
            return num;
        else {
            start++;
            num += num * rate;
            return findValue(rate, start, end, num);
        }
    }

    public static double findYear(double rate, double desired, double lastValue, int cYear) {
        double nextValue = lastValue + lastValue * rate;
        if(nextValue == desired || (nextValue > desired && lastValue < desired)) {
            if (Math.abs(desired - lastValue) > Math.abs(desired - nextValue))
                return cYear++;
            else
                return cYear;
        }
        lastValue = nextValue;
        cYear ++;
        double out = 0;
        try {
            return findYear(rate, desired, lastValue, cYear);
        } catch (Exception e) {
            return out;
        }
    }

    public static double halfLifeAmount(double halfLife, int start, int end, double value) {
        if (start == end)
            return value;
        if ((end - start) < 0)
            return value;
        else {
            start += halfLife;
            value = value/2;
            try {
                return halfLifeAmount(halfLife, start, end, value);
            } catch (Exception e) {
                return 0;
            }
        }
    }
}