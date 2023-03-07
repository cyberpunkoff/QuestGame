package com.example.questgame;

public class Scene {

    private int imageId;
    private Card currentCard;
    private Card lastCard;
    private Scene nextScene;

    Scene(Card currentCard, int imageId) {
        this.currentCard = currentCard;
        this.imageId = imageId;
    }

    int getImageId() {
        return imageId;
    }

    void setImageId(int imageId) {
        this.imageId = imageId;
    }

    Card getLastCard(boolean firstButtonClicked) {

        Card tempCard;

        if (firstButtonClicked) tempCard = ((CardWithOptions) lastCard).getCard(0);
        else tempCard = ((CardWithOptions) lastCard).getCard(1);
        currentCard = tempCard.getNextCard();
        if (currentCard == null) nextScene = tempCard.getNextScene();
        return tempCard;
    }

    Card getCard() {
        if (currentCard == null) return null;
        Card tempCard = currentCard;
        lastCard = currentCard;
        if (currentCard.getNextCard() == null) {
            this.nextScene = currentCard.getNextScene();
        }
        currentCard = currentCard.getNextCard();
        return tempCard;
    }

    Scene getNextScene() {
        return nextScene;
    }

    void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

}
