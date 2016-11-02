package ru.rubicon.client.di;

import dagger.Component;
import ru.rubicon.client.interfaces.IGitHubPresenter;
import ru.rubicon.client.interfaces.IGitHubView;
import ru.rubicon.client.ui.GitHubActivity;
import ru.rubicon.client.ui.MainActivity;
import ru.rubicon.client.interfaces.IPresenter;

/**
 * Created by Витя on 28.10.2016.
 */

public class Components {

    @Component(modules = {ViewModule.class})
    public interface IPresenterComponent {
        void inject(MainActivity mainActivity);

        IPresenter getPresenter();
    }

    @Component(modules = {GitHubPresenterModule.class})
    public interface IGitHubComponent {
        void inject(GitHubActivity view);

        IGitHubPresenter getGitHubPresenter();
    }

}


