import java.util.Scanner;

class Employee extends Rates {
    private String emp_no;
    private String emp_name;
    private String emp_id;
    private int emp_mobile;
    private String emp_address;
    private String emp_email;
    private String emp_desig;
    Scanner sc3 = new Scanner(System.in);

    public String getEmp_no() {
        return emp_no;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public int getEmp_mobile() {
        return emp_mobile;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public String getEmp_desig() {
        return emp_desig;
    }

    //Method To Add New Employee
    public void newEmp() {
        boolean mobileFlag3 = true;

        System.out.println(" *****Add New Employee*****");
        System.out.print("Employee Number: ");
        emp_no = sc3.next();
        System.out.println("Designation (Trainee , Permanent , Executive): ");
        emp_desig = sc3.next();
        System.out.print("Full Name: ");
        emp_name = sc3.next();
        System.out.print("Permanent Address: ");
        emp_address = sc3.next();
        System.out.print("National Id No: ");
        emp_id = sc3.next();
        System.out.print("E-Mail: ");
        emp_email = sc3.next();

        //Avoiding Errors If User Gives Incompatible Data Type
        do {
            System.out.print("Mobile Number: ");
            try {
                emp_mobile = sc3.nextInt();
                mobileFlag3 = false;
            } catch (Exception e) {
                System.out.println("Please Enter a Correct Mobile No");
            }
        } while (mobileFlag3);

    }

    //Update Employee Details
    public void updateEmp() {
        Scanner sc4 = new Scanner(System.in);
        boolean mobileFlag4 = true;
        System.out.print("Employee No: ");
        emp_no = sc4.next();
        System.out.println("Designation (Trainee , Permanent , Executive): ");
        emp_desig = sc4.next();
        System.out.print("Full Name: ");
        emp_name = sc4.next();
        System.out.print("Permanent Address: ");
        emp_address = sc4.next();
        System.out.print("National Id No: ");
        emp_id = sc4.next();

        //Avoiding Errors If User Gives Incompatible Data Type
        do {
            System.out.print("Mobile Number: ");
            try {
                emp_mobile = sc4.nextInt();
                mobileFlag4 = false;
            } catch (Exception e) {
                System.out.println("Please Enter a Correct Mobile No");
            }
        } while (mobileFlag4);

        //Continue Initializing Programme
        System.out.print("E-Mail: ");
        emp_email = sc4.next();
        System.out.println("Successfully Updated Employee");
    }

}

