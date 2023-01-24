import java.util.Scanner;

public class ArtistUserDashboard extends PremiumUserDashboard implements ArtistUserDashboardInterface{
    ControlSystemInterface control_system = ControlSystem.get_control_system_instance();

    private static ArtistUserDashboard dashboard_instance = null;

    private ArtistUserDashboard() {

    }

    public static ArtistUserDashboard get_dashboard_instance() {
        if (dashboard_instance == null) {
            dashboard_instance = new ArtistUserDashboard();
        }
        return dashboard_instance;
    }


    public void show_dashboard_menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View Details");
        System.out.println("2. Show Downloads");
        System.out.println("3. Publish Song");
        System.out.println("4. Show Publications");
        System.out.println("5. Logout");
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
                control_system.logout();
                break;
            default:
                show_dashboard_menu();
        }
    }


    public void publish_song(){
        System.out.println("song published");
        show_dashboard_menu();
    }

    public void view_my_publications(){
        System.out.println("my publications");
        show_dashboard_menu();
    }
}
