package com.cs61b;
import java.io.*;
public class Nuke2 {
	public static void main(String[] args) throws Exception{
		BufferedReader keybd= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("pls enter a String which length is above two:");
		System.out.flush();
		String nuke= new String(keybd.readLine());
		char[] nukechar= nuke.toCharArray();// string to char[] toChar or to CharArray
		char[] newnukechar= new char[nukechar.length-1];
		newnukechar[0]=nukechar[0];
		for(int i=2;i<nukechar.length;i++){
			newnukechar[i-1]=nukechar[i];
		}
		String st= new String();
		st=String.valueOf(newnukechar);// char[] to String: this one or new String(char[])
		System.out.println(st);
	}

}
