package org.example.buysourcecode.exception;

import lombok.Getter;
import lombok.Setter;

public class BaseException extends RuntimeException {

    private Integer status;
    private String code;
    private String type;

    public BaseException(Integer status, String code, String type, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
