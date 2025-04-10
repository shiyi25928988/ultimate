package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drama {
    private Long id;
    private String dramaName;
    private String dramaDesc;
    private String coverUrl;
    private String director;
    private Integer releaseYear;
    private String genre;
    private Date createTime;
    private String actors;
    private Integer likeCount;
    private Date updateTime;

}