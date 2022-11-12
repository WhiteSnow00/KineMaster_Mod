// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.integration.android;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.proto.EncryptedKeyset;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import com.google.crypto.tink.subtle.Hex;
import java.io.IOException;
import android.preference.PreferenceManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.crypto.tink.KeysetReader;

public final class SharedPrefKeysetReader implements KeysetReader
{
    private final SharedPreferences a;
    private final String b;
    
    public SharedPrefKeysetReader(Context applicationContext, final String b, final String s) throws IOException {
        if (b != null) {
            this.b = b;
            applicationContext = applicationContext.getApplicationContext();
            if (s == null) {
                this.a = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            }
            else {
                this.a = applicationContext.getSharedPreferences(s, 0);
            }
            return;
        }
        throw new IllegalArgumentException("keysetName cannot be null");
    }
    
    private byte[] c() throws IOException {
        try {
            final String string = this.a.getString(this.b, (String)null);
            if (string != null) {
                return Hex.a(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.b));
        }
        catch (final ClassCastException | IllegalArgumentException ex) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.b));
        }
    }
    
    @Override
    public EncryptedKeyset a() throws IOException {
        return EncryptedKeyset.Q(this.c(), ExtensionRegistryLite.b());
    }
    
    @Override
    public Keyset b() throws IOException {
        return Keyset.U(this.c(), ExtensionRegistryLite.b());
    }
}
