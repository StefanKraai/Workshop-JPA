package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 2-6-2017.
 */
@Repository
public class ConcertRepository {

    private final EntityManager entityManager;

    @Autowired
    public ConcertRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ConcertDTO> searchConcertByArtistName(String searchParam){
        return entityManager.createQuery("SELECT DISTINCT new nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate)  FROM Concert c WHERE c.artist.name LIKE :name", ConcertDTO.class)
                .setParameter("name", "%"+searchParam+"%")
                .getResultList();
    }

    public List<ConcertDTO> searchConcertByArtistGenre(String searchParam){
        try {
            Genre genre = Genre.valueOf(searchParam);
            return entityManager.createQuery("SELECT DISTINCT new nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate) FROM Concert c WHERE c.artist.genre = :genre", ConcertDTO.class)
                    .setParameter("genre",genre)
                    .getResultList();
        }catch (IllegalArgumentException ex){
            return new ArrayList<>();
        }
    }

    public List<ConcertDTO> searchConcertByLocation(String searchParam){
        return entityManager.createQuery("SELECT DISTINCT new nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate) FROM Concert c WHERE c.location.name LIKE :name", ConcertDTO.class)
                .setParameter("name", "%"+searchParam+"%")
                .getResultList();
    }

    public List<ConcertDTO> searchConcertByMinimumDate(String searchParam){
        try {
            Date date = Date.valueOf(searchParam);
            return entityManager.createQuery("SELECT DISTINCT new nl.first8.hu.ticketsale.venue.ConcertDTO(c.id, c.location.name, c.artist.name, c.artist.genre, c.concertDate) FROM Concert c WHERE c.concertDate > :date", ConcertDTO.class)
                    .setParameter("date",date)
                    .getResultList();
        } catch (IllegalArgumentException ex){
            return new ArrayList<>();
        }
    }
}
