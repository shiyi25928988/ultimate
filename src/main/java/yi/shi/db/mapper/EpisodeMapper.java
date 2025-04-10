package yi.shi.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yi.shi.db.model.Episode;

@Mapper
public interface EpisodeMapper {

    //把这个SQL补全

    @Select("INSERT INTO episode (episode_name, drama_id, episode_desc, episode_url, create_time, update_time) " + "v")
    void insertEpisode(Episode episode);
}
