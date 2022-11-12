// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class u
{
    private int a;
    private int b;
    
    public u(final ViewGroup viewGroup) {
    }
    
    public int a() {
        return this.a | this.b;
    }
    
    public void b(final View view, final View view2, final int n) {
        this.c(view, view2, n, 0);
    }
    
    public void c(final View view, final View view2, final int n, final int n2) {
        if (n2 == 1) {
            this.b = n;
        }
        else {
            this.a = n;
        }
    }
    
    public void d(final View view) {
        this.e(view, 0);
    }
    
    public void e(final View view, final int n) {
        if (n == 1) {
            this.b = 0;
        }
        else {
            this.a = 0;
        }
    }
}
