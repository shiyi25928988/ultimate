package yi.shi.service.impl;

import com.google.inject.Inject;
import yi.shi.db.mapper.DbIniter;
import yi.shi.service.DatabaseInitService;

import javax.sql.DataSource;

public class DatabaseInitServiceImpl implements DatabaseInitService {

    @Inject
    DataSource dataSource;

    @Override
    public void init() {
        DbIniter.init(dataSource);
    }
}
