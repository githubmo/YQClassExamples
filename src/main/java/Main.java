import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.Fish;
import finance.Money;
import hr.Person;

import java.util.HashSet;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        var cat = new Cat("kitty");
        cat.meow();

        IO.println("===========");
        IO.println("hello world");
        IO.println("============");

        var cat2 = new Cat("mimi");
        var x = 10;
        x = 20;
        x = 99;

        var msg = "Cat has %d legs".formatted(Cat.NUM_OF_LEGS);
        IO.println(msg);

        var m1 = new Money(10, "$");
        m1.amount();

        var m2 = new Money(20, "$");

        IO.println(m1 == m2);

        var m3 = new Money(10, "$");

        IO.println(m3.equals(m1));
        var m4 = new Money(30, m3.currency());
        IO.println(m1);

        var m5 = m3.plus(m2);
        IO.println(m5);

        var p1 = new Person("Ali", 1);
        var p2 = new Person("Omar", 2);
        var p3 = new Person("Islam", 3);
        var p4 = new Person("Essideeq", 4);
        var p5 = new Person("mohammed", 5);
        var attendees = new HashSet<>(List.of(p1, p1, p1, p2, p3, p4, p5, p5));
        attendees.add(new Person("Ali", 1));
        IO.println(attendees);
        var animals = List.of(
                new Dog("woofie"),
                new Cat("mimi"),
                new Fish("fifi")
        );

        for(var a : animals) {
            feedAnimal(a);
        }
    }

    static void feedAnimal(Animal animal) {
        switch (animal) {
            case Cat(var name) -> IO.println("feed %s fish".formatted(name));
            case Dog(var name) -> IO.println("feed %s chicken".formatted(name));
            case Fish(var name) -> IO.println("feed %s bread".formatted(name));
        }
    }
}