// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.common.base.Objects;

public final class BaseUrl
{
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    
    public BaseUrl(final String a, final String b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseUrl)) {
            return false;
        }
        final BaseUrl baseUrl = (BaseUrl)o;
        if (this.c != baseUrl.c || this.d != baseUrl.d || !Objects.a((Object)this.a, (Object)baseUrl.a) || !Objects.a((Object)this.b, (Object)baseUrl.b)) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return Objects.b(new Object[] { this.a, this.b, this.c, this.d });
    }
}
