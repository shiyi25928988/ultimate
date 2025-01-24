package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    private Long id;
    private String username;
    private String passwd;
    private String nickName;
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String token;
    private Date createTime;
    private Date updateTime;
    private Date lastLoginTime;
    private String lastLoginIP;
    private String role;
    private boolean isLock;
    private boolean isDeleted;
    private boolean isOnline;
    private String theme;

}
