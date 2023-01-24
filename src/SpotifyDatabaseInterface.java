import java.util.HashMap;

public interface SpotifyDatabaseInterface {
    HashMap<String, User> get_users_database_table();

    HashMap<String, Song> get_songs_database_table();

    void save(User user);

    void save(Song song);

    User find_user_by_email(String email);

    String generate_primary_key(HashMap<String, ?> database_table);

}
