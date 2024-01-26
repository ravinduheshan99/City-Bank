import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CityBank {
    final static String aun = "admin";
    final static String apw = "admin123";
    final static String sun = "staff";
    final static String spw = "staff123";
    public static List<Customer> customers = new ArrayList<>();
    public static List<Employee> emps = new ArrayList<>();

    public static int menu() {
        Scanner in = new Scanner(System.in);
        System.out.println(" 1. Create an Account \n 2. Chequebooks \n 3. Search Customer Details \n 4. Update Customer Details \n 5. Remove Customer \n 6. Back ");
        System.out.println("Enter your choice: ");
        return in.nextInt();
    }

    public static int menu2() {
        Scanner in2 = new Scanner(System.in);
        System.out.println(" 1. Add New Employee \n 2. Search Employee Details \n 3. Update Employee Details \n 4. Remove Employee \n 5. Back ");
        System.out.println("Enter your choice: ");
        return in2.nextInt();
    }

    public static void customerMenu(int ch) {
        Scanner sc = new Scanner(System.in);
        switch (ch) {
            case 1:
                Customer C1 = new Customer();
                C1.openAccount();
                customers.add(C1);
                System.out.println("Account Created Successfully");
                break;
            case 2:
                System.out.println(" 1.Return \n 2.Issue \n Enter Your Choice: ");
                int input = sc.nextInt();
                System.out.println("Please Enter Your Account No: ");
                String account_no = sc.next();
                for (Customer customer : customers) {
                    if (customer.getAcc_no().equals(account_no) && customer.getAcc_type().equals("Current")) {
                        customer.chequeBook(input);
                    }else {
                        System.out.println("PLease Recheck Your Account Number And Try Again");
                        menu();
                    }
                }
                break;
            case 3:
                System.out.print("Please Enter The Account Number You Want To Search: ");
                String ac_no = sc.next();
                boolean found = false;

                for (Customer customer : customers) {
                    if (customer.getAcc_no().equals(ac_no)) {
                        found = true;
                        System.out.println("Account no.: " + customer.getAcc_no());
                        System.out.println("Name Of Account Holder: " + customer.getName());
                        System.out.println("Account type: " + customer.getAcc_type());
                        System.out.println("Permanent Address: " + customer.getAddress());
                        System.out.println("National Identity Card Number: " + customer.getId());
                        System.out.println("Mobile Number: " + customer.getMobile());
                        System.out.println("Email Address: " + customer.getEmail());
                        System.out.println("Branch: " + customer.getBranch());
                        System.out.println("Period(In Months): " + customer.getPeriod());
                        System.out.println("Description: " + customer.getDescription());
                        System.out.println("Balance: " + customer.getBalance());
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Search failed! Account doesn't exist..!!");
                }
                break;
            case 4:
                System.out.print("Please Enter The Account Number You Want To Update: ");
                ac_no = sc.next();
                found = false;
                for (Customer customer : customers) {
                    if (customer.getAcc_no().equals(ac_no)) {
                        found = true;
                        customer.Update();
                    }
                }
                if (!found) {
                    System.out.println("Search failed! Account doesn't exist..!!");
                }
                break;
            case 5:
                System.out.print("Please Enter The Account Number You Want To Remove: ");
                ac_no = sc.next();
                found = false;

                for (Customer customer : customers) {
                    if (customer.getAcc_no().equals(ac_no)) {
                        found = true;
                        customers.remove(customer);
                        System.out.println("Successfully Removed Customer");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Search failed! Account doesn't exist..!!");
                }
                break;
            case 6:
                break;

        }
    }

    public static void employeeMenu(int ch) {
        Scanner sc = new Scanner(System.in);
        switch (ch) {
            case 1:
                Employee E = new Employee();
                E.newEmp();
                emps.add(E);
                System.out.println("Employee Added Successfully");
                break;
            case 2:
                System.out.print("Please Enter The Employee Number You Want To Search: ");
                String emp_no = sc.next();
                boolean found = false;

                for (Employee employee : emps) {
                    if (employee.getEmp_no().equals(emp_no)) {
                        found = true;
                        System.out.println("Employee Number: " + employee.getEmp_no());
                        System.out.println("Name Of Employee: " + employee.getEmp_name());
                        System.out.println("Designation: " + employee.getEmp_desig());
                        System.out.println("Basic Salary: " + employee.sal(employee.getEmp_desig()));
                        System.out.println("Permanent Address: " + employee.getEmp_address());
                        System.out.println("National Identity Card Number: " + employee.getEmp_id());
                        System.out.println("Mobile Number: " + employee.getEmp_mobile());
                        System.out.println("Email Address: " + employee.getEmp_email());
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Search failed! Account doesn't exist..!!");
                }
                break;
            case 3:
                System.out.print("Please Enter The Employee Number You Want To Update: ");
                emp_no = sc.next();
                found = false;
                for (Employee employee : emps) {
                    if (employee.getEmp_no().equals(emp_no)) {
                        found = true;
                        employee.updateEmp();
                    }
                }
                if (!found) {
                    System.out.println("Search failed! Employee doesn't exist..!!");
                }
                break;
            case 4:
                System.out.print("Please Enter The Employee Number You Want To Remove: ");
                emp_no = sc.next();
                found = false;

                for (Employee employee : emps) {
                    if (employee.getEmp_no().equals(emp_no)) {
                        found = true;
                        emps.remove(employee);
                        System.out.println("Successfully Removed Employee");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Search failed! Employee doesn't exist..!!");
                }
                break;
            case 5:
                break;
        }
    }

    public static void main(String[] arg) {

        boolean flag = true;

        System.out.println(" **********CITY BANK********** ");

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Username: ");
            String un = sc.next();
            System.out.println("Password: ");
            String pw = sc.next();

            if (un.equals(aun) && (pw.equals(apw))) {

                int ch;
                do {
                    System.out.println("\n ***Welcome To The City Bank Admin Login***");
                    System.out.println(" 1. Customers \n 2. Employees \n 3. Exit ");
                    System.out.println("Enter your choice: ");
                    ch = sc.nextInt();
                    switch (ch) {

                        case 1:
                            do {
                                ch = menu();
                                customerMenu(ch);
                            } while (ch != 6);
                            break;

                        case 2:
                            do {
                                ch = menu2();
                                employeeMenu(ch);
                            }
                            while (ch != 5);
                            break;

                        case 3:
                            flag = false;
                            System.out.println("See you soon...");
                            break;
                    }
                } while (ch != 3);

            } else if (un.equals(sun) && (pw.equals(spw))) {
                int ch;

                do {
                    System.out.println("\n ***Welcome To The City Bank Staff Login***");
                    ch = menu();
                    customerMenu(ch);
                    if (ch == 6) {
                        flag = false;
                        System.out.println("See you soon");
                    }
                }
                while (ch != 6);
            } else {
                System.out.println("Please Recheck Your Username and Password");
            }
        } while (flag);
    }

}