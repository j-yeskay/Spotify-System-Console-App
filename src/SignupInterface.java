import java.util.HashMap;

public interface SignupInterface {
    HashMap<String, String> signup_form();

    void send_user_object_to_database(HashMap<String, String> signup_form_data);

    void signup();
}
