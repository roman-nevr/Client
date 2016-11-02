package ru.rubicon.client.di;

import dagger.Component;
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
}


