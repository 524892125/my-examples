package com.examples.transtionPrompt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AliTranstion {
    public static String transtion(String str) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("srcLang","auto")
                .addFormDataPart("tgtLang","en")
                .addFormDataPart("domain","general")
                .addFormDataPart("query", str)
                .addFormDataPart("_csrf","d6b731c2-6606-4d87-b69a-9e93b0eb8fcf")
                .build();
        Request request = new Request.Builder()
                .url("https://translate.alibaba.com/api/translate/text")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        String responseStr = "";

        if (response.body() == null) {
            throw new Exception("body is null");
        }

        responseStr = response.body().string();
        response.body().close();


        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseStr, JsonObject.class);
        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        return dataObject.get("translateText").getAsString();
    }
}
