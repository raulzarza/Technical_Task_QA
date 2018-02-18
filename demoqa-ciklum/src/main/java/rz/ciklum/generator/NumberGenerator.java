package rz.ciklum.generator;

import java.util.Random;

/**
 * Generator of random numbers
 */
public class NumberGenerator {

    Random random = new Random();

    public int randomNumberfrom0(int maxNumber) {
        return random.nextInt(maxNumber);
    }
}
