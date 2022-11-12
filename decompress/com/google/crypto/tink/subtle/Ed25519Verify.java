// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;

public final class Ed25519Verify implements PublicKeyVerify
{
    private final ImmutableByteArray a;
    
    public Ed25519Verify(final byte[] array) {
        if (array.length == 32) {
            this.a = ImmutableByteArray.a(array);
            return;
        }
        throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
    }
}
