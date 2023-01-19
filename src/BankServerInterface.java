public interface BankServerInterface {
    boolean debit_card_payment(String number, String pin_number, double amount);
}
