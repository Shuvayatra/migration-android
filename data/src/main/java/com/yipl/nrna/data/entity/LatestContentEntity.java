package com.yipl.nrna.data.entity;

import java.util.List;

/**
 * Created by julian on 12/7/15.
 */
public class LatestContentEntity {
    MetaEntity meta;
    List<QuestionEntity> questions;
    List<PostEntity> posts;

    public MetaEntity getMeta() {
        return meta;
    }

    public void setMeta(MetaEntity pMeta) {
        meta = pMeta;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> pQuestions) {
        questions = pQuestions;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> pPosts) {
        posts = pPosts;
    }
}
