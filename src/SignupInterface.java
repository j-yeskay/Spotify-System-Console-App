import java.util.HashMap;

public interface SignupInterface {
    HashMap<String, String> signup_form();

    void store_user_object_in_database(HashMap<String, String> signup_form_data);

    void signup();
}
