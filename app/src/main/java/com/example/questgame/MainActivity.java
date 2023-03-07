package com.example.questgame;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button firstButton;
    Button secondButton;
    ImageView background;
    TextView textField;
    StoryLine story;
    Handler handler;

    boolean firstButtonClicked;
    boolean cardWithChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        story = new StoryLine();
        story.build();




        handler = new Handler();
        background = (ImageView) findViewById(R.id.background);
        firstButton = (Button) findViewById(R.id.first_button);
        secondButton = (Button) findViewById(R.id.second_button);
        textField = (TextView) findViewById(R.id.textField);

        secondButton.setVisibility(GONE);

        nextStep();

        firstButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //button.setVisibility(GONE);
                //background.setImageResource(R.drawable.mirea);
                firstButtonClicked = true;
                nextStep();



            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //button.setVisibility(GONE);
                //background.setImageResource(R.drawable.mirea);
                firstButtonClicked = false;
                nextStep();


            }
        });

    }


    void nextStep() {

        Card c;

        if (cardWithChoice) {
            cardWithChoice = false;
            c = story.getCard(firstButtonClicked);
        }

        else {
            c = story.getCard();
        }

        if (c != null) updateText(c);
        else {

            updateScreen(story.getScene());
        }



    }

    void updateText(Card card) {
        if (card instanceof CardWithOptions) {

            cardWithChoice = true;

            firstButton.setVisibility(VISIBLE);
            secondButton.setVisibility(VISIBLE);

            CardWithOptions oC = (CardWithOptions) card;
            handler.removeCallbacksAndMessages(null);
            textField.setText("");
            DelayedPrinter.Word word = new DelayedPrinter.Word(27, card.getText());
            word.setOffset(30);
            DelayedPrinter.printText(word, textField, handler);

            firstButton.setText(oC.getVariant(0));
            secondButton.setText(oC.getVariant(1));
        }

        else {


            handler.removeCallbacksAndMessages(null);
            textField.setText("");
            DelayedPrinter.Word word = new DelayedPrinter.Word(25, card.getText());
            word.setOffset(30);
            DelayedPrinter.printText(word, textField, handler);
            //textField.setText(card.getText());
            firstButton.setText("ДАЛЬШЕ");
            secondButton.setVisibility(GONE);
        }


    }

    void updateScreen(Scene scene) {
        background.setImageResource(scene.getImageId());
        updateText(scene.getCard());
    }


}