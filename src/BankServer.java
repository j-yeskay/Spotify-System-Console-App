public class BankServer implements BankServerInterface {
    private static BankServer bank_server_instance = null;
    BankDatabaseInterface bank_database = BankDatabase.get_bank_database();

    private BankServer() {

    }

    public static BankServer get_bank_server_instance() {
        if (bank_server_instance == null) {
            bank_server_instance = new BankServer();
        }
        return bank_server_instance;
    }

    @Override
    public boolean debit_card_payment(String card_number, String pin_number, double amount) {
        DebitCard debit_card = bank_database.find_debit_card_by_number(card_number);
        if (debit_card == null) {
            System.out.println("Invalid Card Number!");
            return false;
        } else if (!debit_card.get_card_pin().equals(pin_number)) {
            System.out.println("Wrong Pin Number!");
            return false;
        } else {
            BankAccountInterface bank_account = debit_card.get_bank_account();
            if (bank_account.get_account_balance() > amount) {
                bank_account.debit(amount);
                System.out.println("Transaction Successful!");
                return true;
            }
            System.out.println("Insufficient Balance");
            return false;
        }
    }

}
