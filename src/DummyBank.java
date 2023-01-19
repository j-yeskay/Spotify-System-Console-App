public class DummyBank {
    BankDatabaseInterface bank_database = BankDatabase.get_bank_database();

    public void generate_dummy_bank_accounts(){
        BankAccountInterface bank_account1 = new BankAccount("12345", "sathish", 2000);
        BankAccountInterface bank_account2 = new BankAccount("67890", "kumar", 50);
        DebitCard debit_card_1 = new DebitCard("Sathish", "1111", "1234", bank_account1);
        DebitCard debit_card_2 = new DebitCard("Kumar", "2222", "0000", bank_account2);
        bank_database.save(debit_card_1);
        bank_database.save(debit_card_2);
    }
}
