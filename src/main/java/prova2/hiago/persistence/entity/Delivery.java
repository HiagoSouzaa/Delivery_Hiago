package prova2.hiago.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("prova")
public class Delivery {

    @Id
    private String id;
    private String code;
    private String deliveryType;
    private LocalDate deliveryDate;
    private LocalDate dueDate;
    private Number value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getdeliveryType() {
        return deliveryType;
    }

    public void setdeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public LocalDate getdeliveryDate() {
        return deliveryDate;
    }

    public void setdeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }
}
