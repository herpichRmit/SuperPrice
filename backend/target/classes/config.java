import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
     
    @Bean
    public DataSource datasource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb/superprice_db");
        dataSourceBuilder.username("springuser");
        dataSourceBuilder.password("ThePassword");
        return dataSourceBuilder.build();
    }
}
