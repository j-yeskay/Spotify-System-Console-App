public interface ControlSystemInterface {
    User get_current_user();

    void set_current_user(User user);

    void logout();

    void go_to_dashboard();
}
