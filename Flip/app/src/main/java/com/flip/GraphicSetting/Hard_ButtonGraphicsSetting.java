package com.flip.GraphicSetting;

import com.flip.Constants;

import java.util.HashSet;
import java.util.Random;

public class Hard_ButtonGraphicsSetting {
    private int[] buttonGraphicsHard;
    private int BUTTON_GRAPHICS_COUNT_HARD; // always half of the row x column

    public int[] getButtonGraphicsHard() {
        return buttonGraphicsHard;
    }

    public void setButtonGraphicsHard(int stage, int rows, int columns) {
        //Random rand = new Random();
        Constants contsX = new Constants();
        int[] frontOfCards = contsX.getFRONT_OF_CARDS();

        this.BUTTON_GRAPHICS_COUNT_HARD = (rows * columns) / 2;
        this.buttonGraphicsHard = new int[BUTTON_GRAPHICS_COUNT_HARD];
        //stores unique elements
        HashSet<Integer> randNums = new HashSet<>();

        //randNums size must be = to frontOfCards length
        while (randNums.size() < BUTTON_GRAPHICS_COUNT_HARD) {
            Random rand = new Random();
            int randomInt = rand.nextInt(frontOfCards.length);
            randNums.add(randomInt);
        }

        //convert the hashSet into array
        Object[] randResult = randNums.toArray();

        setFrontOfCardsHard(stage, frontOfCards, randResult);
    }

    private void setFrontOfCardsHard(int stage, int[] frontOfCards, Object[] randResult) {
        if (stage == 1) {
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                if (i % 2 == 0) {
                    this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                } else {
                    this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[1]];
                }
            }
        }
        if (stage == 2) {
            for (int i = 0; i < 6; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 12] = frontOfCards[(int) randResult[2]];
            }
        }
        if (stage == 3) {
            for (int i = 0; i < 5; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 5] = frontOfCards[(int) randResult[1]];
            }
            for (int i = 10; i < 14; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[3]];
            }
        }
        if (stage == 4) {
            for (int i = 0; i < 4; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 8] = frontOfCards[(int) randResult[2]];
            }
            for (int i = 12; i < 15; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 3] = frontOfCards[(int) randResult[4]];
            }
        }
        if (stage == 5) {
            for (int i = 0; i < 3; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 3] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 9] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 12] = frontOfCards[(int) randResult[4]];
                this.buttonGraphicsHard[i + 15] = frontOfCards[(int) randResult[5]];
            }
        }
        if (stage == 6) {
            for (int i = 0; i < 3; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 3] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 9] = frontOfCards[(int) randResult[3]];
            }
            for (int i = 12; i < 14; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[4]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[5]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[6]];
            }
        }
        if (stage == 7) {
            for (int i = 0; i < 3; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 3] = frontOfCards[(int) randResult[1]];
            }
            for (int i = 6; i < 8; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[4]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[5]];
                this.buttonGraphicsHard[i + 8] = frontOfCards[(int) randResult[6]];
                this.buttonGraphicsHard[i + 10] = frontOfCards[(int) randResult[7]];
            }
        }
        if (stage == 8) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 8] = frontOfCards[(int) randResult[4]];
                this.buttonGraphicsHard[i + 10] = frontOfCards[(int) randResult[5]];
                this.buttonGraphicsHard[i + 12] = frontOfCards[(int) randResult[6]];
                this.buttonGraphicsHard[i + 14] = frontOfCards[(int) randResult[7]];
                this.buttonGraphicsHard[i + 16] = frontOfCards[(int) randResult[8]];
            }
        }
        if (stage == 9) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 8] = frontOfCards[(int) randResult[4]];
                this.buttonGraphicsHard[i + 10] = frontOfCards[(int) randResult[5]];
                this.buttonGraphicsHard[i + 12] = frontOfCards[(int) randResult[6]];
                this.buttonGraphicsHard[i + 14] = frontOfCards[(int) randResult[7]];
            }

            this.buttonGraphicsHard[16] = frontOfCards[(int) randResult[8]];
            this.buttonGraphicsHard[17] = frontOfCards[(int) randResult[9]];
        }
        if (stage == 10) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 8] = frontOfCards[(int) randResult[4]];
                this.buttonGraphicsHard[i + 10] = frontOfCards[(int) randResult[5]];
                this.buttonGraphicsHard[i + 12] = frontOfCards[(int) randResult[6]];
            }
            for (int i = 14; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i - 7]];
            }
        }
        if (stage == 11) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 8] = frontOfCards[(int) randResult[4]];
                this.buttonGraphicsHard[i + 10] = frontOfCards[(int) randResult[5]];
            }
            for (int i = 12; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i - 6]];
            }
        }
        if (stage == 12) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[3]];
                this.buttonGraphicsHard[i + 8] = frontOfCards[(int) randResult[4]];
            }
            for (int i = 10; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i - 5]];
            }
        }
        if (stage == 13) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[2]];
                this.buttonGraphicsHard[i + 6] = frontOfCards[(int) randResult[3]];
            }
            for (int i = 8; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i - 4]];
            }
        }
        if (stage == 14) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
                this.buttonGraphicsHard[i + 4] = frontOfCards[(int) randResult[2]];
            }
            for (int i = 6; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i - 3]];
            }

        }
        if (stage == 15) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
                this.buttonGraphicsHard[i + 2] = frontOfCards[(int) randResult[1]];
            }
            for (int i = 4; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i - 2]];
            }
        }
        if (stage == 16) {
            for (int i = 0; i < 2; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[0]];
            }
            for (int i = 2; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i - 1]];
            }
        }
        if (stage == 17) {
            for (int i = 0; i < BUTTON_GRAPHICS_COUNT_HARD; i++) {
                this.buttonGraphicsHard[i] = frontOfCards[(int) randResult[i]];
            }
        }

    }


}
/*
Stage1= 2 Images; Stage2= 3 Images; Stage3= 4 Images;
Stage4= 5 Images; Stage5= 6 Images; Stage6= 7 Images;
Stage7= 8 Images; Stage8= 9 Images; Stage9= 10 Images;

Stage10= 11 Images; Stage11= 12 Images; Stage12= 13 Images;
Stage13= 14 Images; Stage14= 15 Images; Stage15= 16 Images;
Stage16= 17 Images; Stage17= 18 Images;


 */