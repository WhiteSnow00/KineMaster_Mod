// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.io.IOException;
import java.security.GeneralSecurityException;

public final class CleartextKeysetHandle
{
    public static KeysetHandle a(final KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        return KeysetHandle.e(keysetReader.b());
    }
    
    public static void b(final KeysetHandle keysetHandle, final KeysetWriter keysetWriter) throws IOException {
        keysetWriter.a(keysetHandle.f());
    }
}
