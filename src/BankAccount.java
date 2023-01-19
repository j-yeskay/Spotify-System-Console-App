public class BankAccount {
    private String name;
    private String account_number;
    private double balance;

    BankAccount(String account_number, String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.account_number = account_number;
    }

    public boolean debit(double amount) {
        if (amount < balance) {
            this.set_balance(balance - amount);
            return true;
        } else {
            return false;
        }
    }

    public void credit(double amount) {
        this.set_balance(balance + amount);
    }

    public void set_balance(double amount) {
        this.balance = amount;
    }

    public String get_account_holder_name() {
        return this.name;
    }

    public String get_account_number() {
        return this.account_number;
    }


    public double get_account_balance() {
        return this.balance;
    }


}
