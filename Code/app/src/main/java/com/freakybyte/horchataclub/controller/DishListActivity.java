package com.freakybyte.horchataclub.controller;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.freakybyte.horchataclub.R;
import com.freakybyte.horchataclub.controller.adapter.AllDishListAdapter;
import com.freakybyte.horchataclub.listener.RecyclerListListener;
import com.freakybyte.horchataclub.model.DishModel;
import com.freakybyte.horchataclub.parse.DishListParse;
import com.freakybyte.horchataclub.util.DebugUtil;
import com.freakybyte.horchataclub.web.HorchataRestClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by kokusho on 2/29/16.
 */
public class DishListActivity extends MainActivity implements RecyclerListListener {

    public static final String TAG = "DishListActivity";

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mRecyclerManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView txtEmptyList;

    private AllDishListAdapter mAdapter;

    private ArrayList<DishModel> aDish = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_list);

        getRecyclerView().setHasFixedSize(true);

        getLayoutManager();

        getSwipeRefreshLayout().setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllDishes();
            }
        });

        getAllDishes();

        new ParticleSystem(this, 1000, R.drawable.canela_oval, 10000, R.id.background_hook)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.emiter_top_left), 32);

    }

    private void getAllDishes() {
        HorchataRestClient.getAllHorchataList(new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                aDish = DishListParse.getAllDishes(responseBody);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getRecyclerAdapter().setListDishes(aDish);
                        getTxtEmptyList().setVisibility(aDish.isEmpty() ? View.VISIBLE : View.GONE);
                    }
                });

                DebugUtil.logDebug(TAG, "Status Code:: " + statusCode + " Dishes:: " + aDish.size());

                onFinish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                onFinish();
            }

            @Override
            public void onFinish() {
                hideLoaders();
            }
        });
    }

    private void hideLoaders() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getSwipeRefreshLayout().setRefreshing(false);
            }
        });
    }


    @Override
    public void OnItemClickListener(int iPosition) {
        DebugUtil.logDebug(TAG, "Click on:: " + iPosition);
    }

    private LinearLayoutManager getLayoutManager() {
        if (mRecyclerManager == null) {
            mRecyclerManager = new LinearLayoutManager(this);
            getRecyclerView().setLayoutManager(mRecyclerManager);
            getRecyclerView().setAdapter(getRecyclerAdapter());
        }
        return mRecyclerManager;
    }

    private RecyclerView getRecyclerView() {
        if (mRecyclerView == null)
            mRecyclerView = (RecyclerView) findViewById(R.id.list_all_dishes);
        return mRecyclerView;
    }

    private AllDishListAdapter getRecyclerAdapter() {
        if (mAdapter == null)
            mAdapter = new AllDishListAdapter(DishListActivity.this, DishListActivity.this);
        return mAdapter;
    }

    private SwipeRefreshLayout getSwipeRefreshLayout() {
        if (swipeRefreshLayout == null)
            swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        return swipeRefreshLayout;
    }

    private TextView getTxtEmptyList() {
        if (txtEmptyList == null)
            txtEmptyList = (TextView) findViewById(R.id.txt_empty_list);
        return txtEmptyList;
    }

}
