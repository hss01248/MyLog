package com.orhanobut.logger.util;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Kale
 * @date 2016/3/23
 */
public class XmlJsonParser {

    /**
     * It is used for json pretty print
     */
    private static final int JSON_INDENT = 4;

    @CheckResult
    public static String xml(String xml) {
        if (TextUtils.isEmpty(xml)) {
            return "Empty/Null xml content.(This msg from logger)";
        }
        try {
            Source xmlInput = new StreamSource(new StringReader(xml));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString().replaceFirst(">", ">\n");
        } catch (TransformerException e) {
            return e.getCause().getMessage() + "\n" + xml;
        }
    }

    @CheckResult
    public static String json(@Nullable String json) {
        if (TextUtils.isEmpty(json)) {
            return "Empty/Null json content.(This msg from logger)";
        }
        try {
            if (json.startsWith("{")) {
                return new JSONObject(json).toString(JSON_INDENT);
            } else if (json.startsWith("[")) {
                return new JSONArray(json).toString(JSON_INDENT);
            }
        } catch (JSONException e) {
            return e.getCause().getMessage() + "\n" + json;
        }
        return "Log error!.(This msg from logger, expect json ,but not json)";
    }
}
