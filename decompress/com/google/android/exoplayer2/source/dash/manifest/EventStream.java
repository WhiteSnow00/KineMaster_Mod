// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

public final class EventStream
{
    public final EventMessage[] a;
    public final long[] b;
    public final String c;
    public final String d;
    public final long e;
    
    public EventStream(final String c, final String d, final long e, final long[] b, final EventMessage[] a) {
        this.c = c;
        this.d = d;
        this.e = e;
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append("/");
        sb.append(this.d);
        return sb.toString();
    }
}
