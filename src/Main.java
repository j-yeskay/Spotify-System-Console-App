import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        DummyBank dummyBank = new DummyBank();
        dummyBank.generate_dummy_bank_accounts();
        SpotifyDatabaseInterface database = SpotifyDatabase.get_database_instance();
        User user = new User("sathish", "sathish", "sathish");
        user.set_user_type(UserType.ARTIST);
        database.save(user);
        show_main_menu();
    }

    public static void show_main_menu() {
        System.out.println("Welcome to Spotify");
        System.out.println("1. Signup");
        System.out.println("2. Login");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input) {
            case "1":
                SignupInterface signup_page = new Signup();
                signup_page.signup();
                break;
            case "2":
                LoginInterface login_page = new Login();
                login_page.login();
                break;
            default:
                System.exit(0);
        }
    }

}
