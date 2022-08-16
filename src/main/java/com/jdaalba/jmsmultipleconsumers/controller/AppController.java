package com.jdaalba.jmsmultipleconsumers.controller;

import com.jdaalba.jmsmultipleconsumers.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class AppController {

  private final JmsTemplate jmsTemplate;

  @PostMapping
  public void accept(@RequestBody MessageDto messageDto) {
    log.info("Publishing {}", messageDto);
    jmsTemplate.convertAndSend(messageDto);
  }
}
