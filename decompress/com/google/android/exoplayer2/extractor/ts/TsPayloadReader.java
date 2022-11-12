// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.util.SparseArray;
import java.util.Collections;
import java.util.List;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public interface TsPayloadReader
{
    void a(final TimestampAdjuster p0, final ExtractorOutput p1, final TrackIdGenerator p2);
    
    void b(final ParsableByteArray p0, final int p1) throws ParserException;
    
    void c();
    
    public static final class DvbSubtitleInfo
    {
        public final String a;
        public final int b;
        public final byte[] c;
        
        public DvbSubtitleInfo(final String a, final int b, final byte[] c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static final class EsInfo
    {
        public final int a;
        public final String b;
        public final List<DvbSubtitleInfo> c;
        public final byte[] d;
        
        public EsInfo(final int a, final String b, final List<DvbSubtitleInfo> list, final byte[] d) {
            this.a = a;
            this.b = b;
            List<Object> c;
            if (list == null) {
                c = (List<Object>)Collections.emptyList();
            }
            else {
                c = (List<Object>)Collections.unmodifiableList((List<? extends DvbSubtitleInfo>)list);
            }
            this.c = (List<DvbSubtitleInfo>)c;
            this.d = d;
        }
    }
    
    public interface Factory
    {
        SparseArray<TsPayloadReader> a();
        
        TsPayloadReader b(final int p0, final EsInfo p1);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
    
    public static final class TrackIdGenerator
    {
        private final String a;
        private final int b;
        private final int c;
        private int d;
        private String e;
        
        public TrackIdGenerator(final int n, final int n2) {
            this(Integer.MIN_VALUE, n, n2);
        }
        
        public TrackIdGenerator(final int n, final int b, final int c) {
            String string;
            if (n != Integer.MIN_VALUE) {
                final StringBuilder sb = new StringBuilder();
                sb.append(n);
                sb.append("/");
                string = sb.toString();
            }
            else {
                string = "";
            }
            this.a = string;
            this.b = b;
            this.c = c;
            this.d = Integer.MIN_VALUE;
            this.e = "";
        }
        
        private void d() {
            if (this.d != Integer.MIN_VALUE) {
                return;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
        
        public void a() {
            final int d = this.d;
            int b;
            if (d == Integer.MIN_VALUE) {
                b = this.b;
            }
            else {
                b = d + this.c;
            }
            this.d = b;
            final StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(this.d);
            this.e = sb.toString();
        }
        
        public String b() {
            this.d();
            return this.e;
        }
        
        public int c() {
            this.d();
            return this.d;
        }
    }
}
