// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.util;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import java.util.Iterator;
import java.util.Collection;
import org.json.JSONStringer;
import org.json.JSONTokener;
import org.json.JSONException;
import java.io.IOException;
import org.json.JSONObject;
import java.util.Map;

public class JsonMapper
{
    public static Map<String, Object> a(final String s) throws IOException {
        try {
            return h(new JSONObject(s));
        }
        catch (final JSONException ex) {
            throw new IOException((Throwable)ex);
        }
    }
    
    public static Object b(final String s) throws IOException {
        try {
            return f(new JSONTokener(s).nextValue());
        }
        catch (final JSONException ex) {
            throw new IOException((Throwable)ex);
        }
    }
    
    public static String c(final Map<String, Object> map) throws IOException {
        return d(map);
    }
    
    public static String d(final Object o) throws IOException {
        if (o == null) {
            return "null";
        }
        if (o instanceof String) {
            return JSONObject.quote((String)o);
        }
        if (o instanceof Number) {
            try {
                return JSONObject.numberToString((Number)o);
            }
            catch (final JSONException ex) {
                throw new IOException("Could not serialize number", (Throwable)ex);
            }
        }
        if (o instanceof Boolean) {
            String s;
            if (o) {
                s = "true";
            }
            else {
                s = "false";
            }
            return s;
        }
        try {
            final JSONStringer jsonStringer = new JSONStringer();
            e(o, jsonStringer);
            return jsonStringer.toString();
        }
        catch (final JSONException ex2) {
            throw new IOException("Failed to serialize JSON", (Throwable)ex2);
        }
    }
    
    private static void e(final Object o, final JSONStringer jsonStringer) throws IOException, JSONException {
        if (o instanceof Map) {
            jsonStringer.object();
            for (final Map.Entry<String, V> entry : ((Map)o).entrySet()) {
                jsonStringer.key((String)entry.getKey());
                e(entry.getValue(), jsonStringer);
            }
            jsonStringer.endObject();
        }
        else if (o instanceof Collection) {
            final Collection collection = (Collection)o;
            jsonStringer.array();
            final Iterator iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                e(iterator2.next(), jsonStringer);
            }
            jsonStringer.endArray();
        }
        else {
            jsonStringer.value(o);
        }
    }
    
    private static Object f(final Object o) throws JSONException {
        if (o instanceof JSONObject) {
            return h((JSONObject)o);
        }
        if (o instanceof JSONArray) {
            return g((JSONArray)o);
        }
        Object o2 = o;
        if (o.equals(JSONObject.NULL)) {
            o2 = null;
        }
        return o2;
    }
    
    private static List<Object> g(final JSONArray jsonArray) throws JSONException {
        final ArrayList list = new ArrayList(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); ++i) {
            list.add(f(jsonArray.get(i)));
        }
        return list;
    }
    
    private static Map<String, Object> h(final JSONObject jsonObject) throws JSONException {
        final HashMap hashMap = new HashMap(jsonObject.length());
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            final String s = keys.next();
            hashMap.put(s, f(jsonObject.get(s)));
        }
        return hashMap;
    }
}
