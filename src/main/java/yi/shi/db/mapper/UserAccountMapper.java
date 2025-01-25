package yi.shi.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import yi.shi.db.model.UserAccount;

@Mapper
public interface UserAccountMapper {

    @Insert("INSERT INTO user_account(username, passwd, nick_name, email, phone, address, avatar, token, create_time, update_time, last_login_time, last_login_ip, role, is_lock, is_deleted, is_online) VALUES(#{username}, #{passwd}, #{nickName, jdbcType=VARCHAR}, #{email, jdbcType=VARCHAR}, #{phone, jdbcType=VARCHAR}, #{address, jdbcType=VARCHAR}, #{avatar, jdbcType=VARCHAR}, #{token, jdbcType=VARCHAR}, #{createTime, jdbcType=TIMESTAMP}, #{updateTime, jdbcType=TIMESTAMP}, #{lastLoginTime, jdbcType=TIMESTAMP}, #{lastLoginIP, jdbcType=VARCHAR}, #{role, jdbcType=VARCHAR}, #{isLock, jdbcType=SMALLINT}, #{isDeleted, jdbcType=SMALLINT}, #{isOnline, jdbcType=SMALLINT})")
    int insert(UserAccount userAccount);

    @Select("SELECT passwd FROM user_account WHERE username = #{username}")
    String getPasswdByUsername(String username);

    @Select("SELECT role FROM user_account WHERE username = #{username}")
    String getRoleByUsername(String username);

    @Select("SELECT * FROM user_account WHERE username = #{username}")
    UserAccount getUserByUsername(String username);

    @Select("SELECT COUNT(*) FROM user_account WHERE username = #{username}")
    int getCountByUsername(String username);

    @Update("UPDATE user_account SET last_login_time = #{lastLoginTime}, last_login_ip = #{lastLoginIP} WHERE username = #{username}")
    int updateLastLoginTimeAndIP(UserAccount userAccount);

    @Update("UPDATE user_account SET passwd = #{passwd} WHERE username = #{username}")
    int updatePasswd(UserAccount userAccount);

    @Update("UPDATE user_account SET nick_name = #{nickName}, email = #{email}, phone = #{phone}, address = #{address}, avatar = #{avatar}, token = #{token} WHERE username = #{username}")
    int updateUserInfo(UserAccount userAccount);

    @Select("SELECT * FROM user_account WHERE id = #{id}")
    UserAccount getUserById(Long id);
}
