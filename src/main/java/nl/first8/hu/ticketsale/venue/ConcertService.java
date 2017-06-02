package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 2-6-2017.
 */
@Service
public class ConcertService {
    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    public List<ConcertDTO> searchConcert(String searchParam){
        List<ConcertDTO> result = new ArrayList<>();
        result.addAll(concertRepository.searchConcertByArtistGenre(searchParam));
        result.addAll(concertRepository.searchConcertByArtistName(searchParam));
        result.addAll(concertRepository.searchConcertByLocation(searchParam));
        result.addAll(concertRepository.searchConcertByMinimumDate(searchParam));
        return result;
    }
}
