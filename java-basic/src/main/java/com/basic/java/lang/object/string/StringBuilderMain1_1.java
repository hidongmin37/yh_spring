package main.lang.object.string;

public class StringBuilderMain1_1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        sb.append("E");
        System.out.println("sb = " + sb);

        sb.insert(4, "java");
        System.out.println("after insert sb = " + sb);
    }
}
