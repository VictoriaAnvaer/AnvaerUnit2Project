public class LinearEquation {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    // fix int to double
    public double distance() {
        return roundedToHundreth(Math.sqrt(Math.pow((double) x2 - x1, 2) + Math.pow((double) y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundreth(y1 - (x1 * (((double) y2 - y1) / (x2 - x1))));
    }

    public double slope() {
        return roundedToHundreth(((double) y2 - y1) / (x2 - x1));
    }

    public String equation() {
        String bOutput = " + " + (yIntercept());
        String xOutput = (y2 - y1) + "/" + (x2 - x1) + "x";
        if (y2 == y1) {
            return "y = " + yIntercept();
        }
        if ((y2 - y1) % (x2 - x1) == 0) {
            xOutput = (y2 - y1)/(x2 - x1) + "x";
            if (Math.abs((y2 - y1)/(x2 - x1)) == 1) {
                if ((y2 - y1)/(x2 - x1) == 1) {
                    xOutput = "x";
                } else {
                    xOutput = "-x";
                }
            }
        } else if ((x2 - x1) < 0) {
            if ((y2 - y1) < 0) {
                xOutput = Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) + "x";
            } else {
                xOutput = "-" + (y2 - y1) + "/" + Math.abs(x2 - x1) + "x";
            }
        }
        if (yIntercept() == 0) {
            bOutput = "";
        } else if (yIntercept() < 0) {
            bOutput = " - " + Math.abs(yIntercept());
        }
        return "y = " + xOutput + bOutput;
    }

    public String coordinateForX(double x) {
        return "(" + x + ", " + (slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe distance between these points is: " + distance();
    }

    private double roundedToHundreth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

}
