// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeySign;

public final class Ed25519Sign implements PublicKeySign
{
    private final byte[] a;
    private final byte[] b;
    
    public Ed25519Sign(byte[] e) throws GeneralSecurityException {
        if (e.length == 32) {
            e = f.e(e);
            this.a = e;
            this.b = f.i(e);
            return;
        }
        throw new IllegalArgumentException(String.format("Given private key's length is not %s", 32));
    }
    
    public static final class KeyPair
    {
        private final byte[] a;
        private final byte[] b;
        
        private KeyPair(final byte[] a, final byte[] b) {
            this.a = a;
            this.b = b;
        }
        
        public static KeyPair c() throws GeneralSecurityException {
            final byte[] c = Random.c(32);
            return new KeyPair(f.i(f.e(c)), c);
        }
        
        public byte[] a() {
            final byte[] b = this.b;
            return Arrays.copyOf(b, b.length);
        }
        
        public byte[] b() {
            final byte[] a = this.a;
            return Arrays.copyOf(a, a.length);
        }
    }
}
