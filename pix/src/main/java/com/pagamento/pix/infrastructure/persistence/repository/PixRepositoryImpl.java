package com.pagamento.pix.infrastructure.persistence.repository;

import com.pagamento.pix.core.domain.aggregates.pix.Pix;
import com.pagamento.pix.core.domain.aggregates.pix.PixRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PixRepositoryImpl implements PixRepository {

    private final MongoTemplate mongoTemplate;

    @Value("${spring.data.mongodb.collection}")
    private String defaultCollection;

    public PixRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Pix pix) {
        mongoTemplate.save(pix, defaultCollection);
    }

    @Override
    public Pix findById(String id) {
        return mongoTemplate.findById(id, Pix.class, defaultCollection);
    }

    @Override
    public List<Pix> findAll() {
        return mongoTemplate.findAll(Pix.class, defaultCollection);
    }
}
