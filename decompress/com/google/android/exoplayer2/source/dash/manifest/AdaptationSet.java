// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class AdaptationSet
{
    public final int a;
    public final int b;
    public final List<Representation> c;
    public final List<Descriptor> d;
    public final List<Descriptor> e;
    public final List<Descriptor> f;
    
    public AdaptationSet(final int a, final int b, final List<Representation> list, final List<Descriptor> list2, final List<Descriptor> list3, final List<Descriptor> list4) {
        this.a = a;
        this.b = b;
        this.c = Collections.unmodifiableList((List<? extends Representation>)list);
        this.d = Collections.unmodifiableList((List<? extends Descriptor>)list2);
        this.e = Collections.unmodifiableList((List<? extends Descriptor>)list3);
        this.f = Collections.unmodifiableList((List<? extends Descriptor>)list4);
    }
}
