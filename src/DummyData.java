public class DummyData {
    BankDatabaseInterface bank_database = BankDatabase.get_bank_database();
    SpotifyDatabaseInterface spotify_database = SpotifyDatabase.get_database_instance();

    public void generate_dummy_bank_accounts(){
        BankAccountInterface bank_account1 = new BankAccount("12345", "sathish", 2000);
        BankAccountInterface bank_account2 = new BankAccount("67890", "kumar", 50);
        DebitCard debit_card_1 = new DebitCard("Sathish", "1111", "1234", bank_account1);
        DebitCard debit_card_2 = new DebitCard("Kumar", "2222", "0000", bank_account2);
        bank_database.save(debit_card_1);
        bank_database.save(debit_card_2);
    }

    public void generate_dummy_artist_accounts(){
        User user_1 = new User("Justin", "justin@justin.com", "password");
        User user_2 = new User("Rahman", "rahman@rahman.com", "password");

        user_1.set_user_type(UserType.ARTIST);
        user_2.set_user_type(UserType.ARTIST);
        spotify_database.save(user_1);
        spotify_database.save(user_2);
    }

    public void generate_dummy_songs(){
        User artist_1 = spotify_database.find_user_by_email("justin@justin.com");
        User artist_2 = spotify_database.find_user_by_email("rahman@rahman.com");

        spotify_database.save(new Song("Closer", artist_2));
        spotify_database.save(new Song("faded", artist_1));
        spotify_database.save(new Song("despacito", artist_2));
        spotify_database.save(new Song("gangnam style", artist_1));
        spotify_database.save(new Song("believer", artist_1));
    }
}
