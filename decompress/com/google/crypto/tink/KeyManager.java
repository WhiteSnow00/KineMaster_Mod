// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;

public interface KeyManager<P>
{
    boolean a(final String p0);
    
    KeyData b(final ByteString p0) throws GeneralSecurityException;
    
    P c(final ByteString p0) throws GeneralSecurityException;
    
    MessageLite d(final ByteString p0) throws GeneralSecurityException;
}
