public class Calculator{

    public static int add(int a,int b){
        return a + b;
    }  
    
    public static int subtract(int a,int b){
        return a - b;
    }  

    public static double multiply(double c, double d){
        return (c * d);
    }

    public static int remainder(int a, int b){
        return (a % b);
    }

    public static void weekday(String weekday){
        
        switch(weekday){
            case "Monday":
                System.out.println("It is Monday");
            break;
            case "Tuesday":
                System.out.println("It is Tuesday");
            break;
            case "Wednesday":
                System.out.println("It is Wednesday my dude!");
            break;
            case "Thursday":
                System.out.println("It is Thursday");
            break;
            case "Friday":
                System.out.println("It is finally Friday!");
            break;
            case "Saturday":
                System.out.println("It is Saturday");
            break;
            case "Sunday":
                System.out.println("It is Sunday");
            break;
            default:
                System.out.println("What are you asking?");
            break;
        }
        
    } 
    public static void countdown(int startValue) { 
        int i = startValue;
        while(startValue >= 0 && i >= 0){
            System.out.println(i);
            i--;
        }
        if (startValue < 0){
            System.out.println("Input must be positive or 0");
        }
    }

    public static void main(String[] args){
        int sum = add(2,4);
        System.out.println(sum);
        int dif = subtract(2,4);
        System.out.println(dif);
        double mul = multiply(2,4);
        System.out.println(mul);
        int mod = remainder(2,4);
        System.out.println(mod);
        System.out.println("Howdy " + args[0] + "! ");
        weekday(args[1]);
        countdown(4); 
    }



}