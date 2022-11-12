// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import androidx.core.util.h;
import android.view.ContentInfo$Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build$VERSION;
import java.util.Objects;
import android.content.ClipData;
import android.view.ContentInfo;

public final class c
{
    private final f a;
    
    c(final f a) {
        this.a = a;
    }
    
    static String a(final int n) {
        if ((n & 0x1) != 0x0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(n);
    }
    
    static String e(final int n) {
        if (n == 0) {
            return "SOURCE_APP";
        }
        if (n == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (n == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (n == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (n == 4) {
            return "SOURCE_AUTOFILL";
        }
        if (n != 5) {
            return String.valueOf(n);
        }
        return "SOURCE_PROCESS_TEXT";
    }
    
    public static c g(final ContentInfo contentInfo) {
        return new c((f)new e(contentInfo));
    }
    
    public ClipData b() {
        return this.a.i();
    }
    
    public int c() {
        return this.a.getFlags();
    }
    
    public int d() {
        return this.a.g();
    }
    
    public ContentInfo f() {
        final ContentInfo h = this.a.h();
        Objects.requireNonNull(h);
        final ContentInfo contentInfo = h;
        return h;
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
    
    public static final class a
    {
        private final c a;
        
        public a(final ClipData clipData, final int n) {
            if (Build$VERSION.SDK_INT >= 31) {
                this.a = new b(clipData, n);
            }
            else {
                this.a = new d(clipData, n);
            }
        }
        
        public c a() {
            return this.a.build();
        }
        
        public a b(final Bundle extras) {
            this.a.setExtras(extras);
            return this;
        }
        
        public a c(final int flags) {
            this.a.setFlags(flags);
            return this;
        }
        
        public a d(final Uri uri) {
            this.a.a(uri);
            return this;
        }
    }
    
    private static final class b implements c
    {
        private final ContentInfo$Builder a;
        
        b(final ClipData clipData, final int n) {
            this.a = new ContentInfo$Builder(clipData, n);
        }
        
        @Override
        public void a(final Uri linkUri) {
            this.a.setLinkUri(linkUri);
        }
        
        @Override
        public c build() {
            return new c((f)new e(this.a.build()));
        }
        
        @Override
        public void setExtras(final Bundle extras) {
            this.a.setExtras(extras);
        }
        
        @Override
        public void setFlags(final int flags) {
            this.a.setFlags(flags);
        }
    }
    
    private interface c
    {
        void a(final Uri p0);
        
        androidx.core.view.c build();
        
        void setExtras(final Bundle p0);
        
        void setFlags(final int p0);
    }
    
    private static final class d implements c
    {
        ClipData a;
        int b;
        int c;
        Uri d;
        Bundle e;
        
        d(final ClipData a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void a(final Uri d) {
            this.d = d;
        }
        
        @Override
        public c build() {
            return new c((f)new g(this));
        }
        
        @Override
        public void setExtras(final Bundle e) {
            this.e = e;
        }
        
        @Override
        public void setFlags(final int c) {
            this.c = c;
        }
    }
    
    private static final class e implements f
    {
        private final ContentInfo a;
        
        e(final ContentInfo contentInfo) {
            this.a = h.g(contentInfo);
        }
        
        @Override
        public int g() {
            return this.a.getSource();
        }
        
        @Override
        public int getFlags() {
            return this.a.getFlags();
        }
        
        @Override
        public ContentInfo h() {
            return this.a;
        }
        
        @Override
        public ClipData i() {
            return this.a.getClip();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
    }
    
    private interface f
    {
        int g();
        
        int getFlags();
        
        ContentInfo h();
        
        ClipData i();
    }
    
    private static final class g implements f
    {
        private final ClipData a;
        private final int b;
        private final int c;
        private final Uri d;
        private final Bundle e;
        
        g(final d d) {
            this.a = h.g(d.a);
            this.b = h.c(d.b, 0, 5, "source");
            this.c = h.f(d.c, 1);
            this.d = d.d;
            this.e = d.e;
        }
        
        @Override
        public int g() {
            return this.b;
        }
        
        @Override
        public int getFlags() {
            return this.c;
        }
        
        @Override
        public ContentInfo h() {
            return null;
        }
        
        @Override
        public ClipData i() {
            return this.a;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.a.getDescription());
            sb.append(", source=");
            sb.append(androidx.core.view.c.e(this.b));
            sb.append(", flags=");
            sb.append(androidx.core.view.c.a(this.c));
            final Uri d = this.d;
            final String s = "";
            String string;
            if (d == null) {
                string = "";
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(", hasLinkUri(");
                sb2.append(this.d.toString().length());
                sb2.append(")");
                string = sb2.toString();
            }
            sb.append(string);
            String s2;
            if (this.e == null) {
                s2 = s;
            }
            else {
                s2 = ", hasExtras";
            }
            sb.append(s2);
            sb.append("}");
            return sb.toString();
        }
    }
}
