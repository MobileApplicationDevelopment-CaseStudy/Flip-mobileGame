package com.flip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.GridLayout;

public class MemoryButton extends androidx.appcompat.widget.AppCompatButton {
    protected int rowCount;
    protected int columnCount;
    protected int frontImageIDs;

    protected Drawable frontImages;
    protected Drawable backImage;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    public MemoryButton(Context context, int rowCount, int columnCount, int frontImageIDs) {
        super(context);

        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.frontImageIDs = frontImageIDs;

        frontImages = getResources().getDrawable(frontImageIDs);
        backImage = getResources().getDrawable(R.drawable.cardback_optimized);

        setBackground(backImage); //sets the backImage of card

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(rowCount), GridLayout.spec(columnCount));

        tempParams.width = (int) getResources().getDisplayMetrics().density * 50;
        tempParams.height = (int) getResources().getDisplayMetrics().density * 60;

        setLayoutParams(tempParams);
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontImageIDs() {
        return frontImageIDs;
    }

    public void flip() {
        if (isMatched) {
            return;
        }
        if (isFlipped) {
            setBackground(backImage);
            isFlipped = false;
        } else {
            setBackground(frontImages);
            isFlipped = true;
        }
    }

}
