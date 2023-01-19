public class DebitCard {
    private String card_owner_name;
    private String card_number;
    private String card_pin;
    private BankAccountInterface bank_account;
    DebitCard(String card_owner_name, String card_number, String card_pin, BankAccount account) {
        this.card_owner_name = card_owner_name;
        this.card_number = card_number;
        this.card_pin = card_pin;
        this.bank_account = account;
    }

    public String get_card_number() {
        return this.card_number;
    }

    public String get_card_pin() {
        return this.card_pin;
    }

    public BankAccountInterface get_bank_account() {
        return this.bank_account;
    }
}
