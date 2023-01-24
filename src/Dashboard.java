public class Dashboard implements DashboardInterface{

    @Override
    public void show_user_details(User user) {
        System.out.println("Name : " + user.get_name());
        System.out.println("Email : " + user.get_email());
        System.out.println("Account Type : " + user.get_user_type());
    }
}
