// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import java.lang.ref.WeakReference;
import java.lang.ref.Reference;
import android.text.Editable;
import android.text.Spannable;
import android.text.Selection;
import androidx.emoji2.text.e;
import android.widget.EditText;
import android.text.TextWatcher;

final class g implements TextWatcher
{
    private final EditText a;
    private final boolean b;
    private e.e c;
    private int d;
    private int e;
    private boolean f;
    
    g(final EditText a, final boolean b) {
        this.d = Integer.MAX_VALUE;
        this.e = 0;
        this.a = a;
        this.b = b;
        this.f = true;
    }
    
    private e.e a() {
        if (this.c == null) {
            this.c = new a(this.a);
        }
        return this.c;
    }
    
    static void c(final EditText editText, int selectionEnd) {
        if (selectionEnd == 1 && editText != null && editText.isAttachedToWindow()) {
            final Editable editableText = editText.getEditableText();
            final int selectionStart = Selection.getSelectionStart((CharSequence)editableText);
            selectionEnd = Selection.getSelectionEnd((CharSequence)editableText);
            e.b().o((CharSequence)editableText);
            d.b((Spannable)editableText, selectionStart, selectionEnd);
        }
    }
    
    private boolean e() {
        return !this.f || (!this.b && !androidx.emoji2.text.e.h());
    }
    
    public void afterTextChanged(final Editable editable) {
    }
    
    public boolean b() {
        return this.f;
    }
    
    public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
    }
    
    public void d(final boolean f) {
        if (this.f != f) {
            if (this.c != null) {
                androidx.emoji2.text.e.b().t(this.c);
            }
            this.f = f;
            if (f) {
                c(this.a, androidx.emoji2.text.e.b().d());
            }
        }
    }
    
    public void onTextChanged(final CharSequence charSequence, final int n, int d, final int n2) {
        if (!this.a.isInEditMode()) {
            if (!this.e()) {
                if (d <= n2 && charSequence instanceof Spannable) {
                    d = androidx.emoji2.text.e.b().d();
                    if (d != 0) {
                        if (d == 1) {
                            androidx.emoji2.text.e.b().r(charSequence, n, n + n2, this.d, this.e);
                            return;
                        }
                        if (d != 3) {
                            return;
                        }
                    }
                    androidx.emoji2.text.e.b().s(this.a());
                }
            }
        }
    }
    
    private static class a extends e
    {
        private final Reference<EditText> a;
        
        a(final EditText editText) {
            this.a = new WeakReference<EditText>(editText);
        }
        
        @Override
        public void b() {
            super.b();
            g.c(this.a.get(), 1);
        }
    }
}
