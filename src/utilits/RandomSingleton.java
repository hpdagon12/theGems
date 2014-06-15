package utilits;

import java.util.Random;


public class RandomSingleton {
    private static Random r;

    private RandomSingleton(){
    }

    public static synchronized Random getRandom(){
        if (r == null){
            r = new Random();
        }
        return r;
    }
}