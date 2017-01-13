package ru.rubicon.client.model.odata;

/**
 * Created by Admin on 12.01.2017.
 */

public class OdataFilters {
    //&$filter=substringof(%27Чеб%27,Description)
    public static String substringOf(String what, String from){
        return "substringof('" + what + "', " + from + ")";
    }
}
