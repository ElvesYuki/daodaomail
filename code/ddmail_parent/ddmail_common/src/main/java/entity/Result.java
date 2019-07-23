package entity;

import java.io.Serializable;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 19:53 2019/7/21
 * @Modified By:
 */
public class Result implements Serializable {

    private Boolean success;
    private String message;

    public Result() {
    }

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
