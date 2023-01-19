public interface BankAccountInterface {
    public boolean debit(double amount);

    public void credit(double amount);

    public void set_balance(double amount);

    public String get_account_holder_name();

    public String get_account_number();


    public double get_account_balance();
}
