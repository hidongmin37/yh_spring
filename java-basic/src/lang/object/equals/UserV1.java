package lang.object.equals;

import java.util.Objects;

public class UserV1 {
    private String id;

    public UserV1(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserV1 userV1 = (UserV1) o;
        return Objects.equals(id, userV1.id); // 문자끼리의 비교는 equals로 비교
    }
 
}
