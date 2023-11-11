package task1;

public class Moon implements  CelestialBody{

    private static Moon instance = new Moon();

    private Moon() {
    }

    public static Moon getInstance() {
        return instance;
    }


    @Override
    public void rotate() {
        System.out.println("Moon is rotating");
    }

    @Override
    public void orbit() {
        System.out.println("Moon is in orbit");
    }

    @Override
    public void shine() {
        System.out.println("Moon is reflecting");
    }
}

