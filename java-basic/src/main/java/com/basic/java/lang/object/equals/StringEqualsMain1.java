package main.lang.object.equals;

public class StringEqualsMain1 {
    public static void main(String[] args) {

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("str1 == str2 " + (str1==str2));
        System.out.println("equals 비교 " + (str1.equals(str2)));

        String str3 = "Asdfasdf";
        str2 = "ewe";
        str3 = "asdee";
        System.out.println(str3);
    }
}
