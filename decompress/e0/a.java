// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import android.widget.TextView;
import android.text.method.NumberKeyListener;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.text.method.KeyListener;
import androidx.core.util.h;
import android.widget.EditText;

public final class a
{
    private final b a;
    private int b;
    private int c;
    
    public a(final EditText editText, final boolean b) {
        this.b = Integer.MAX_VALUE;
        this.c = 0;
        h.h(editText, "editText cannot be null");
        this.a = (b)new a(editText, b);
    }
    
    public KeyListener a(final KeyListener keyListener) {
        return this.a.a(keyListener);
    }
    
    public boolean b() {
        return this.a.b();
    }
    
    public InputConnection c(final InputConnection inputConnection, final EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.a.c(inputConnection, editorInfo);
    }
    
    public void d(final boolean b) {
        this.a.d(b);
    }
    
    private static class a extends b
    {
        private final EditText a;
        private final g b;
        
        a(final EditText a, final boolean b) {
            (this.a = a).addTextChangedListener((TextWatcher)(this.b = new g(a, b)));
            a.setEditableFactory(e0.b.getInstance());
        }
        
        @Override
        KeyListener a(final KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return (KeyListener)new e(keyListener);
        }
        
        @Override
        boolean b() {
            return this.b.b();
        }
        
        @Override
        InputConnection c(final InputConnection inputConnection, final EditorInfo editorInfo) {
            if (inputConnection instanceof c) {
                return inputConnection;
            }
            return (InputConnection)new c((TextView)this.a, inputConnection, editorInfo);
        }
        
        @Override
        void d(final boolean b) {
            this.b.d(b);
        }
    }
    
    static class b
    {
        KeyListener a(final KeyListener keyListener) {
            throw null;
        }
        
        boolean b() {
            throw null;
        }
        
        InputConnection c(final InputConnection inputConnection, final EditorInfo editorInfo) {
            throw null;
        }
        
        void d(final boolean b) {
            throw null;
        }
    }
}
