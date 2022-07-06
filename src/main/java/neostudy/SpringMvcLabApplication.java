package neostudy;

import neostudy.entity.User;
import neostudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SpringMvcLabApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcLabApplication.class, args);
    }

    @Override
    public void run(String... args){
        User user1 = User.builder()
                .fullname("Иван Иванов")
                .address("Деревня Гадюкино")
                .dateOfBirth("2000-05-05")
                .email("ivanov@mail.ru")
                .phone("1234578")
                .build();
        userService.saveUser(user1);

        User user2 = User.builder()
                .fullname("Сергей Сергеев")
                .address("Город Москва")
                .dateOfBirth("2001-07-07")
                .email("sergeev@mail.ru")
                .phone("1458756")
                .build();
        userService.saveUser(user2);

        User user3 = User.builder()
                .fullname("Пётр Петров")
                .address("Город Санкт-Петербург")
                .dateOfBirth("1999-02-02")
                .email("petrov@mail.ru")
                .phone("9514585")
                .build();
        userService.saveUser(user3);
    }
}
