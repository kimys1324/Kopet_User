package com.example.kimys1324.kopet_drawer.Common;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kimys1324 on 7/15/16.
 */   class GettingPHP extends AsyncTask<String, Integer, String> {
    @Override
    protected String doInBackground(String... params) {
        StringBuilder jsonHtml = new StringBuilder();
        try {
            URL phpUrl = new URL(params[0] + "/animalpicture.php?" + "id="+"111");
            HttpURLConnection conn = (HttpURLConnection) phpUrl.openConnection();
            if (conn != null) {
                conn.setConnectTimeout(10000);
                conn.setUseCaches(false);

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    while (true) {
                        String line = br.readLine();
                        if (line == null)
                            break;
                        jsonHtml.append(line + "\n");
                        Log.i("", "성공");
                    }
                    br.close();
                }
                conn.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonHtml.toString();
    }

    protected void onPostExecute(String str) {
        String id;
        String zz = "";
        try {

            JSONObject root = new JSONObject(str);

            JSONArray ja = root.getJSONArray("results"); //get the JSONArray which I made in the php file. the name of JSONArray is "results"

            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                //id = jo.getString("pictureid");
                zz += "\tid : " + jo.get("id");
                zz += "\n\t--------------------------------------------\n";
            }
            //tv.setText(zz);
        } catch (JSONException e) {

            e.printStackTrace();
        }
    }
}