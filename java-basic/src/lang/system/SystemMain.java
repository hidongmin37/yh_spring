package lang.system;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SystemMain {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano);

        //환경 변수를 읽는다.
        Map<String, String> getenv = System.getenv();
        System.out.println("getenv = " + getenv);


        //시스템 속성을 읽는다.
        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);

        String property = System.getProperty("java.version");
        System.out.println("property = " + property);


        // 배열을 고속으로 복사
        char[] originalArray = {'h','e','l','l','o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
        System.out.println("copiedArray = " + Arrays.toString(copiedArray));


        System.exit(0);
    }

}
