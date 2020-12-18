package pl.nowak.pawel.java.crud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.nowak.pawel.java.crud.service.UserService;

public class CrudApplicationContext {
    public static void main(String[] args) {
        ApplicationContext contextXml = new ClassPathXmlApplicationContext();
        ApplicationContext context = new AnnotationConfigApplicationContext("pl.nowak.pawel.java.crud.service");
        Object userMapperObject = context.getBean("userMapper");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userMapperObject);

        System.out.println(userService);
    }
}
