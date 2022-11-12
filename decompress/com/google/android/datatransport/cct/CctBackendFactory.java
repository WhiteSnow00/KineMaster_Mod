// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.backends.CreationContext;
import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.BackendFactory;

@Keep
public class CctBackendFactory implements BackendFactory
{
    @Override
    public TransportBackend create(final CreationContext creationContext) {
        return new c(creationContext.b(), creationContext.e(), creationContext.d());
    }
}
