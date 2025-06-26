/*
 * Class: CMSC203
 * Instructor:
 * Description: Simple Procedure class for Programming I; represents one medical procedure and its cost.
 * Due: 07/27/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ashley Qiao
 */
public class Procedure {
    // Fields
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharge;

    // Constructors
    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitionerName = "";
        this.procedureCharge = 0.0;
    }

    public Procedure(String procedureName, String procedureDate) {
        this();
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    public Procedure(String procedureName, String procedureDate,
                     String practitionerName, double procedureCharge) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharge = procedureCharge;
    }

    // Get and set
    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public String getProcedureDate() { return procedureDate; }
    public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }
    public String getPractitionerName() { return practitionerName; }
    public void setPractitionerName(String practitionerName) { this.practitionerName = practitionerName; }
    public double getProcedureCharge() { return procedureCharge; }
    public void setProcedureCharge(double procedureCharge) { this.procedureCharge = procedureCharge; }

    public String toString() {
        return "    Procedure: " + procedureName + "\n" +
               "    Procedure Date: " + procedureDate + "\n" +
               "    Practitioner: " + practitionerName + "\n" +
               "    Charge: $" + String.format("%.2f", procedureCharge);
    }
}