package animal;

public record Cat(String name) implements Animal {
    public static int NUM_OF_LEGS = 4;


    public void meow() {
        IO.println("Meow!");
    }
}
