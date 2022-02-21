package com.example.util;

import com.example.dtos.InspectionsDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
    // Creating an object of Gson class
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //String prettyJson = gson.toJson();
}
