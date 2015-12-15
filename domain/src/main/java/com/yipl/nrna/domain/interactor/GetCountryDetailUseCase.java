package com.yipl.nrna.domain.interactor;

import com.yipl.nrna.domain.executor.PostExecutionThread;
import com.yipl.nrna.domain.executor.ThreadExecutor;
import com.yipl.nrna.domain.model.Country;
import com.yipl.nrna.domain.repository.IRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetCountryDetailUseCase extends UseCase<Country> {

    private final IRepository mRepository;
    private long mId;

    @Inject
    public GetCountryDetailUseCase(long pId, IRepository pRepository, ThreadExecutor
            pThreadExecutor, PostExecutionThread
                                           pPostExecutionThread) {
        super(pThreadExecutor, pPostExecutionThread);
        this.mId = pId;
        mRepository = pRepository;
    }

    @Override
    protected Observable<Country> buildUseCaseObservable() {
        return mRepository.getSingle(mId);
    }
}
