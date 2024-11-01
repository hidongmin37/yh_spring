package main.lang.object.string;

public class CharArrayMain {

    public static void main(String[] args) {
        String abc = "asdf";
        String ehd = abc.concat("edd");
        System.out.println("abc = " + abc);
        System.out.println("ehd = " + ehd);

        String str2 = "start hello java, hello spring, hello jpa";

        String key = "hello";

        int count = 0;
        int index = str2.indexOf(key);
        System.out.println("index = " + index);
        while (index >= 0) {
            index = str2.indexOf(key, index + 1);
            System.out.println("index = " + index);
            count++;
        }
        System.out.println("count = " + count);


        String str = "hello java";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(sb);

    }
}
