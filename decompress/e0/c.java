// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import androidx.emoji2.text.e;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import android.view.inputmethod.InputConnectionWrapper;

final class c extends InputConnectionWrapper
{
    private final TextView a;
    private final a b;
    
    c(final TextView textView, final InputConnection inputConnection, final EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }
    
    c(final TextView a, final InputConnection inputConnection, final EditorInfo editorInfo, final a b) {
        super(inputConnection, false);
        this.a = a;
        (this.b = b).b(editorInfo);
    }
    
    private Editable a() {
        return this.a.getEditableText();
    }
    
    public boolean deleteSurroundingText(final int n, final int n2) {
        return this.b.a((InputConnection)this, this.a(), n, n2, false) || super.deleteSurroundingText(n, n2);
    }
    
    public boolean deleteSurroundingTextInCodePoints(final int n, final int n2) {
        return this.b.a((InputConnection)this, this.a(), n, n2, true) || super.deleteSurroundingTextInCodePoints(n, n2);
    }
    
    public static class a
    {
        public boolean a(final InputConnection inputConnection, final Editable editable, final int n, final int n2, final boolean b) {
            return e.e(inputConnection, editable, n, n2, b);
        }
        
        public void b(final EditorInfo editorInfo) {
            if (e.h()) {
                e.b().u(editorInfo);
            }
        }
    }
}
