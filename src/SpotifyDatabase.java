import java.util.HashMap;

public class SpotifyDatabase implements SpotifyDatabaseInterface {
    private static SpotifyDatabaseInterface database_instance;
    private HashMap<String, User> users = new HashMap<>();

    private SpotifyDatabase() {

    }

    public static SpotifyDatabaseInterface get_database_instance() {
        if (database_instance == null) {
            database_instance = new SpotifyDatabase();
        }
        return database_instance;
    }

    @Override
    public HashMap<String, User> get_users_database_table() {
        return users;
    }

    @Override
    public void save(User user) {
        users.put(user.get_email(), user);
    }

    @Override
    public User find_user_by_email(String email) {
        return users.get(email);
    }
}
