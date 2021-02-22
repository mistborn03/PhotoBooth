package Services;

import DataSource.PictureDS;
import DataSource.UserDS;
import Pictures.Pictures;
import User.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Services {

    UserDS userDS;
    PictureDS pictureDS;
    HashSet<String> star_users ;

    public Services(UserDS userDS,PictureDS pictureDS) {
        this.userDS = userDS;
        this.pictureDS = pictureDS;
        star_users =  new HashSet<>();
    }


    public void registerUser(String input_name,String user_name){

       if(userDS.getUserToNameMap().containsKey(input_name)) {
           System.out.println(input_name + " already exists");
           return;
       }


        User user = new User(input_name,user_name);
        userDS.getUserToNameMap().put(input_name,user);
        System.out.println(input_name + " with user name " + user_name + " is created");
    }

    public void post_picture(String input_name,String picture,String caption){

        if(!userDS.getUserToNameMap().containsKey(input_name)) {
            System.out.println("User Does not exist");
            return;
        }

        userDS.getUserToNameMap().get(input_name).getPictures_captions().put(picture,caption);
        Pictures pictures = new Pictures(picture,caption,0);
        pictureDS.getPictureToNameMap().put(picture,pictures);
        System.out.println(input_name + " posts " + picture +" , " + caption);
    }

    public void like_picture(String user_name, String picture){

        pictureDS.getPictureToNameMap().get(picture).setLikes(pictureDS.getPictureToNameMap().get(picture).getLikes()+1);
        System.out.println(user_name + " likes" + picture);
    }

    public void get_pictures(){

        List<Pictures> pictures = new ArrayList<>(pictureDS.getPictureToNameMap().values());
        pictures.sort(new PictureSort());

        for(int i=0;i<pictures.size();i++)
            System.out.println(pictures.get(i).getName());
    }

    public void follow(String user_follows,String user_followed){

        userDS.getUserToNameMap().get(user_followed).getUsers_follow_me().add(user_follows);
        System.out.println(user_follows +" follows " + user_followed);

        userDS.getUserToNameMap().get(user_follows).getUsers_i_follow().add(user_followed);

        add_star_user(user_followed);


    }

    public void get_likes(String picture_name){

        System.out.println(pictureDS.getPictureToNameMap().get(picture_name).getLikes());
    }

    public void get_followers(String user_name){

         HashSet<String > user_follow_me =   userDS.getUserToNameMap().get(user_name).getUsers_follow_me();

         System.out.println(user_follow_me);
    }

    public void add_star_user(String user_followed){



        if(userDS.getUserToNameMap().get(user_followed).getUsers_follow_me().size() >=2) {
            if(!star_users.contains(user_followed))
                star_users.add(user_followed);
        }
    }

    public void get_star_user(){

        System.out.println(star_users);
    }

}


class PictureSort implements Comparator<Pictures> {
    @Override
    public int compare(Pictures picture1 ,Pictures picture2){

        return picture2.getCreatedAt() > picture1.getCreatedAt() ? 1 : -1;
    }
}