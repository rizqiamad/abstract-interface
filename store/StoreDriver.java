/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application launches from this class
 *
 * @author Goteti Santosh Ravi Teja
 */
public class StoreDriver {

  /**
   *
   * @param args the command line arguments
   * @throws java.io.FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {
    //1. Declare variables managerCount, salesAssociateCount of type integer and initialize them to 0.
    int managerCount = 0;
    int salesAssociateCount = 0;
    int casherCount = 0;

    //2. Declare & initialize an object for PrintWriter class and use the file name "outputFile.txt" to write the corresponding data
    PrintWriter pwd = new PrintWriter(new File("outputFile.txt"));
    //3. Declare and initialize a scanner object "scanner" to read from the file "inputFile.txt"
    Scanner sc = new Scanner(new File("inputFile.txt"));
    //4. Declare and initialize a List object of type Manager as "managerList", and initialize the object as an ArrayList.
    List<Manager> managerList = new ArrayList<Manager>();
    //5. Declare and initialize a List object of type SalesAssociate as "salesAssociateList", and initialize the object as an ArrayList.
    List<SalesAssociate> SalesAssociateList = new ArrayList<SalesAssociate>();
    //6. Declare and initialize a List object of type SalesAssociate as "salesAssociateList", and initialize the object as an ArrayList.
    List<Casher> CasherList = new ArrayList<Casher>();
    //7. While inputFile.txt has more data(While loop starts here) {
    while (sc.hasNext()) {
      String employeeType = sc.nextLine();
      String storeDetails = sc.nextLine();
      String empName = sc.nextLine();
      String birthDay = sc.nextLine();
      String feelling = sc.nextLine();
      double basePay = sc.nextDouble();
      double numberOfHoursWorked = sc.nextDouble();
      double hourlyRate = sc.nextDouble();
      byte yearWorking = sc.nextByte();

      //   Read in the data, and store them to the respective variables such as,
      //   employeeType, storeDetails, empName variables of type String.
      //   basePay, numberOfHoursWorked and hourlyRate as type double
      // 8. If the employee type in the inputFile is "Manager" , then declare variables currentSales, CurrentStoreSales of type double
      //    and read the data.
      if (employeeType.equals("Manager")) {
        double currentSales = sc.nextDouble();
        double CurrentStoreSales = sc.nextDouble();

        //8a. create an object for Manager named as "manager"
        //    and initialize the multiple argument constructor with above mentioned variables in (question 6 & 7).
        //    Then add the manager object to the arrayList of managerList.If the employee type is not manager then
        //    declare a variable salesRate of type double and scan the element, now create an object for salesAssociate named as "salesAssociate",
        //    initialize the sales associate by invoking the constructor of SalesAssociate class with above mentioned variables (question 6 & 7).
        //    Then add the salesAssociate object to the arrayList of salesAssociateList
        Manager manager = new Manager(
          CurrentStoreSales,
          currentSales,
          numberOfHoursWorked,
          hourlyRate,
          storeDetails,
          basePay,
          empName,
          birthDay,
          yearWorking,
          feelling
        );
        sc.nextLine();
        managerList.add(manager);
      } else if (employeeType.equalsIgnoreCase("Casher")) {
        byte rating = sc.nextByte();
        Casher casher = new Casher(
          numberOfHoursWorked,
          hourlyRate,
          storeDetails,
          basePay,
          empName,
          rating,
          birthDay,
          yearWorking,
          feelling
        );
        CasherList.add(casher);
        if (sc.hasNext()) {
          sc.nextLine();
        }
      } else {
        double salesRate = sc.nextDouble();
        SalesAssociate salesAssociate = new SalesAssociate(
          salesRate,
          numberOfHoursWorked,
          hourlyRate,
          storeDetails,
          empName,
          basePay,
          birthDay,
          yearWorking,
          feelling
        );
        SalesAssociateList.add(salesAssociate);
        if (sc.hasNext()) {
          sc.nextLine();
        }
      }
    }

    // While Loop ends here
    //9. Print the size of the managerList to the console and outputfile. See the sample output for sample formatting
    System.out.println(
      "******************************************************"
    );
    System.out.println(
      "Number of employees working as MANAGER are: " + managerList.size()
    );
    System.out.println(
      "******************************************************"
    );
    pwd.println("******************************************************");
    pwd.println(
      "Number of employees working as MANAGER are: " + managerList.size()
    );
    pwd.println("******************************************************");
    //10. Use an enhanced for loop and iterate through managerList which is of type Manager and use "manager" as variable.
    //   Increment the count of the managerCount by one every time loop is started. Now test the toString() method of manager class. Also write this output to
    //   the console & outputFile. Test the salesPercentByManager of manager class and write the output to both console and output file.
    //   Test the calculatePay(), calculateRemainingStoreRevenue(double), and checkPromotionEligibility() method of manager class and write the output to both console and output file. Do the required String formatting by seeing the sample output

    for (Manager manager : managerList) {
      managerCount++;
      System.out.println(managerCount + ". Manager Details:");
      System.out.println(manager);
      pwd.println(managerCount + ". Manager Details:");
      pwd.println(manager);
      System.out.println(
        "Percentage of sales done: " +
        String.format("%.2f", manager.salesPercentByManager()) +
        "%"
      );
      pwd.println(
        "Percentage of sales done: " +
        String.format("%.2f", manager.salesPercentByManager()) +
        "%"
      );
      System.out.println(
        "Gross Payment: $" + String.format("%.1f", manager.calculatePay())
      );
      pwd.println(
        "Gross Payment: $" + String.format("%.1f", manager.calculatePay())
      );
      System.out.println("Birth Day : " + manager.birthDay());
      pwd.println("Birth Day : " + manager.birthDay());
      System.out.println("Year Working : " + manager.yearWorking() + "Years");
      pwd.println("Year Working : " + manager.yearWorking() + "Years");
      System.out.println("Feeling : " + manager.feelling());
      pwd.println("Feeling : " + manager.feelling());
      System.out.println(
        "Remaining store revenue: $" +
        manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales())
      );
      pwd.println(
        "Remaining store revenue: $" +
        manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales())
      );

      System.out.print(
        "Is " + manager.getEmployeeName() + " eligible for promotion? "
      );
      if (manager.checkPromotionEligibility() == true) {
        System.out.println("Yes, he is \n");
      } else {
        System.out.println("No, he needs to work harder\n");
      }
    }

    //   For Loop ends here
    //11.Print the size of the salesAssociateList to the console and outputfile. See the sample output for sample formatting
    System.out.println(
      "******************************************************"
    );
    System.out.println(
      "Number of employees working as SALES ASSOCIATES are: " +
      SalesAssociateList.size()
    );
    System.out.println(
      "******************************************************"
    );
    pwd.println("******************************************************");
    pwd.println(
      "Number of employees working as SALES ASSOCIATES are: " +
      SalesAssociateList.size()
    );
    pwd.println("******************************************************");

    //12. Use a enhanced for loop and iterate through salesAssociateList which is of type SalesAssociate and use "salesAssociate" as variable.
    //   Increment the count of the salesAssociateCount by one every time loop is started. Now test the toString() method of SalesAssociate class. Also write this output to
    //   the console & outputFile.
    //   Test the calculatePay(), calculateCommission(), and checkPromotionEligibility() method of salesAssociate class and write the output to both console and output file. Do the required String formatting by seeing the sample output
    for (SalesAssociate salesAssociate : SalesAssociateList) {
      salesAssociateCount++;
      System.out.println(salesAssociateCount + ". Sales Associate Details:");
      System.out.println(salesAssociate);
      pwd.println(salesAssociateCount + ". Sales associate Details:");
      pwd.println(salesAssociate);
      System.out.println(
        "Total commission: $" + salesAssociate.calculateCommission()
      );
      System.out.println("Gross Payment: $" + salesAssociate.calculatePay());

      pwd.println("Total commission: $" + salesAssociate.calculateCommission());
      pwd.println("Gross Payment: $" + salesAssociate.calculatePay());

      System.out.println("Birth Day : " + salesAssociate.birthDay());
      pwd.println("Birth Day : " + salesAssociate.birthDay());
      System.out.println("Feeling : " + salesAssociate.feelling());
      pwd.println("Feeling : " + salesAssociate.feelling());
      System.out.println(
        "Years Working : " + salesAssociate.yearWorking() + "Years"
      );
      pwd.println("Years Working : " + salesAssociate.yearWorking() + "Years");

      System.out.print(
        "Is " + salesAssociate.getEmployeeName() + " eligible for promotion? "
      );
      if (salesAssociate.checkPromotionEligibility() == true) {
        System.out.println("Yes, he/she is eligible\n");
      } else {
        System.out.println("No, he/she needs to work harder\n");
      }
    }
    //   For loop ends after this
    //12.Print the size of the chaserList to the console and outputfile. See the sample output for sample formatting
    System.out.println(
      "******************************************************"
    );
    System.out.println(
      "Number of employees working as CASHER are: " + CasherList.size()
    );
    System.out.println(
      "******************************************************"
    );
    pwd.println("******************************************************");
    pwd.println(
      "Number of employees working as CASHER are: " + CasherList.size()
    );
    pwd.println("******************************************************");

    //13. Use a enhanced for loop and iterate through CasherList which is of type SalesAssociate and use "salesAssociate" as variable.
    //   Increment the count of the salesAssociateCount by one every time loop is started. Now test the toString() method of SalesAssociate class. Also write this output to
    //   the console & outputFile.
    //   Test the calculatePay(), calculateCommission(), and checkPromotionEligibility() method of salesAssociate class and write the output to both console and output file. Do the required String formatting by seeing the sample output
    for (Casher casher : CasherList) {
      casherCount++;
      System.out.println(casherCount + ". Casher Details:");
      System.out.println(casher);
      pwd.println(casherCount + ". Casher Details:");
      pwd.println(casher);
      System.out.println("Total commission: $" + casher.calculateCommission());
      System.out.println("Gross Payment: $" + casher.calculatePay());

      pwd.println("Total commission: $" + casher.calculateCommission());
      pwd.println("Gross Payment: $" + casher.calculatePay());

      System.out.println("Birth Day : " + casher.birthDay());
      pwd.println("Birth Day : " + casher.birthDay());
      System.out.println("Years Working : " + casher.yearWorking() + "Years");
      pwd.println("Years Working : " + casher.yearWorking() + "Years");
      System.out.println("Feeling : " + casher.feelling());
      pwd.println("Feeling : " + casher.feelling());

      System.out.print(
        "Is " + casher.getEmployeeName() + " eligible for promotion? "
      );
      if (casher.checkPromotionEligibility() == true) {
        System.out.println("Yes, he/she is eligible\n");
      } else {
        System.out.println("No, he/she needs to work harder\n");
      }
    }
    pwd.close();
    //   For loop ends after this
  }
}
