package yi.shi.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
 *     "data": {},
 *     "message": "success",
 *     "code": 1
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {
    T data;
    String message;
    int code;

    public static <T> ResponseWrapper<T> success(T data) {
        return new ResponseWrapper<>(data, "success", ResponseCode.SUCCESS);
    }

    public static <T> ResponseWrapper<T> fail(String message) {
        return new ResponseWrapper<>(null, message, ResponseCode.FAIL);
    }
}
