package ru.rubicon.client;

import android.app.Application;

import ru.rubicon.client.di.Components;
import ru.rubicon.client.di.Components.IPresenterComponent;
import ru.rubicon.client.di.Components.IGitHubComponent;
import ru.rubicon.client.di.DaggerComponents_IGitHubComponent;
import ru.rubicon.client.di.DaggerComponents_IPresenterComponent;
import ru.rubicon.client.di.GitHubPresenterModule;
import ru.rubicon.client.di.AgeModule;
import ru.rubicon.client.di.ViewModule;
import ru.rubicon.client.interfaces.IGitHubView;
import ru.rubicon.client.interfaces.IShowUser;


/**
 * Created by Витя on 24.10.2016.
 */

public class Basement extends Application {

    private float data;
    private static IPresenterComponent component;
    private static IGitHubComponent gitHubComponent;
    private static Components.IUserComponent userComponent;

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public static IPresenterComponent getComponent() {
        return component;
    }

    public static void setPresenterComponent(IShowUser view) {
        component = DaggerComponents_IPresenterComponent.builder().viewModule(new ViewModule(view)).build();
    }

    public static void setGitHubComponent(IGitHubView gitHubView){
        gitHubComponent = DaggerComponents_IGitHubComponent.builder().gitHubPresenterModule(new GitHubPresenterModule(gitHubView)).build();
    }

    public static IGitHubComponent getGitHubComponent(){
        return gitHubComponent;
    }

    public static Components.IUserComponent getUserComponent() {
        return userComponent;
    }

    public static void setUserComponent(Components.IUserComponent userComponent) {
        Basement.userComponent = userComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setData(100500);

    }
}
