package com.example.questgame;

public class StoryLine {

    Scene scene;

    void build() {

        Card card1 = new Card("Привет! Сегодня твой первый студенчесчкий день, ну что ты готов отправиться в путь?");
        Card card2 = new Card("Вот вы и приехали в свой любимый институт. Вас ждет чудесный день!");


        scene = new Scene(card1, R.drawable.room);

        Scene scene1 = new Scene(card2, R.drawable.mirea);

        card1.setNextScene(scene1);

        Card card3 = new Card("Ого! Да ты опаздываешь на пары к Дзержинскому! Это может плохо закончиться.");
        Card card4 = new Card("Скорее беги в А-15!");

        card2.setNextCard(card3);
        card3.setNextCard(card4);


        Card card5 = new Card("Ой! Совсем забыл, тебе же нужно обязательно оставить куртку в гардеробе. Иначе тебя могут не пустить на лекцию");
        CardWithOptions card6 = new CardWithOptions("Но в раздевалке такая большая очередь! Если сдавать куртку, то я обязательно опаздаю...");

        card5.setNextCard(card6);

        Scene dressingRoom = new Scene(card5, R.drawable.dressing_room);

        Card firstChoice = new Card("Ты решил не сдавать куртку, и преподаватель не пустил тебя на лекцию. Теперь староста поставит тебе пропуск.");
        Card secondChoice = new Card("Ты сдал куртку, но из-за этого слишком сильно опоздал на лекцию. Преподаватель не пустил тебя в кабинет, а староста поставил пропуск.");

        card6.addOption("Сдать куртку (стоять в очереди)", secondChoice);
        card6.addOption("Пойти на лекцию с курткой (не стоять в очереди)", firstChoice);


        Card card7 = new Card("Ну зато можно успеть поесть в столовке!");
        Scene stolovka = new Scene(card7, R.drawable.stolovka);


        firstChoice.setNextScene(stolovka);
        secondChoice.setNextScene(stolovka);






        Card card8 = new Card("Так, что тут у нас на обед...");




        Scene vibor_bluda = new Scene(card8, R.drawable.bluda);

        card7.setNextScene(vibor_bluda);

        CardWithOptions card9 = new CardWithOptions("Взять суп или взять салат?");


        card8.setNextCard(card9);

        Card card10 = new Card("Вы взяли суп, и он оказался очень вкусным. Теперь вы сыты.");
        Card card11 = new Card("Вы взяли салат, но в нем оказалось слишком много майонеза. Зря потратили деньги.");
        Card card12 = new Card("Ну, подкрепились, можно отправляться дальше на учебу. Теперь-то я точно попаду на лецию!");




        card9.addOption("ВЗЯТЬ СУП", card10);
        card9.addOption("ВЗЯТЬ САЛАТ", card11);



        Card card13 = new Card("Так, что тут у нас...");

        Scene lecture = new Scene(card13, R.drawable.lecture);

        card12.setNextScene(lecture);


        Card card14 = new Card("Матанализ! Очень важная дисциплина, но ваш друг предлагает поиграть в морской бой.");

        card13.setNextCard(card14);


        CardWithOptions decide = new CardWithOptions("Соглситься сыграть или продолжить заниматься?");

        Card firstopt = new Card("Вы всю пару играли в морской бой, в будущем на экзамене вы попадете на пересдачу");
        Card secondopt = new Card("Вы решили заниматься на лекции, а не играть в игры. Впоследствии на экзамене вы получили пятерку.");

        decide.addOption("ИГРАТЬ С ДРУГОМ", firstopt);
        decide.addOption("ПРОДОЛЖИТЬ ЗАНИМАТЬСЯ", secondopt);

        card14.setNextCard(decide);

        Card dayend = new Card("Вот учебный день и подошел к концу!");
        Card dayend1 = new Card("Сегодня вы хорошо потрудились и пора отправляться домой! Завтра будет отличный день!");

        dayend.setNextCard(dayend1);




        Scene dayEnd = new Scene(dayend, R.drawable.day_end);

        firstopt.setNextScene(dayEnd);
        secondopt.setNextScene(dayEnd);



        Card finalCard = new Card("Спасибо за прохождение MireaQuest! Надеюсь вам понравилось и было интересно играть!");


        Scene finalScene = new Scene(finalCard, R.drawable.street);

        dayend1.setNextScene(finalScene);



        card11.setNextCard(card12);
        card10.setNextCard(card12);


        card4.setNextScene(dressingRoom);


    }

    void setScene() {

    }

    Scene getScene() {
        return scene;
    }

    Card getCard(boolean firstButtonClicked) {

        Card tempCard = scene.getLastCard(firstButtonClicked);

        if (tempCard.getText().equals("")) {
            Scene tempScene = tempCard.getNextScene();
            if (tempScene == null) return new Card("END");
            else scene = tempScene;
        }

        return tempCard;
    }

    Card getCard() {
        Card tempCard = scene.getCard();

        if (tempCard == null) {

            Scene tempScene = scene.getNextScene();
            if (tempScene == null) return new Card("END");
            else {
                this.scene = tempScene;
            }

        }

        return tempCard;
    }
}
