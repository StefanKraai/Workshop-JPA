package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by Stefan on 2-6-2017.
 */
@Data
@AllArgsConstructor
public class ConcertDTO {
    private long id;
    private String locationName;
    private String artistName;
    private Genre artistGenre;
    private Date concertDate;
}
