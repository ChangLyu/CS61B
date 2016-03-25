package labs.lab6.bankinf;

public class BadTransactionException extends Exception{

	   public int  transactionValue;  // The invalid account number.

	   /**
	    *  Creates an exception object for nonexistent account "badAcctNumber".
	    **/
	   public BadTransactionException(int badTransactionValue) {
	     super("Invalid transaction value: " + badTransactionValue);

	     transactionValue = badTransactionValue;}
	   
}
