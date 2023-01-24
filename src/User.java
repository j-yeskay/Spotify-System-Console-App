import java.util.HashMap;

public class User {

    private String name;
    private String email;
    private UserType user_type;
    private String password;

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.user_type = UserType.BASIC;
    }

    public String get_name() {
        return this.name;
    }

    public String get_email() {
        return this.email;
    }

    public UserType get_user_type() {
        return this.user_type;
    }

    public void set_user_type(UserType type) {
        this.user_type = type;
    }

    public String get_password() {
        return this.password;
    }

    public HashMap<String, String> get_user_details() {
        HashMap<String, String> user_details = new HashMap<>();
        user_details.put("name", this.name);
        user_details.put("email", this.email);
        user_details.put("Account Type : ", this.user_type.toString());
        return user_details;
    }

}
