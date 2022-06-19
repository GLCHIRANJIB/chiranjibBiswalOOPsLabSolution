package com.chiranjib.main;
import java.util.Scanner;
import java.util.Random;

public class Employee 
{
    String  firstName, lastName;
    public Employee(String fname,String lname)
    {
        firstName = fname;
        lastName = lname;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String fn,ln;
        char ch; 
        String dept="";
        System.out.print("Enter your first name\t:");
        fn = sc.nextLine();
        System.out.print("Enter your last name\t:");
        ln = sc.nextLine();
        Employee emp = new Employee(fn,ln);
        System.out.print("Choose your Department Technical(1)/Admin(2)/Human Resource(3)/Legal(4)");
        ch = sc.next().charAt(0);
        if(ch=='1')         dept = "tech";
        else if(ch=='2')    dept = "admin";
        else if(ch=='3')    dept = "hr";
        else if(ch=='4')    dept = "legal";
        CredentialService.showCredentials(emp,dept);
    }
}
class CredentialService
{
    private static char[] generatePassword()
    {
      String passString = "!@#$ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
      int passLength = 8;
      Random random = new Random();
      char[] password = new char[passLength];
   
      for(int i = 0; i< passLength ; i++) 
      {
         password[i] = passString.charAt(random.nextInt(passString.length()));
      }
      return password;
    }
    private static String generateEmailAddress(Employee e,String d)
    {
        String companyName = "ABC";
        String email = e.firstName+e.lastName+"@"+d+"."+companyName+".com";
        return email.toLowerCase(); 
    }
    public static void showCredentials(Employee e,String d)
    {
        System.out.println("Dear "+e.firstName+" your generated credentials are as follows");
        System.out.println("Email --->\t" + generateEmailAddress(e,d));
        System.out.println("Password --->\t" + generatePassword());
    }
}
