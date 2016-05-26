package com.freakybyte.horchataclub.web;

import com.freakybyte.horchataclub.HorchataApplication;
import com.freakybyte.horchataclub.R;

/**
 * Created by kokusho on 2/29/16.
 */
public class HorchataApi {

    public static String getHorchataApiUrl() {
        return HorchataApplication.getInstance().getResources().getString(R.string.url_api);
    }

}
