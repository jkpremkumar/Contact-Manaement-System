package Contact;
import java.util.*;
import java.sql.*;
public class ContactMain {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		try {
			while (true) {
	            System.out.println("\nContact Management System");
	            System.out.println("1. Add Contact");
	            System.out.println("2. View Contacts");
	            System.out.println("3. Update Contact");
	            System.out.println("4. Delete Contact");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scan.nextInt();
	            scan.nextLine(); 

	            switch (choice) 
	            {
	                case 1:
	                	addContact cont=new addContact();
	                	cont.add();
	                	cont.view();
	                	break;
	                case 2:
	                	addContact contview=new addContact();
	                	contview.view();
	                    break;
	                case 3:
	                	addContact contupd=new addContact();
	                	contupd.update();
	                	contupd.view();
	                    break;
	                case 4:
	                	addContact contdel=new addContact();
	                	contdel.delet();
	                	contdel.view();
	                    break;
	                case 5:
	                    System.out.println("Exiting Contact Management System. Goodbye!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
			}
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
}