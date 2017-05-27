package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Genre genre;

    @OneToMany(mappedBy = "artist")
    private List<Concert> concerts;
}
