public interface BankDatabaseInterface {
    void save(DebitCard debit_card);
    DebitCard find_debit_card_by_number(String card_number);
}
