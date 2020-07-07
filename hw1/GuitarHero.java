import es.datastructur.synthesizer.GuitarString;

import java.util.ArrayList;
import java.util.List;

public class GuitarHero {
    private static final double CONCERT_A = 440.0;


    public static double[] keyToConcert(String keys) {
        char[] keyArray = keys.toCharArray();
        double[] concertArray = new double[keyArray.length];
        /* create two guitar strings, for concert A and C */
        for (int i = 0; i < concertArray.length; i++) {
            concertArray[i] = CONCERT_A * Math.pow(2,(double)(i-24)/12.0);
        }
        return concertArray;
    }


    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        double[] CONCERTS = GuitarHero.keyToConcert(keyboard);

        GuitarString[] GS = new GuitarString[CONCERTS.length];
        for (int i = 0; i < CONCERTS.length; i ++) {
            GS[i] = new GuitarString(CONCERTS[i]);
        }
        GuitarString string = GS[0];

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int idx = keyboard.indexOf(key);
                if (keyboard.contains("" + key)) {
                    string = GS[idx];
                    string.pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = string.sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            string.tic();
        }
    }
}

