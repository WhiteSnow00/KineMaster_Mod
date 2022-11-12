// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import java.io.IOException;
import com.google.crypto.tink.proto.Keyset;
import java.io.OutputStream;

public final class BinaryKeysetWriter implements KeysetWriter
{
    private final OutputStream a;
    private final boolean b;
    
    @Override
    public void a(final Keyset keyset) throws IOException {
        try {
            keyset.j(this.a);
        }
        finally {
            if (this.b) {
                this.a.close();
            }
        }
    }
    
    @Override
    public void b(final EncryptedKeyset encryptedKeyset) throws IOException {
        try {
            encryptedKeyset.j(this.a);
        }
        finally {
            if (this.b) {
                this.a.close();
            }
        }
    }
}
