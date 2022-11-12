// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import java.util.Map;
import java.io.Writer;
import java.io.StringWriter;
import com.google.android.gms.internal.ads.zzfbl;
import android.util.JsonWriter;
import android.util.JsonToken;
import java.io.IOException;
import android.util.JsonReader;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzcfi;
import org.json.JSONArray;
import android.os.Bundle;
import org.json.JSONObject;

public final class zzbu
{
    public static final zzbt a;
    
    static {
        a = new j();
    }
    
    public static Bundle a(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        final Iterator keys = jsonObject.keys();
        final Bundle bundle = new Bundle();
        while (keys.hasNext()) {
            final String s = keys.next();
            final Object opt = jsonObject.opt(s);
            if (opt != null) {
                if (opt instanceof Boolean) {
                    bundle.putBoolean(s, (boolean)opt);
                }
                else if (opt instanceof Double) {
                    bundle.putDouble(s, (double)opt);
                }
                else if (opt instanceof Integer) {
                    bundle.putInt(s, (int)opt);
                }
                else if (opt instanceof Long) {
                    bundle.putLong(s, (long)opt);
                }
                else if (opt instanceof String) {
                    bundle.putString(s, (String)opt);
                }
                else if (opt instanceof JSONArray) {
                    final JSONArray jsonArray = (JSONArray)opt;
                    if (jsonArray.length() == 0) {
                        continue;
                    }
                    final int length = jsonArray.length();
                    final int n = 0;
                    final int n2 = 0;
                    final int n3 = 0;
                    final int n4 = 0;
                    Object opt2 = null;
                    for (int n5 = 0; opt2 == null && n5 < length; ++n5) {
                        if (!jsonArray.isNull(n5)) {
                            opt2 = jsonArray.opt(n5);
                        }
                        else {
                            opt2 = null;
                        }
                    }
                    if (opt2 == null) {
                        zzcfi.zzj("Expected JSONArray with at least 1 non-null element for key:".concat(String.valueOf(s)));
                    }
                    else if (opt2 instanceof JSONObject) {
                        final Bundle[] array = new Bundle[length];
                        for (int i = n4; i < length; ++i) {
                            Bundle a;
                            if (!jsonArray.isNull(i)) {
                                a = a(jsonArray.optJSONObject(i));
                            }
                            else {
                                a = null;
                            }
                            array[i] = a;
                        }
                        bundle.putParcelableArray(s, (Parcelable[])array);
                    }
                    else if (opt2 instanceof Number) {
                        final double[] array2 = new double[jsonArray.length()];
                        for (int j = n; j < length; ++j) {
                            array2[j] = jsonArray.optDouble(j);
                        }
                        bundle.putDoubleArray(s, array2);
                    }
                    else if (opt2 instanceof CharSequence) {
                        final String[] array3 = new String[length];
                        for (int k = n2; k < length; ++k) {
                            String optString;
                            if (!jsonArray.isNull(k)) {
                                optString = jsonArray.optString(k);
                            }
                            else {
                                optString = null;
                            }
                            array3[k] = optString;
                        }
                        bundle.putStringArray(s, array3);
                    }
                    else if (opt2 instanceof Boolean) {
                        final boolean[] array4 = new boolean[length];
                        for (int l = n3; l < length; ++l) {
                            array4[l] = jsonArray.optBoolean(l);
                        }
                        bundle.putBooleanArray(s, array4);
                    }
                    else {
                        zzcfi.zzj(String.format("JSONArray with unsupported type %s for key:%s", opt2.getClass().getCanonicalName(), s));
                    }
                }
                else if (opt instanceof JSONObject) {
                    bundle.putBundle(s, a((JSONObject)opt));
                }
                else {
                    zzcfi.zzj("Unsupported type for key:".concat(String.valueOf(s)));
                }
            }
        }
        return bundle;
    }
    
    public static String b(final String s, final JSONObject jsonObject, final String... array) {
        final JSONObject m = m(jsonObject, array);
        if (m == null) {
            return "";
        }
        return m.optString(array[0], "");
    }
    
    public static List c(final JSONArray jsonArray, final List list) throws JSONException {
        List list2 = list;
        if (list == null) {
            list2 = new ArrayList();
        }
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); ++i) {
                list2.add(jsonArray.getString(i));
            }
        }
        return list2;
    }
    
    public static List d(final JsonReader jsonReader) throws IllegalStateException, IOException {
        final ArrayList list = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            list.add(jsonReader.nextString());
        }
        jsonReader.endArray();
        return list;
    }
    
    public static JSONArray e(final JsonReader jsonReader) throws IllegalStateException, IOException, JSONException {
        final JSONArray jsonArray = new JSONArray();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            final JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals((Object)peek)) {
                jsonArray.put((Object)e(jsonReader));
            }
            else if (JsonToken.BEGIN_OBJECT.equals((Object)peek)) {
                jsonArray.put((Object)h(jsonReader));
            }
            else if (JsonToken.BOOLEAN.equals((Object)peek)) {
                jsonArray.put(jsonReader.nextBoolean());
            }
            else if (JsonToken.NUMBER.equals((Object)peek)) {
                jsonArray.put(jsonReader.nextDouble());
            }
            else {
                if (!JsonToken.STRING.equals((Object)peek)) {
                    throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(peek)));
                }
                jsonArray.put((Object)jsonReader.nextString());
            }
        }
        jsonReader.endArray();
        return jsonArray;
    }
    
    public static JSONObject f(JSONObject jsonObject, final String s) throws JSONException {
        try {
            jsonObject = jsonObject.getJSONObject(s);
        }
        catch (final JSONException ex) {
            final JSONObject jsonObject2 = new JSONObject();
            jsonObject.put(s, (Object)jsonObject2);
            jsonObject = jsonObject2;
        }
        return jsonObject;
    }
    
    public static JSONObject g(JSONObject m, final String... array) {
        m = m(m, array);
        if (m == null) {
            return null;
        }
        return m.optJSONObject(array[1]);
    }
    
    public static JSONObject h(final JsonReader jsonReader) throws IllegalStateException, IOException, JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            final JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals((Object)peek)) {
                jsonObject.put(nextName, (Object)e(jsonReader));
            }
            else if (JsonToken.BEGIN_OBJECT.equals((Object)peek)) {
                jsonObject.put(nextName, (Object)h(jsonReader));
            }
            else if (JsonToken.BOOLEAN.equals((Object)peek)) {
                jsonObject.put(nextName, jsonReader.nextBoolean());
            }
            else if (JsonToken.NUMBER.equals((Object)peek)) {
                jsonObject.put(nextName, jsonReader.nextDouble());
            }
            else {
                if (!JsonToken.STRING.equals((Object)peek)) {
                    throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(peek)));
                }
                jsonObject.put(nextName, (Object)jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return jsonObject;
    }
    
    public static void i(final JsonWriter jsonWriter, final JSONArray jsonArray) throws IOException {
        try {
            jsonWriter.beginArray();
            for (int i = 0; i < jsonArray.length(); ++i) {
                final Object value = jsonArray.get(i);
                if (value instanceof String) {
                    jsonWriter.value((String)value);
                }
                else if (value instanceof Number) {
                    jsonWriter.value((Number)value);
                }
                else if (value instanceof Boolean) {
                    jsonWriter.value((boolean)value);
                }
                else if (value instanceof JSONObject) {
                    j(jsonWriter, (JSONObject)value);
                }
                else {
                    if (!(value instanceof JSONArray)) {
                        final String value2 = String.valueOf(value);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unable to write field: ");
                        sb.append(value2);
                        throw new JSONException(sb.toString());
                    }
                    i(jsonWriter, (JSONArray)value);
                }
            }
            jsonWriter.endArray();
        }
        catch (final JSONException ex) {
            throw new IOException((Throwable)ex);
        }
    }
    
    public static void j(final JsonWriter jsonWriter, final JSONObject jsonObject) throws IOException {
        try {
            jsonWriter.beginObject();
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String s = keys.next();
                final Object value = jsonObject.get(s);
                if (value instanceof String) {
                    jsonWriter.name(s).value((String)value);
                }
                else if (value instanceof Number) {
                    jsonWriter.name(s).value((Number)value);
                }
                else if (value instanceof Boolean) {
                    jsonWriter.name(s).value((boolean)value);
                }
                else if (value instanceof JSONObject) {
                    j(jsonWriter.name(s), (JSONObject)value);
                }
                else {
                    if (!(value instanceof JSONArray)) {
                        final String value2 = String.valueOf(value);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("unable to write field: ");
                        sb.append(value2);
                        throw new JSONException(sb.toString());
                    }
                    i(jsonWriter.name(s), (JSONArray)value);
                }
            }
            jsonWriter.endObject();
        }
        catch (final JSONException ex) {
            throw new IOException((Throwable)ex);
        }
    }
    
    public static boolean k(final boolean b, JSONObject m, final String... array) {
        m = m(m, array);
        return m != null && m.optBoolean(array[array.length - 1], false);
    }
    
    public static String l(final zzfbl zzfbl) {
        final String s = null;
        String string;
        if (zzfbl == null) {
            string = s;
        }
        else {
            final StringWriter stringWriter = new StringWriter();
            try {
                final JsonWriter jsonWriter = new JsonWriter((Writer)stringWriter);
                n(jsonWriter, zzfbl);
                jsonWriter.close();
                string = stringWriter.toString();
            }
            catch (final IOException ex) {
                zzcfi.zzh("Error when writing JSON.", (Throwable)ex);
                string = s;
            }
        }
        return string;
    }
    
    private static JSONObject m(JSONObject optJSONObject, final String[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (optJSONObject == null) {
                return null;
            }
            optJSONObject = optJSONObject.optJSONObject(array[i]);
        }
        return optJSONObject;
    }
    
    private static void n(final JsonWriter jsonWriter, final Object o) throws IOException {
        if (o == null) {
            jsonWriter.nullValue();
            return;
        }
        if (o instanceof Number) {
            jsonWriter.value((Number)o);
            return;
        }
        if (o instanceof Boolean) {
            jsonWriter.value((boolean)o);
            return;
        }
        if (o instanceof String) {
            jsonWriter.value((String)o);
            return;
        }
        if (o instanceof zzfbl) {
            j(jsonWriter, ((zzfbl)o).zzd);
            return;
        }
        if (o instanceof Map) {
            jsonWriter.beginObject();
            for (final Map.Entry<Object, V> entry : ((Map)o).entrySet()) {
                final String key = entry.getKey();
                if (key instanceof String) {
                    n(jsonWriter.name((String)key), entry.getValue());
                }
            }
            jsonWriter.endObject();
            return;
        }
        if (o instanceof List) {
            jsonWriter.beginArray();
            final Iterator iterator2 = ((List)o).iterator();
            while (iterator2.hasNext()) {
                n(jsonWriter, iterator2.next());
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.nullValue();
    }
}
