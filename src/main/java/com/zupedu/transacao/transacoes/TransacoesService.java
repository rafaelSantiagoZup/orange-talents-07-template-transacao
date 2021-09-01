package com.zupedu.transacao.transacoes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TransacoesService {
    private final Logger logger = LoggerFactory.getLogger(TransacoesService.class);
    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    private final TransacoesRepository transacoesRepository;

    public TransacoesService(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }

    @KafkaListener(id = "transacoes", topics = "transacoes")
    @Transactional
    public void listen(TransacoesForm transacoesForm) {
        logger.info("Received: " + transacoesForm.toString());
        System.out.println(transacoesForm.toString());
        transacoesRepository.save(transacoesForm.toModel());
    }

}
