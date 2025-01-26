package main.lang.object.equals;

public class EqualsMainV1 {

    public static void main(String[] args) {
        UserV1 user1 = new UserV1("id-100");
        UserV1 user2 = new UserV1("id-100");
        UserV1 user3 = user1;

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);
        
        System.out.println("user1 == user2  =>" + (user1 == user2));
        System.out.println("equals => " + (user1.equals(user2)));

    }
}
