import java.util.HashMap;
import java.util.Scanner;

public class Login implements LoginInterface {

    SpotifyDatabaseInterface db = SpotifyDatabase.get_database_instance();
    Dashboard dashboard = Dashboard.get_dashboard_instance();

    @Override
    public void login() {
        HashMap<String, String> login_form_data = login_form();
        User user = db.find_user_by_email(login_form_data.get("email"));
        if (user == null) {
            System.out.println("Account Does not Exists!");
            Main.show_main_menu();
        } else {
            if (!user.get_password().equals(login_form_data.get("password"))) {
                System.out.println("Wrong Password");
                Main.show_main_menu();
            } else {
                ControlSystemInterface control_system = ControlSystem.get_control_system_instance();
                control_system.set_current_user(user);
                System.out.println("Logged in Successfully!");
                dashboard.show_dashboard();
            }
        }
    }

    @Override
    public HashMap<String, String> login_form() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Email : ");
        String email = sc.nextLine();
        System.out.println("Enter Password : ");
        String password = sc.nextLine();
        HashMap<String, String> login_form_user_data = new HashMap<>();
        login_form_user_data.put("email", email);
        login_form_user_data.put("password", password);
        return login_form_user_data;
    }

}
