package com.tnt_development.speedreading.Modules.Main;

import com.tnt_development.speedreading.Model.SpritzWord;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

public interface MainView {
    void showWord(SpritzWord word);

    void showToast(String message);

    void hideLoading();
}
