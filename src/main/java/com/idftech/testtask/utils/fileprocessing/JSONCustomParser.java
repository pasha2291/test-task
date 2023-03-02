package com.idftech.testtask.utils.fileprocessing;

import com.idftech.testtask.utils.logger.CustomLogger;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class JSONCustomParser {
    private static JSONParser parser = new JSONParser();

    @SneakyThrows
    public static String getElementByNameFromResPath(String path, String elementName) {
        CustomLogger.info(String.format("JSONCustomParser.getElementByNameFromResourcePath() : %s : %s", path, elementName));
        path = FileFullPath.getFileFullPath(path);
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
        return (String) jsonObject.get(elementName);
    }

    @SneakyThrows
    public static List<String> parseArrayToListByNameFromResPath(String path, String elementName) {
        CustomLogger.info(String.format("JSONCustomParser.parseArrayToListByNameFromResourcePath() : %s : %s", path, elementName));
        List<String> values = new ArrayList<>();
        path = FileFullPath.getFileFullPath(path);
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
        JSONArray elements = (JSONArray)jsonObject.get(elementName);
        for(Object obj : elements){
            values.add(obj.toString());
        }
        return values;
    }
}
