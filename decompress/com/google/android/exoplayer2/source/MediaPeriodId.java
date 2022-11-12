// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public class MediaPeriodId
{
    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;
    
    protected MediaPeriodId(final MediaPeriodId mediaPeriodId) {
        this.a = mediaPeriodId.a;
        this.b = mediaPeriodId.b;
        this.c = mediaPeriodId.c;
        this.d = mediaPeriodId.d;
        this.e = mediaPeriodId.e;
    }
    
    public MediaPeriodId(final Object o) {
        this(o, -1L);
    }
    
    public MediaPeriodId(final Object o, final int n, final int n2, final long n3) {
        this(o, n, n2, n3, -1);
    }
    
    private MediaPeriodId(final Object a, final int b, final int c, final long d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public MediaPeriodId(final Object o, final long n) {
        this(o, -1, -1, n, -1);
    }
    
    public MediaPeriodId(final Object o, final long n, final int n2) {
        this(o, -1, -1, n, n2);
    }
    
    public MediaPeriodId a(final Object o) {
        MediaPeriodId mediaPeriodId;
        if (this.a.equals(o)) {
            mediaPeriodId = this;
        }
        else {
            mediaPeriodId = new MediaPeriodId(o, this.b, this.c, this.d, this.e);
        }
        return mediaPeriodId;
    }
    
    public boolean b() {
        return this.b != -1;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof MediaPeriodId)) {
            return false;
        }
        final MediaPeriodId mediaPeriodId = (MediaPeriodId)o;
        if (!this.a.equals(mediaPeriodId.a) || this.b != mediaPeriodId.b || this.c != mediaPeriodId.c || this.d != mediaPeriodId.d || this.e != mediaPeriodId.e) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return ((((527 + this.a.hashCode()) * 31 + this.b) * 31 + this.c) * 31 + (int)this.d) * 31 + this.e;
    }
}
