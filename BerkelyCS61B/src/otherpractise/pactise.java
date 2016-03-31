package otherpractise;

public class pactise {
	public static String parity(String msg){
		String parityStr=null;
		int n =msg.hashCode();
		switch(n%2){
		case 0:
		parityStr="even";
		break;
		case 1:
			parityStr="odd";
		break;
		}
		return parityStr;
	}
 public static void main(String args[]){
	 String n= new String("sgd");
	 String out=pactise.parity(n);
	 System.out.println(out);
 }
 
}
