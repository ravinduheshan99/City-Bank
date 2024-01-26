import java.util.Scanner;

class Customer extends Rates {
    private String acc_no;
    private String name;
    private String id;
    private int mobile;
    private String address;
    private String email;
    private String acc_type;
    private long balance;
    private String description;
    private String branch;
    private double period;
    private int issued;
    private int returned;
    Scanner sc = new Scanner(System.in);

    public String getAcc_no() {
        return acc_no;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public long getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public String getBranch() {
        return branch;
    }

    public double getPeriod() {
        return period;
    }


    //Method To Open New Account
    public void openAccount() {
        boolean mobileFlag = true;

        //Initializing Customer Details
        System.out.println(" *****Create New Account*****");
        System.out.print("Account No: ");
        acc_no = sc.nextLine();
        System.out.print("Account type (Savings , Current , Fixed): ");
        acc_type = sc.nextLine();
        System.out.print("Branch: ");
        branch = sc.nextLine();
        System.out.print("Full Name: ");
        name = sc.nextLine();
        System.out.print("Permanent Address: ");
        address = sc.nextLine();
        System.out.print("National Id No: ");
        id = sc.nextLine();
        System.out.print("E-Mail: ");
        email = sc.nextLine();
        System.out.println("Description: ");
        description = sc.nextLine();

        //Avoiding Errors If User Gives Incompatible Data Type
        do {
            //Scanner sc = new Scanner(System.in);
            System.out.print("Mobile Number: ");
            try {
                mobile = sc.nextInt();
                mobileFlag = false;
            } catch (Exception e) {
                System.out.println("Please Enter a Correct Mobile No");
            }
        } while (mobileFlag);

        //Categorized Accounts According To The Account Types
        if (acc_type.equals("Savings")) {
            System.out.println(" *****Minimum Initial Deposit Amount is 1000*****\n ");
        } else if (acc_type.equals("Current")) {
            System.out.println("Choose type of the current account");
            System.out.println(" 1.Corporate customer Account \n 2.Business Customer Account \n 3.Personal Customer Account");
            System.out.println("Enter Choice");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Minimum deposit value is 250 000");
                    break;
                case 2:
                    System.out.println("Minimum deposit value is 15 000");
                    break;
                case 3:
                    System.out.println("Minimum deposit value is 8 000");
                    break;
            }
        }
        System.out.print("Initial Deposit: ");
        balance = sc.nextLong();
        System.out.print("Period(In Months): ");
        period = sc.nextInt();

        if (acc_type.equals("Fixed")) {
            System.out.println("Your Interest Rate is: " + showIntrestRate(period));
            System.out.println("Total Amount At The End Of The Period: " + calculateTotal(balance, period));
        } else if (acc_type.equals("Current")) {
            description = sc.nextLine();
            System.out.println("Number of Check Books Issue:");
            issued = sc.nextInt();
            System.out.println("Number of Check Books Returned:");
            returned = sc.nextInt();
        }
    }

    //update customer details
    public void Update() {
        boolean mobileFlag2 = true;
        //Initialize New Details
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Account No: ");
        acc_no = sc2.nextLine();
        System.out.print("Account type (Savings , Current , Fixed): ");
        acc_type = sc2.nextLine();
        System.out.print("Branch: ");
        branch = sc2.nextLine();
        System.out.print("Full Name: ");
        name = sc2.nextLine();
        System.out.print("Permanent Address: ");
        address = sc2.nextLine();
        System.out.print("National Id No: ");
        id = sc2.nextLine();
        System.out.print("E-Mail: ");
        email = sc2.nextLine();
        System.out.println("Description: ");
        description = sc2.nextLine();

        //Avoiding Errors If User Gives Incompatible Data Type
        do {
            System.out.print("Mobile Number: ");
            try {
                mobile = sc2.nextInt();
                mobileFlag2 = false;
            } catch (Exception e) {
                System.out.println("Please Enter a Correct Mobile No");
            }
        } while (mobileFlag2);

        if (acc_type.equals("Savings")) {
            System.out.println("Customer is Switching to a Savings Account");
            System.out.println(" *****Minimum Initial Deposit Amount is 1000*****\n ");
        } else if (acc_type.equals("Current")) {
            System.out.println("Customer is Switching to a Current Account");
            System.out.println("Choose type of the current account");
            System.out.println(" 1.Corporate customer Account \n 2.Business Customer Account \n 3.Personal Customer Account");
            System.out.println("Enter Choice");
            int num = sc2.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Minimum deposit value is 250 000");
                    break;
                case 2:
                    System.out.println("Minimum deposit value is 15 000");
                    break;
                case 3:
                    System.out.println("Minimum deposit value is 8 000");
                    break;
            }
        }
        System.out.print("Initial Deposit: ");
        balance = sc2.nextLong();
        System.out.print("Period(In Months): ");
        period = sc2.nextInt();

        if (acc_type.equals("Fixed")) {
            System.out.println("Customer is Switching to a Fixed Deposit");
            System.out.println("Your Interest Rate is: " + showIntrestRate(period));
            System.out.println("Total Amount At The End Of The Period: " + calculateTotal(balance, period));
        } else if (acc_type.equals("Current")) {
            description = sc2.nextLine();
            System.out.println("Number of Check Books Issue:");
            issued = sc2.nextInt();
            System.out.println("Number of Check Books Returned:");
            returned = sc2.nextInt();
        }

        System.out.println("Successfully Updated Customer");
    }

    //Issue And Return Chequebooks
    public void chequeBook(int input) {
        int num_of_books;
        if (input == 1) {
            System.out.println("Enter the number of books to returned: ");
            num_of_books = sc.nextInt();
            this.returned += num_of_books;
            System.out.println("Successfully Returned\n");
        } else {

            if (this.issued == 0 || this.returned == this.issued) {
                System.out.println("Enter the number of cheque books needed");
                num_of_books = sc.nextInt();
                if (num_of_books < 6) {
                    System.out.println("Allowed to issue");
                    this.issued += num_of_books;
                    System.out.println("Successfully Issued");
                } else {
                    System.out.println("Maximum number of books allowed is 5");
                }
            } else {
                System.out.println("Please return the previous cheque books which were issued");
            }
        }
    }
}


