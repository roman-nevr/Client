package ru.rubicon.client.di;

import dagger.Component;
import ru.rubicon.client.MainActivity;
import ru.rubicon.client.Presenter;
import ru.rubicon.client.interfaces.IPresenter;
import ru.rubicon.client.interfaces.IShowUser;

/**
 * Created by Витя on 28.10.2016.
 */

@Component(modules = {ViewModule.class})
public interface IPresenterComponent {
    void inject(MainActivity mainActivity);
    IPresenter getPresenter();
}
