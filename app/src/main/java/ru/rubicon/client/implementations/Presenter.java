package ru.rubicon.client.implementations;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

import ru.rubicon.client.model.User;
import ru.rubicon.client.interfaces.IPresenter;
import ru.rubicon.client.interfaces.IShowUser;
import ru.rubicon.client.ui.GitHubActivity;

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
    public void pressButtonNextUser() {
        view.showUser(new User());
    }

    @Override
    public void pressButtonNextActivity(Context context) {
        GitHubActivity.start(context);
    }
}
