package yi.shi.db.mapper;

import org.apache.ibatis.annotations.*;
import yi.shi.db.model.Images;

import java.util.List;

@Mapper
public interface ImagesMapper {

    @Insert("INSERT INTO images(album_id, image_url, owner_id, create_time) VALUES(#{albumId}, #{imageUrl}, #{ownerId}, #{createTime})")
    int insert(Images images);

    @Update("UPDATE images SET album_id = #{albumId}, image_url = #{imageUrl}, owner_id = #{ownerId}, create_time = #{createTime} WHERE id = #{id}")
    int update(Images images);

    @Delete("DELETE FROM images WHERE id = #{id}")
    int deleteById(Long id);

    @Delete("DELETE FROM images WHERE album_id = #{albumId}")
    int deleteByAlbumId(Long albumId);

    @Select("SELECT * FROM images WHERE id = #{id}")
    Images selectById(Long id);

    @Select("SELECT * FROM images WHERE album_id = #{albumId}")
    List<Images> selectByAlbumId(Long albumId);
}
