// 
// Decompiled by Procyon v0.6.0
// 

package androidx.browser.customtabs;

import android.os.Bundle;

public final class a
{
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    
    a(final Integer a, final Integer b, final Integer c, final Integer d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    Bundle a() {
        final Bundle bundle = new Bundle();
        final Integer a = this.a;
        if (a != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", (int)a);
        }
        final Integer b = this.b;
        if (b != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", (int)b);
        }
        final Integer c = this.c;
        if (c != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", (int)c);
        }
        final Integer d = this.d;
        if (d != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", (int)d);
        }
        return bundle;
    }
    
    public static final class a
    {
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        
        public androidx.browser.customtabs.a a() {
            return new androidx.browser.customtabs.a(this.a, this.b, this.c, this.d);
        }
        
        public a b(final int n) {
            this.a = (n | 0xFF000000);
            return this;
        }
    }
}
