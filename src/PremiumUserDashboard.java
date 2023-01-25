import java.util.Scanner;
import java.util.HashMap;

public class PremiumUserDashboard extends Dashboard implements PremiumUserDashboardInterface{
    ControlSystemInterface control_system = ControlSystem.get_control_system_instance();
    MusicPlayerInterface music_player = MusicPlayer.get_musicplayer_instance();

    private static PremiumUserDashboard dashboard_instance = null;

    protected PremiumUserDashboard() {

    }

    public static PremiumUserDashboard get_dashboard_instance() {
        if (dashboard_instance == null) {
            dashboard_instance = new PremiumUserDashboard();
        }
        return dashboard_instance;
    }


    public void show_dashboard_menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View Details");
        System.out.println("2. Show Downloads");
        System.out.println("3. Go To Music Player");
        System.out.println("4. Logout");
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
                go_to_music_player();
                break;
            case "4":
                control_system.logout();
                break;
            default:
                show_dashboard_menu();
        }
    }

    public void show_downloads(){
        User current_user = control_system.get_current_user();
        HashMap<String, Song> songs = current_user.get_downloaded_songs();

            music_player.show_songs(songs);

        show_dashboard_menu();
    }

}
