package Contact;

import java.util.Scanner;

public class savedContact {
	static String name;
	static String phonenum;
	static String email;
	savedContact(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter Name");
		name=scanner.next();
		
		System.out.println("enter phone no");
		phonenum=scanner.next();	
		
		System.out.println("enter email");
		email=scanner.next();
	}
	savedContact(String name){
		this.name=name;
	}
}