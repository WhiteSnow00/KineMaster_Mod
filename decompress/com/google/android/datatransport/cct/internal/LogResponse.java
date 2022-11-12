// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import java.io.IOException;
import android.util.JsonToken;
import android.util.JsonReader;
import java.io.Reader;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LogResponse
{
    static LogResponse a(final long n) {
        return new f(n);
    }
    
    public static LogResponse b(Reader reader) throws IOException {
        reader = (Reader)new JsonReader(reader);
        try {
            ((JsonReader)reader).beginObject();
            while (((JsonReader)reader).hasNext()) {
                if (((JsonReader)reader).nextName().equals("nextRequestWaitMillis")) {
                    if (((JsonReader)reader).peek() == JsonToken.STRING) {
                        return a(Long.parseLong(((JsonReader)reader).nextString()));
                    }
                    return a(((JsonReader)reader).nextLong());
                }
                else {
                    ((JsonReader)reader).skipValue();
                }
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        }
        finally {
            ((JsonReader)reader).close();
        }
    }
    
    public abstract long c();
}
