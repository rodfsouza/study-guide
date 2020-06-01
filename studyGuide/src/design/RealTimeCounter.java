package design;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class RealTimeCounter {

    private static final int DEFAULT_SIZE = 300; //Correspond to 5 minutes.
    private final AtomicIntegerArray counter = new AtomicIntegerArray(DEFAULT_SIZE);
    private volatile int pos = 0;

    private static volatile RealTimeCounter INSTANCE;

    private RealTimeCounter() {
        PositionUpdater updater = new PositionUpdater(this);
        updater.start();
    }

    public static RealTimeCounter getInstance() {
        if (INSTANCE == null) {
            if (INSTANCE == null) {
                INSTANCE = new RealTimeCounter();
            }
        }
        return INSTANCE;
    }

    public void hit() {
        counter.getAndIncrement(pos);
    }

    public int get() {
        int total = 0;
        for (int i = 0; i < counter.length(); i++) {
            total += counter.get(i);
        }
        return total;
    }

    private void incrementPos() {
        int newPos = (pos + 1) % DEFAULT_SIZE;
        counter.set(newPos, 0);
        pos = newPos;
    }

    public class PositionUpdater extends TimerTask {

        private final RealTimeCounter realTimeCounter;
        private final Timer timer = new Timer(true);
        private final long DELAY_IN_MILLI = TimeUnit.SECONDS.toMillis(1);

        PositionUpdater(RealTimeCounter realTimeCounter) {
            this.realTimeCounter = realTimeCounter;
        }

        void start() {
            timer.schedule(this, DELAY_IN_MILLI);
        }

        @Override
        public void run() {
            realTimeCounter.incrementPos();
        }
    }
}
