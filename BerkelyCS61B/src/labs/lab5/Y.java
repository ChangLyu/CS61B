package labs.lab5;

public class Y extends X implements Z{

	
	public void newmethod(int i){
		super.newmethod(i);
		System.out.println("override method");
	}
	public static void main(String args[]){
		Y ya= new Y();
		 ya.newmethod(3);
        //((X)ya).newmethod(3);
       // ((Z)ya).newmethod(3);

        X xa=(X)ya;
        xa.newmethod(4);
        
        X xa2= new X();
        xa2.newmethod(6);

		System.out.println(X.a);
		System.out.println(Z.a);
		
	}
}