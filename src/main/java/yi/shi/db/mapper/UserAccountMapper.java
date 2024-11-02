package yi.shi.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yi.shi.db.model.UserAccount;

@Mapper
public interface UserAccountMapper {

    @Insert("INSERT INTO UserAccount(username, passwd, email, phone, address, avatar, token, create_time, update_time, last_login_time, last_login_ip, role, is_lock, is_deleted, is_online) VALUES(#{username}, #{passwd}, #{email}, #{phone}, #{address}, #{avatar}, #{token}, #{createTime}, #{updateTime}, #{lastLoginTime}, #{lastLoginIP}, #{role}, #{isLock}, #{isDeleted}, #{isOnline})")
    int insert(UserAccount userAccount);

    @Select("SELECT passwd FROM UserAccount WHERE username = #{username}")
    String getPasswdByUsername(String username);

    @Select("SELECT role FROM UserAccount WHERE username = #{username}")
    String getRoleByUsername(String username);
}
