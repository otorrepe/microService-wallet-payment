package com.nttdata.bank.payment.config;
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

import com.nttdata.bank.payment.events.Event;

@Configuration
public class KafkaProducer {
	
private final String bootstrapAddress = "localhost:9092";
	
	public ProducerFactory<String, Event<?>> producerFactory(){
		Map<String, Object> config = new HashMap<>();
		//direccion del bus de msj de kafka
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		//llave con la que se serializara ese msj (que tipo y que serializador a usar)
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//Configuracion del objeto se va a serializar
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, Event<?>> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}

}
