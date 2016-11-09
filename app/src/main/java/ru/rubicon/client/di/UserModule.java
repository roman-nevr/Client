package ru.rubicon.client.di;

import dagger.Module;
import dagger.Provides;
import ru.rubicon.client.di.scope.UserScope;
import ru.rubicon.client.model.Age;
import ru.rubicon.client.model.User;

/**
 * Created by Витя on 09.11.2016.
 */
@Module
public class UserModule {

    @UserScope
    @Provides
    User provideUser(){
        return new User();
    }

    @UserScope
    @Provides
    Age provideAge(){
        return new Age();
    }
}
