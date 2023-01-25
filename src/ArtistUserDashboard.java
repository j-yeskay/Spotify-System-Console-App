import java.util.Scanner;

public class ArtistUserDashboard extends PremiumUserDashboard implements ArtistUserDashboardInterface{
    ControlSystemInterface control_system = ControlSystem.get_control_system_instance();
    SpotifyDatabaseInterface spotify_database = SpotifyDatabase.get_database_instance();
    MusicPlayerInterface music_player = MusicPlayer.get_musicplayer_instance();

    private static ArtistUserDashboard dashboard_instance = null;

    private ArtistUserDashboard() {

    }

    public static ArtistUserDashboard get_dashboard_instance() {
        if (dashboard_instance == null) {
            dashboard_instance = new ArtistUserDashboard();
        }
        return dashboard_instance;
    }

    @Override
    public void show_dashboard_menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View Details");
        System.out.println("2. Show Downloads");
        System.out.println("3. Publish Song");
        System.out.println("4. Show Publications");
        System.out.println("5. Go To Music Player");
        System.out.println("6. Logout");
        String input = sc.nextLine();
        switch(input){
            case "1":
                show_user_details(control_system.get_current_user());
                show_dashboard_menu();
                break;
            case "2":
                show_downloads();
                break;
            case "3":
                publish_song();
                break;
            case "4":
                view_my_publications();
                break;
            case "5":
                go_to_music_player();
                break;
            case "6":
                control_system.logout();
                break;
            default:
                show_dashboard_menu();
        }
    }

    @Override
    public void publish_song(){
        User current_user = control_system.get_current_user();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Song Title : ");
        String title = sc.nextLine();
        Song song = new Song(title, current_user);
        spotify_database.save(song);
        current_user.add_to_published_songs(song);
        System.out.println("Song Published!");
        show_dashboard_menu();
    }

    @Override
    public void view_my_publications(){
        music_player.show_songs(control_system.get_current_user().get_published_songs());
        show_dashboard_menu();
    }
}
