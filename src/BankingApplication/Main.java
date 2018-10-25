package BankingApplication;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("National Australia Bank");

        bank.addNewBranch("Adelaide");

        bank.addNewCustomer("Adelaide", "Tim", 50.05);
        bank.addNewCustomer("Adelaide", "John", 175.34);
        bank.addNewCustomer("Adelaide", "Mike", 220.12);

        bank.addNewBranch("Sydney");

        bank.addNewCustomer("Sydney", "Bob", 150.54);
        bank.addNewCustomer("Sydney", "Joe", 100.00);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "John", 1.65);

        bank.customerList("Adelaide", false);
        bank.customerList("Adelaide", true);

        bank.customerList("Sydney", true);

        bank.addNewBranch("Melbourne");

        if (!bank.addNewCustomer("Melbourne", "Brian", 345.45)) {
            System.out.println("Error Melbourne branch does not exist");
        }

        bank.customerList("Melbourne", true);

        if (!bank.addNewBranch("Adelaide")) {
            System.out.println("Adelaide branch already exist!");
        }

        if (!bank.addCustomerTransaction("Adelaide", "Tom", 53.34)) {
            System.out.println("Customer dose not exist at branch!");
        }

        if (!bank.addNewCustomer("Adelaide", "Tim", 12.21)) {
            System.out.println("Customer already exist!");
        }

    }

}
