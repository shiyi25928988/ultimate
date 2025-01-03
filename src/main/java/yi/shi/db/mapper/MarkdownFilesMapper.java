package yi.shi.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import yi.shi.db.model.MarkdownFiles;

import java.util.List;

@Mapper
public interface MarkdownFilesMapper {

    @Select("SELECT MAX(id) FROM markdown_files")
    long selectMaxId();

    @Insert("INSERT INTO markdown_files(user_id, title, content, create_time, update_time) VALUES(#{userId}, #{title}, #{content}, #{createTime}, #{updateTime})")
    int insert(MarkdownFiles markdownFiles);

    @Select("SELECT * FROM markdown_files WHERE user_id = #{userId} AND title = #{title}")
    List<MarkdownFiles> selectByUserIdAndTitle(String userId, String title);

    @Select("SELECT * FROM markdown_files WHERE id = #{id}")
    MarkdownFiles selectById(Long id);

    @Select("SELECT * FROM markdown_files WHERE user_id = #{userId}")
    List<MarkdownFiles> selectByUserId(Long userId);

    @Select("SELECT * FROM markdown_files WHERE shared_token = #{sharedToken}")
    MarkdownFiles selectBySharedToken(String sharedToken);

    @Select("SELECT EXISTS(SELECT 1 FROM markdown_files WHERE shared_token = #{sharedToken})")
    Boolean isSharedTokenExist(String sharedToken);

    @Update("UPDATE markdown_files SET title = #{title}, content = #{content}, update_time = #{updateTime}, shared_token = #{sharedToken} WHERE id = #{id}")
    int update(MarkdownFiles markdownFiles);
}
