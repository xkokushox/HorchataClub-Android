package com.freakybyte.horchataclub.web;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.client.params.ClientPNames;

/**
 * Created by kokusho on 2/29/16.
 */
public class HorchataRestClient {

    public static final String TAG = "HorchataRestClient";

    private static AsyncHttpClient client;

    private static AsyncHttpClient getClient() {
        if (client == null) {
            client = new AsyncHttpClient();
            client.getHttpClient().getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
        }
        return client;
    }

    public static void getAllHorchataList(AsyncHttpResponseHandler responseHandler) {
        getClient().get(HorchataApi.getHorchataApiUrl(), null, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        //client.post(getAbsoluteUrl(url), params, responseHandler);
    }


}
