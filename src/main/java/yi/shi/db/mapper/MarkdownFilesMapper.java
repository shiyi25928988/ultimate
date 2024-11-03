package yi.shi.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import yi.shi.db.model.MarkdownFiles;

@Mapper
public interface MarkdownFilesMapper {
    @Insert("INSERT INTO markdown_files(user_id, title, content, create_time, update_time) VALUES(#{userId}, #{title}, #{content}, #{createTime}, #{updateTime})")
    int insert(MarkdownFiles markdownFiles);
}
