package com.purplerat.jpin;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PinParser {
    private static final Logger logger = LoggerFactory.getLogger(PinParser.class);
    static final Pattern DATA_JSON_REGEX = Pattern.compile("(\\{.*\\})");

    public static boolean isUrlSupported(String url){
        Objects.requireNonNull(url);
        return UrlManager.isUrlSupported(url);
    }
    public Pin parse(String url) throws IOException,NotSupportedFormatException {
        if(!isUrlSupported(url)){
            throw new IllegalArgumentException();
        }
        Document page = NetTools.getPage(url);

        JsonObject entry = parseJsonData(page);
        PinMeta meta = parseMeta(entry);
        StreamingData streamingData = parseStreamingData(entry);
        return new Pin(meta,streamingData);
    }
    private static JsonObject parseJsonData(Document page) throws NotSupportedFormatException{
        Matcher mat;
        for (Element i : page.select("script")) {
            if ((mat = DATA_JSON_REGEX.matcher(i.data())).find()) {
                try {
                    JsonObject object = new Gson().fromJson(mat.group(1), JsonObject.class);
                    if (object.has("@type") && object.get("@type").getAsString().equals("VideoObject")) {
                        return object;
                    }
                } catch (JsonSyntaxException ignored) {}
            }
        }
        throw new NotSupportedFormatException();
    }
    private static PinMeta parseMeta(JsonObject entry){
        String name = entry.get("name").getAsString();
        String description = entry.get("description").getAsString();
        String thumbnail = entry.get("thumbnailUrl").getAsString();
        String url = entry.get("@id").getAsString();
        return new PinMeta(name,description,thumbnail,url);
    }
    private static StreamingData parseStreamingData(JsonObject entry){
        int width = Integer.parseInt(entry.get("width").getAsString().split(" ")[0]);
        int height = Integer.parseInt(entry.get("height").getAsString().split(" ")[0]);
        String url = entry.get("contentUrl").getAsString();
        return new StreamingData(width,height,url);
    }
}
