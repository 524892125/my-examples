package com.examples.transtionPrompt;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {


        ConnectMysql connectMysql = new ConnectMysql();
        ArrayList<JsonObject> list = connectMysql.query("SELECT * FROM prompt where id  > 5000 AND Prompt = '' or Prompt IS NULL");
        for (JsonObject o : list) {
            String prompt = o.get("Prompt_cn").getAsString();
            if (prompt == null) {
                continue;
            }

            try {
                prompt =  prompt.replace("\r\n", "\\n").replace("\n", "\\n");
                System.out.println(prompt);

                String res = PythonGoogleTranstion.transtion(prompt);

                System.out.println(res);
                System.out.println("update id " + o.get("id").getAsString());
                res = res.replaceAll("'", "\"");
//                connectMysql.update("UPDATE wl_prompt SET Prompt = '" + res + "' WHERE id = " + o.get("id").getAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
