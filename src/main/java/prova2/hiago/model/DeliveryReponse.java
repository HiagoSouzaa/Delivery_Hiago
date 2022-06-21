package prova2.hiago.model;

import java.time.LocalDate;

public class DeliveryReponse {

	private String id;
    private String Ordercode;
    private String deliveryCpf;
    private LocalDate deliveryDate;
    private Number cep;
    private String status;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getdeliveryOrdercode() {
        return Ordercode;
    }

    public void setOrdercode(String Ordercode) {
        this.Ordercode = Ordercode;
    }

    public String getdeliveryCpf() {
        return deliveryCpf;
    }

    public void setdeliveryCpf(String deliveryCpf) {
        this.deliveryCpf = deliveryCpf;
    }

    public LocalDate getdeliveryDate() {
        return deliveryDate;
    }

    public void setdeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    

    public Number getcep() {
        return cep;
    }

    public void setcep(Number cep) {
        this.cep = cep;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
}
