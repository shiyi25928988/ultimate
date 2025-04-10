package yi.shi.service.impl;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import yi.shi.db.mapper.DramaMapper;
import yi.shi.db.model.Drama;
import yi.shi.service.DramaService;

import java.util.Collections;
import java.util.List;

public class DramaServiceImpl implements DramaService {

    @Inject
    private DramaMapper dramaMapper;

    @Override
    public void insertDrama(Drama drama) {
        dramaMapper.insertDrama(drama);
    }

    @Override
    public void updateDrama(Drama drama) {
        dramaMapper.updateDrama(drama);
    }

    @Override
    public void deleteDrama(Long id) {
        dramaMapper.deleteDrama(id);
    }

    @Override
    public Drama selectDramaById(Long id) {
        return dramaMapper.selectDramaById(id);
    }

    @Override
    public List<Drama> selectAllDramas() {
        return dramaMapper.selectAllDramas();
    }

    @Override
    public List<Drama> selectDramasByName(String name) {
        return dramaMapper.selectDramasByName(name);
    }

    @Override
    public List<Drama> selectDramasByGenre(String genre) {
        return dramaMapper.selectDramasByGenre(genre);
    }

    @Override
    public List<Drama> selectDramasByDirector(String director) {
        return dramaMapper.selectDramasByDirector(director);
    }

    @Override
    public List<Drama> selectDramasByYear(Integer year) {
        return dramaMapper.selectDramasByYear(year);
    }

    @Override
    public List<Drama> selectDramasByActor(String actor) {
        return Collections.emptyList();
    }
}
