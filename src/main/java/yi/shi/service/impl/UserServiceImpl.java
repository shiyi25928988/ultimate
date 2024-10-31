package yi.shi.service.impl;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import yi.shi.db.mapper.UserAccountMapper;
import yi.shi.db.model.UserAccount;
import yi.shi.service.UserService;
import yi.shi.utils.PasswordEncryptor;

import java.util.Date;

public class UserServiceImpl implements UserService {

    @Inject
    private UserAccountMapper userAccountMapper;

    @Override
    public String getPasswdByUsername(String username) {
        return userAccountMapper.getPasswdByUsername(username);
    }

    @Override
    public int addNewUser(UserAccount userAccount) {
        userAccount.setPasswd(PasswordEncryptor.encryptPassword(userAccount.getPasswd()));
        userAccount.setCreateTime(new Date());
        return userAccountMapper.insert(userAccount);
    }

    @Override
    public boolean checkUser(String username, String password) {
        if(Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)){
            return false;
        }
        String passwd = userAccountMapper.getPasswdByUsername(username);
        if(Strings.isNullOrEmpty(passwd)){
            return false;
        }
        if(passwd.equals(PasswordEncryptor.encryptPassword(password))){
            return true;
        }
        return false;
    }
}