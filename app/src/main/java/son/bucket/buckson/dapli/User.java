package son.bucket.buckson.dapli;

public class User {
    private String profile_img_url;
    private String user_name;

    public User(){}
    public User(String _user_name, String _profile_img_path){
        this.user_name = _user_name;
        this.profile_img_url = _profile_img_path;
    }

    public String get_profile_img_path(){return profile_img_url;}
    public String get_user_name(){return user_name;}
}
