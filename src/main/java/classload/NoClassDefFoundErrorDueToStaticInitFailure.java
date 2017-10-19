package classload;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samo on 2017/10/19.
 *
 * @author samo
 * @date 2017/10/19
 */
public class NoClassDefFoundErrorDueToStaticInitFailure {
    public static void main(String args[]){

        List<User> users = new ArrayList<User>(2);

        for(int i=0; i<2; i++){
            try{
                users.add(new User(String.valueOf(i))); //will throw NoClassDefFoundError
            }catch(Throwable t){
                t.printStackTrace();
            }
        }
    }
}


class User{
    private static String USER_ID = getUserId();

    public User(String id){
        this.USER_ID = id;
    }
    private static String getUserId() {
        throw new RuntimeException("UserId Not found");
    }
}
