// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import java.io.IOException;
import com.google.crypto.tink.proto.Keyset;

public interface KeysetWriter
{
    void a(final Keyset p0) throws IOException;
    
    void b(final EncryptedKeyset p0) throws IOException;
}
