package ru.rubicon.client.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;
import ru.rubicon.client.interfaces.IGitHubPresenter;
import ru.rubicon.client.model.Age;
import ru.rubicon.client.model.User;
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

        IPresenter plusPresenter();
    }

    @Singleton
    @Component(modules = AgeModule.class)
    public interface IUserComponent {
        void inject(User user);
    }

    @Component(modules = {GitHubPresenterModule.class})
    public interface IGitHubComponent {
        void inject(GitHubActivity view);

        IGitHubPresenter plusGitHubPresenter();
    }

}


