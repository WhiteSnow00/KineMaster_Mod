// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.io.IOException;
import org.json.JSONArray;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.KeyData;
import org.json.JSONException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.proto.EncryptedKeyset;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class JsonKeysetReader implements KeysetReader
{
    private static final Charset e;
    private final InputStream a;
    private final JSONObject b;
    private final boolean c;
    private boolean d;
    
    static {
        e = Charset.forName("UTF-8");
    }
    
    private EncryptedKeyset c(final JSONObject jsonObject) throws JSONException {
        l(jsonObject);
        byte[] array;
        if (this.d) {
            array = Base64.i(jsonObject.getString("encryptedKeyset"));
        }
        else {
            array = Base64.a(jsonObject.getString("encryptedKeyset"));
        }
        return EncryptedKeyset.O().D(ByteString.copyFrom(array)).E(k(jsonObject.getJSONObject("keysetInfo"))).p();
    }
    
    private static KeyData.KeyMaterialType d(final String s) throws JSONException {
        if (s.equals("SYMMETRIC")) {
            return KeyData.KeyMaterialType.SYMMETRIC;
        }
        if (s.equals("ASYMMETRIC_PRIVATE")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
        }
        if (s.equals("ASYMMETRIC_PUBLIC")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
        }
        if (s.equals("REMOTE")) {
            return KeyData.KeyMaterialType.REMOTE;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unknown key material type: ");
        sb.append(s);
        throw new JSONException(sb.toString());
    }
    
    private static OutputPrefixType e(final String s) throws JSONException {
        if (s.equals("TINK")) {
            return OutputPrefixType.TINK;
        }
        if (s.equals("RAW")) {
            return OutputPrefixType.RAW;
        }
        if (s.equals("LEGACY")) {
            return OutputPrefixType.LEGACY;
        }
        if (s.equals("CRUNCHY")) {
            return OutputPrefixType.CRUNCHY;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unknown output prefix type: ");
        sb.append(s);
        throw new JSONException(sb.toString());
    }
    
    private static KeyStatusType f(final String s) throws JSONException {
        if (s.equals("ENABLED")) {
            return KeyStatusType.ENABLED;
        }
        if (s.equals("DISABLED")) {
            return KeyStatusType.DISABLED;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unknown status: ");
        sb.append(s);
        throw new JSONException(sb.toString());
    }
    
    private KeyData g(final JSONObject jsonObject) throws JSONException {
        n(jsonObject);
        byte[] array;
        if (this.d) {
            array = Base64.i(jsonObject.getString("value"));
        }
        else {
            array = Base64.a(jsonObject.getString("value"));
        }
        return KeyData.R().E(jsonObject.getString("typeUrl")).F(ByteString.copyFrom(array)).D(d(jsonObject.getString("keyMaterialType"))).p();
    }
    
    private Keyset.Key h(final JSONObject jsonObject) throws JSONException {
        m(jsonObject);
        return ((GeneratedMessageLite.Builder<Keyset.Key, BuilderType>)Keyset.Key.T().G(f(jsonObject.getString("status"))).E(jsonObject.getInt("keyId")).F(e(jsonObject.getString("outputPrefixType"))).D(this.g(jsonObject.getJSONObject("keyData")))).p();
    }
    
    private static KeysetInfo.KeyInfo i(final JSONObject jsonObject) throws JSONException {
        return ((GeneratedMessageLite.Builder<KeysetInfo.KeyInfo, BuilderType>)KeysetInfo.KeyInfo.S().F(f(jsonObject.getString("status"))).D(jsonObject.getInt("keyId")).E(e(jsonObject.getString("outputPrefixType"))).G(jsonObject.getString("typeUrl"))).p();
    }
    
    private Keyset j(final JSONObject jsonObject) throws JSONException {
        o(jsonObject);
        final Keyset.Builder s = Keyset.S();
        if (jsonObject.has("primaryKeyId")) {
            s.H(jsonObject.getInt("primaryKeyId"));
        }
        final JSONArray jsonArray = jsonObject.getJSONArray("key");
        for (int i = 0; i < jsonArray.length(); ++i) {
            s.D(this.h(jsonArray.getJSONObject(i)));
        }
        return ((GeneratedMessageLite.Builder<Keyset, BuilderType>)s).p();
    }
    
    private static KeysetInfo k(final JSONObject jsonObject) throws JSONException {
        final KeysetInfo.Builder s = KeysetInfo.S();
        if (jsonObject.has("primaryKeyId")) {
            s.E(jsonObject.getInt("primaryKeyId"));
        }
        if (jsonObject.has("keyInfo")) {
            final JSONArray jsonArray = jsonObject.getJSONArray("keyInfo");
            for (int i = 0; i < jsonArray.length(); ++i) {
                s.D(i(jsonArray.getJSONObject(i)));
            }
        }
        return ((GeneratedMessageLite.Builder<KeysetInfo, BuilderType>)s).p();
    }
    
    private static void l(final JSONObject jsonObject) throws JSONException {
        if (jsonObject.has("encryptedKeyset")) {
            return;
        }
        throw new JSONException("invalid encrypted keyset");
    }
    
    private static void m(final JSONObject jsonObject) throws JSONException {
        if (jsonObject.has("keyData") && jsonObject.has("status") && jsonObject.has("keyId") && jsonObject.has("outputPrefixType")) {
            return;
        }
        throw new JSONException("invalid key");
    }
    
    private static void n(final JSONObject jsonObject) throws JSONException {
        if (jsonObject.has("typeUrl") && jsonObject.has("value") && jsonObject.has("keyMaterialType")) {
            return;
        }
        throw new JSONException("invalid keyData");
    }
    
    private static void o(final JSONObject jsonObject) throws JSONException {
        if (jsonObject.has("key") && jsonObject.getJSONArray("key").length() != 0) {
            return;
        }
        throw new JSONException("invalid keyset");
    }
    
    @Override
    public EncryptedKeyset a() throws IOException {
        try {
            try {
                final JSONObject b = this.b;
                if (b != null) {
                    final EncryptedKeyset c = this.c(b);
                    final InputStream a = this.a;
                    if (a != null && this.c) {
                        a.close();
                    }
                    return c;
                }
                final EncryptedKeyset c2 = this.c(new JSONObject(new String(com.google.crypto.tink.a.c(this.a), JsonKeysetReader.e)));
                final InputStream a2 = this.a;
                if (a2 != null && this.c) {
                    a2.close();
                }
                return c2;
            }
            finally {
                final InputStream a3 = this.a;
                if (a3 != null && this.c) {
                    a3.close();
                }
            }
        }
        catch (final JSONException ex) {}
    }
    
    @Override
    public Keyset b() throws IOException {
        try {
            try {
                final JSONObject b = this.b;
                if (b != null) {
                    final Keyset j = this.j(b);
                    final InputStream a = this.a;
                    if (a != null && this.c) {
                        a.close();
                    }
                    return j;
                }
                final Keyset i = this.j(new JSONObject(new String(com.google.crypto.tink.a.c(this.a), JsonKeysetReader.e)));
                final InputStream a2 = this.a;
                if (a2 != null && this.c) {
                    a2.close();
                }
                return i;
            }
            finally {
                final InputStream a3 = this.a;
                if (a3 != null && this.c) {
                    a3.close();
                }
            }
        }
        catch (final JSONException ex) {}
    }
}
