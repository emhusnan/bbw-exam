package id.emhusnan.exam.bbw.authorization.model;

import javax.persistence.*;

@Entity
@Table(name = "bbw_va_transaction")
public class VirtualAccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "va_number")
    String vaNumber;
    @Column(name = "amount")
    int amount;
    @Column(name = "note")
    String note;
    @Column(name = "reference_number")
    String referenceNumber;
    @Column(name = "client_id")
    String clientId;
    @Column(name = "timestamp")
    String timestamp;

}
