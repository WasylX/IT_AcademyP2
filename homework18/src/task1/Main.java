package task1;

public class Main {
    public static void main(String[] args) {
        CelestialBody sun = Sun.getInstance();
        CelestialBody moon = Moon.getInstance();
        CelestialBody earth = Earth.getInstance();

        sun.shine();
        moon.orbit();
        earth.rotate();

    }
}
