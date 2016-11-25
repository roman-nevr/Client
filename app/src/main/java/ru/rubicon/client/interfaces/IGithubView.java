package ru.rubicon.client.interfaces;

/**
 * Created by Витя on 02.11.2016.
 */

public interface IGitHubView {
    void setText(String string);
    String getOwnerName();
    String getPassword();
    String getRepoName();
    void showProgressBar();
    void hideProgressBar();
}
