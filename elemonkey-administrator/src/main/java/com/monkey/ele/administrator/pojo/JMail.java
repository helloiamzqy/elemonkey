package com.monkey.ele.administrator.pojo;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:35 PM
 **/
public class JMail {

    public static final class JMailType {
        public static final String AD_REQUEST = "AD_REQUEST";
        public static final String STORE_REQUEST = "STORE_REQUEST";
        public static final String COMPLAIN_REQUEST = "COMPLAIN_REQUEST";
        public static final String STORE_ACK = "STORE_ACK";
        public static final String AD_ACK = "AD_ACK";
    }

    private Object message;
    private String messageType;

}
