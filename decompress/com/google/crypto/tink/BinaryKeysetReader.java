// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.proto.EncryptedKeyset;
import java.io.InputStream;

public final class BinaryKeysetReader implements KeysetReader
{
    private final InputStream a;
    private final boolean b;
    
    @Override
    public EncryptedKeyset a() throws IOException {
        try {
            return EncryptedKeyset.P(this.a, ExtensionRegistryLite.b());
        }
        finally {
            if (this.b) {
                this.a.close();
            }
        }
    }
    
    @Override
    public Keyset b() throws IOException {
        try {
            return Keyset.T(this.a, ExtensionRegistryLite.b());
        }
        finally {
            if (this.b) {
                this.a.close();
            }
        }
    }
}
