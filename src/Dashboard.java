import java.util.Scanner;

public class Dashboard {
    private static Dashboard dashboard_instance = null;
    ControlSystemInterface control_system = ControlSystem.get_control_system_instance();

    private Dashboard() {

    }

    public static Dashboard get_dashboard_instance() {
        if (dashboard_instance == null) {
            dashboard_instance = new Dashboard();
        }
        return dashboard_instance;
    }

    public void show_dashboard() {
        ControlSystemInterface control_system = ControlSystem.get_control_system_instance();
        if (control_system.get_current_user() != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dashboard");
            System.out.println("1. View User Details");
            System.out.println("2. Go Premium");
            System.out.println("3. Logout");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    User current_user = control_system.get_current_user();
                    show_user_details(current_user);
                    break;

                case "2":
                    go_premium();
                    break;

                case "3":
                    control_system.logout();
                    break;

                default:
                    System.exit(0);
            }

        } else {
            System.out.println("Unauthorized");
        }
    }

    public void show_user_details(User user) {
        System.out.println("Name : " + user.get_name());
        System.out.println("Email : " + user.get_email());
        System.out.println("Account Type : " + user.get_user_type());
        show_dashboard();

    }

    public void go_premium() {
        if (control_system.get_current_user().get_user_type() == UserType.PREMIUM) {
            System.out.println("Already Premium Account!");
            show_dashboard();
        } else {
            UpgradeToPremium upgrade_to_premium_page = new UpgradeToPremium();
            upgrade_to_premium_page.payment_option_menu();
        }
    }
}
