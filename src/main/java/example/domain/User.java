package example.domain;

import org.springframework.stereotype.Component;

@Component
public class User {

    public User() {
    }

    public User(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
		return this.getName() + ":" + this.getAge();
    	
    }

    private String name;
    private int age;
}
