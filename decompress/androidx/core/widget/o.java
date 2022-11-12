// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.text.Spanned;
import android.content.ClipData;
import android.widget.TextView;
import android.util.Log;
import androidx.core.view.c;
import android.view.View;
import android.text.Spannable;
import android.text.Selection;
import android.text.Editable;
import android.content.ClipData$Item;
import android.content.Context;
import androidx.core.view.w;

public final class o implements w
{
    private static CharSequence b(final Context context, final ClipData$Item clipData$Item, final int n) {
        return a.a(context, clipData$Item, n);
    }
    
    private static void c(final Editable editable, final CharSequence charSequence) {
        final int selectionStart = Selection.getSelectionStart((CharSequence)editable);
        final int selectionEnd = Selection.getSelectionEnd((CharSequence)editable);
        final int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        final int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection((Spannable)editable, max2);
        editable.replace(max, max2, charSequence);
    }
    
    @Override
    public c a(final View view, final c c) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("onReceive: ");
            sb.append(c);
            Log.d("ReceiveContent", sb.toString());
        }
        if (c.d() == 2) {
            return c;
        }
        final ClipData b = c.b();
        final int c2 = c.c();
        final TextView textView = (TextView)view;
        final Editable editable = (Editable)textView.getText();
        final Context context = textView.getContext();
        int i = 0;
        int n = 0;
        while (i < b.getItemCount()) {
            final CharSequence b2 = b(context, b.getItemAt(i), c2);
            int n2 = n;
            if (b2 != null) {
                if (n == 0) {
                    c(editable, b2);
                    n2 = 1;
                }
                else {
                    editable.insert(Selection.getSelectionEnd((CharSequence)editable), (CharSequence)"\n");
                    editable.insert(Selection.getSelectionEnd((CharSequence)editable), b2);
                    n2 = n;
                }
            }
            ++i;
            n = n2;
        }
        return null;
    }
    
    private static final class a
    {
        static CharSequence a(final Context context, final ClipData$Item clipData$Item, final int n) {
            if ((n & 0x1) != 0x0) {
                CharSequence charSequence2;
                final CharSequence charSequence = charSequence2 = clipData$Item.coerceToText(context);
                if (charSequence instanceof Spanned) {
                    charSequence2 = charSequence.toString();
                }
                return charSequence2;
            }
            return clipData$Item.coerceToStyledText(context);
        }
    }
}
