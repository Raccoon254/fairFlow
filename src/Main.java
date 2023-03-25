import javax.xml.crypto.Data;

public class Main {
    //Main Class
    public static void main(String[] args){
        User Steve = new User("STEVE","Steve","admin","admin","admin@corruption.com","RACSAM");

        //TODO new Database().registerUser(Steve);
        // new Database().registerOrganization(new Organization("S2RCX","kenTom","kentom@fairFlow.com","kenTom","A kenTom company","NAIROBI"));

        //new Database().registerFunds(new Fund(IdGenerator.autoIdLengthFix("fundId"),"Chuka Uni Fund","Funds To Test Db","RACSAM"));
        new Database().registerCategory(new Category(IdGenerator.autoIdLengthFix("categoryId"),"OFFLINE FUNDS","FUNDS OFFERED IN CASH"));

        /*
        Initialize the FairFlowController: The main class first creates an instance of the FairFlowController, which is the class responsible for managing the different operations and functionality of the application.

        Get a list of all transactions for a particular fund: The main class calls a method on the FairFlowController to retrieve all transactions associated with a particular fund. This list of transactions will be used for subsequent operations.

        Detect potential corruption in the fund's transactions: The FairFlowController is used to detect any potential instances of corruption in the transactions associated with the fund. This could involve analyzing transaction patterns, checking for unusual activity, or applying other rules and heuristics to identify suspicious behavior.

        Report potential corruption to system administrators: If potential corruption is detected, the main class calls a method on the FairFlowController to report the suspicious activity to system administrators or other authorized personnel. This could involve sending a notification or alert, generating a report, or taking other actions to ensure that the issue is addressed appropriately.

        Approve or reject transactions: The main class uses the FairFlowController to evaluate each transaction in the list and determine whether it should be approved or rejected based on various factors such as the amount, category, or other criteria. This might involve applying business rules or policies to make decisions and flagging transactions that require additional review or investigation.

        Flag transactions as potential cash misuse: Finally, the FairFlowController can be used to flag transactions that may be indicative of cash misuse, such as transactions involving large amounts of cash or those that violate other policies or regulations. These flagged transactions can be reviewed further or escalated as needed to address any potential issues.

      */
    }

}
