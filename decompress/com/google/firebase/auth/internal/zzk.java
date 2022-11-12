// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase_auth_api.zzbg;
import com.google.android.gms.internal.firebase-auth-api.zzbi;
import java.io.OutputStream;
import com.google.android.gms.internal.firebase_auth_api.zzaq;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import android.util.Base64;
import com.google.android.gms.internal.firebase_auth_api.zzau;
import com.google.android.gms.internal.firebase_auth_api.zzu;
import android.util.Log;
import java.security.GeneralSecurityException;
import java.io.IOException;
import com.google.android.gms.internal.firebase_auth_api.zzem;
import com.google.android.gms.internal.firebase_auth_api.zzff;
import com.google.android.gms.internal.firebase_auth_api.zzeh;
import android.content.Context;
import com.google.android.gms.internal.firebase-auth-api.zzfh;

public final class zzk
{
    private static zzk c;
    private final String a;
    private final zzfh b;
    
    private zzk(Context zzg, final String a, final boolean b) {
        this.a = a;
        Label_0106: {
            try {
                zzeh.zza();
                final zzff zzff = new zzff();
                zzff.zzf((Context)zzg, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", a));
                zzff.zzd(zzem.zza);
                zzff.zze(String.format("android-keystore://firebear_master_key_id.%s", a));
                zzg = (IOException)zzff.zzg();
                break Label_0106;
            }
            catch (final IOException zzg) {}
            catch (final GeneralSecurityException ex) {}
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n".concat(String.valueOf(zzg.getMessage())));
            zzg = null;
        }
        this.b = (zzfh)zzg;
    }
    
    public static zzk a(final Context context, final String s) {
        final zzk c = zzk.c;
        if (c == null || !zzu.zza((Object)c.a, (Object)s)) {
            zzk.c = new zzk(context, s, true);
        }
        return zzk.c;
    }
    
    public final String b(final String ex) {
        final zzfh b = this.b;
        if (b != null) {
            try {
                synchronized (b) {
                    return new String(((zzau)((zzbg)((com.google.android.gms.internal.firebase_auth_api.zzfh)this.b).zza()).zze((Class)com.google.android.gms.internal.firebase-auth-api.zzau.class)).zza(Base64.decode((String)ex, 8), (byte[])null), "UTF-8");
                }
            }
            catch (final UnsupportedEncodingException ex) {}
            catch (final GeneralSecurityException ex2) {}
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n".concat(String.valueOf(ex.getMessage())));
            return null;
        }
        Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
        return null;
    }
    
    public final String c() {
        if (this.b == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final zzbi zza = zzaq.zza((OutputStream)byteArrayOutputStream);
        try {
            synchronized (this.b) {
                ((zzbg)((zzbg)((com.google.android.gms.internal.firebase_auth_api.zzfh)this.b).zza()).zzb()).zzg(zza);
                monitorexit(this.b);
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
            }
        }
        catch (final IOException ex) {}
        catch (final GeneralSecurityException ex2) {}
        final IOException ex;
        Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n".concat(String.valueOf(ex.getMessage())));
        return null;
    }
}
