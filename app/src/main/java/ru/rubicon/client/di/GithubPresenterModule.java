package ru.rubicon.client.di;

import dagger.Module;
import dagger.Provides;
import ru.rubicon.client.implementations.GitHubPresenterImpl;
import ru.rubicon.client.interfaces.IGitHubView;
import ru.rubicon.client.interfaces.IGitHubPresenter;

/**
 * Created by Витя on 02.11.2016.
 */

@Module
public class GitHubPresenterModule {

    private IGitHubView view;

    public GitHubPresenterModule(IGitHubView view){
        this.view = view;
    }

    @Provides
    IGitHubView provideIGitHubView(){
        return view;
    }

    @Provides
    IGitHubPresenter provideIGithubPresenter(){
        return new GitHubPresenterImpl(view);
    }
}
