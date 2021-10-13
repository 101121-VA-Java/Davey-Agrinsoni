public class Calculator{
    /*
        Method declarations:
        - [Access modifer] [non-access modifeiers] [return type]
            reusable logic
            }
    */
    /*public static void print(int numberofTimes){
        for(int i = 0; i < numberofTimes; i++){
            System.out.println("Hi");
        }
    }*/

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
    public void countdown(int startValue) { 
    return 0;
    }

    public static void main(String[] args){
        //int sum = remainder(2,4);
        //System.out.println(sum);
        weekday(args[0]);
        //int dif = subtract(4,2);

    }



}