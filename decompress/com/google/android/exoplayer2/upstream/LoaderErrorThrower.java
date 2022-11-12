// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface LoaderErrorThrower
{
    void a() throws IOException;
    
    public static final class Dummy implements LoaderErrorThrower
    {
        @Override
        public void a() {
        }
    }
}
