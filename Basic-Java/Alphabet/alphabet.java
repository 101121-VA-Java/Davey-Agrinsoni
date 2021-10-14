public class alphabet{
	public static void main(String[] args){
	int alp = 65;
	for(int i=0; i < 26;){
		if (i < 13 ){ 
			System.out.print((char)(alp+i)+" " );
			i++;
			}
		if (i==13){
			System.out.println(" ");
			System.out.print((char)(alp+i)+" ");
			i++;
			}
		else {
			System.out.print((char)(alp+i)+" ");
			i++;
			}
		}
	}












}



