package prova2.hiago.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import prova2.hiago.persistence.entity.Auditing;

@Repository
public interface AuditingRepository extends MongoRepository<Auditing, String> {
}