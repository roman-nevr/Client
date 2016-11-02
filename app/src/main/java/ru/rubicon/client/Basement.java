package ru.rubicon.client;

import android.app.Application;

import ru.rubicon.client.di.Components.IPresenterComponent;

import ru.rubicon.client.di.DaggerComponents_IPresenterComponent;
import ru.rubicon.client.di.ViewModule;
import ru.rubicon.client.interfaces.IShowUser;


/**
 * Created by Витя on 24.10.2016.
 */

public class Basement extends Application {

    private float data;
    private static IPresenterComponent component;

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public static IPresenterComponent getComponent() {
        return component;
    }

    public static void setComponent(IShowUser view) {
        component = DaggerComponents_IPresenterComponent.builder().viewModule(new ViewModule(view)).build();;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setData(100500);

    }
}
