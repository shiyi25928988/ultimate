package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.service.impl.DatabaseInitServiceImpl;

@ImplementedBy(DatabaseInitServiceImpl.class)
public interface DatabaseInitService {

    void init();
}
