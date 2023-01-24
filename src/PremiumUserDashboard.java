import java.util.Scanner;

public class PremiumUserDashboard extends Dashboard implements PremiumUserDashboardInterface{
    ControlSystemInterface control_system = ControlSystem.get_control_system_instance();

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
        System.out.println("3. Logout");
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
                control_system.logout();
                break;
            default:
                show_dashboard_menu();
        }
    }

    public void show_downloads(){
        System.out.println("downloads are here...");
        show_dashboard_menu();
    }

}
