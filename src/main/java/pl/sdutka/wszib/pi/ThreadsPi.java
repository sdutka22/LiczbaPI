package pl.sdutka.wszib.pi;
import java.util.Random;

public class ThreadsPi implements Runnable {
    Random rand = new Random();
    @Override
    public void run() {
        int totalShots = 10000;
        int hitsInsideCircle = 0;
        double r = 1;

        for(int i = 0; i < totalShots; i++){
            double x = 2 * rand.nextDouble() - 1;
            double y = 2 * rand.nextDouble() - 1;

            if (Math.sqrt((x * x) + (y * y)) <= r) {
                hitsInsideCircle++;
            }
        }
        synchronized (App.class) {
            App.totalShots += totalShots;
            App.circleHits += hitsInsideCircle;
        }
    }
}
