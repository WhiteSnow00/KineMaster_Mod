// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle.prf;

import java.io.InputStream;
import com.google.errorprone.annotations.Immutable;

@Immutable
public interface StreamingPrf
{
    InputStream a(final byte[] p0);
}
