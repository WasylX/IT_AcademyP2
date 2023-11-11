package task1;

class Subsystem extends Thread {
    private final String name;
    private final Splitter splitter;

    public Subsystem(String name, Splitter splitter) {
        this.name = name;
        this.splitter = splitter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            splitter.splitAndSend(name + " message " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

