package com.yipl.nrna.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yipl.nrna.R;
import com.yipl.nrna.base.BaseActivity;
import com.yipl.nrna.di.component.DaggerDataComponent;
import com.yipl.nrna.di.module.DataModule;
import com.yipl.nrna.domain.model.Post;
import com.yipl.nrna.domain.util.MyConstants;
import com.yipl.nrna.presenter.VideoDetailActivityPresenter;
import com.yipl.nrna.ui.adapter.CountryInfoPagerAdapter;
import com.yipl.nrna.ui.interfaces.VideoDetailActivityView;

import javax.inject.Inject;

import butterknife.Bind;

public class VideoDetailActivity extends BaseActivity implements VideoDetailActivityView {

    Long mId;

    @Inject
    VideoDetailActivityPresenter mPresenter;

    @Bind(R.id.data_container)
    CoordinatorLayout mDataContainer;
    @Bind(R.id.image)
    SimpleDraweeView mImage;
    @Bind(R.id.description)
    TextView mDescription;
    @Bind(R.id.progressBar)
    ProgressBar mProgressBar;

    private CountryInfoPagerAdapter mAdapter;

    public Post mVideo;

    @Override
    public int getLayout() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        if(data!= null){
            mId = data.getLong(MyConstants.Extras.KEY_ID, Long.MIN_VALUE);
            getSupportActionBar().setTitle(data.getString(MyConstants.Extras.KEY_TITLE));
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
        fetchDetail();
    }

    private void initialize(){
        DaggerDataComponent.builder()
                .activityModule(getActivityModule())
                .dataModule(new DataModule(mId))
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
        mPresenter.attachView(this);
    }

    private void fetchDetail() {
        mPresenter.initialize();
    }

    @Override
    public void renderVideoDetail(Post pVideo) {
        mVideo = pVideo;
        getSupportActionBar().setTitle(mVideo.getTitle());
        mImage.setImageURI(Uri.parse(mVideo.getData().getThumbnail()));
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mVideo.getData().getMediaUrl()));
                startActivity(intent);
            }
        });
        mDescription.setText(mVideo.getDescription());
    }

    @Override
    public void showLoadingView() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorView(String pErrorMessage) {
        Snackbar.make(mDataContainer, pErrorMessage, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideErrorView() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showRetryView() {
    }

    @Override
    public void hideRetryView() {
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void hideEmptyView() {

    }
}
