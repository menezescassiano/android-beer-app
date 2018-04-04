package com.cassianomenezes.mytransferwise.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.cassianomenezes.mytransferwise.R;
import com.cassianomenezes.mytransferwise.databinding.ActivityPlayerBinding;
import com.cassianomenezes.mytransferwise.entries.Player;
import com.cassianomenezes.mytransferwise.util.Constants;
import com.cassianomenezes.mytransferwise.viewmodel.PlayerViewModel;

import java.util.Objects;

public class PlayerActivity extends AppCompatActivity {

    private ActivityPlayerBinding binding;
    private PlayerViewModel viewModel;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleBundle();
        setupViewModel();
        setupBinding();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    private void handleBundle() {
        if (getIntent().getExtras() != null && getIntent().getExtras().size() > 0) {
            player = getIntent().getExtras().getParcelable(Constants.BUNDLE_PLAYER_INFO);
        } else {
            finish();
        }
    }

    private void setupViewModel() {
        viewModel = new PlayerViewModel(this, player);
    }

    private void setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player);
        binding.setViewModel(viewModel);
    }

    public ActivityPlayerBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityPlayerBinding binding) {
        this.binding = binding;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
