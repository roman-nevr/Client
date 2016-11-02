package ru.rubicon.client.di;

import dagger.Module;
import dagger.Provides;
import ru.rubicon.client.implementations.GithubPresenterImpl;
import ru.rubicon.client.interfaces.IGithubPresenter;
import ru.rubicon.client.interfaces.IGithubView;

/**
 * Created by Витя on 02.11.2016.
 */

@Module
public class GithubPresenterModule {

    private IGithubView view;

    public GithubPresenterModule(IGithubView view){
        this.view = view;
    }

    @Provides
    IGithubPresenter provideIGithubPresenter(){
        return new GithubPresenterImpl(view);
    }
}
