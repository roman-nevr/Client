package ru.rubicon.client.interfaces;

/**
 * Created by Витя on 02.11.2016.
 */

public interface IGitHubPresenter {
    public void requestUser(String user);
    public void requestContributors(String owner, String repo);
}
