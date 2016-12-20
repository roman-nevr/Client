package ru.rubicon.client.implementations;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.security.auth.Subject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.rubicon.client.implementations.observables.Observables;
import ru.rubicon.client.interfaces.IGitHubPresenter;
import ru.rubicon.client.interfaces.IGitHubView;
import ru.rubicon.client.model.StringProfile;
import ru.rubicon.client.model.git.File;
import ru.rubicon.client.model.git.Files;
import ru.rubicon.client.model.git.Gist;
import ru.rubicon.client.model.git.GitUser;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

/**
 * Created by Витя on 02.11.2016.
 */

public class GitHubPresenterImpl implements IGitHubPresenter {

    private final IGitHubView view;
    private Subscription subscription, subscription2;
    private PublishSubject<StringProfile> subject;

    @Inject
    public GitHubPresenterImpl(IGitHubView view) {
        this.view = view;
        /*subject = PublishSubject.create();
        subscription = Observables.stringProfileObservable.
                observeOn(AndroidSchedulers.mainThread()).subscribe(subject);
        subject.subscribe(new MySubscriber());
        subject.subscribe(new MySubscriber());*/
    }

    @Override
    public void requestUser(String userName) {
        ServiceGenerator.GitAPI gitClient = ServiceGenerator.createService(ServiceGenerator.GitAPI.class);

        // асинхронный режим
        Call<GitUser> call = gitClient.user(userName);
        view.showProgressBar();
        call.enqueue(new Callback<GitUser>() {
            @Override
            public void onResponse(Call<GitUser> call, Response<GitUser> response) {
                view.setText(call.toString()+ "\n" + response.toString());
            }

            @Override
            public void onFailure(Call<GitUser> call, Throwable t) {

            }


            /*@Override
            public void onResponse(Response response, Retrofit retrofit) {
                // response.isSuccess() is true if the response code is 2xx
                if (response.isSuccess()) {
                    GitUser user = (GitUser) response.body();
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
            }*/
        });
    }

    @Override
    public void requestContributors(String owner, String repo) {
        view.showProgressBar();
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceGenerator.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/
        // Create an instance of our GitHub API interface.
        ServiceGenerator.GitAPI github = ServiceGenerator.createService(ServiceGenerator.GitAPI.class);

        // Create a call instance for looking up Retrofit contributors.
        Call<List<ServiceGenerator.Contributor>> call = github.contributors(owner, repo);
        call.enqueue(new Callback<List<ServiceGenerator.Contributor>>() {
            @Override
            public void onResponse(Call<List<ServiceGenerator.Contributor>> call, Response<List<ServiceGenerator.Contributor>> response) {
                view.setText(call.toString()+ "\n" + response.toString());
            }

            @Override
            public void onFailure(Call<List<ServiceGenerator.Contributor>> call, Throwable t) {

            }



            /*@Override
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
            }*/
        });
    }

    @Override
    public void loginRequest(String login, String password) {
        ServiceGenerator.GitAPI loginService =
                ServiceGenerator.createService(ServiceGenerator.GitAPI.class, login, password);
        Call<GitUser> call = loginService.basicLogin();
        call.enqueue(new Callback<GitUser>() {
            @Override
            public void onResponse(Call<GitUser> call, Response<GitUser> response) {
                if(response.body() != null){
                    view.setText(response.body().getName());
                }else {
                    //view.setText(call.toString()+ "\n" + response.toString());
                    try {
                        view.setText(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<GitUser> call, Throwable t) {

            }
        });
    }

    @Override
    public void emailRequest(String login, String password) {
        ServiceGenerator.GitAPI loginService =
                ServiceGenerator.createService(ServiceGenerator.GitAPI.class, login, password);
        Call<List<GitUser>> call = loginService.getEmails();
        call.enqueue(new Callback<List<GitUser>>() {
            @Override
            public void onResponse(Call<List<GitUser>> call, Response<List<GitUser>> response) {
                if(response.body() != null){
                    view.setText(response.body().get(0).getEmail());
                }else {
                    //view.setText(call.toString()+ "\n" + response.toString());
                    try {
                        view.setText(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<GitUser>> call, Throwable t) {

            }
        });
    }

    @Override
    public void checkEvents() {

        Gson gson = new  GsonBuilder().setPrettyPrinting().create();
        Gist gist = new Gist();
        gist.setDescription("32423");
        String json = gson.toJson(gist);

        List<File> files = new ArrayList<>();
        files.add(new File("first", "plain", null, "", 2));
        //files.add(new File("first1", "plain", null, "", 3));

        json = gson.toJson(new Files(files));


        view.setText(json);

    }

    @Override
    public void onStop() {
        //subscription.unsubscribe();
    }

    class MySubscriber extends Subscriber<StringProfile>{
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            view.setText("Ошибка!");
            view.showProgressBar();
        }

        @Override
        public void onNext(StringProfile stringProfile) {
            view.addText("id " + stringProfile.getId() + ", name " + stringProfile.getName());
        }
    }
}

