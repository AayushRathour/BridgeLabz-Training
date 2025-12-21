import java.util.*;

public class CollinearUsingSlope{
    // use the formula to check collinearity
    public static boolean isCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3){
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);
        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    // use the formula to check collinearity using area of triangle
    public static boolean isCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3){
        double area = (0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
        return area == 0;
    }

    public static void main(String[] args){
		// take input cordinates
        Scanner sc=new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        // calling method and printing results
        if(isCollinearBySlope(x1,y1,x2,y2,x3,y3)) System.out.println("Collinear using Slope Method");
        else System.out.println("Not Collinear using Slope Method");

        // area method result
        if(isCollinearByArea(x1,y1,x2,y2,x3,y3)) System.out.println("Collinear using Area Method");
        else System.out.println("Not Collinear using Area Method");
		sc.close();
    }
}