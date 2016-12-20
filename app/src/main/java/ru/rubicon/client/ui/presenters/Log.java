package ru.rubicon.client.ui.presenters;

import ru.rubicon.client.Basement;

/**
 * Created by Admin on 20.12.2016.
 */

public class Log {
    public static void add(String string){
        Basement.log.add(string);
    }
}
