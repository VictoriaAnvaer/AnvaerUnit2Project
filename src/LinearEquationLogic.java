import java.util.Scanner;

public class LinearEquationLogic {

    private Scanner myScanner;
    private LinearEquation equation;
    private String continueCalculate = "y";

    public LinearEquationLogic() {
        equation = null;
        myScanner = new Scanner(System.in);
        String continueCalculate = "y";
    }

    public void start() {
        loopCalculate();
    }

    private void loopCalculate() {
        System.out.println("Welcome to the linear equation calculator!");
        while (continueCalculate.equals("y")) {
            getCoords();
            coordX();
            System.out.print("\nWould you like to enter another coordinate? (y/n) ");
            myScanner.nextLine();
            continueCalculate =  myScanner.nextLine();
        }
    }

    private void getCoords() {

        System.out.print("\nEnter coordinate 1: ");
        String coord1 = myScanner.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = myScanner.nextLine();
        System.out.println();

        int x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.length() - 1));
        int x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.length() - 1));

        equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println(equation.lineInfo());

    }

    private void coordX() {
        System.out.print("\nEnter a value for X: ");
        double x = myScanner.nextDouble();
        System.out.println("The point on the line is: " + equation.coordinateForX(x));
    }

}