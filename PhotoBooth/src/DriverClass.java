import DataSource.PictureDS;
import DataSource.UserDS;
import Services.Services;
import java.util.Scanner;

public class DriverClass {

    public static void main(String args[]){


        UserDS userDS = new UserDS();
        PictureDS pictureDS = new PictureDS();

        Services services = new Services(userDS,pictureDS);

        Scanner sc = new Scanner(System.in);

        String inp = sc.nextLine();

        while(!inp.equalsIgnoreCase("quit")){
            String [] input = inp.split(",");
            switch(input[0]) {

                case "RegisterUser" : services.registerUser(input[1],input[2]);
                                        break;

                case "Post" : services.post_picture(input[1],input[2],input[3]);
                                break;

                case "Like" : services.like_picture(input[1],input[2]);
                                break;

                case "showPictures" : services.get_pictures();
                                        break;

                case "Follow" :     services.follow(input[1],input[2]);
                                    break;

                case "getLikes" :       services.get_likes(input[1]);
                                        break;

                case "getFollowers" :  services.get_followers(input[1]);
                                            break;

                case "getStarUsers"  :  services.get_star_user();
                                        break;


                default : System.out.println("Invalid input");
                            break;
            }


            inp = sc.nextLine();

        }




    }

}


//RegisterUser,User1,UserName1
//Post,User1,Picture1,caption1
//Post,User1,Picture2,caption2
//RegisterUser,User2,UserName2
//Like,User2,Picture1
//Follow,User2,User1
//RegisterUser,User3,UserName3
//Post,User3,Picture3,caption3
//RegisterUser,User4,UserName4
//RegisterUser,User5,UserName5
//Follow,User4,User1
//Follow,User5,User1
//showPictures
//getLikes,Picture1
//getFollowers,User1


//getFollowers,User2