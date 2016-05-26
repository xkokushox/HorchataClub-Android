package com.freakybyte.horchataclub.parse;

import com.freakybyte.horchataclub.model.DishModel;
import com.freakybyte.horchataclub.util.DebugUtil;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by kokusho on 2/29/16.
 */
public class DishListParse extends MainParse {

    public static final String TAG = "DishListParse";

    public static ArrayList<DishModel> getAllDishes(byte[] responseBody) {

        startParsed();

        String sResponse = getStringFromByte(responseBody);

        // DebugUtil.logDebug(TAG, "Response:: " + sResponse);

        ArrayList<DishModel> aDish = new ArrayList<>();

        Type listType = new TypeToken<ArrayList<DishModel>>() {
        }.getType();

        try {
            aDish = new GsonBuilder().create().fromJson(sResponse, listType);
        } catch (Exception ex) {
            DebugUtil.logError(TAG, ex);
        }

        stopParsed();

        return aDish;
    }
}
