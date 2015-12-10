package com.yipl.nrna.ui.adapter;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yipl.nrna.R;
import com.yipl.nrna.databinding.AudioDataBinding;
import com.yipl.nrna.databinding.QuestionDataBinding;
import com.yipl.nrna.databinding.VideoDataBinding;
import com.yipl.nrna.domain.model.BaseModel;
import com.yipl.nrna.domain.model.Post;
import com.yipl.nrna.domain.model.Question;

import java.util.List;

import butterknife.ButterKnife;

import static com.yipl.nrna.domain.util.MyConstants.Adapter.TYPE_AUDIO;
import static com.yipl.nrna.domain.util.MyConstants.Adapter.TYPE_QUESTION;
import static com.yipl.nrna.domain.util.MyConstants.Adapter.TYPE_VIDEO;

public class ListAdapter<T extends BaseModel> extends RecyclerView.Adapter<RecyclerView
        .ViewHolder> {

    List<T> mDataCollection;
    private final LayoutInflater mLayoutInflater;

    public ListAdapter(Context pContext) {
        this.mLayoutInflater = (LayoutInflater) pContext.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
    }

    public ListAdapter(Context pContext, List<T> pDataCollection) {
        mDataCollection = pDataCollection;
        this.mLayoutInflater = (LayoutInflater) pContext.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
    }

    public class QuestionsViewHolder extends RecyclerView.ViewHolder {

        public QuestionDataBinding mBinding;

        public QuestionsViewHolder(QuestionDataBinding binding) {
            super(binding.getRoot());
            ButterKnife.bind(this, binding.getRoot());
            this.mBinding = binding;
            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onListItemSelected(data.get(getAdapterPosition()));
                }
            });*/
        }
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder {

        public AudioDataBinding mBinding;

        public AudioViewHolder(AudioDataBinding binding) {
            super(binding.getRoot());
            ButterKnife.bind(this, binding.getRoot());
            this.mBinding = binding;
            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onListItemSelected(data.get(getAdapterPosition()));
                }
            });*/
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        public VideoDataBinding mBinding;

        public VideoViewHolder(VideoDataBinding binding) {
            super(binding.getRoot());
            ButterKnife.bind(this, binding.getRoot());
            this.mBinding = binding;
            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onListItemSelected(data.get(getAdapterPosition()));
                }
            });*/
        }
    }

    public void setDataCollection(List<T> pDataCollection) {
        mDataCollection = pDataCollection;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (mDataCollection != null) ? mDataCollection.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataCollection.get(position).getDataType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            default:
            case TYPE_QUESTION:
                QuestionDataBinding qBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout
                        .list_item_question, parent, false);
                viewHolder = new QuestionsViewHolder(qBinding);
                break;
            case TYPE_AUDIO:
                AudioDataBinding aBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout
                        .list_item_question, parent, false);
                viewHolder = new AudioViewHolder(aBinding);
                break;
            case TYPE_VIDEO:
                VideoDataBinding vBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout
                        .list_item_question, parent, false);
                viewHolder = new VideoViewHolder(vBinding);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_QUESTION:
                ((QuestionsViewHolder) holder).mBinding.setQuestion((Question) mDataCollection.get(position));
                break;
            case TYPE_AUDIO:
                ((AudioViewHolder) holder).mBinding.setAudio((Post) mDataCollection.get
                        (position));
                break;
            default:
            case TYPE_VIDEO:
                ((VideoViewHolder) holder).mBinding.setVideo((Post) mDataCollection.get
                        (position));
                break;
        }
    }
}