// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.integration.android;

import com.google.crypto.tink.proto.EncryptedKeyset;
import java.io.IOException;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.proto.Keyset;
import android.preference.PreferenceManager;
import android.content.Context;
import android.content.SharedPreferences$Editor;
import com.google.crypto.tink.KeysetWriter;

public final class SharedPrefKeysetWriter implements KeysetWriter
{
    private final SharedPreferences$Editor a;
    private final String b;
    
    public SharedPrefKeysetWriter(Context applicationContext, final String b, final String s) {
        if (b != null) {
            this.b = b;
            applicationContext = applicationContext.getApplicationContext();
            if (s == null) {
                this.a = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            }
            else {
                this.a = applicationContext.getSharedPreferences(s, 0).edit();
            }
            return;
        }
        throw new IllegalArgumentException("keysetName cannot be null");
    }
    
    @Override
    public void a(final Keyset keyset) throws IOException {
        if (this.a.putString(this.b, Hex.b(keyset.c())).commit()) {
            return;
        }
        throw new IOException("Failed to write to SharedPreferences");
    }
    
    @Override
    public void b(final EncryptedKeyset encryptedKeyset) throws IOException {
        if (this.a.putString(this.b, Hex.b(encryptedKeyset.c())).commit()) {
            return;
        }
        throw new IOException("Failed to write to SharedPreferences");
    }
}
