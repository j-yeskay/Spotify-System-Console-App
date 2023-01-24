import java.util.HashMap;

public class SpotifyDatabase implements SpotifyDatabaseInterface {
    private static SpotifyDatabaseInterface database_instance;
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, Song> songs = new HashMap<>();

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
    public HashMap<String, Song> get_songs_database_table() {
        return songs;
    }

    @Override
    public void save(User user) {
        users.put(user.get_email(), user);
    }

    @Override
    public void save(Song song){
        String primary_key = generate_primary_key(get_songs_database_table());
        song.set_id(primary_key);
        songs.put(song.get_id(), song);
    }

    @Override
    public String generate_primary_key(HashMap<String, ?> database_table){
        int length = database_table.size();
        String primary_key = Integer.toString(length + 1);
        return primary_key;
    }

    @Override
    public User find_user_by_email(String email) {
        return users.get(email);
    }
}
