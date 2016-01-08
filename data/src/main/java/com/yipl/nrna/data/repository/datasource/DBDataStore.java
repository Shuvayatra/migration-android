package com.yipl.nrna.data.repository.datasource;

import com.yipl.nrna.data.database.DatabaseDao;
import com.yipl.nrna.data.entity.AnswerEntity;
import com.yipl.nrna.data.entity.CountryEntity;
import com.yipl.nrna.data.entity.CountryUpdateEntity;
import com.yipl.nrna.data.entity.PostEntity;
import com.yipl.nrna.data.entity.QuestionEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Nirazan-PC on 12/9/2015.
 */
public class DBDataStore implements IDataStore {

    DatabaseDao database;

    @Inject
    public DBDataStore(DatabaseDao database) {
        this.database = database;
    }

    public Observable<PostEntity> getPostById(Long pId) {
        return database.getPostById(pId);
    }

    public Observable<List<PostEntity>> getAllPosts(String pStage, String pType, int pLimit) {
        return database.getAllPosts(pStage, pType, pLimit);
    }

    public Observable<List<PostEntity>> getPostByQuestion(Long pQuestionId, String pStage, String
            pType, int pLimit) {
        return database.getPostByQuestion(pQuestionId, pStage, pType, pLimit);
    }

    public Observable<List<PostEntity>> getPostByAnswer(Long pAnswerId, String pStage, String
            pType, int pLimit) {
        return database.getPostByAnswer(pAnswerId, pStage, pType, pLimit);
    }

    public Observable<List<PostEntity>> getPostByCountry(Long pCountryId, String pStage, String
            pType, int pLimit) {
        return database.getPostByCountry(pCountryId, pStage, pType, pLimit);
    }

    public Observable<List<QuestionEntity>> getAllQuestion(String pStage, int pLimit) {
        return database.getAllQuestions(pStage, pLimit);
    }

    public Observable<List<AnswerEntity>> getAllAnswers(int limit) {
        return database.getAllAnswers(limit);
    }

    public Observable<List<AnswerEntity>> getAnswersByQuestion(Long pQuestionId, int pLimit) {
        return database.getAnswersByQuestion(pQuestionId, pLimit);
    }

    public Observable<List<CountryUpdateEntity>> getUpdatesByCountry(Long pCountryId, int pLimit) {
        return database.getUpdatesByCountry(pCountryId, pLimit);
    }

    public Observable<List<CountryEntity>> getAllCountries(int pLimit) {
        return database.getAllCountries(pLimit);
    }

    public Observable<CountryEntity> getCountryById(long pId) {
        return database.getCountryById(pId);
    }

    public Observable<List<String>> getTags() {
        return database.getTags();
    }

}

