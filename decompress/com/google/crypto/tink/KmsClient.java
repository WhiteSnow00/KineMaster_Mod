// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface KmsClient
{
    boolean a(final String p0);
    
    Aead b(final String p0) throws GeneralSecurityException;
}
