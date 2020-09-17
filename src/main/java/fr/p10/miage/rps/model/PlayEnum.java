package fr.p10.miage.rps.model;

import java.util.List;
import java.util.Random;

public enum PlayEnum {
    ROCK,
    PAPER,
    SCISSORS;

    private static final List<PlayEnum> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PlayEnum randomPlay() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
