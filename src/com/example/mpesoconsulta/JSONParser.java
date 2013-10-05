package com.example.mpesoconsulta;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class JSONParser {

	public static JSONArray getJSON(String json)
	{
		JSONArray jObj = new JSONArray();
		try {
            jObj = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
		return jObj;
	}
}