package yi.shi.db.mapper;

import org.apache.ibatis.annotations.*;
import yi.shi.db.model.Album;

import java.util.List;

@Mapper
public interface AlbumMapper {

    @Select("SELECT COALESCE(MAX(id), 0) FROM album")
    long selectMaxId();

    @Insert("INSERT INTO album(id, album_name, album_desc, cover_url, owner_id, create_time) VALUES(#{id}, #{albumName}, #{albumDesc}, #{coverUrl}, #{ownerId}, #{createTime})")
    int insert(Album album);

    @Update("UPDATE album SET album_name = #{albumName}, album_desc = #{albumDesc}, cover_url = #{coverUrl}, owner_id = #{ownerId}, create_time = #{createTime} WHERE id = #{id}")
    int update(Album album);

    @Delete("DELETE FROM album WHERE id = #{id}")
    int deleteById(Long id);

    @Select("SELECT * FROM album WHERE id = #{id}")
    Album selectById(Long id);

    @Select("SELECT * FROM album WHERE album_name like concat('%',#{albumName},'%')")
    List<Album> selectAlbumsByName(String albumName);

    @Select("SELECT * FROM album")
    List<Album> selectAllAlbums();

}
