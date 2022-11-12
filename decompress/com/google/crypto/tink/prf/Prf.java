// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;
import com.google.errorprone.annotations.Immutable;

@Immutable
public interface Prf
{
    byte[] a(final byte[] p0, final int p1) throws GeneralSecurityException;
}
