package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.UserAccount;
import yi.shi.service.impl.UserServiceImpl;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

    String getPasswdByUsername(String username);

    int addNewUser(UserAccount userAccount);

    boolean checkUser(String username, String password);

    String getRoleByUsername(String username);
}
