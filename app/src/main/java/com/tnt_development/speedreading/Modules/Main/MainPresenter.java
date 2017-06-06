package com.tnt_development.speedreading.Modules.Main;

import com.tnt_development.speedreading.Application.App;
import com.tnt_development.speedreading.Application.Global;
import com.tnt_development.speedreading.R;
import com.tnt_development.speedreading.Util.Sprintz;
import com.tnt_development.speedreading.Util.TextParser;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tadejvengust1 on 6. 06. 17.
 */

public class MainPresenter {

    @Inject
    MainView mainView;

    @Inject
    TextParser parser;

    @Inject
    Sprintz sprintz;

    @Inject
    public  MainPresenter(){}

    LinkedList<String> words;

    int refreshRate;

    public void showWords()
    {

        Flowable.fromCallable(new Callable<String>(){

            @Override
            public String call() throws Exception {

                loadWords();

                return "done";
            }
        }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mainView.hideLoading();
                display();
            }
        });

        refreshRate = 60000 / Global.wordsPerMinute;
    }

    private void loadWords()
    {
        try {
            words = parser.parseText();
        } catch (IOException e) {
            mainView.showToast(App.context().getString(R.string.errorReadingFile));
        }
    }

    private void display()
    {
        if(words.size() > 0) {

            mainView.showWord(sprintz.getSprintzWord(words.removeFirst()));

            Observable.timer(refreshRate, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<Long>() {
                        @Override
                        public void onNext(Long value) {
                            display();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }



}
