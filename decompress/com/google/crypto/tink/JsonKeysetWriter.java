// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.io.IOException;
import com.google.crypto.tink.proto.KeysetInfo;
import java.util.Iterator;
import org.json.JSONArray;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeyData;
import org.json.JSONException;
import com.google.crypto.tink.subtle.Base64;
import org.json.JSONObject;
import com.google.crypto.tink.proto.EncryptedKeyset;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class JsonKeysetWriter implements KeysetWriter
{
    private static final Charset b;
    private final OutputStream a;
    
    static {
        b = Charset.forName("UTF-8");
    }
    
    private JSONObject c(final EncryptedKeyset encryptedKeyset) throws JSONException {
        return new JSONObject().put("encryptedKeyset", (Object)Base64.e(encryptedKeyset.M().toByteArray())).put("keysetInfo", (Object)this.h(encryptedKeyset.N()));
    }
    
    private JSONObject d(final KeyData keyData) throws JSONException {
        return new JSONObject().put("typeUrl", (Object)keyData.P()).put("value", (Object)Base64.e(keyData.Q().toByteArray())).put("keyMaterialType", (Object)keyData.O().name());
    }
    
    private JSONObject e(final Keyset.Key key) throws JSONException {
        return new JSONObject().put("keyData", (Object)this.d(key.O())).put("status", (Object)key.R().name()).put("keyId", this.i(key.P())).put("outputPrefixType", (Object)key.Q().name());
    }
    
    private JSONObject f(final Keyset keyset) throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("primaryKeyId", this.i(keyset.R()));
        final JSONArray jsonArray = new JSONArray();
        final Iterator<Keyset.Key> iterator = keyset.Q().iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)this.e(iterator.next()));
        }
        jsonObject.put("key", (Object)jsonArray);
        return jsonObject;
    }
    
    private JSONObject g(final KeysetInfo.KeyInfo keyInfo) throws JSONException {
        return new JSONObject().put("typeUrl", (Object)keyInfo.R()).put("status", (Object)keyInfo.Q().name()).put("keyId", keyInfo.O()).put("outputPrefixType", (Object)keyInfo.P().name());
    }
    
    private JSONObject h(final KeysetInfo keysetInfo) throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("primaryKeyId", this.i(keysetInfo.R()));
        final JSONArray jsonArray = new JSONArray();
        final Iterator<KeysetInfo.KeyInfo> iterator = keysetInfo.Q().iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)this.g(iterator.next()));
        }
        jsonObject.put("keyInfo", (Object)jsonArray);
        return jsonObject;
    }
    
    private long i(final int n) {
        return (long)n & 0xFFFFFFFFL;
    }
    
    @Override
    public void a(final Keyset keyset) throws IOException {
        try {
            try {
                final OutputStream a = this.a;
                final String string = this.f(keyset).toString(4);
                final Charset b = JsonKeysetWriter.b;
                a.write(string.getBytes(b));
                this.a.write(System.lineSeparator().getBytes(b));
                this.a.close();
                return;
            }
            finally {}
        }
        catch (final JSONException ex) {
            throw new IOException((Throwable)ex);
        }
        this.a.close();
    }
    
    @Override
    public void b(final EncryptedKeyset encryptedKeyset) throws IOException {
        try {
            try {
                final OutputStream a = this.a;
                final String string = this.c(encryptedKeyset).toString(4);
                final Charset b = JsonKeysetWriter.b;
                a.write(string.getBytes(b));
                this.a.write(System.lineSeparator().getBytes(b));
                this.a.close();
                return;
            }
            finally {}
        }
        catch (final JSONException ex) {
            throw new IOException((Throwable)ex);
        }
        this.a.close();
    }
}
