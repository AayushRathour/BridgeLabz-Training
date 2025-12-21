public class FindTheBonus{
    // generates salary and years of service
    public static double[][] getRandom(){
        double[][] result = new double[10][2];
        for(int i = 0; i < 10; i++){
            result[i][0] = 10000 + (Math.random()*90000);
            result[i][1] = 1+(int)(Math.random()*10);
        }
        return result;
    }

    // add bonus to salary of employees
    public static double[][] addBonus(double[][] arr){
        double[][] result = new double[10][2];
        for(int i = 0; i < 10; i++){
            double salary = arr[i][0];
            double years = arr[i][1];
            double bonus = 0;
			if(years >= 5) bonus = salary/20;
			else bonus = salary/50;
            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    // print the prev and new salary
    public static void print(double[][] prev, double[][] updated){
        double oldSal = 0;
		int newSal = 0;
		int bonusSum = 0;
		
        for(int i=0;i<10;i++){
            oldSal += prev[i][0];
            newSal += updated[i][0];
            bonusSum += updated[i][1];
        }
        System.out.println("old Salary : " + oldSal);
        System.out.println("New Salary : " + newSal);
        System.out.println("Bonus given : " + bonusSum);
    }

    public static void main(String[] args){
        double[][] employeeData = getRandom();
        double[][] updatedData = addBonus(employeeData);
        print(employeeData, updatedData);
    }
}