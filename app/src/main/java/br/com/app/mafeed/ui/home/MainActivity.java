package br.com.app.mafeed.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.app.mafeed.R;
import br.com.app.mafeed.business.model.RSSObject;
import br.com.app.mafeed.business.services.rss.RSSClient;
import br.com.app.mafeed.utils.ActivityUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainAdapter.AdapterCallback, RSSClient.RSSCallback {

    RSSClient service;
    List<RSSObject> rssObjectList;
    private MainAdapter mAdapter;

    @BindView(R.id.recycle_view_main) RecyclerView recyclerView;
    @BindView(R.id.main_progress_bar) ProgressBar mainProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.service = new RSSClient(this);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        rssObjectList = new ArrayList<>();
        initRecycleView();
    }

    private void initRecycleView() {
        mAdapter = new MainAdapter(this.rssObjectList,this, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        List<String> teste = new ArrayList<>();
        teste.add("http://pox.globo.com/");
        teste.add("https://jovemnerd.com.br/feed/");
        loadFeeds(teste);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_filter:
                //todo - implement
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void loadFeeds(final List<String> urls) {
        Toast.makeText(this,"Teste",Toast.LENGTH_SHORT).show();
        try {
            for (String url : urls) {
//                service.getRSS(url, MainActivity.this);
            }
        } catch (Exception e ){
            ActivityUtils.showErrorToast(this, e.getMessage());
        }
    }

    @Override
    public void onFeedClicked(int position, RSSObject rss) {

    }

    @Override
    public void onPreExecute() {
        mainProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onError() {
        mainProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(RSSObject rss) {
        mainProgressBar.setVisibility(View.GONE);
        rssObjectList.add(rss);
        mAdapter.notifyDataSetChanged();
    }
}