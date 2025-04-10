package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.Drama;
import yi.shi.service.impl.DramaServiceImpl;

import java.util.List;

@ImplementedBy(DramaServiceImpl.class)
public interface DramaService {
    void insertDrama(Drama drama);
    void updateDrama(Drama drama);
    void deleteDrama(Long id);
    Drama selectDramaById(Long id);
    List<Drama> selectAllDramas();
    List<Drama> selectDramasByName(String name);
    List<Drama> selectDramasByGenre(String genre);
    List<Drama> selectDramasByDirector(String director);
    List<Drama> selectDramasByYear(Integer year);
    List<Drama> selectDramasByActor(String actor);
}
