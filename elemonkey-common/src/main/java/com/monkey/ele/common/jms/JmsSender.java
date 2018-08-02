package com.monkey.ele.common.jms;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 7/30/2018 5:19 PM
 **/
@Component
public class JmsSender {

    private static final Logger LOGGER = Logger.getLogger(JmsSender.class);

    @Autowired
    private Destination destination;
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendTextMessage(final String message) {
        LOGGER.info("send message: " + message + ", to: " + this.destination);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

}
