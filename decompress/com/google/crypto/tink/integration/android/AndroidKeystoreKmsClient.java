// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.integration.android;

import java.io.IOException;
import android.util.Log;
import java.util.Locale;
import java.security.KeyStoreException;
import java.util.Arrays;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.Aead;
import java.security.spec.AlgorithmParameterSpec;
import android.security.keystore.KeyGenParameterSpec$Builder;
import javax.crypto.KeyGenerator;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import javax.annotation.concurrent.GuardedBy;
import java.security.KeyStore;
import com.google.crypto.tink.KmsClient;

public final class AndroidKeystoreKmsClient implements KmsClient
{
    private static final String c = "AndroidKeystoreKmsClient";
    private final String a;
    @GuardedBy
    private KeyStore b;
    
    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }
    
    private AndroidKeystoreKmsClient(final Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
    }
    
    AndroidKeystoreKmsClient(final Builder builder, final AndroidKeystoreKmsClient$a object) {
        this(builder);
    }
    
    static boolean c() {
        return f();
    }
    
    public static void d(final String s) throws GeneralSecurityException {
        if (!new AndroidKeystoreKmsClient().e(s)) {
            final String b = Validators.b("android-keystore://", s);
            final KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init((AlgorithmParameterSpec)new KeyGenParameterSpec$Builder(b, 3).setKeySize(256).setBlockModes(new String[] { "GCM" }).setEncryptionPaddings(new String[] { "NoPadding" }).build());
            instance.generateKey();
            return;
        }
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", s));
    }
    
    private static boolean f() {
        return true;
    }
    
    private static Aead g(final Aead aead) throws GeneralSecurityException {
        final byte[] c = Random.c(10);
        final byte[] array = new byte[0];
        if (Arrays.equals(c, aead.b(aead.a(c, array), array))) {
            return aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }
    
    @Override
    public boolean a(final String s) {
        synchronized (this) {
            final String a = this.a;
            boolean b = true;
            if (a != null && a.equals(s)) {
                return true;
            }
            if (this.a != null || !s.toLowerCase(Locale.US).startsWith("android-keystore://")) {
                b = false;
            }
            return b;
        }
    }
    
    @Override
    public Aead b(final String s) throws GeneralSecurityException {
        synchronized (this) {
            final String a = this.a;
            if (a != null && !a.equals(s)) {
                throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.a, s));
            }
            return g(new AndroidKeystoreAesGcm(Validators.b("android-keystore://", s), this.b));
        }
    }
    
    boolean e(String b) throws GeneralSecurityException {
        monitorenter(this);
        try {
            b = Validators.b("android-keystore://", (String)b);
            try {
                return this.b.containsAlias((String)b);
            }
            catch (final NullPointerException ex) {
                Log.w(AndroidKeystoreKmsClient.c, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
                try {
                    Thread.sleep(20L);
                    (this.b = KeyStore.getInstance("AndroidKeyStore")).load(null);
                    return this.b.containsAlias((String)b);
                }
                catch (final IOException ex2) {
                    throw new GeneralSecurityException(ex2);
                }
                catch (final InterruptedException ex3) {}
            }
        }
        finally {}
    }
    
    public static final class Builder
    {
        String a;
        KeyStore b;
        
        public Builder() {
            this.a = null;
            this.b = null;
            if (AndroidKeystoreKmsClient.c()) {
                KeyStore instance = null;
                try {
                    instance = KeyStore.getInstance("AndroidKeyStore");
                    (this.b = instance).load(null);
                    return;
                }
                catch (final IOException instance) {}
                catch (final GeneralSecurityException ex) {}
                throw new IllegalStateException((Throwable)instance);
            }
            throw new IllegalStateException("need Android Keystore on Android M or newer");
        }
        
        public AndroidKeystoreKmsClient a() {
            return new AndroidKeystoreKmsClient(this, null);
        }
        
        public Builder b(final KeyStore b) {
            if (b != null) {
                this.b = b;
                return this;
            }
            throw new IllegalArgumentException("val cannot be null");
        }
    }
}
