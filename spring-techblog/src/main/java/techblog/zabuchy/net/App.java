package techblog.zabuchy.net;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[]{"spring.xml"});

        Person me = (Person) appContext.getBean("person");

        System.out.println("About to print a name...");
        me.printName();

        System.out.println("About to print a website...");
        me.printWebsite();

        System.out.println("About to throw an exception...");
        try {
            me.throwException();
        } catch (Exception e) {

        }

    }
}