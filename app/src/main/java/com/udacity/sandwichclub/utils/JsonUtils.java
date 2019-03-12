package com.udacity.sandwichclub.utils;

import android.util.JsonReader;
import android.util.JsonWriter;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameJsonObject = jsonObject.getJSONObject("name");

            String mainName = nameJsonObject.getString("mainName");
            JSONArray alsoKnownAsJA = nameJsonObject.getJSONArray("alsoKnownAs");

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");

            JSONArray ingredientsJA = jsonObject.getJSONArray("ingredients");

            List<String> ingredients = new ArrayList<>();
            List<String> alsoKnownAs = new ArrayList<>();

            for (int i = 0; i < ingredientsJA.length(); i++) {
                ingredients.add((String) ingredientsJA.get(i));
            }

            for (int i = 0; i < alsoKnownAsJA.length(); i++) {
                alsoKnownAs.add((String) alsoKnownAsJA.get(i));
            }
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
