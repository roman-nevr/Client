package ru.rubicon.client.interfaces;

/**
 * Created by Витя on 02.11.2016.
 */

public interface IGitHubPresenter {
    void requestUser(String user);
    void requestContributors(String owner, String repo);
    void loginRequest(String login, String password);
    void emailRequest(String login, String password);
    void checkEvents();
}
