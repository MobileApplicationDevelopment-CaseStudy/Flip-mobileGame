package com.flip;

public class Constants {
    private final int[] FRONT_OF_CARDS = {
            R.drawable.card1_optimized, R.drawable.card2_optimized, R.drawable.card3_optimized, R.drawable.card4_optimized,
            R.drawable.card5_optimized, R.drawable.card6_optimized, R.drawable.card7_optimized, R.drawable.card8_optimized,
            R.drawable.card9_optimized, R.drawable.card10_optimized, R.drawable.card11_optimized, R.drawable.card12_optimized,
            R.drawable.card13_optimized, R.drawable.card14_optimized, R.drawable.card15_optimized, R.drawable.card16_optimized,
            R.drawable.card17_optimized, R.drawable.card18_optimized
    };

    private final String[] BUTTON_DB_NAMES = {
            "btnEasy", "btnEasy1", "btnEasy2", "btnEasy3", "btnEasy4", "btnEasy5", "btnEasy6",
            "btnEasy7", "btnEasy8", "btnEasy9", "btnEasy10",

            "btnAverage", "btnAverage1", "btnAverage2", "btnAverage3", "btnAverage4", "btnAverage5",
            "btnAverage6", "btnAverage7", "btnAverage8", "btnAverage9", "btnAverage10", "btnAverage11",
            "btnAverage12", "btnAverage13", "btnAverage14", "btnAverage15", "btnAverage16",

            "btnHard", "btnHard1", "btnHard2", "btnHard3", "btnHard4", "btnHard5", "btnHard6", "btnHard7",
            "btnHard8", "btnHard9", "btnHard10", "btnHard11", "btnHard12", "btnHard13", "btnHard14", "btnHard15",
            "btnHard16", "btnHard17",

            "btnEndless"
    };

    int[] btnIds = {
            R.id.btnEasy1, R.id.btnEasy2, R.id.btnEasy3, R.id.btnEasy4, R.id.btnEasy5,
            R.id.btnEasy6, R.id.btnEasy7, R.id.btnEasy8, R.id.btnEasy9, R.id.btnEasy10,
            R.id.btnAverage1, R.id.btnAverage2, R.id.btnAverage3, R.id.btnAverage4,
            R.id.btnAverage5, R.id.btnAverage6, R.id.btnAverage7, R.id.btnAverage8,
            R.id.btnAverage9, R.id.btnAverage10, R.id.btnAverage11, R.id.btnAverage12,
            R.id.btnAverage13, R.id.btnAverage14, R.id.btnAverage15, R.id.btnAverage16,
            R.id.btnHard1, R.id.btnHard2, R.id.btnHard3, R.id.btnHard4, R.id.btnHard5, R.id.btnHard6, R.id.btnHard7,
            R.id.btnHard8, R.id.btnHard9, R.id.btnHard10, R.id.btnHard11, R.id.btnHard12, R.id.btnHard13, R.id.btnHard14,
            R.id.btnHard15, R.id.btnHard16, R.id.btnHard17
    };

    public int[] getBtnIds() {
        return btnIds;
    }

    public String[] getBUTTON_DB_NAMES() {
        return BUTTON_DB_NAMES;
    }

    public int[] getFRONT_OF_CARDS() {
        return FRONT_OF_CARDS;
    }
}
