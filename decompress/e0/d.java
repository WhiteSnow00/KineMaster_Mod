// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import java.lang.ref.WeakReference;
import java.lang.ref.Reference;
import android.text.Spanned;
import android.text.Selection;
import android.text.Spannable;
import androidx.emoji2.text.e;
import android.widget.TextView;
import android.text.InputFilter;

final class d implements InputFilter
{
    private final TextView a;
    private e.e b;
    
    d(final TextView a) {
        this.a = a;
    }
    
    private e.e a() {
        if (this.b == null) {
            this.b = new a(this.a, this);
        }
        return this.b;
    }
    
    static void b(final Spannable spannable, final int n, final int n2) {
        if (n >= 0 && n2 >= 0) {
            Selection.setSelection(spannable, n, n2);
        }
        else if (n >= 0) {
            Selection.setSelection(spannable, n);
        }
        else if (n2 >= 0) {
            Selection.setSelection(spannable, n2);
        }
    }
    
    public CharSequence filter(CharSequence subSequence, final int n, final int n2, final Spanned spanned, final int n3, final int n4) {
        if (this.a.isInEditMode()) {
            return subSequence;
        }
        final int d = e.b().d();
        if (d != 0) {
            final int n5 = 1;
            if (d == 1) {
                int n6 = n5;
                if (n4 == 0) {
                    n6 = n5;
                    if (n3 == 0) {
                        n6 = n5;
                        if (spanned.length() == 0) {
                            n6 = n5;
                            if (subSequence == this.a.getText()) {
                                n6 = 0;
                            }
                        }
                    }
                }
                CharSequence p6 = subSequence;
                if (n6 != 0 && (p6 = subSequence) != null) {
                    if (n != 0 || n2 != subSequence.length()) {
                        subSequence = subSequence.subSequence(n, n2);
                    }
                    p6 = e.b().p(subSequence, 0, subSequence.length());
                }
                return p6;
            }
            if (d != 3) {
                return subSequence;
            }
        }
        e.b().s(this.a());
        return subSequence;
    }
    
    private static class a extends e
    {
        private final Reference<TextView> a;
        private final Reference<d> b;
        
        a(final TextView textView, final d d) {
            this.a = new WeakReference<TextView>(textView);
            this.b = new WeakReference<d>(d);
        }
        
        private boolean c(final TextView textView, final InputFilter inputFilter) {
            if (inputFilter != null) {
                if (textView != null) {
                    final InputFilter[] filters = textView.getFilters();
                    if (filters == null) {
                        return false;
                    }
                    for (int i = 0; i < filters.length; ++i) {
                        if (filters[i] == inputFilter) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        
        @Override
        public void b() {
            super.b();
            final TextView textView = this.a.get();
            if (!this.c(textView, (InputFilter)this.b.get())) {
                return;
            }
            if (textView.isAttachedToWindow()) {
                final CharSequence text = textView.getText();
                final CharSequence o = androidx.emoji2.text.e.b().o(text);
                if (text == o) {
                    return;
                }
                final int selectionStart = Selection.getSelectionStart(o);
                final int selectionEnd = Selection.getSelectionEnd(o);
                textView.setText(o);
                if (o instanceof Spannable) {
                    d.b((Spannable)o, selectionStart, selectionEnd);
                }
            }
        }
    }
}
