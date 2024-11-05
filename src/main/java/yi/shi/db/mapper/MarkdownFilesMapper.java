package yi.shi.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yi.shi.db.model.MarkdownFiles;

import java.util.List;

@Mapper
public interface MarkdownFilesMapper {
    @Insert("INSERT INTO markdown_files(user_id, title, content, create_time, update_time) VALUES(#{userId}, #{title}, #{content}, #{createTime}, #{updateTime})")
    int insert(MarkdownFiles markdownFiles);

    @Select("SELECT * FROM markdown_files WHERE user_id = #{userId} AND title = #{title}")
    List<MarkdownFiles> selectByUserIdAndTitle(String userId, String title);

    @Select("SELECT * FROM markdown_files WHERE id = #{id}")
    MarkdownFiles selectById(Long id);

    @Select("SELECT * FROM markdown_files WHERE user_id = #{userId}")
    List<MarkdownFiles> selectByUserId(Long userId);
}
