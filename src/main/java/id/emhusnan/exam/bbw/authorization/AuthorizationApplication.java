package id.emhusnan.exam.bbw.authorization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class AuthorizationApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class, args);
    }

    //    @Autowired
//    private UserRepository userRepository;
//
//    private void seedUsersTable() {
//        User user = new User();
//        user.setUsername("husnan");
//        user.setPassword("123");
//        userRepository.save(user);
//        System.out.println("OK seeder");
//
//    }

    @Override
    public void run(String... args) throws Exception {
//        seedUsersTable();

    }
}
