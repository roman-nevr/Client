package ru.rubicon.client.implementations.observables;

import ru.rubicon.client.model.StringProfile;
import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by Admin on 30.11.2016.
 */

public class Observables {

    public static Observable<StringProfile> stringProfileObservable = getTimerObesrvable(2000);

    private static Observable<StringProfile> getTimerObesrvable(int time){
        return Observable.create(new Observable.OnSubscribe<StringProfile>() {
            Thread thread;
            @Override
            public void call(Subscriber<? super StringProfile> subscriber) {
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (!subscriber.isUnsubscribed()){
                            subscriber.onNext(new StringProfile(123, " on another thread " +
                                    stringProfileObservable.toString()));
                            try {
                                thread.sleep(time);
                            } catch (InterruptedException e) {
                                subscriber.onError(e);
                            }
                        }
                        subscriber.onCompleted();
                    }
                });
                thread.start();
            }
        });
    }
}
