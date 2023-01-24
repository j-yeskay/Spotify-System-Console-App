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

    @Override
    public void go_to_dashboard(){
        if(this.get_current_user().get_user_type() == UserType.BASIC){
            BasicUserDashboardInterface dashboard = BasicUserDashboard.get_dashboard_instance();
            dashboard.show_dashboard_menu();
        }
        if(this.get_current_user().get_user_type() == UserType.PREMIUM){
            PremiumUserDashboardInterface dashboard = PremiumUserDashboard.get_dashboard_instance();
            dashboard.show_dashboard_menu();
        }
        else{
            ArtistUserDashboardInterface dashboard = ArtistUserDashboard.get_dashboard_instance();
            dashboard.show_dashboard_menu();
        }
    }

}
