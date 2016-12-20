package ru.rubicon.client.model;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by Admin on 01.12.2016.
 */

public class StringProfileRepository {

    public  static final StringProfile NULL = new StringProfile(-1,"");
    private static final BehaviorSubject<StringProfile> mSubject = BehaviorSubject.create(NULL);
    private static final Object mSubjectLock = new Object();
    private static StringProfile stringProfile = NULL;

    public static Observable<StringProfile> getStringProfileObservable(){
        return mSubject;
    }

    public static void update(@NonNull  IStringProfileUpdater updater){
        synchronized (mSubjectLock){
            StringProfile.Builder builder = new StringProfile.Builder(stringProfile.getId(),
                                                                        stringProfile.getName());
            builder = updater.execute(builder);
            stringProfile = builder.build();
            mSubject.onNext(stringProfile);
        }
    }

    public interface IStringProfileUpdater{
        @NonNull StringProfile.Builder execute(StringProfile.Builder builder);
    }
}
