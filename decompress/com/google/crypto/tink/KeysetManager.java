// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.security.SecureRandom;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.KeyTemplate;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;
import com.google.crypto.tink.proto.Keyset;

public final class KeysetManager
{
    @GuardedBy
    private final Keyset.Builder a;
    
    private KeysetManager(final Keyset.Builder a) {
        this.a = a;
    }
    
    private boolean d(final int n) {
        synchronized (this) {
            final Iterator<Keyset.Key> iterator = this.a.G().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().P() == n) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private Keyset.Key e(final KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            final KeyData q = Registry.q(keyTemplate);
            final int f = this.f();
            OutputPrefixType outputPrefixType;
            if ((outputPrefixType = keyTemplate.O()) == OutputPrefixType.UNKNOWN_PREFIX) {
                outputPrefixType = OutputPrefixType.TINK;
            }
            return (Keyset.Key)Keyset.Key.T().D(q).E(f).G(KeyStatusType.ENABLED).F(outputPrefixType).p();
        }
    }
    
    private int f() {
        synchronized (this) {
            int n;
            for (n = g(); this.d(n); n = g()) {}
            return n;
        }
    }
    
    private static int g() {
        final SecureRandom secureRandom = new SecureRandom();
        byte[] array;
        int i;
        for (array = new byte[4], i = 0; i == 0; i = ((array[0] & 0x7F) << 24 | (array[1] & 0xFF) << 16 | (array[2] & 0xFF) << 8 | (array[3] & 0xFF))) {
            secureRandom.nextBytes(array);
        }
        return i;
    }
    
    public static KeysetManager i() {
        return new KeysetManager(Keyset.S());
    }
    
    public static KeysetManager j(final KeysetHandle keysetHandle) {
        return new KeysetManager(((GeneratedMessageLite<MessageType, Keyset.Builder>)keysetHandle.f()).I());
    }
    
    public KeysetManager a(final com.google.crypto.tink.KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (this) {
            this.b(keyTemplate.b(), false);
            return this;
        }
    }
    
    @Deprecated
    public int b(final KeyTemplate keyTemplate, final boolean b) throws GeneralSecurityException {
        synchronized (this) {
            final Keyset.Key e = this.e(keyTemplate);
            this.a.D(e);
            if (b) {
                this.a.H(e.P());
            }
            return e.P();
        }
    }
    
    public KeysetHandle c() throws GeneralSecurityException {
        synchronized (this) {
            return KeysetHandle.e(((GeneratedMessageLite.Builder<Keyset, BuilderType>)this.a).p());
        }
    }
    
    public KeysetManager h(final int n) throws GeneralSecurityException {
        monitorenter(this);
        int i = 0;
        try {
            while (i < this.a.F()) {
                final Keyset.Key e = this.a.E(i);
                if (e.P() == n) {
                    if (e.R().equals(KeyStatusType.ENABLED)) {
                        this.a.H(n);
                        return this;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("cannot set key as primary because it's not enabled: ");
                    sb.append(n);
                    throw new GeneralSecurityException(sb.toString());
                }
                else {
                    ++i;
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("key not found: ");
            sb2.append(n);
            throw new GeneralSecurityException(sb2.toString());
        }
        finally {
            monitorexit(this);
        }
    }
}
