public class ArrayBasics{
    
    public static String[] reverse(String[] input){
        // Print all elements of names array backwards
        String[] rev = new String[input.length];
        int j = 0;
        for(int i = input.length - 1; j < input.length; i--){
            rev[i] = input[j];
            j++;
        }
        return rev;
    }

    public static void main(String[] args){
        System.out.println("Hello World!");

        String[] revarg = reverse(args);
        /*for(String l : rev){
			System.out.print(l);
        }*/
        for(int i = 0; i < revarg.length; i++){
             System.out.print(revarg[i]);
            }
        //String[] car = {"R", "a", "c", "e","c","a","R."};
        //String[] batch = new String[3]; 
        
    }


}
