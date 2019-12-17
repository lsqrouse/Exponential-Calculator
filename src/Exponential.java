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
                System.out.println("Please enter the desired ending year: ");
                int end = s.nextInt();
                s.nextLine();
                System.out.println("Please enter the value in the starting year: ");
                double num = s.nextDouble();
                s.nextLine();
                double out = findValue(rate, start, end, num);
                System.out.println("The value in " + end + " years is " + out);
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
}