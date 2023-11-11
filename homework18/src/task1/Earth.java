package task1;

class Earth implements CelestialBodies {
    private static final Earth instance = new Earth();

    private Earth() {
    }

    public static Earth getInstance() {
        return instance;
    }

    @Override
    public void rotate() {
        System.out.println("Earth is rotating");
    }

    @Override
    public void orbit() {
        System.out.println("Earth is in orbit");
    }

    @Override
    public void shine() {
        System.out.println("Earth isn't shining");
    }
}

