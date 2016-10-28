package ru.rubicon.client;

import android.app.Application;
import javax.inject.*;
import dagger.*;
import ru.rubicon.client.di.DaggerIPresenterComponent;
import ru.rubicon.client.di.IPresenterComponent;
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
        component = DaggerIPresenterComponent.builder().viewModule(new ViewModule(view)).build();;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setData(100500);

    }
}
