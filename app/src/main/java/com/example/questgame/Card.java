package com.example.questgame;

public class Card {
    private String text;
    private Card nextCard;
    private Scene nextScene;

    Card(String text) {
        this.text = text;
    }

    Scene getNextScene() {
        return nextScene;
    }

    void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

    Card getNextCard() {
        return nextCard;
    }

    void setNextCard(Card nextCard) {
        this.nextCard = nextCard;
    }

    String getText() {
        return this.text;
    }
}
