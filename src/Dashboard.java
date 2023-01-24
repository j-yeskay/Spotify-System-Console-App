public class Dashboard implements DashboardInterface{

    @Override
    public void show_user_details(User user) {
        System.out.println("Name : " + user.get_name());
        System.out.println("Email : " + user.get_email());
        System.out.println("Account Type : " + user.get_user_type());
    }

    public void go_to_music_player(){
        MusicPlayerInterface music_player = MusicPlayer.get_musicplayer_instance();
        music_player.music_player_menu();
    }
}
