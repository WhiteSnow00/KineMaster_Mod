// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory
{
    @Override
    public SequenceableLoader a(final SequenceableLoader... array) {
        return new CompositeSequenceableLoader(array);
    }
}
