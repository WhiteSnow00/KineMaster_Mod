// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

public final class Random
{
    private static final ThreadLocal<SecureRandom> a;
    
    static {
        a = new ThreadLocal<SecureRandom>() {
            protected SecureRandom a() {
                return Random.a();
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.a();
            }
        };
    }
    
    static SecureRandom a() {
        return b();
    }
    
    private static SecureRandom b() {
        final SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
    
    public static byte[] c(final int n) {
        final byte[] array = new byte[n];
        Random.a.get().nextBytes(array);
        return array;
    }
    
    public static final int d() {
        return Random.a.get().nextInt();
    }
}
