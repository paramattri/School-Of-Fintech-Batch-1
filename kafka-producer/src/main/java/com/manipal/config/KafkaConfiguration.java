package com.manipal.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.manipal.model.Book;

@Configuration
public class KafkaConfiguration {
	
	@Bean
	public ProducerFactory<String, String> producerFactory(){	
		Map<String, Object> configs = new HashMap<>();
		//config for server
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configs);
		return producerFactory;
		
	}
	
	@Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
	
	@Bean
	public ProducerFactory<String, Book> producerFactoryBook(){	
		Map<String, Object> configs = new HashMap<>();
		//config for server
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		ProducerFactory<String, Book> producerFactory = new DefaultKafkaProducerFactory<>(configs);
		return producerFactory;
		
	}
	
	@Bean
    public KafkaTemplate<String, Book> kafkaTemplateBook() {
        return new KafkaTemplate<String, Book>(producerFactoryBook());
    }
}
