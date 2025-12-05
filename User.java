package pack1;
import java.util.Scanner;


class InvalidUsername extends Exception{
	public InvalidUsername(String msg) {
		super(msg);
	}
	public String toString() {
		return "enter valid username";
	}
}

class InvalidPasssword extends Exception{
	public InvalidPasssword(String msg) {
		super(msg);
	}
	
	public String toString() {
		return "enter valid username";
	}	
}


 class Myuser{
	private String username="Nitin";
	private int password=1234;
	 
	public void validateusername(String usersusername) throws InvalidUsername{
		if(!usersusername.equals(this.username)) {
			throw new InvalidUsername("username wrong");
		}
	}
	
	public void validatepassword(int userspassword) throws InvalidPasssword{
		if(userspassword !=password) {
			throw new InvalidPasssword("password wrong");
		}
	}
	
	 
	 
 }
 
 public class User{
	 public static void main(String [] args) {
		 
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter username");
		 
		 String usersusername=sc.nextLine();
		 Myuser obj1=new Myuser();
		 
		 
		 try {
			 obj1.validateusername(usersusername);
			 
			 int attemps=3;
			 
			 while(attemps>0) {
				 System.out.println("Enter password");
				 int userspassword=sc.nextInt();
				 try {
			 
				 obj1.validatepassword(userspassword);
				 System.out.println("Login Successful!");
                
                 break;
			
			 }catch(InvalidPasssword e) {
				 System.out.println(e.getMessage());
				 attemps--;
                 System.out.println(e.getMessage() + " Attempts left: " + attemps);

				 if(attemps==0) {
					System.out.println("Account locked"); 
				 }
			 }
			 }
		 }catch(InvalidUsername e) {
	            System.out.println(e.getMessage());
		 }
	 }
 }

