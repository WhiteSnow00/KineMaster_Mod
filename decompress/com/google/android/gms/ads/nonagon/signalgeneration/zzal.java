// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import org.json.JSONException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import android.util.JsonReader;
import android.os.Bundle;

public final class zzal
{
    public final String a;
    public String b;
    public Bundle c;
    
    public zzal(final JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        this.c = new Bundle();
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        String nextString = "";
        while (jsonReader.hasNext()) {
            String nextName;
            if ((nextName = jsonReader.nextName()) == null) {
                nextName = "";
            }
            final int hashCode = nextName.hashCode();
            int n = 0;
            Label_0110: {
                if (hashCode != -995427962) {
                    if (hashCode == -271442291) {
                        if (nextName.equals("signal_dictionary")) {
                            n = 1;
                            break Label_0110;
                        }
                    }
                }
                else if (nextName.equals("params")) {
                    n = 0;
                    break Label_0110;
                }
                n = -1;
            }
            if (n != 0) {
                if (n != 1) {
                    jsonReader.skipValue();
                }
                else {
                    hashMap = new HashMap();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        hashMap.put(jsonReader.nextName(), jsonReader.nextString());
                    }
                    jsonReader.endObject();
                }
            }
            else {
                nextString = jsonReader.nextString();
            }
        }
        this.a = nextString;
        jsonReader.endObject();
        for (final Map.Entry<String, V> entry : hashMap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.c.putString((String)entry.getKey(), (String)entry.getValue());
            }
        }
    }
}
