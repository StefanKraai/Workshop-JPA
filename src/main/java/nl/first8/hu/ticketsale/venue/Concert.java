package nl.first8.hu.ticketsale.venue;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concert implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

}
