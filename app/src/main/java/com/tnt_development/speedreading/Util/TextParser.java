package com.tnt_development.speedreading.Util;

import android.util.Log;

import com.tnt_development.speedreading.Application.App;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

public class TextParser {

    public LinkedList<String> parseText() throws IOException {
        LinkedList<String> words;
        String contents = new Scanner(new DataInputStream(App.context().getAssets().open("text.txt"))).useDelimiter("\\Z").next();

        words = new LinkedList<>(Arrays.asList(contents.replace("\n"," ").trim().replaceAll(" +", " ").split(" ")));

        return words;
    }
}
