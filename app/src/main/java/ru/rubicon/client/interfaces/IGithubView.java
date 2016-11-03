package ru.rubicon.client.interfaces;

/**
 * Created by Витя on 02.11.2016.
 */

public interface IGithubView {
    public void setText(String string);
    public String getText();
    public void showProgressBar();
    public void hideProgressBar();
}
