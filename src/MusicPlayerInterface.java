import java.util.HashMap;

public interface MusicPlayerInterface {
    void play(Song song);
    void stop();
    void download();
    void set_currently_playing(Song song);
    Song get_currently_playing();
    void music_player_menu();
    void show_songs(HashMap<String, Song> songs);
}
