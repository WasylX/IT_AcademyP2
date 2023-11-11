package task1;

public class Sun implements CelestialBody{

    private static Sun instance = new Sun();

    private Sun() {
    }


    public static Sun getInstance() {
        return instance;
    }

    @Override
    public void rotate() {
        System.out.println("Sun isn't rotating");
    }

    @Override
    public void orbit() {
        System.out.println("Sun is in orbit");
    }

    @Override
    public void shine() {
        System.out.println("Sun is shining");
    }
}
