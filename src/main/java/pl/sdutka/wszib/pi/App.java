package pl.sdutka.wszib.pi;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static int totalShots = 0;
    public static int circleHits = 0;
    public static void main(String[] args) {
        double pi;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new ThreadsPi()));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e){
            System.out.println("Thread interrupted: " + e.getMessage());    
        }

        synchronized (App.class) {
            pi = 4.0 * ((double) circleHits / (double) totalShots);
        }

        String output = "Ilosc strzałów: " + totalShots + "\n" +
                "Ilosc trafień: " + circleHits + "\n" +
                "Wyliczone Pi: " + pi + "\n";
        System.out.println(output);
    }
}
