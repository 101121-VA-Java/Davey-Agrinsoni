public class ArrayBasics{
    
    public static String[] reverse(String[] input){
        // Reverses all the elements of the inputed array and returns a new reversed array.
        String[] rev = new String[input.length];
        int j = 0;
        for(int i = input.length - 1; j < input.length; i--){
            rev[i] = input[j];
            j++;
        }
        return rev;
    }

    public static void main(String[] args){
        //System.out.println("Hello World!");
        String[] revarg = reverse(args);
        
        for(int i = 0; i < revarg.length; i++){
             System.out.print(revarg[i]+" ");
        }
    }
}
