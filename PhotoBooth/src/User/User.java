package User;

import java.util.HashMap;
import java.util.HashSet;

public class User {

    String input_name;

    String user_name;

    HashSet<String> users_follow_me;

    HashSet<String> users_i_follow;

    HashMap<String,String> pictures_captions;

    HashMap<String,Integer> pictures_likes;


    public User(String input_name, String user_name) {
        this.input_name = input_name;
        this.user_name = user_name;
        this.users_follow_me = new HashSet<>();
        this.users_i_follow = new HashSet<>();
        this.pictures_captions = new HashMap<>();
        this.pictures_likes = new HashMap<>();
    }


    public String getInput_name() {
        return input_name;
    }

    public void setInput_name(String input_name) {
        this.input_name = input_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public HashSet<String> getUsers_follow_me() {
        return users_follow_me;
    }

    public void setUsers_follow_me(HashSet<String> users_follow_me) {
        this.users_follow_me = users_follow_me;
    }

    public HashSet<String> getUsers_i_follow() {
        return users_i_follow;
    }

    public void setUsers_i_follow(HashSet<String> users_i_follow) {
        this.users_i_follow = users_i_follow;
    }

    public HashMap<String, String> getPictures_captions() {
        return pictures_captions;
    }

    public void setPictures_captions(HashMap<String, String> pictures_captions) {
        this.pictures_captions = pictures_captions;
    }

    public HashMap<String, Integer> getPictures_likes() {
        return pictures_likes;
    }

    public void setPictures_likes(HashMap<String, Integer> pictures_likes) {
        this.pictures_likes = pictures_likes;
    }
}
