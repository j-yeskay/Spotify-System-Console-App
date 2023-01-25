import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


public class MusicPlayer implements MusicPlayerInterface{

    private static MusicPlayer musicplayer_instance = null;

    private MusicPlayer() {

    }

    public static MusicPlayer get_musicplayer_instance() {
        if (musicplayer_instance == null) {
            musicplayer_instance = new MusicPlayer();
        }
        return musicplayer_instance;
    }

    private Song currently_playing;

    ControlSystem control_system = ControlSystem.get_control_system_instance();
    SpotifyDatabaseInterface spotify_database = SpotifyDatabase.get_database_instance();

    @Override
    public void play(Song song){
        this.set_currently_playing(song);
    }

    @Override
    public void stop(){
        if(currently_playing != null){
            System.out.println("Stopped...");
            this.set_currently_playing(null);
        }
    }

    @Override
    public void download(){
        User user = control_system.get_current_user();
        if(user.get_user_type() == UserType.BASIC){
            System.out.println("Upgrade to Premium to Download");
        }
        else if(user.get_downloaded_songs().get(currently_playing.get_id()) != null){
            System.out.println("Song Already in Downloads");
        }
        else{
            user.add_to_downloaded_songs(currently_playing);
            System.out.println("Song Downloaded");
            this.set_currently_playing(null);
        }
    }

    @Override
    public void show_songs(HashMap<String, Song> songs){
        if(songs.size() == 0){
            System.out.println("No Songs Available...");
        }
        else {
            for (Entry<String, Song> entry : songs.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue().get_title() + " by " + entry.getValue().get_artist().get_name());
            }
        }
    }

    @Override
    public void set_currently_playing(Song song){
        this.currently_playing = song;
    }

    @Override
    public Song get_currently_playing(){
        return this.currently_playing;
    }

    @Override
    public void music_player_menu(){
        System.out.println("Enter Song ID to Play..");
        Scanner sc = new Scanner(System.in);

        HashMap<String, Song> songs = spotify_database.get_songs_database_table();
        show_songs(songs);


        if(currently_playing != null){
            System.out.println("Currently Playing " + this.get_currently_playing().get_title() + " by " + get_currently_playing().get_artist().get_name());
            System.out.println("ENTER S TO STOP");
            System.out.println("ENTER D TO DOWNLOAD " + this.get_currently_playing().get_title() + " by " + get_currently_playing().get_artist().get_name());
        }
        System.out.println("ENTER Q TO QUIT");

        String input = sc.nextLine();

        if (input.equals("Q") || (input.equals("q"))){
            System.out.println("quit..");
            this.set_currently_playing(null);
            control_system.go_to_dashboard();
        }
        else if(input.equals("S") || input.equals("s")){
            this.stop();
            music_player_menu();
        }
        else if(input.equals("D") || input.equals("d")){
            this.download();
            music_player_menu();
        }
        else if(songs.get(input) == null){
            System.out.println("Song ID not Found..");
            this.set_currently_playing(null);
            music_player_menu();
        }
        else{
            this.play(songs.get(input));
            music_player_menu();
        }
    }

}
