package ru.rubicon.client.di;

import android.app.Activity;

import dagger.Component;
import dagger.Subcomponent;
import ru.rubicon.client.di.scope.UserScope;
import ru.rubicon.client.interfaces.IGitHubPresenter;
import ru.rubicon.client.interfaces.IGitHubView;
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
        IUserComponent newComponent(UserModule module);
    }

    @UserScope
    @Subcomponent(modules = UserModule.class)
    public interface IUserComponent {
        User plusUser();
        Age plusAge();

        void inject(MainActivity activity);
    }

    @Component(modules = {GitHubPresenterModule.class})
    public interface IGitHubComponent {
        void inject(GitHubActivity view);

        IGitHubPresenter plusGitHubPresenter();
    }

}


