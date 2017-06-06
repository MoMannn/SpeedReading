package com.tnt_development.speedreading.Util;

import com.tnt_development.speedreading.Model.SpritzWord;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

public class Sprintz {

    private int getPivot(String word)
    {
        int pivot = 4;
        switch (word.length())
        {
            case 0:
            case 1:
                pivot = 0;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                pivot = 1;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                pivot = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                pivot = 3;
                break;
            default:
                pivot = 4;
        };

        return pivot;
    }

    public SpritzWord getSprintzWord(String word)
    {
        SpritzWord spritzWord = new SpritzWord();
        if(word.length() > 0) {
            int pivot = getPivot(word);

            spritzWord.setPivot(word.substring(pivot, pivot + 1));
            spritzWord.setLeft(word.substring(0, pivot));
            spritzWord.setRight(word.substring(pivot + 1, word.length()));

        }
        return spritzWord;

    }
}
