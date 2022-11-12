// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.View;

class m
{
    boolean a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    boolean h;
    boolean i;
    
    m() {
        this.a = true;
        this.f = 0;
        this.g = 0;
    }
    
    boolean a(final RecyclerView.z z) {
        final int c = this.c;
        return c >= 0 && c < z.b();
    }
    
    View b(final RecyclerView.v v) {
        final View o = v.o(this.c);
        this.c += this.d;
        return o;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LayoutState{mAvailable=");
        sb.append(this.b);
        sb.append(", mCurrentPosition=");
        sb.append(this.c);
        sb.append(", mItemDirection=");
        sb.append(this.d);
        sb.append(", mLayoutDirection=");
        sb.append(this.e);
        sb.append(", mStartLine=");
        sb.append(this.f);
        sb.append(", mEndLine=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
