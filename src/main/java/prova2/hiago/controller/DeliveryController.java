package prova2.hiago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import prova2.hiago.model.DeliveryReponse;
import prova2.hiago.model.DeliveryRequest;
import prova2.hiago.persistence.entity.Delivery;
import prova2.hiago.persistence.repository.DeliveryRepository;
import prova2.hiago.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DeliveryController {

    @Autowired
    private DeliveryService service;
    private DeliveryRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DeliveryReponse> create(@RequestBody DeliveryRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryReponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok(service.getFromId(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<DeliveryReponse> updateDelivery(@RequestBody DeliveryRequest request, @PathVariable String id) {
        return ResponseEntity.ok(service.updateDelivery(request, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDelivery(@PathVariable String id) {
        service.deleteDelivery(id);
    }
}
