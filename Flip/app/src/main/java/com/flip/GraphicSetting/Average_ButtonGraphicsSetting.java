package com.flip.GraphicSetting;

import com.flip.Constants;

import java.util.HashSet;
import java.util.Random;

public class Average_ButtonGraphicsSetting {
    private int[] buttonGraphicsAve;
    private int BUTTON_GRAPHICS_COUNT_AVE;

    public int[] getButtonGraphicsAve() {
        return buttonGraphicsAve;
    }

    public void setButtonGraphicsAve(int stage, int rows, int columns) {
        //Random rand = new Random()
        Constants contsX = new Constants();
        int[] frontOfCards = contsX.getFRONT_OF_CARDS();

        this.BUTTON_GRAPHICS_COUNT_AVE = (rows * columns) / 2;
        this.buttonGraphicsAve = new int[BUTTON_GRAPHICS_COUNT_AVE];

        //hashset stores unique elements randomly
        HashSet<Integer> randNums = new HashSet<>();

        //randNums size must be = to frontOfCards length
        while (randNums.size() < BUTTON_GRAPHICS_COUNT_AVE) {
            Random rand = new Random();
            int randomInt = rand.nextInt(frontOfCards.length);
            randNums.add(randomInt);
        }

        //convert the hashSet into array
        Object[] randResult = randNums.toArray();

        setFrontOfCardsEasy(stage, frontOfCards, randResult, rows, columns);
    }

    private void setFrontOfCardsEasy(int stage, int[] frontOfCards, Object[] randResult, int rows, int columns) {
        if (stage == 1) { //4x4
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                if (i % 2 == 0) {
                    this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                } else {
                    this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[1]];
                }
            }
        }
        if (stage == 2) { //4x4
            for (int i = 0; i < 3; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 3] = frontOfCards[(int) randResult[1]];
            }
            for (int i = 6; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[2]];
            }
        }
        if (stage == 3) { //4x4
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsAve[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsAve[i + 6] = frontOfCards[(int) randResult[3]];
            }
        }
        if (stage == 4) { //4x4
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsAve[i + 4] = frontOfCards[(int) randResult[2]];
            }
            this.buttonGraphicsAve[6] = frontOfCards[(int) randResult[3]];
            this.buttonGraphicsAve[7] = frontOfCards[(int) randResult[4]];
        }
        if (stage == 5) { //4x4
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[1]];
            }
            for (int i = 4; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[i - 2]];
            }
        }
        if (stage == 6) { //4x4
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
            }
            for (int i = 2; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[i - 1]];
            }
        }
        if (stage == 7) { //4x4
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[i]];
            }
        }
        if (stage == 8) { //4x5
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                if (i % 2 == 0) {
                    this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                } else {
                    this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[1]];
                }
            }
        }
        if (stage == 9) { //4x5
            for (int i = 0; i < 4; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
            }
            for (int i = 4; i < 7; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsAve[i + 3] = frontOfCards[(int) randResult[2]];
            }
        }
        if (stage == 10) { //4x5
            for (int i = 0; i < 3; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 3] = frontOfCards[(int) randResult[1]];
            }
            for (int i = 6; i < 8; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[3]];
            }
        }
        if (stage == 11) { //4x5
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsAve[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsAve[i + 6] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsAve[i + 8] = frontOfCards[(int) randResult[4]];
            }
        }
        if (stage == 12) { //4x5
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsAve[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsAve[i + 6] = frontOfCards[(int) randResult[3]];
            }
            this.buttonGraphicsAve[8] = frontOfCards[(int) randResult[4]];
            this.buttonGraphicsAve[9] = frontOfCards[(int) randResult[5]];
        }
        if (stage == 13) { //4x5
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsAve[i + 4] = frontOfCards[(int) randResult[2]];
            }
            for (int i = 6; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[i-3]];
            }
        }
        if (stage == 14) { //4x5
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsAve[i + 2] = frontOfCards[(int) randResult[1]];
            }
            for (int i = 4; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[i-2]];
            }
        }
        if (stage == 15) { //4x5
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[0]];
            }
            for (int i = 2; i < BUTTON_GRAPHICS_COUNT_AVE; i++) {
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[i-1]];
            }
        }
        if (stage == 16) { //4x5
            for (int i = 0; i<BUTTON_GRAPHICS_COUNT_AVE; i++){
                this.buttonGraphicsAve[i] = frontOfCards[(int) randResult[i]];
            }
        }

    }


}
