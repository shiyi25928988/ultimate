package yi.shi.modules;

import com.google.inject.name.Names;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

public class DataSourceModule extends MyBatisModule {
    @Override
    protected void initialize() {
        Names.bindProperties(binder(), System.getProperties());
        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        mapUnderscoreToCamelCase(true);
        getMapperClasses().forEach(mapperClass -> addMapperClass(mapperClass));
    }

    private Set<Class<?>> getMapperClasses() {
        String packageName = "yi.shi.db.mapper";
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(packageName)
                .addScanners(Scanners.TypesAnnotated));
        return reflections.getTypesAnnotatedWith(Mapper.class);
    }
}
