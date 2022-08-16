package com.jdaalba.jmsmultipleconsumers.config;

import javax.jms.ConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

@Configuration
class BeanConfig {

  @Bean
  JmsTemplate jmsTemplate(
      @Value("${app.destination}") String destination,
      ConnectionFactory connectionFactory
  ) {
    final JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
    jmsTemplate.setDefaultDestination(new ActiveMQTopic("VirtualTopic." + destination));
    jmsTemplate.setMessageConverter(messageConverter());
    return jmsTemplate;
  }

  @Bean
  MessageConverter messageConverter() {
    final var messageConverter = new MappingJackson2MessageConverter();
    messageConverter.setTypeIdPropertyName("_class");
    return messageConverter;
  }
}
