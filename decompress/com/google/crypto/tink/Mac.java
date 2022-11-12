// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface Mac
{
    void a(final byte[] p0, final byte[] p1) throws GeneralSecurityException;
    
    byte[] b(final byte[] p0) throws GeneralSecurityException;
}
