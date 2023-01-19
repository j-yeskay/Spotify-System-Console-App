import java.util.HashMap;
import java.util.Scanner;

public class UpgradeToPremium {

    ControlSystemInterface control_system = ControlSystem.get_control_system_instance();
    BankServerInterface bank_system = BankServer.get_bank_server_instance();

    Dashboard dashboard = Dashboard.get_dashboard_instance();

    double premium_cost = 100;

    Scanner sc = new Scanner(System.in);


    public void payment_option_menu() {
        System.out.println("Payment Options : ");
        System.out.println("1. Debit Card Payment");
        System.out.println("2. UPI Payment ");
        String input = sc.nextLine();
        if (input.equals("1")) {

            HashMap<String, String> debit_card_details = debit_card_details_form();
            String card_number = debit_card_details.get("card_number");
            String card_pin = debit_card_details.get("card_pin");

            if (bank_system.debit_card_payment(card_number, card_pin, premium_cost)) {
                User current_user = control_system.get_current_user();
                current_user.set_user_type(UserType.PREMIUM);
            } else {
                System.out.println("Transaction Failed!");
            }
            dashboard.show_dashboard();
        }
    }

    public HashMap<String, String> debit_card_details_form(){
        HashMap<String, String> debit_card_details = new HashMap<>();
        System.out.println("Enter Debit Card Number : ");
        String card_number = sc.nextLine();
        System.out.println("Enter Debit Card Pin : ");
        String card_pin = sc.nextLine();
        debit_card_details.put("card_number", card_number);
        debit_card_details.put("card_pin", card_pin);
        return debit_card_details;
    }

}
