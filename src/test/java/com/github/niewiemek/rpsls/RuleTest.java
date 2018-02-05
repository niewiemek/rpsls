package com.github.niewiemek.rpsls;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class RuleTest {


    private static Rule SPOCK_RULE = new Rule(Figure.SPOCK, Stream.of(Figure.ROCK, Figure.SCISSORS).collect(Collectors.toSet()));

    @Test
    public void spockWins() {

        assertThat(SPOCK_RULE.duel(Figure.ROCK)).isEqualTo(Rule.Result.WIN);
        assertThat(SPOCK_RULE.duel(Figure.SCISSORS)).isEqualTo(Rule.Result.WIN);
    }

    @Test
    public void spockLooses() {

        assertThat(SPOCK_RULE.duel(Figure.LIZZARD)).isEqualTo(Rule.Result.LOOSE);
        assertThat(SPOCK_RULE.duel(Figure.PAPER)).isEqualTo(Rule.Result.LOOSE);
    }

    @Test
    public void spockDrawsWithSpock() {

        assertThat(SPOCK_RULE.duel(Figure.SPOCK)).isEqualTo(Rule.Result.DRAW);
    }
}