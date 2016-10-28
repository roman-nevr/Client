package ru.rubicon.client;

import javax.inject.Inject;

import dagger.Module;
import ru.rubicon.client.entities.User;
import ru.rubicon.client.interfaces.IPresenter;
import ru.rubicon.client.interfaces.IShowUser;

/**
 * Created by Витя on 25.10.2016.
 */
public class Presenter implements IPresenter{

    private final IShowUser view;

    @Inject
    public Presenter(IShowUser view){
        this.view = view;
    }

    @Override
    public void pressButtonNext() {
        view.show(new User());
    }
}
