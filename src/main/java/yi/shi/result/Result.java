package yi.shi.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    T data;
    String message;
    int code;

    public static <T> Result<T> success(T data) {
        return new Result<>(data, "success", ResultCode.SUCCESS);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(null, message, ResultCode.FAIL);
    }
}
