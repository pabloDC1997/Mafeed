package br.com.app.mafeed.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.app.mafeed.R;
import br.com.app.mafeed.business.services.rss.RSSClient;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    RSSClient service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.service = new RSSClient(this);
    }
}
