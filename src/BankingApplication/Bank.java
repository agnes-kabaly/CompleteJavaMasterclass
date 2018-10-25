package BankingApplication;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public boolean addNewBranch(String branchName) {

        return false;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount) {

        return false;
    }

    public boolean addCustomerTransaction(String branchNAme, String customerName, double amount) {

        return false;
    }

    public boolean customerList(String branchName, boolean showTransaction) {

        return false;
    }

    private Branch findBranch(String branchName) {

        return null;
    }

}
