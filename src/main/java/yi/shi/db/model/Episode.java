package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episode {
    private Long id;
    private Long dramaId;
    private String episodeName;
    private String episodeDesc;
    private String magnetLink;
    private Date createTime;
    private Date updateTime;
}