// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.common.collect.ImmutableMultimap;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import com.google.common.collect.ImmutableListMultimap$Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableListMultimap;

final class RtspHeaders
{
    public static final RtspHeaders b;
    private final ImmutableListMultimap<String, String> a;
    
    static {
        b = new Builder().e();
    }
    
    private RtspHeaders(final Builder builder) {
        this.a = (ImmutableListMultimap<String, String>)Builder.a(builder).f();
    }
    
    RtspHeaders(final Builder builder, final RtspHeaders$a object) {
        this(builder);
    }
    
    static String a(final String s) {
        return c(s);
    }
    
    private static String c(final String s) {
        if (Ascii.a((CharSequence)s, (CharSequence)"Accept")) {
            return "Accept";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Allow")) {
            return "Allow";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Authorization")) {
            return "Authorization";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Bandwidth")) {
            return "Bandwidth";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Blocksize")) {
            return "Blocksize";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Cache-Control")) {
            return "Cache-Control";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Connection")) {
            return "Connection";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Content-Base")) {
            return "Content-Base";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Content-Encoding")) {
            return "Content-Encoding";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Content-Language")) {
            return "Content-Language";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Content-Length")) {
            return "Content-Length";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Content-Location")) {
            return "Content-Location";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Content-Type")) {
            return "Content-Type";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"CSeq")) {
            return "CSeq";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Date")) {
            return "Date";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Expires")) {
            return "Expires";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Location")) {
            return "Location";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Proxy-Authenticate")) {
            return "Proxy-Authenticate";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Proxy-Require")) {
            return "Proxy-Require";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Public")) {
            return "Public";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Range")) {
            return "Range";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"RTP-Info")) {
            return "RTP-Info";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"RTCP-Interval")) {
            return "RTCP-Interval";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Scale")) {
            return "Scale";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Session")) {
            return "Session";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Speed")) {
            return "Speed";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Supported")) {
            return "Supported";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Timestamp")) {
            return "Timestamp";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Transport")) {
            return "Transport";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"User-Agent")) {
            return "User-Agent";
        }
        if (Ascii.a((CharSequence)s, (CharSequence)"Via")) {
            return "Via";
        }
        String s2 = s;
        if (Ascii.a((CharSequence)s, (CharSequence)"WWW-Authenticate")) {
            s2 = "WWW-Authenticate";
        }
        return s2;
    }
    
    public ImmutableListMultimap<String, String> b() {
        return this.a;
    }
    
    public String d(final String s) {
        final ImmutableList<String> e = this.e(s);
        if (((AbstractCollection)e).isEmpty()) {
            return null;
        }
        return (String)Iterables.h((Iterable)e);
    }
    
    public ImmutableList<String> e(final String s) {
        return (ImmutableList<String>)this.a.get((Object)c(s));
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof RtspHeaders && ((ImmutableMultimap)this.a).equals((Object)((RtspHeaders)o).a));
    }
    
    @Override
    public int hashCode() {
        return ((ImmutableMultimap)this.a).hashCode();
    }
    
    public static final class Builder
    {
        private final ImmutableListMultimap$Builder<String, String> a;
        
        public Builder() {
            this.a = (ImmutableListMultimap$Builder<String, String>)new ImmutableListMultimap$Builder();
        }
        
        public Builder(final String s, final String s2, final int n) {
            this();
            this.b("User-Agent", s);
            this.b("CSeq", String.valueOf(n));
            if (s2 != null) {
                this.b("Session", s2);
            }
        }
        
        static ImmutableListMultimap$Builder a(final Builder builder) {
            return builder.a;
        }
        
        public Builder b(final String s, final String s2) {
            this.a.g((Object)RtspHeaders.a(s.trim()), (Object)s2.trim());
            return this;
        }
        
        public Builder c(final List<String> list) {
            for (int i = 0; i < list.size(); ++i) {
                final String[] u0 = Util.U0(list.get(i), ":\\s?");
                if (u0.length == 2) {
                    this.b(u0[0], u0[1]);
                }
            }
            return this;
        }
        
        public Builder d(final Map<String, String> map) {
            for (final Map.Entry entry : map.entrySet()) {
                this.b((String)entry.getKey(), (String)entry.getValue());
            }
            return this;
        }
        
        public RtspHeaders e() {
            return new RtspHeaders(this, null);
        }
    }
}
