package com.jyh.jiangboot.command;

import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.exceptions.NSQException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class NsqProduce {

    @Value("${NSQ_ADDRESS}")
    private String address;

    @Value("${NSQ_DAEMON_PORT}")
    private Integer nsqDaemonPort;

    @Value("${NSQ_TOPIC}")
    private String nsqTopic;

    private NSQProducer getProducer() {
        NSQProducer producer = new NSQProducer();
        producer.addAddress(address, nsqDaemonPort).start();
        return producer;
    }

    private void produce(String msg) throws NSQException, TimeoutException {
        this.getProducer().produce(nsqTopic, msg.getBytes());
    }

}
