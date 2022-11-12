// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;
import com.google.crypto.tink.proto.EncryptedKeyset;

public interface KeysetReader
{
    EncryptedKeyset a() throws IOException;
    
    Keyset b() throws IOException;
}
