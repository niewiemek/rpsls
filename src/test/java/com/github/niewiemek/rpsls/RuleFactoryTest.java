package com.github.niewiemek.rpsls;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static com.github.niewiemek.rpsls.Figure.*;
import static com.github.niewiemek.rpsls.Rule.Result.DRAW;
import static com.github.niewiemek.rpsls.Rule.Result.LOOSE;
import static com.github.niewiemek.rpsls.Rule.Result.WIN;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(Parameterized.class)
public class RuleFactoryTest {

    private RuleFactory ruleFactory = new RuleFactory();

    @Parameterized.Parameters(name = "Fight: {0} {2} vs {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {SCISSORS, PAPER, WIN},
                {PAPER, SCISSORS, LOOSE},
                {PAPER, ROCK, WIN},
                {ROCK, PAPER, LOOSE},
                {ROCK, LIZZARD, WIN},
                {LIZZARD, ROCK, LOOSE},
                {LIZZARD, SPOCK, WIN},
                {SPOCK, LIZZARD, LOOSE},
                {SPOCK, SCISSORS, WIN},
                {SCISSORS, SPOCK, LOOSE},
                {SCISSORS, LIZZARD, WIN},
                {LIZZARD, SCISSORS, LOOSE},
                {LIZZARD, PAPER, WIN},
                {PAPER, LIZZARD, LOOSE},
                {PAPER, SPOCK, WIN},
                {SPOCK, PAPER, LOOSE},
                {SPOCK, ROCK, WIN},
                {ROCK, SPOCK, LOOSE},
                {ROCK, SCISSORS, WIN},
                {SCISSORS, ROCK, LOOSE},
                {ROCK, ROCK, DRAW},
                {PAPER, PAPER, DRAW},
                {SCISSORS, SCISSORS, DRAW},
                {LIZZARD, LIZZARD, DRAW},
                {SPOCK, SPOCK, DRAW}


        });

    }

    @Parameterized.Parameter
    public Figure fig1;

    @Parameterized.Parameter(1)
    public Figure fig2;

    @Parameterized.Parameter(2)
    public Rule.Result result;

    @Test
    public void testRule() {

        Rule rule = ruleFactory.createRule(fig1);

        Rule.Result duelResult = rule.duel(fig2);

        assertThat(duelResult).isEqualTo(result);
    }

}