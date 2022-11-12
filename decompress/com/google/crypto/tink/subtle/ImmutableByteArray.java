// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

public final class ImmutableByteArray
{
    private final byte[] a;
    
    private ImmutableByteArray(final byte[] array, final int n, final int n2) {
        System.arraycopy(array, n, this.a = new byte[n2], 0, n2);
    }
    
    public static ImmutableByteArray a(final byte[] array) {
        if (array == null) {
            return null;
        }
        return b(array, 0, array.length);
    }
    
    public static ImmutableByteArray b(final byte[] array, final int n, final int n2) {
        return new ImmutableByteArray(array, n, n2);
    }
}
