package ru.rubicon.client.interfaces;

import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Admin on 29.11.2016.
 */

public interface RxConvention {
    interface IRxActivityView{
        void setText(String text);
        void addText(String text);
        String getName();
        void showProgress();
        void hideProgress();
        Button getAddButton();
        EditText getEditText();
    }
    interface IRxActivityPresenter{
        void onButtonAddClick();
    }
}
