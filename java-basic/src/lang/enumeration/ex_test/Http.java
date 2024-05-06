package lang.enumeration.ex_test;

public enum Http {
    OK(200,"OK"),BAD_REQUEST(400,"Bad Request"),NOT_FOUND(404,"Not Found"),INTERNAL_SERVER_ERROR(500,"Internal Server Error");

    private int code;
    private String message;

    Http(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return code >= 200 && code < 300;
    }

    public static Http findByCode(int code) {
        Http[] values = values();
        for (Http value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;

    }
}
