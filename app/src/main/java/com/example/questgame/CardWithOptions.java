package com.example.questgame;

import java.util.HashMap;

public class CardWithOptions extends Card {
    private HashMap<String, Card> options = new HashMap<>();

    CardWithOptions(String text) {
        super(text);
    }

    void addOption(String text, Card card) {
        options.put(text, card);
    }

    HashMap<String, Card> getOptions() {
        return options;
    }

    String getVariant(int i) {

        Object[] opt = options.keySet().toArray();
        return (String) opt[i];
    }

    Card getCard(int i) {
        Object[] opt = options.keySet().toArray();
        return options.get((String) opt[i]);
    }
}
