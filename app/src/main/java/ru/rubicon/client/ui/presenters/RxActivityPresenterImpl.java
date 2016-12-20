package ru.rubicon.client.ui.presenters;

import android.support.annotation.NonNull;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;

import ru.rubicon.client.Basement;
import ru.rubicon.client.implementations.observables.Observables;
import ru.rubicon.client.interfaces.RxConvention;
import ru.rubicon.client.model.StringProfile;
import ru.rubicon.client.model.StringProfileRepository;
import ru.rubicon.client.model.git.GitUser;
import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Admin on 29.11.2016.
 */

public class RxActivityPresenterImpl implements RxConvention.IRxActivityPresenter {

    private RxConvention.IRxActivityView view;

    private Subscription mSubscription, mSubscription2;

    private StringProfile currentStringProfile;

    public RxActivityPresenterImpl(RxConvention.IRxActivityView view) {
        this.view = view;
        init();
    }

    private void init() {
        currentStringProfile = StringProfileRepository.NULL;
        mSubscription = StringProfileRepository.getStringProfileObservable().map(i -> {return i.toBuilder().setName(i.getName() + " intercepted").build();}).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new RxActivitySubscriber());
        /*mSubscription2 = Observables.stringProfileObservable.
                observeOn(AndroidSchedulers.mainThread()).subscribe(new RxActivitySubscriber());*/
        RxView.clicks(view.getAddButton()).subscribe(o -> StringProfileRepository.update(new StringProfileUpdater()));
    }

    @Override
    public void onButtonAddClick() {
        //StringProfileRepository.update(new StringProfileUpdater());
    }

    @Override
    public void onStop() {
        mSubscription.unsubscribe();
        //mSubscription2.unsubscribe();
    }

    private class RxActivitySubscriber extends Subscriber<StringProfile>{
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            view.addText(e.toString());
        }

        @Override
        public void onNext(StringProfile stringProfile) {
            /*if (!stringProfile.equals(currentStringProfile)){
                view.addText(stringProfile.toString());
                currentStringProfile = stringProfile;
            }*/
            view.addText(stringProfile.toString());
            currentStringProfile = stringProfile;
        }
    }

    private class StringProfileUpdater implements StringProfileRepository.IStringProfileUpdater{
        @NonNull
        @Override
        public StringProfile.Builder execute(StringProfile.Builder builder) {
            builder.setName(view.getName());
            builder.setId(builder.getId() + 1);
            return builder;
        }
    }
}
