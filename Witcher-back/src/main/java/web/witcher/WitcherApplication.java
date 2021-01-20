package web.witcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import web.witcher.Repositories.Custom.CustomRepositoryImpl;

@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
@SpringBootApplication
public class WitcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WitcherApplication.class, args);
    }

}
