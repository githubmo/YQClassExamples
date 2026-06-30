import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.Fish;
import finance.Money;
import hr.Person;
import shape.Circle;
import shape.Shape;
import shape.Square;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

        // old way creating new data structures
        var attendees = new HashSet<>(List.of(p1, p1, p1, p2, p3, p4, p5, p5));

        var names = new HashSet<String>();
        for (var a:attendees) {
            names.add(a.name());
        }

        var capitalizedNames = new HashSet<>();
        for (var n : names){
            capitalizedNames.add(n.toUpperCase());
        }

        // New way
        var capitalizedNames2 = attendees
                .stream()
                .map(a -> a.name())
                .map(n -> n.toUpperCase())
                .filter(n -> !n.startsWith("M"))
                .collect(Collectors.toSet());

        IO.println("=========");
        IO.println(capitalizedNames2);
        IO.println("=========");


        attendees.add(new Person("Ali", 1));
//        IO.println(attendees);
        var animals = List.of(
                new Dog("woofie"),
                new Cat("mimi"),
                new Fish("fifi")
        );

        for(var a : animals) {
            feedAnimal(a);
        }

        IO.println(area(new Circle(10)));

        var name = "Mohammed";
        var age = 18;

        var intro = "%s is %d years old"
                .formatted(name, age);
        var intro2 = String.format("%s is %d years old",
                                        name, age);
        IO.println(intro);

        var words = List.of("git",
                "docker",
                "java",
                "kafka",
                "quarkus");

        IO.println(words);

        // CAPITALISE ALL WORDS
        "mo".toUpperCase(); // == MO // example

        var capitalizedWords =
                words.stream().map(word -> word.toUpperCase()).toList();

        // Filter technology names with 4 or fewer words
        var filteredWords = capitalizedWords.stream().filter(capitalizedWord -> capitalizedWord.length() <= 4).toList();

        IO.println(capitalizedWords);
        IO.println(filteredWords);
    }

    static void feedAnimal(Animal animal) {
        switch (animal) {
            case Cat(var name) -> IO.println("feed %s fish".formatted(name));
            case Dog(var name) -> IO.println("feed %s chicken".formatted(name));
            case Fish(var name) -> IO.println("feed %s bread".formatted(name));
        }
    }

    static double area(Shape s) {
        var result = 0.0;

        switch(s) {
            case Circle circle when circle.r() <= 0 -> {
                result = 0;
            }

            case Square square when square.side() == 0 -> {
                result = 0;
            }

            case Circle circle -> {
                result = Math.PI * circle.r() * circle.r();
            }
            case Square square -> {
                result = square.side() * square.side();
            }
        }

        return result;
    }
}