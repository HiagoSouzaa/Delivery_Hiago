package prova2.hiago.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import prova2.hiago.model.AuditingResponse;
import prova2.hiago.service.AuditingService;

import java.util.List;

@RestController
@RequestMapping("/v1/auditing")
public class AuditingController {

    @Autowired
    private AuditingService auditingService;

    @GetMapping
    public ResponseEntity<List<AuditingResponse>> getAll() {
        return ResponseEntity.ok(auditingService.getAll());
    }
}
