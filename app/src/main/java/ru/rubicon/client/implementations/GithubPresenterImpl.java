package ru.rubicon.client.implementations;

import android.view.View;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import ru.rubicon.client.interfaces.IGitHubPresenter;
import ru.rubicon.client.interfaces.IGitHubView;
import ru.rubicon.client.model.GitModel;

/**
 * Created by Витя on 02.11.2016.
 */

public class GitHubPresenterImpl implements IGitHubPresenter {

    private final IGitHubView view;

    @Inject
    public GitHubPresenterImpl(IGitHubView view) {
        this.view = view;
    }

    @Override
    public void requestUser(String userName) {
        ServiceGenerator.GitAPI gitClient = ServiceGenerator.createService(ServiceGenerator.GitAPI.class);

        // асинхронный режим
        Call<GitModel> call = gitClient.user(userName);
        view.showProgressBar();
        call.enqueue(new Callback<GitModel>() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                // response.isSuccess() is true if the response code is 2xx
                if (response.isSuccess()) {
                    GitModel user = (GitModel) response.body();
                    view.hideProgressBar();
                    // Получаем json из github-сервера и конвертируем его в удобный вид
                    view.setText("Аккаунт Github: " + user.getName() +
                            "\nСайт: " + user.getBlog() +
                            "\nКомпания: " + user.getCompany()
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
                view.hideProgressBar();
                // handle execution failures like no internet connectivity
                view.setText("Error occured while quering");
            }
        });
    }

    @Override
    public void requestContributors(String owner, String repo) {
        view.showProgressBar();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceGenerator.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // Create an instance of our GitHub API interface.
        ServiceGenerator.GitHub github = retrofit.create(ServiceGenerator.GitHub.class);

        // Create a call instance for looking up Retrofit contributors.
        Call<List<ServiceGenerator.Contributor>> call = github.contributors(owner, repo);
        call.enqueue(new Callback<List<ServiceGenerator.Contributor>>() {
            @Override
            public void onResponse(Response<List<ServiceGenerator.Contributor>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    view.hideProgressBar();
                    List<ServiceGenerator.Contributor> contributors = response.body();

                    for (ServiceGenerator.Contributor contributor : contributors) {
                        System.out.println(contributor.login + " (" + contributor.contributions + ")");
                    }
                    //view.hideProgressBar();
                    view.setText("Success, example: \n" + contributors.get(0).login);
                } else {
                    int statusCode = response.code();

                    // handle request errors yourself
                    ResponseBody errorBody = response.errorBody();
                    try {
                        view.setText(errorBody.string());
                        view.hideProgressBar();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                view.hideProgressBar();
                // handle execution failures like no internet connectivity
                view.setText("Error occured while quering");
            }
        });
    }
}

