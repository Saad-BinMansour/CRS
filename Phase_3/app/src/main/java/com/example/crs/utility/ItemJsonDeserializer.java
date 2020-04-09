package com.example.crs.utility;

import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.generic.InternalMemory;
import com.example.crs.model.generic.RAM;
import com.example.crs.model.item.Item;
import com.example.crs.model.laptop.ComputerItem;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;

public class ItemJsonDeserializer implements JsonDeserializer<Item> {
    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";

    @Override
    public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        /*String type = json.getAsJsonObject().get("type").getAsString();
        switch (type) {
            case "ComputerItem":
                return context.deserialize(json, ComputerItem.class);

            case "CPU":
                return context.deserialize(json, CPU.class);

            case "GPU":
                return context.deserialize(json, GPU.class);

            case "RAM":
                return context.deserialize(json, RAM.class);

            case "InternalMemory":
                return context.deserialize(json, InternalMemory.class);

            default:
                throw new IllegalArgumentException("Non of the Item's class children");
        }*/

        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();

        Class<?> klass;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject.get(INSTANCE), klass);
    }
}
