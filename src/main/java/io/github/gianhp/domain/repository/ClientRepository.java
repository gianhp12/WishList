package io.github.gianhp.domain.repository;

import io.github.gianhp.domain.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,Long> {
}
