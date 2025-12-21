import java.util.*;


public class QuadraticEquation{
    // find roots of quadratic equation
    public static double[] getRoots(double a,double b,double c){
		// find delta using formula
        double delta = Math.pow(b,2) + 4 * a * c;
		
		// for delta less than 0 return empty array
        if(delta < 0) return new double[]{};
		
        // for delta equal to zero return one root
        if(delta == 0){
            double root = -b / (2 * a);
            return new double[]{root};
        }
		
        // for delta value positive return two roots in an array
        double deltaRoot = Math.sqrt(delta);
        double root1 = (-b + deltaRoot) / (2 * a);
        double root2 = (-b - deltaRoot) / (2 * a);
        return new double[]{root1,root2};
    }
    public static void main(String[] args){
		// Creating scanner object and taking input
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter values of a, b and c : ");
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
		
        // calling function to find roots
        double[] roots = getRoots(a,b,c);
		
		
        // Printing results
        if(roots.length == 0) System.out.println("No roots");
        else if(roots.length==1) System.out.println(roots[0]);
        else System.out.println(roots[0] + " " + roots[1]);
		sc.close();
    }
}