package com.flip.GraphicSetting;

import com.flip.Constants;

import java.util.HashSet;
import java.util.Random;

public class Easy_ButtonGraphicsSetting {
    private int[] buttonGraphicsEasy;
    private int BUTTON_GRAPHICS_COUNT_EASY;

    public int[] getButtonGraphicsEasy() {
        return buttonGraphicsEasy;
    }

    public void setButtonGraphicsEasy(int stage, int rows, int columns) {
        //Random rand = new Random();
        Constants contsX = new Constants();
        int[] frontOfCards = contsX.getFRONT_OF_CARDS();

        this.BUTTON_GRAPHICS_COUNT_EASY = (rows * columns) / 2; //always half of the row x column //determines the number of card a level will be using
        this.buttonGraphicsEasy = new int[BUTTON_GRAPHICS_COUNT_EASY];

        //hashset stores unique elements randomly
        HashSet<Integer> randNums = new HashSet<>();

        //randNums size must be = to frontOfCards length
        while (randNums.size() < BUTTON_GRAPHICS_COUNT_EASY) {
            Random rand = new Random();
            int randomInt = rand.nextInt(frontOfCards.length);
            randNums.add(randomInt);
        }

        //convert the hashSet into array
        Object[] randResult = randNums.toArray();


        setFrontOfCardsEasy(stage, frontOfCards, randResult, rows, columns);

    }

    private void setFrontOfCardsEasy(int stage, int[] frontOfCards, Object[] randResult, int rows, int columns) {
        if (stage == 1) { //2x2
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_EASY; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[i]];
            }
        }
        if (stage == 2) { //2x3
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_EASY; i++) {
                if (i % 2 == 0) {
                    this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[0]];
                } else {
                    this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[1]];
                }
            }
        }
        if (stage == 3) { //2x3
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_EASY; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[i]];
            }
        }
        if (stage == 4) { //2x4
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsEasy[i + 2] = frontOfCards[(int) randResult[1]];
            }
        }
        if (stage == 5) { //2x4
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[0]];
            }
            this.buttonGraphicsEasy[2] = frontOfCards[(int) randResult[1]];
            this.buttonGraphicsEasy[3] = frontOfCards[(int) randResult[2]];
        }
        if (stage == 6) {//2x4
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_EASY; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[i]];
            }
        }
        if (stage == 7) { //2x5
            for (int i = 0; i < 3; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[0]];
            }
            for (int i = 3; i < BUTTON_GRAPHICS_COUNT_EASY; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[1]];
            }
        }
        if (stage == 8) { //2x5
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[0]];
            }
            for (int i = 2; i < 4; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[1]];
            }
            this.buttonGraphicsEasy[4] = frontOfCards[(int) randResult[2]];
        }
        if (stage == 9) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[0]];
            }
            for (int i = 2; i < BUTTON_GRAPHICS_COUNT_EASY; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[i - 1]];
            }
        }
        if (stage == 10) {
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_EASY; i++) {
                this.buttonGraphicsEasy[i] = frontOfCards[(int) randResult[i]];
            }
        }
    }

}
