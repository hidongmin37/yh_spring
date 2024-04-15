package lang.object.tostring;

public class ToStringMain1 {
    public static void main(String[] args) {
        Object o = new Object();
        String string = o.toString();

        // toString() 반환값 출력
        System.out.println(string);
        System.out.println(o);
    }
}
