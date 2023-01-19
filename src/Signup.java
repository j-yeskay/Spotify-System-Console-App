import java.util.HashMap;
import java.util.Scanner;

public class Signup implements SignupInterface {

    @Override
    public void signup() {
        HashMap<String, String> signup_form_data = signup_form();
        send_user_object_to_database(signup_form_data);
        System.out.println("Account Created Successfully.");
        Main.show_main_menu();
    }

    @Override
    public HashMap<String, String> signup_form() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Email : ");
        String email = sc.nextLine();
        System.out.println("Enter Password : ");
        String password = sc.nextLine();
        HashMap<String, String> user_data = new HashMap<>();
        user_data.put("name", name);
        user_data.put("email", email);
        user_data.put("password", password);
        return user_data;
    }

    @Override
    public void send_user_object_to_database(HashMap<String, String> signup_form_data) {
        SpotifyDatabaseInterface db = SpotifyDatabase.get_database_instance();
        User user = new User(signup_form_data.get("name"), signup_form_data.get("email"), signup_form_data.get("password"));
        if (db.find_user_by_email(user.get_email()) == null) {
            db.save(user);
        } else {
            System.out.println("Account Already Exists!");
            Main.show_main_menu();
        }

    }
}
