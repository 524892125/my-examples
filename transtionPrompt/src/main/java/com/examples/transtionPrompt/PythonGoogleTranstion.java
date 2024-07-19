package com.examples.transtionPrompt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;

public class PythonGoogleTranstion {
    public static String transtion(String str) throws Exception
    {
        str =  str.replace("\r\n", "\\n").replace("\n", "\\n");

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"text\": \""+ str +"\"\r\n}");
        Request request = new Request.Builder()
                .url("http://127.0.0.1:5000/transtion")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String responseStr = "";

        System.out.println(response);
        if (response.body() == null) {
            throw new Exception("body is null");
        }

        responseStr = response.body().string();
        response.body().close();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseStr, JsonObject.class);
        return jsonObject.get("res").getAsString();
    }
}
