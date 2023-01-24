public class Song {
    private String title;
    private User artist;
    private String id;

    Song(String title, User artist){
        this.title = title;
        this.artist = artist;
    }

    public void play(){
        System.out.println("Playing...");
    }

    public void stop(){
        System.out.println("Stopped...");
    }



    public String get_title(){
        return this.title;
    }

    public User get_artist(){
        return this.artist;
    }

    public void set_id(String id){
        this.id = id;
    }

    public String get_id(){
        return this.id;
    }

}
