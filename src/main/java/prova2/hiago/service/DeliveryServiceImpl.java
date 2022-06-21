package prova2.hiago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova2.hiago.controller.exception.InvalidDataException;
import prova2.hiago.controller.exception.ObjectNotFoundException;
import prova2.hiago.model.DeliveryReponse;
import prova2.hiago.model.DeliveryRequest;
import prova2.hiago.persistence.entity.Auditing;
import prova2.hiago.persistence.entity.Delivery;
import prova2.hiago.persistence.repository.AuditingRepository;
import prova2.hiago.persistence.repository.DeliveryRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository repository;
    @Autowired
    private AuditingRepository auditingRepository;
    private AuditingService auditingService;

    @Override
    public DeliveryReponse create(DeliveryRequest request) {
        var delivery = new Delivery();
        delivery.setOrdercode(request.getdeliveryOrdercode());
        delivery.setdeliveryCpf(request.getdeliveryCpf());
        delivery.setdeliveryDate(request.getdeliveryDate());
        delivery.setcep(request.getcep());
        delivery.setstatus(request.getstatus());

        repository.save((delivery));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String date = dateFormat .format(today);

        Auditing auditing = new Auditing();
        auditing.setOperation("Create");
        auditing.setData(date);
        auditingRepository.save(auditing);

        return createResponse(delivery);
    }

    @Override
    public List<DeliveryReponse> getAll() {
        List<DeliveryReponse> reponses = new ArrayList<>();

        List<Delivery> deliverys = repository.findAll();

        if (!deliverys.isEmpty()) {
            deliverys.forEach(delivery -> reponses.add(createResponse(delivery)));
        }

        return reponses;
    }

    @Override
    public Delivery getFromId(String id) {
        if(id == null) {
            throw new InvalidDataException("Id can't be NULL.");
        }
        Optional<Delivery> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Delivery not found: " + id));
    }

    @Override
    public DeliveryReponse updateDelivery(DeliveryRequest request, String id) {
        if(id == null) {
            throw new InvalidDataException("Id can't be NULL.");
        }
        Delivery delivery = getFromId(id);

        delivery.setOrdercode(request.getdeliveryOrdercode());
        delivery.setdeliveryCpf(request.getdeliveryCpf());
        delivery.setdeliveryDate(request.getdeliveryDate());
        delivery.setcep(request.getcep());
        delivery.setstatus(request.getstatus());
        
        repository.save(delivery);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy/ HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String date = dateFormat .format(today);

        Auditing auditing = new Auditing();
        auditing.setOperation("Update");
        auditing.setData(date);
        auditingRepository.save(auditing);

        return createResponse(delivery);
    }

    @Override
    public void deleteDelivery(String id) {
        Delivery delivery = getFromId(id);
        repository.delete(delivery);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy/ HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String date = dateFormat .format(today);

        Auditing auditing = new Auditing();
        auditing.setOperation("Delete");
        auditing.setData(date);
        auditingRepository.save(auditing);
    }

    private DeliveryReponse createResponse(Delivery delivery) {
        DeliveryReponse response = new DeliveryReponse();

        response.setId(delivery.getId());
        response.setOrdercode(delivery.getdeliveryOrdercode());
        response.setdeliveryCpf(delivery.getdeliveryCpf());
        response.setdeliveryDate(delivery.getdeliveryDate());
        response.setcep(delivery.getcep());
        response.setstatus(delivery.getstatus());

        return response;
    }

    @Override
    public DeliveryReponse updatePayment(DeliveryRequest request, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletePayment(String id) {
        // TODO Auto-generated method stub
        
    }
}
