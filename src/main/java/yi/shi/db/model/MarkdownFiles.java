package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkdownFiles {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String coverUrl;
    private Date createTime;
    private Date updateTime;
    private String sharedToken;
}
