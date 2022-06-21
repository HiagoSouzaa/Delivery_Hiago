package prova2.hiago.service;

import org.springframework.web.bind.annotation.PathVariable;

import prova2.hiago.model.DeliveryReponse;
import prova2.hiago.model.DeliveryRequest;
import prova2.hiago.persistence.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    DeliveryReponse create(DeliveryRequest request);

    List<DeliveryReponse> getAll();

    Delivery getFromId(@PathVariable String id);

    DeliveryReponse updatePayment(DeliveryRequest request, @PathVariable String id);

    void deletePayment(@PathVariable String id);

    Object updateDelivery(DeliveryRequest request, String id);

    void deleteDelivery(String id);
}
