class Rates {

    //Calculate Fixed Deposit Rates
    public Double showIntrestRate(double p) {
        double r;
        if (60 <= p) {
            r = 0.13;
        } else if (12 <= p || p < 60) {
            r = 0.11;
        } else if (3 <= p || p < 12) {
            r = 0.075;
        } else if (1 <= p || p < 3) {
            r = 0;
        } else {
            r = 0;
        }
        return r;
    }

    //Calculate Total Amount in Fixed Deposit Account
    public Double calculateTotal(double amt, double pd) {
        double r, total;
        double amount = amt;
        if (60 <= pd) {
            r = 0.13;
        } else if (12 <= pd || pd < 60) {
            r = 0.11;
        } else if (3 <= pd || pd < 12) {
            r = 0.075;
        } else if (1 <= pd || pd < 3) {
            r = 0;
        } else {
            r = 0;
        }
        total = ((amount * r) * (pd / 12)) + amount;
        return total;
    }

    //Calculate Salary For Employees
    public double sal(String desig) {
        double s = 0;
        if (desig.equals("Trainee")) {
            s = 25000.00;
        } else if (desig.equals("Permanent")) {
            s = 35000.00;
        } else if (desig.equals("Executive")) {
            s = 75000.00;
        }
        return s;
    }

}