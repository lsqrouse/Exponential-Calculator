import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Which mode would you like to use?\nEnter [V] to find a value after x years" +
                "\nEnter [Y] to find how many years it would take to get to a value." +
                "\n Enter [A] to solve an Arithmatic Expression");
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
                double out = Exponential.findValue(rate, start, end, num);
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
                out = Exponential.findYear(rate, desired, num, 0);
                if (out == 0)
                    System.out.println("The value will be " + desired + " in " + out + " years.");
                else
                    System.out.println("The value could not be calculated.");
                break;
            case "H" :
                System.out.println("PLease enter the half life");
                rate = s.nextDouble();
                s.nextLine();
                start = 0;
                System.out.println("Please enter the starting value: ");
                num = s.nextDouble();
                s.nextLine();
                System.out.println("Please enter the desired ending time: ");
                end = s.nextInt();
                s.nextLine();
                out = Exponential.halfLifeAmount(rate, start, end,num);
                if (out == 0)
                    System.out.println("The value in " + end + " units of time is " + out);
                else
                    System.out.println("The value could not be calculated.");
                break;
            case "A" :
                System.out.println("Please Enter a the Expression: ");
                in = s.nextLine();
                System.out.println("The value of this expression is " + Arithmetic.solve(in));
        }

    }

}
