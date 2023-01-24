import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        DummyData dummy = new DummyData();
        dummy.generate_dummy_bank_accounts();
        dummy.generate_dummy_artist_accounts();
        dummy.generate_dummy_songs();

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
