// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.content.res.TypedArray;
import d.j;
import android.util.AttributeSet;
import android.text.method.NumberKeyListener;
import android.text.method.KeyListener;
import e0.a;
import android.widget.EditText;

class i
{
    private final EditText a;
    private final a b;
    
    i(final EditText a) {
        this.a = a;
        this.b = new a(a, false);
    }
    
    KeyListener a(final KeyListener keyListener) {
        KeyListener a = keyListener;
        if (this.b(keyListener)) {
            a = this.b.a(keyListener);
        }
        return a;
    }
    
    boolean b(final KeyListener keyListener) {
        return keyListener instanceof NumberKeyListener ^ true;
    }
    
    boolean c() {
        return this.b.b();
    }
    
    void d(final AttributeSet set, int u0) {
        final TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(set, j.g0, u0, 0);
        try {
            u0 = j.u0;
            final boolean hasValue = obtainStyledAttributes.hasValue(u0);
            boolean boolean1 = true;
            if (hasValue) {
                boolean1 = obtainStyledAttributes.getBoolean(u0, true);
            }
            obtainStyledAttributes.recycle();
            this.f(boolean1);
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    InputConnection e(final InputConnection inputConnection, final EditorInfo editorInfo) {
        return this.b.c(inputConnection, editorInfo);
    }
    
    void f(final boolean b) {
        this.b.d(b);
    }
}
