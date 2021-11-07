package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        Lombok lombok = new Lombok();
        lombok.setName("memberA");
        lombok.setAge(22);

        System.out.println("Name: " + lombok.getName() + "\n" + "Age: " + lombok.getAge());
    }
    
}