package com.adeptimpulse.bucketdrops.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.adeptimpulse.bucketdrops.app.adapters.AdapterDrops;
import com.adeptimpulse.bucketdrops.app.beans.Drop;
import com.bumptech.glide.Glide;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ActivityMain extends AppCompatActivity {

    private Toolbar mToolbar;
    Button mBtnAdd;
    RecyclerView mRecyclerView;
    Realm mRealm;
    RealmResults<Drop> mResults;
    AdapterDrops mAdapterDrops;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_drops);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Drop.class).findAllAsync();
        mAdapterDrops = new AdapterDrops(this, mResults);
        mRecyclerView.setAdapter(mAdapterDrops);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }
        });
        setSupportActionBar(mToolbar);
        initBackgroundImage();

    }

    private RealmChangeListener mRealmChangeListener = new RealmChangeListener() {
        @Override
        public void onChange() {
            mAdapterDrops.update(mResults);

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        mResults.addChangeListener(mRealmChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mResults.removeChangeListener(mRealmChangeListener);
    }

    private void showDialogAdd() {
        DialogAdd dialogAdd = new DialogAdd();
        dialogAdd.show(getSupportFragmentManager(), "Add");
    }

    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this).load(R.drawable.background).centerCrop().into(background);
    }
}
