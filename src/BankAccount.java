public class BankAccount implements BankAccountInterface{
    private String name;
    private String account_number;
    private double balance;

    BankAccount(String account_number, String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.account_number = account_number;
    }

    @Override
    public boolean debit(double amount) {
        if (amount < balance) {
            this.set_balance(balance - amount);
            return true;
        }
        return false;
    }

    @Override
    public void credit(double amount) {
        this.set_balance(balance + amount);
    }

    @Override
    public void set_balance(double amount) {
        this.balance = amount;
    }

    @Override
    public String get_account_holder_name() {
        return this.name;
    }

    @Override
    public String get_account_number() {
        return this.account_number;
    }

    @Override
    public double get_account_balance() {
        return this.balance;
    }


}
