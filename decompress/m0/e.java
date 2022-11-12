// 
// Decompiled by Procyon v0.6.0
// 

package m0;

import android.text.TextUtils;

class e implements c
{
    private String a;
    private int b;
    private int c;
    
    e(final String a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = true;
        boolean b2 = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof e)) {
            return false;
        }
        final e e = (e)o;
        if (this.b >= 0 && e.b >= 0) {
            if (!TextUtils.equals((CharSequence)this.a, (CharSequence)e.a) || this.b != e.b || this.c != e.c) {
                b2 = false;
            }
            return b2;
        }
        return TextUtils.equals((CharSequence)this.a, (CharSequence)e.a) && this.c == e.c && b;
    }
    
    @Override
    public int hashCode() {
        return androidx.core.util.c.b(this.a, this.c);
    }
}
