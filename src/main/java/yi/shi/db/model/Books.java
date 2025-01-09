package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private Long id;
    private String bookName;
    private String isbn;
    private String digest;
    private String author;
    private String aboutAuthor;
    private String price;
    private String coverUrl;
    private Long ownerId;
    private Long holderId;
    private Date createTime;
}
