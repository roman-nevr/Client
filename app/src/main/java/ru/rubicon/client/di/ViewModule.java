package ru.rubicon.client.di;

import dagger.Module;
import dagger.Provides;
import ru.rubicon.client.implementations.Presenter;
import ru.rubicon.client.interfaces.IPresenter;
import ru.rubicon.client.interfaces.IShowUser;

/**
 * Created by Витя on 28.10.2016.
 */

@Module
public class ViewModule {

    private IShowUser mainActivity;

    public ViewModule(IShowUser view) {
        this.mainActivity = view;
    }

    @Provides
    IShowUser provideIShowUser(){
        return mainActivity;
    }

    @Provides
    IPresenter provideIPresenter(){
        return new Presenter(mainActivity);
    }
}
