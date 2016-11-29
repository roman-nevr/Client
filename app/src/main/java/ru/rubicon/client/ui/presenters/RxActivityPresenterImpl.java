package ru.rubicon.client.ui.presenters;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;

import ru.rubicon.client.interfaces.RxConvention;
import ru.rubicon.client.model.git.GitUser;
import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Admin on 29.11.2016.
 */

public class RxActivityPresenterImpl implements RxConvention.IRxActivityPresenter {

    private RxConvention.IRxActivityView view;

    private Subscription mSubscription;

    public RxActivityPresenterImpl(RxConvention.IRxActivityView view) {
        this.view = view;
        init();
    }

    private void init() {
        /*mSubscription = Observable.combineLatest(
                RxTextView.textChanges(view.getEditText()),
                RxView.clicks(view.getAddButton()),
        )*/
        //mSubscription = myObservable.subscribe(i -> view.addText("" + i));
        Observable.just(new GitUser()).subscribe();
        //mSubscription = RxTextView.textChanges(view.getEditText()).subscribe();
    }

    @Override
    public void onButtonAddClick() {
        myObservable.subscribe(i -> view.addText("" + i));
    }

    Observable<Integer> myObservable = Observable.create(
            new Observable.OnSubscribe<Integer>() {
                @Override
                public void call(Subscriber<? super Integer> sub) {
                    sub.onNext(1);
                    sub.onCompleted();
                }
            }
    );
}
