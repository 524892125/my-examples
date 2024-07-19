package com.examples.transtionPrompt;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;

import static java.lang.System.exit;

public class DeepLTranstion {
    public static String transtion(String str) throws Exception {
        str =  str.replace("\r\n", "\\n").replace("\n", "\\n");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"jsonrpc\":\"2.0\",\"method\": \"LMT_handle_jobs\",\"params\":{\"jobs\":[{\"kind\":\"default\",\"sentences\":[{\"text\":\"" + str + "\",\"id\":1,\"prefix\":\"\"}],\"raw_en_context_before\":[],\"raw_en_context_after\":[],\"preferred_num_beams\":4}],\"lang\":{\"target_lang\":\"EN\",\"preference\":{\"weight\":{},\"default\":\"default\"},\"source_lang_computed\":\"ZH\"},\"priority\":-1,\"commonJobParams\":{\"quality\":\"fast\",\"regionalVariant\":\"en-US\",\"mode\":\"translate\",\"browserType\":1,\"textType\":\"plaintext\"},\"timestamp\":1721373675521},\"id\":82210015}");

        Request request = new Request.Builder()
                .url("https://www2.deepl.com/jsonrpc?method=LMT_handle_jobs")
                .method("POST", body)
                .addHeader("accept", "*/*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en-GB;q=0.8,en;q=0.7")
                .addHeader("cache-control", "no-cache")
                .addHeader("content-type", "application/json")
                .addHeader("cookie", "INGRESSCOOKIE=ebb7d05c9b0ea2cc2dcb5198f325103e|a6d4ac311669391fc997a6a267dc91c0; userCountry=SG; dapUid=507da24f-f9d8-445c-b2a4-4982a9a119b1; releaseGroups=8391.DM-1630.2.2_9129.DM-1419.2.2_9683.SEO-747.2.2_12124.AAEXP-10360.1.1_12130.AAEXP-10366.1.1_8253.DWFA-625.2.2_8287.TC-1035.2.5_8393.DPAY-3431.2.2_10381.DF-3974.2.2_12111.AAEXP-10347.2.1_12116.AAEXP-10352.1.1_6402.DWFA-716.2.3_6732.DF-3818.2.4_11072.B2B-1154.2.5_11550.SEO-706.1.1_12110.AAEXP-10346.2.1_12123.AAEXP-10359.1.1_2455.DPAY-2828.2.2_4854.DM-1255.2.5_6359.DM-1411.2.10_7617.DWFA-774.2.2_10551.DAL-1134.2.1_12114.AAEXP-10350.1.1_12120.AAEXP-10356.1.1_12129.AAEXP-10365.1.1_2413.DWFA-524.2.4_2373.DM-1113.2.4_2656.DM-1177.2.2_8392.DWFA-813.2.2_12005.WDW-552.2.1_12133.AAEXP-10369.1.1_975.DM-609.2.3_3961.B2B-663.2.3_5562.DWFA-732.2.2_7616.DWFA-777.2.2_10380.DF-3973.2.2_10550.DWFA-884.2.2_11861.CEX-77.1.3_12105.AAEXP-10341.2.1_220.DF-1925.1.9_12127.AAEXP-10363.2.1_4121.WDW-356.2.5_4478.SI-606.2.3_5707.TACO-104.2.2_12134.AAEXP-10370.1.1_1583.DM-807.2.5_11548.DM-1613.2.1_12074.DEM-1270.2.1_12131.AAEXP-10367.1.1_8635.DM-1158.2.3_7584.TACO-60.2.2_7759.DWFA-814.2.2_10379.DF-3874.2.2_12106.AAEXP-10342.1.1_12117.AAEXP-10353.2.1_4322.DWFA-689.2.2_8776.DM-1442.2.2_12118.AAEXP-10354.1.1_12122.AAEXP-10358.1.1_3613.WDW-267.2.2_3283.DWFA-661.2.2_10794.DF-3869.2.1_2055.DM-814.2.3_5719.DWFA-761.2.2_9026.DF-3894.2.4_10449.DF-3959.2.2_11591.TACO-210.1.1_12115.AAEXP-10351.1.1_5560.DWFA-638.2.2_8041.DM-1581.2.2_10238.MTD-392.2.2_10752.TACO-109.2.3_12113.AAEXP-10349.1.1_12119.AAEXP-10355.1.1_12125.AAEXP-10361.1.1_12126.AAEXP-10362.1.1_1483.DM-821.2.2_12132.AAEXP-10368.1.1_12003.DM-1857.2.1_12107.AAEXP-10343.2.1_12108.AAEXP-10344.2.1_12112.AAEXP-10348.2.1_12128.AAEXP-10364.1.1_9824.AP-523.2.3_11549.DM-1149.1.1_10382.DF-3962.1.2_10731.CEX-69.1.3_11547.DF-3929.2.2_12109.AAEXP-10345.1.1_12121.AAEXP-10357.1.1_2962.DF-3552.2.6; LMTBID=v2|9c1a5cd8-1122-4da0-8b53-bac05e4ed13c|94432773e408ae98e3ffaf4ad7c3ceb6; privacySettings=%7B%22v%22%3A%221%22%2C%22t%22%3A1721347200%2C%22m%22%3A%22LAX_AUTO%22%2C%22consent%22%3A%5B%22NECESSARY%22%2C%22PERFORMANCE%22%2C%22COMFORT%22%2C%22MARKETING%22%5D%7D; dapVn=1; dapSid=%7B%22sid%22%3A%22053d1856-c288-49f9-9e5b-373a6c185926%22%2C%22lastUpdate%22%3A1721373672%7D")
                .addHeader("origin", "https://www.deepl.com")
                .addHeader("pragma", "no-cache")
                .addHeader("priority", "u=1, i")
                .addHeader("referer", "https://www.deepl.com/")
                .addHeader("sec-ch-ua", "\"Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-site")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")
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

        JsonObject resultObject = jsonObject.getAsJsonObject("result");
        System.out.println(resultObject);

        JsonArray translationsArray = resultObject.getAsJsonArray("translations");
        JsonObject firstTranslationObject = translationsArray.get(0).getAsJsonObject();

        JsonArray beamsArray = firstTranslationObject.getAsJsonArray("beams");
        JsonObject firstBeamObject = beamsArray.get(0).getAsJsonObject();

        JsonArray sentencesArray = firstBeamObject.getAsJsonArray("sentences");
        JsonObject firstSentenceObject = sentencesArray.get(0).getAsJsonObject();

        String text = firstSentenceObject.get("text").getAsString();

        return text;
    }
}
