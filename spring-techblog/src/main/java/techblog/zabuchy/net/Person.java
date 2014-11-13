package techblog.zabuchy.net;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Person {
    private String name;
    private String website;

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void printName() {
        System.out.println("My name: " + this.name);
    }

    public void printWebsite() {
        System.out.println("My website: " + this.website);
        privateMethod();
        publicMethod();
    }

    private void privateMethod() {
        System.out.println("Private method");
    }

    private void publicMethod() {
        System.out.println("Public method");
    }

    public void throwException() {
        throw new IllegalArgumentException();
    }

}
