package com.tnt_development.speedreading.Modules.Main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tnt_development.speedreading.DI.Component.DaggerMainComponent;
import com.tnt_development.speedreading.DI.Component.MainComponent;
import com.tnt_development.speedreading.DI.Module.MainModule;
import com.tnt_development.speedreading.Model.SpritzWord;
import com.tnt_development.speedreading.R;
import com.tnt_development.speedreading.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    private ActivityMainBinding binding;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainComponent component = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();

        component.injectMainActivity(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivityHandlers(this);

        mainPresenter.showWords();
    }

    @Override
    public void showWord(SpritzWord word) {
        binding.setWord(word);

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        binding.loading.setVisibility(View.GONE);
    }
}
