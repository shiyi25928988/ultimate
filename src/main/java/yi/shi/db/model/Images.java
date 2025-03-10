package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {
    Long id;
    Long albumId;
    String imageUrl;
    Long ownerId;
    Date createTime;
}
