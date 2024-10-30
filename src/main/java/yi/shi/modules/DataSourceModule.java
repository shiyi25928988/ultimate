package yi.shi.modules;

import com.google.inject.name.Names;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import yi.shi.db.mapper.UserAccountMapper;

public class DataSourceModule extends MyBatisModule {
    @Override
    protected void initialize() {
        Names.bindProperties(binder(), System.getProperties());
        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        addMapperClass(UserAccountMapper.class);//前面的照抄，这里加自己的mapper
    }
}
