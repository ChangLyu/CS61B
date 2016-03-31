package otherpractise;
import java.io.*;
import java.net.*;
public class OpenCommercial {
public static void main(String[] args) throws Exception{

	String URL1= "http://www.";
	BufferedReader keybd= new BufferedReader(new InputStreamReader(System.in));// construct a new bufferedreader class
	System.out.print("pls enter a name of a website:");
	System.out.flush();// let the print quickly appear
	String URL2= new String(keybd.readLine()); // let the bufferedreader keybd reference to the line read from the keyboard, converting it to string
	String URL3= new String();
			URL3=URL1.concat(URL2);
			URL3=URL3.concat(".com");
	URL url= new URL(URL3);// create a new url "www. keybd word.com"
	 
	BufferedReader contents= new BufferedReader(
			new InputStreamReader(url.openStream())); // open a url and put the content into contents
	
	String[] stringArray=new String[5];
    stringArray[0]=contents.readLine();
    stringArray[1]=contents.readLine();
    stringArray[2]=contents.readLine();
    stringArray[3]=contents.readLine();
    stringArray[4]=contents.readLine();
	for(int i=4; i>=0;i--){
		System.out.println(stringArray[i]);// read the line from first to fifth and print them in convert sequence
	}
	
}
}
