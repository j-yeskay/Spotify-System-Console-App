import java.util.HashMap;

public class BankDatabase implements BankDatabaseInterface {
    private static BankDatabase bank_database_instance = null;
    private final HashMap<String, DebitCard> debit_cards = new HashMap<>();

    private BankDatabase() {

    }

    public static BankDatabase get_bank_database() {
        if (bank_database_instance == null) {
            bank_database_instance = new BankDatabase();
        }
        return bank_database_instance;
    }
    @Override
    public void save(DebitCard debit_card) {
        this.debit_cards.put(debit_card.get_card_number(), debit_card);
    }

    @Override
    public DebitCard find_debit_card_by_number(String card_number) {
        return debit_cards.get(card_number);
    }


}
