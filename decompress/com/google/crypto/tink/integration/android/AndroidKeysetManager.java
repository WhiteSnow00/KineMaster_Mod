// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.integration.android;

import android.content.Context;
import java.security.KeyStoreException;
import java.security.ProviderException;
import java.io.FileNotFoundException;
import com.google.crypto.tink.CleartextKeysetHandle;
import android.util.Log;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.security.KeyStore;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.KeysetHandle;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.annotation.concurrent.GuardedBy;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetWriter;

public final class AndroidKeysetManager
{
    private static final String d = "AndroidKeysetManager";
    private final KeysetWriter a;
    private final Aead b;
    @GuardedBy
    private KeysetManager c;
    
    private AndroidKeysetManager(final Builder builder) throws GeneralSecurityException, IOException {
        this.a = Builder.a(builder);
        this.b = Builder.b(builder);
        this.c = Builder.c(builder);
    }
    
    AndroidKeysetManager(final Builder builder, final AndroidKeysetManager$a object) throws GeneralSecurityException, IOException {
        this(builder);
    }
    
    static boolean a() {
        return d();
    }
    
    static String b() {
        return AndroidKeysetManager.d;
    }
    
    private static boolean d() {
        return true;
    }
    
    public KeysetHandle c() throws GeneralSecurityException {
        synchronized (this) {
            return this.c.c();
        }
    }
    
    public static final class Builder
    {
        private KeysetReader a;
        private KeysetWriter b;
        private String c;
        private Aead d;
        private boolean e;
        private KeyTemplate f;
        private KeyStore g;
        @GuardedBy
        private KeysetManager h;
        
        public Builder() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = true;
            this.f = null;
            this.g = null;
        }
        
        static KeysetWriter a(final Builder builder) {
            return builder.b;
        }
        
        static Aead b(final Builder builder) {
            return builder.d;
        }
        
        static KeysetManager c(final Builder builder) {
            return builder.h;
        }
        
        private KeysetManager e() throws GeneralSecurityException, IOException {
            Object o = this.d;
            if (o != null) {
                try {
                    o = KeysetManager.j(KeysetHandle.j(this.a, (Aead)o));
                    return (KeysetManager)o;
                }
                catch (final GeneralSecurityException o) {}
                catch (final InvalidProtocolBufferException ex) {}
                Log.w(AndroidKeysetManager.b(), "cannot decrypt keyset: ", (Throwable)o);
            }
            return KeysetManager.j(CleartextKeysetHandle.a(this.a));
        }
        
        private KeysetManager f() throws GeneralSecurityException, IOException {
            try {
                return this.e();
            }
            catch (final FileNotFoundException ex) {
                Log.w(AndroidKeysetManager.b(), "keyset not found, will generate a new one", (Throwable)ex);
                if (this.f != null) {
                    final KeysetManager a = KeysetManager.i().a(this.f);
                    final KeysetManager h = a.h(a.c().g().P(0).O());
                    if (this.d != null) {
                        h.c().k(this.b, this.d);
                    }
                    else {
                        CleartextKeysetHandle.b(h.c(), this.b);
                    }
                    return h;
                }
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }
        
        private Aead g() throws GeneralSecurityException {
            if (!AndroidKeysetManager.a()) {
                Log.w(AndroidKeysetManager.b(), "Android Keystore requires at least Android M");
                return null;
            }
            Object o;
            if (this.g != null) {
                o = new AndroidKeystoreKmsClient.Builder().b(this.g).a();
            }
            else {
                o = new AndroidKeystoreKmsClient();
            }
            final boolean e = ((AndroidKeystoreKmsClient)o).e(this.c);
            Label_0093: {
                if (!e) {
                    try {
                        AndroidKeystoreKmsClient.d(this.c);
                        break Label_0093;
                    }
                    catch (final ProviderException o) {}
                    catch (final GeneralSecurityException ex) {}
                    Log.w(AndroidKeysetManager.b(), "cannot use Android Keystore, it'll be disabled", (Throwable)o);
                    return null;
                }
                try {
                    o = ((AndroidKeystoreKmsClient)o).b(this.c);
                    return (Aead)o;
                }
                catch (final ProviderException o) {}
                catch (final GeneralSecurityException ex2) {}
            }
            if (!e) {
                Log.w(AndroidKeysetManager.b(), "cannot use Android Keystore, it'll be disabled", (Throwable)o);
                return null;
            }
            throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.c), (Throwable)o);
        }
        
        public AndroidKeysetManager d() throws GeneralSecurityException, IOException {
            synchronized (this) {
                if (this.c != null) {
                    this.d = this.g();
                }
                this.h = this.f();
                return new AndroidKeysetManager(this, null);
            }
        }
        
        public Builder h(final KeyTemplate f) {
            this.f = f;
            return this;
        }
        
        public Builder i(final String c) {
            if (!c.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (this.e) {
                this.c = c;
                return this;
            }
            throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
        }
        
        public Builder j(final Context context, final String s, final String s2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (s != null) {
                this.a = new SharedPrefKeysetReader(context, s, s2);
                this.b = new SharedPrefKeysetWriter(context, s, s2);
                return this;
            }
            throw new IllegalArgumentException("need a keyset name");
        }
    }
}
