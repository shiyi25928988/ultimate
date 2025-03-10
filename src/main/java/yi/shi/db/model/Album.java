package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    Long id;
    String albumName;
    String albumDesc;
    String coverUrl;
    Long ownerId;
    Date createTime;
}
