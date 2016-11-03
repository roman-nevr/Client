package ru.rubicon.client.implementations;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import ru.rubicon.client.interfaces.IGithubPresenter;
import ru.rubicon.client.interfaces.IGithubView;
import ru.rubicon.client.model.GitModel;

/**
 * Created by Витя on 02.11.2016.
 */

public class GithubPresenterImpl implements IGithubPresenter{

    private IGithubView view;

    @Inject
    public GithubPresenterImpl(IGithubView view) {
        this.view = view;
    }

    @Override
    public void getUser(String userName) {
        ServiceGenerator.GitAPI gitClient = ServiceGenerator.createService(ServiceGenerator.GitAPI.class);

        // асинхронный режим
        Call<GitModel> call = gitClient.user(userName);
        call.enqueue(new Callback<GitModel>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                // response.isSuccess() is true if the response code is 2xx
                if (response.isSuccess()) {
                    GitModel user = (GitModel) response.body();

                    // Получаем json из github-сервера и конвертируем его в удобный вид
                    view.setText("Аккаунт Github: " + user.getName() +
                            "\nСайт: " + user.getBlog() +
                            "\nКомпания: " + user.getCompany() +
                            "\n Repos: " + user.getReposUrl()
                    );

                } else {
                    int statusCode = response.code();

                    // handle request errors yourself
                    ResponseBody errorBody = response.errorBody();
                    try {
                        view.setText(errorBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // handle execution failures like no internet connectivity
                view.setText("Error occured while quering");
            }
        });
    }

    @Override
    public void getContributor(String contributor) {

    }
}

