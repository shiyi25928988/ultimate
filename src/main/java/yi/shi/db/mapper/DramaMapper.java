package yi.shi.db.mapper;

import org.apache.ibatis.annotations.*;
import yi.shi.db.model.Drama;

import java.util.List;

@Mapper
public interface DramaMapper {

    @Insert("INSERT INTO drama (drama_name, drama_desc, cover_url, director, release_year, genre, create_time, actors, like_count, update_time) " +
            "VALUES (#{dramaName}, #{dramaDesc}, #{coverUrl}, #{director}, #{releaseYear}, #{genre}, #{createTime}, #{actors}, #{likeCount}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertDrama(Drama drama);

    @Update("UPDATE drama SET drama_name = #{dramaName}, drama_desc = #{dramaDesc}, cover_url = #{coverUrl}, director = #{director}, " +
            "release_year = #{releaseYear}, genre = #{genre}, create_time = #{createTime}, actors = #{actors}, like_count = #{likeCount}, " +
            "update_time = #{updateTime} WHERE id = #{id}")
    void updateDrama(Drama drama);

    @Delete("DELETE FROM drama WHERE id = #{id}")
    void deleteDrama(Long id);

    @Select("SELECT * FROM drama WHERE id = #{id}")
    Drama selectDramaById(Long id);

    @Select("SELECT * FROM drama WHERE drama_name like concat('%',#{dramaName},'%')")
    List<Drama> selectDramasByName(String name);

    @Select("SELECT * FROM drama")
    List<Drama> selectAllDramas();

    @Select("SELECT * FROM drama WHERE genre = #{genre}")
    List<Drama> selectDramasByGenre(String genre);

    @Select("SELECT * FROM drama WHERE release_year = #{year}")
    List<Drama> selectDramasByYear(int year);

    @Select("SELECT * FROM drama WHERE director = #{director}")
    List<Drama> selectDramasByDirector(String director);
}