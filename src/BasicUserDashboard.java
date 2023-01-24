import java.util.Scanner;

public class BasicUserDashboard extends Dashboard implements BasicUserDashboardInterface{

    ControlSystemInterface control_system = ControlSystem.get_control_system_instance();



    private static BasicUserDashboard dashboard_instance = null;

    private BasicUserDashboard() {

    }

    public static BasicUserDashboard get_dashboard_instance() {
        if (dashboard_instance == null) {
            dashboard_instance = new BasicUserDashboard();
        }
        return dashboard_instance;
    }


    public void show_dashboard_menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View Details");
        System.out.println("2. Go Premium");
        System.out.println("3. Logout");
        String input = sc.nextLine();
        switch(input){
            case "1":
                super.show_user_details(control_system.get_current_user());
                show_dashboard_menu();
                break;
            case "2":
                go_premium();
                break;
            case "3":
                control_system.logout();
                break;
            default:
                show_dashboard_menu();
        }
    }

    public void go_premium() {
        UpgradeToPremium upgrade_to_premium_page = new UpgradeToPremium();
            upgrade_to_premium_page.payment_option_menu();
        }
    }

