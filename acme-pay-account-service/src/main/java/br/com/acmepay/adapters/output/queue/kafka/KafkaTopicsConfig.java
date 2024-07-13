package br.com.acmepay.adapters.output.queue.kafka;

import br.com.acmepay.constants.ConstantsKafka;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic transactions() {
        return TopicBuilder.name(ConstantsKafka.TRANSACTIONS_TOPIC)
                .partitions(1)
                .build();
    }
}