package main.lang.object.string;

public class TestString {
    public static void main(String[] args) {
        String url = "https://www.inflearn.com/";
        boolean b = url.startsWith("https://");
        System.out.println("b = " + b);


        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int sum = 0;
        for (String s : arr) {
            System.out.println(s + ": " + s.length());
            sum += s.length();
        }
        System.out.println("sum = " + sum);


        String str = "hello.txt";
        int i = str.indexOf(".txt");
        System.out.println("i = " + i);
        String substring = str.substring(0, 5);
        String substring2 = str.substring(5, 9);
        System.out.println("substring = " + substring);
        System.out.println("substring2 = " + substring2);


    }
}
