import java.util.HashMap;

public interface SpotifyDatabaseInterface {
    HashMap<String, User> get_users_database_table();

    void save(User user);

    User find_user_by_email(String email);
}
