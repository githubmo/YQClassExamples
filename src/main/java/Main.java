import animal.Cat;
import finance.Money;

import java.math.BigDecimal;

public class Main {



    public static void main(String[] args) {

        var cat = new Cat();
        cat.meow();

        IO.println("===========");
        IO.println("hello world");
        IO.println("============");

        var cat2 = new Cat();
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



    }
}
