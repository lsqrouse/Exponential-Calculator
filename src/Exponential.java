import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.util.Scanner;

public class Exponential {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Which mode would you like to use?\nEnter [V] to find a value after x years" +
                "\nEnter [Y] to find how many years it would take to get to a value.");
        String in = s.nextLine();
        switch (in.toUpperCase()) {
            case "V" :
                System.out.println("PLease enter the growth rate per year: ");
                double rate = s.nextDouble();
                s.nextLine();
                int start = 0;
                System.out.println("Please enter the desired amount of years later ");
                int end = s.nextInt();
                s.nextLine();
                System.out.println("Please enter the value in the starting year: ");
                double num = s.nextDouble();
                s.nextLine();
                double out = findValue(rate, start, end, num);
                System.out.println("The value in " + end + " years is " + out);
                break;
            case "Y" :
                System.out.println("PLease enter the growth rate per year: ");
                rate = s.nextDouble();
                s.nextLine();
                System.out.println("Please enter the value in the starting year: ");
                num = s.nextDouble();
                s.nextLine();
                System.out.println("Please enter the value in the desired ending year: ");
                double desired = s.nextDouble();
                s.nextLine();
                out = findYear(rate, desired, num, 0);
                System.out.println("The value will be " + desired + " in " + out + " years.");
                break;
        }

    }

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
            out = findYear(rate, desired, lastValue, cYear);
        } catch (Exception e) {
            return out;
        }
        return out;

    }
}