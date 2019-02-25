package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {



        try {
            /*  Step One: Convert json string to JSON object */
            JSONObject json_data = new JSONObject(json);

            /* Step Two: Parse the Base Object's Keys */
            // Handle anomolies first
            JSONObject name = json_data.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray altNames = name.getJSONArray("alsoKnownAs");
            ArrayList<String> altNamesList = new ArrayList<>();
            for(int i=0; i<altNames.length(); i++) {
                altNamesList.add(altNames.getString(i));
            }

            JSONArray ingredients = json_data.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for(int i=0; i<ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            // Parsing keys with primitive assignments
            String placeOfOrigin = json_data.getString("placeOfOrigin");
            String image = json_data.getString("image");
            String description = json_data.getString("description");
            return new Sandwich(mainName, altNamesList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {

            /* Print Any Errors */
            e.printStackTrace();
        }

        return null;
    }
}
