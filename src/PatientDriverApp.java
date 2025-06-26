/*
 * Class: CMSC203
 * Instructor:
 * Description: Simple driver for Programming I; reads one patient and three procedures, then shows all details.
 * Due: 07/27/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ashley Qiao 07/01/25
 */
import java.util.Scanner;

public class PatientDriverApp {
    public static void main(String[] args) {
        System.out.println("The program was developed by a Student: Ashley Qiao 07/01/25\n");
        Scanner sc = new Scanner(System.in);

        Patient patient = new Patient();
        System.out.print("Enter patient's first name: ");
        patient.setFirstName(sc.nextLine());
        System.out.print("Enter patient's middle name: ");
        patient.setMiddleName(sc.nextLine());
        System.out.print("Enter patient's last name: ");
        patient.setLastName(sc.nextLine());
        System.out.print("Enter patient's street address: ");
        patient.setAddress(sc.nextLine());
        System.out.print("Enter patient's city: ");
        patient.setCity(sc.nextLine());
        System.out.print("Enter patient's state (ex. MD): ");
        patient.setState(sc.nextLine());
        System.out.print("Enter patient's ZIP: ");
        patient.setZip(sc.nextLine());
        System.out.print("Enter patient's phone number (xxx-xxx-xxxx): ");
        patient.setPhoneNumber(sc.nextLine());
        System.out.print("Enter emergency contact name: ");
        patient.setEmergencyContactName(sc.nextLine());
        System.out.print("Enter emergency contact phone (xxx-xxx-xxxx): ");
        patient.setEmergencyContactPhone(sc.nextLine());

        Procedure p1 = new Procedure();
        System.out.print("Procedure 1 name: ");
        p1.setProcedureName(sc.nextLine());
        System.out.print("Procedure 1 date: ");
        p1.setProcedureDate(sc.nextLine());
        System.out.print("Procedure 1 practitioner: ");
        p1.setPractitionerName(sc.nextLine());

        double charge1;
        do 
        {
            System.out.print("Procedure 1 cost: ");
            String input;
            while (true) 
            {
                input = sc.nextLine();
                try 
                {
                    charge1 = Double.parseDouble(input);
                    break;
                } 
                catch (NumberFormatException e) 
                {
                    System.out.print("Invalid entry. Please enter a valid cost: ");
                }
            }
            if (charge1 < 0) 
            {
                System.out.println("The charges must be zero or more.");
            }
        } 
        while (charge1 < 0);

        p1.setProcedureCharge(charge1);

        System.out.print("Procedure 2 name: ");
        String name2 = sc.nextLine();
        System.out.print("Procedure 2 date: ");
        String date2 = sc.nextLine();
        Procedure p2 = new Procedure(name2, date2);
        System.out.print("Procedure 2 practitioner: ");
        p2.setPractitionerName(sc.nextLine());

        double charge2;
        do 
        {
            System.out.print("Procedure 2 cost: ");
            String input2;
            while (true) 
            {
                input2 = sc.nextLine();
                try 
                {
                    charge2 = Double.parseDouble(input2);
                    break;
                } catch (NumberFormatException e) 
                {
                    System.out.print("Invalid entry. Please enter a valid cost: ");
                }
            }
            if (charge2 < 0) 
            {
                System.out.println("The charges must be zero or more.");
            }
        } 
        while (charge2 < 0);
        p2.setProcedureCharge(charge2);

        System.out.print("Procedure 3 name: ");
        String name3 = sc.nextLine();
        System.out.print("Procedure 3 date: ");
        String date3 = sc.nextLine();
        System.out.print("Procedure 3 practitioner: ");
        String pract3 = sc.nextLine();

        double charge3;
        do 
        {
            System.out.print("Procedure 3 cost: ");
            String input3;
            while (true) 
            {
                input3 = sc.nextLine();
                try 
                {
                    charge3 = Double.parseDouble(input3);
                    break;
                } catch (NumberFormatException e) 
                {
                    System.out.print("Invalid. Please enter a valid cost: ");
                }
            }
            if (charge3 < 0) 
            {
                System.out.println("The charges must be zero or more.");
            }
        } while (charge3 < 0);

        Procedure p3 = new Procedure(name3, date3, pract3, charge3);

        // Displays results
        System.out.println();
        System.out.println(patient + "\n");
        System.out.println(p1 + "\n");
        System.out.println(p2 + "\n");
        System.out.println(p3 + "\n");

        double total = calculateTotalCharges(p1, p2, p3);
        System.out.printf("Total Charges: $%,.2f\n", total);

        sc.close();
    }

    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getProcedureCharge() + p2.getProcedureCharge() + p3.getProcedureCharge();
    }
}
