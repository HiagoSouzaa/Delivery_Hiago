package prova2.hiago.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import prova2.hiago.persistence.entity.Delivery;

@Repository
public interface DeliveryRepository extends MongoRepository<Delivery, String> {
}
