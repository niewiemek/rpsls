package com.github.niewiemek.rpsls;

import java.util.Collections;
import java.util.Set;

/**
 * Game rule implements logic between figures. A figure always draw a battle agains itself.
 * It wins against some other figures while it looses to the remaining ones.
 */
public class Rule {

    private final Figure figure;
    private final Set<Figure> wins;

    public Rule(Figure figure, Set<Figure> wins) {
        this.figure = figure;
        this.wins = Collections.unmodifiableSet(wins);
    }

    public Result duel(Figure figure) {
        if(this.figure.equals(figure)) {
            return Result.DRAW;
        }

        return wins.contains(figure) ? Result.WIN : Result.LOOSE;
    }

    public static enum Result {
        WIN, DRAW, LOOSE;
    }
}
