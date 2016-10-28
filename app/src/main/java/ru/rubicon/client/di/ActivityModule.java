package ru.rubicon.client.di;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Витя on 28.10.2016.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity activity() {
        return this.activity;
    }
}