/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Prompts the user to describe one patient and three procedures, then displays all info and charge
 * Due: 07/27/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ashley Qiao
 */
public class Patient 
{
    // Fields
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone; 
    public Patient() 
    {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phoneNumber = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }

    public Patient(String firstName, String middleName, String lastName) 
    {
        this();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Patient(String firstName, String middleName, String lastName,
                   String address, String city, String state, String zip,
                   String phoneNumber,
                   String emergencyContactName, String emergencyContactPhone) 
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }
    
    public String getFirstName()
    {
    	return firstName;
    }
    
    public void setFirstName(String firstName)
    {
    	this.firstName = firstName;
    }
    
    public String getMiddleName()
    { 
        return middleName;
    }

    public void setMiddleName(String middleName)
    { 
        this.middleName = middleName;
    }

    public String getLastName()
    { 
        return lastName;
    }

    public void setLastName(String lastName)
    { 
        this.lastName = lastName;
    }

    public String getAddress()
    { 
        return address;
    }

    public void setAddress(String address)
    { 
        this.address = address;
    }

    public String getCity()
    { 
        return city;
    }

    public void setCity(String city)
    { 
        this.city = city;
    }

    public String getState()
    { 
        return state;
    }

    public void setState(String state)
    { 
        this.state = state;
    }

    public String getZip()
    { 
        return zip;
    }

    public void setZip(String zip)
    { 
        this.zip = zip;
    }

    public String getPhoneNumber()
    { 
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    { 
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyContactName()
    { 
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName)
    { 
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone()
    { 
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone)
    { 
        this.emergencyContactPhone = emergencyContactPhone;
    }


    public String buildFullName() 
    {
        return firstName + " " + middleName + " " + lastName;
    }

    public String buildAddress() 
    {
        return address + " " + city + " " + state + " " + zip;
    }

    public String buildEmergencyContact() 
    {
        return emergencyContactName + " " + emergencyContactPhone;
    }


    public String toString() 
    {
        return "Patient Details:\n" +
               "Name: " + buildFullName() + "\n" +
               "Address: " + buildAddress() + "\n" +
               "Phone: " + phoneNumber + "\n" +
               "Emergency Contact: " + buildEmergencyContact();
    }
}