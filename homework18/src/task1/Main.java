package task1;

public class Main {
    public static void main(String[] args) {
        CelestialBodies sun = Sun.getInstance();
        CelestialBodies moon = Moon.getInstance();
        CelestialBodies earth = Earth.getInstance();

        sun.shine();
        moon.orbit();
        earth.rotate();
    }
}

