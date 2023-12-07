package dev.danvega.multipleds.subscriber;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {

    private final JdbcClient jdbcClient;

    public SubscriberService(@Qualifier("subscriberJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Subscriber> findAll() {
        return jdbcClient.sql("select id,name,email from Subscriber")
                .query(Subscriber.class)
                .list();
    }

}
