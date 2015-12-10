package com.yipl.nrna.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yipl.nrna.domain.model.Question;
import com.yipl.nrna.ui.fragment.RecentQuestionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julian on 12/10/15.
 */
public class QuestionPagerAdapter extends FragmentPagerAdapter {
    FragmentManager mFragmentManager;
    List<Question> mQuestions;

    public QuestionPagerAdapter(FragmentManager pFragmentManager) {
        super(pFragmentManager);
        this.mFragmentManager = pFragmentManager;
        mQuestions = new ArrayList<>();
    }

    public void setQuestions(List<Question> pQuestions) {
        this.mQuestions = pQuestions;
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == mQuestions.size()) {
            return RecentQuestionFragment.newInstance(null);
        } else {
            return RecentQuestionFragment.newInstance(mQuestions.get(position));
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return FragmentStatePagerAdapter.POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mQuestions.size() + 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mQuestions.get(position).getQuestion();
    }
}
