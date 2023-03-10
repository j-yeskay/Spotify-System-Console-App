import java.util.HashMap;

public class User {

    private String name;
    private String email;
    private UserType user_type;
    private String password;
    private HashMap<String, Song> downloaded_songs = new HashMap<>();
    private HashMap<String, Song> published_songs = new HashMap<>();

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.user_type = UserType.BASIC;
    }

    public String get_name() {
        return this.name;
    }

    public String get_email() {
        return this.email;
    }

    public UserType get_user_type() {
        return this.user_type;
    }

    public void set_user_type(UserType type) {
        this.user_type = type;
    }

    public String get_password() {
        return this.password;
    }

    public void add_to_downloaded_songs(Song song){
        this.downloaded_songs.put(song.get_id(), song);
    }

    public HashMap<String, Song> get_downloaded_songs(){
        return this.downloaded_songs;
    }

    public void add_to_published_songs(Song song){
        this.published_songs.put(song.get_id(), song);
    }

    public HashMap<String, Song> get_published_songs(){
        return this.published_songs;
    }

}
