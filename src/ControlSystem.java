public class ControlSystem implements ControlSystemInterface {
    private static ControlSystem control_system_instance;
    private User current_user = null;

    private ControlSystem() {

    }

    public static ControlSystem get_control_system_instance() {
        if (control_system_instance == null) {
            control_system_instance = new ControlSystem();
        }
        return control_system_instance;
    }

    @Override
    public User get_current_user() {
        return this.current_user;
    }

    @Override
    public void set_current_user(User user) {
        current_user = user;
    }

    @Override
    public void logout(){
        this.set_current_user(null);
        Main.show_main_menu();
    }

}
