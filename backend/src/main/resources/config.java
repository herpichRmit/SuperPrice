import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
     
    @Bean
    public DataSource datasource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/database_superprice");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("KeyboardFish_3");
        return dataSourceBuilder.build();
    }
}


