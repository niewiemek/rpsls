package com.github.niewiemek.rpsls;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RuleFactory {

    private final Map<Figure, Rule> rules;

    public RuleFactory() {
        rules = new HashMap<>();

        rules.put(Figure.ROCK, new Rule(Figure.ROCK, createSet(Figure.LIZZARD, Figure.SCISSORS)));
        rules.put(Figure.PAPER, new Rule(Figure.PAPER, createSet(Figure.ROCK, Figure.SPOCK)));
        rules.put(Figure.SCISSORS, new Rule(Figure.SCISSORS, createSet(Figure.PAPER, Figure.LIZZARD)));
        rules.put(Figure.LIZZARD, new Rule(Figure.LIZZARD, createSet(Figure.SPOCK, Figure.PAPER)));
        rules.put(Figure.SPOCK, new Rule(Figure.SPOCK, createSet(Figure.SCISSORS, Figure.ROCK)));
    }

    public Rule createRule(Figure figure) {
        return rules.get(figure);
    }

    private Set<Figure> createSet(Figure... figures) {
        return Stream.of(figures).collect(Collectors.toSet());
    }
}
