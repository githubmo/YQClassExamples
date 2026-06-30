package animal;

public sealed interface Animal permits Cat, Dog, Fish {
    public String name();
}