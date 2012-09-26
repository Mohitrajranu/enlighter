package com.fourthelephant.enlighter.message;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Vadim Bobrov
 */
@Component
public class MailListener {

    public MailListener(){
        System.out.println("MailListener started");
    }

    public void onMessage(Map map) {
        System.out.println("message arrived");
        System.out.println(map);
    }

}