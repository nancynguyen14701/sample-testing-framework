package com.itgirls.FW.common.utilities;


import com.itgirls.FW.common.AbstractLog;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class JsonUtil extends AbstractLog {

    private static Method findMethod(Class testClass, String testcaseName) {
        Method[] methods = testClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (testcaseName.equals(method.getName()))
                return method;
        }
        return null;
    }

    private static int getParameterCount(Method method) {
        if (method != null) {
            return method.getParameterCount();
        }
        return 0;
    }

    public static Object[][] getJSONTestData(String testcaseName, Class testClass) {
        Method method = findMethod(testClass, testcaseName);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            Object obj = jsonParser.parse(new FileReader("src/test/resources/testdata/" + testClass.getSimpleName() + ".json"));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        JSONArray testDataList = (JSONArray) jsonObject.get(testcaseName);

        // Get number of parameter of particular test method
        int paramCount = getParameterCount(method);
        Object[][] data = new Object[testDataList.size()][paramCount];

        for (int i = 0; i < testDataList.size(); i++) {
            JSONObject testData = (JSONObject) testDataList.get(i);
            data[i] = new Object[paramCount];
            for (int j = 0; j < paramCount; j++) {
                Parameter p = method.getParameters()[j];
                data[i][j] = testData.get(p.getName());
            }
        }
        return data;

    }
}
