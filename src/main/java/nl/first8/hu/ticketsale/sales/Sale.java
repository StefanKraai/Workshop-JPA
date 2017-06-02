package nl.first8.hu.ticketsale.sales;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Sale implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "ticket_account_id", referencedColumnName = "account_id")
        ,
        @JoinColumn(name = "ticket_concert_id", referencedColumnName = "concert_id")})
    private Ticket ticket;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sellDate;

    @Min(1)
    private int price;

    @OneToOne
    private AuditTrail auditTrail;

}
