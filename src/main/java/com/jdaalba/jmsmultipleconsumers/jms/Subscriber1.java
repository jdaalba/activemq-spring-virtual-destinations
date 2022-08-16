package com.jdaalba.jmsmultipleconsumers.jms;

import com.jdaalba.jmsmultipleconsumers.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Subscriber1 {

  @JmsListener(
      destination = "Consumer.${app.consumers.c1}.VirtualTopic.${app.destination}"
  )
  public void on(MessageDto messageDto) {
    final var subscriberName = "subs#1";
    log.info("[{}] :: Received {}", subscriberName, messageDto);
  }
}
