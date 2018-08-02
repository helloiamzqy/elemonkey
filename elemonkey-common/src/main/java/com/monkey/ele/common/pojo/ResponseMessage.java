package com.monkey.ele.common.pojo;

public class ResponseMessage {

    private Object content;
    private Integer resultCode;
    private String message;

    public ResponseMessage() { }

    public ResponseMessage(Object content, Integer resultCode, String message) {
        this.content = content;
        this.resultCode = resultCode;
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
