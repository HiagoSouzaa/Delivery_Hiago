package prova2.hiago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova2.hiago.model.AuditingResponse;
import prova2.hiago.persistence.entity.Auditing;
import prova2.hiago.persistence.repository.AuditingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditingServiceImpl implements AuditingService {

    @Autowired
    private AuditingRepository auditingRepository;

    @Override
    public List<AuditingResponse> getAll() {
        List<AuditingResponse> reponses = new ArrayList<>();

        List<Auditing> auditings = auditingRepository.findAll();

        if (!auditings.isEmpty()) {
            auditings.forEach(auditing -> reponses.add(createResponse(auditing)));
        }

        return reponses;
    }

    private AuditingResponse createResponse(Auditing auditing) {
        AuditingResponse response = new AuditingResponse();

        response.setId(auditing.getId());
        response.setOperation(auditing.getOperation());
        response.setData(auditing.getData());

        return response;
    }
}
