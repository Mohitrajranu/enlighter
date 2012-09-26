package com.fourthelephant.enlighter.message;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.jms.*;

/**
 * @author Vadim Bobrov
 */
@Component
public class Sender {

    @Inject
    private JmsTemplate jmsTemplate;

/*
    @Inject
    private Destination destination;
*/

    public void sendMail() {

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("mailId", "3");
                message.setString("country", "Russia");
                message.setDouble("weight", 146);
                return message;
            }
        });

    }
}
