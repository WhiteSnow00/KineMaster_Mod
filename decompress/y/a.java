// 
// Decompiled by Procyon v0.6.0
// 

package y;

import android.text.TextUtils;
import android.text.SpannableStringBuilder;
import android.os.Bundle;
import android.os.Build$VERSION;
import androidx.core.util.h;
import android.view.inputmethod.EditorInfo;

public final class a
{
    private static final String[] a;
    
    static {
        a = new String[0];
    }
    
    private static boolean a(final CharSequence charSequence, final int n, final int n2) {
        if (n2 != 0) {
            return n2 == 1 && Character.isHighSurrogate(charSequence.charAt(n));
        }
        return Character.isLowSurrogate(charSequence.charAt(n));
    }
    
    private static boolean b(int n) {
        n &= 0xFFF;
        return n == 129 || n == 225 || n == 18;
    }
    
    public static void c(final EditorInfo editorInfo, final String[] contentMimeTypes) {
        editorInfo.contentMimeTypes = contentMimeTypes;
    }
    
    public static void d(final EditorInfo editorInfo, final CharSequence charSequence, final int n) {
        h.g(charSequence);
        if (Build$VERSION.SDK_INT >= 30) {
            y.a.a.a(editorInfo, charSequence, n);
            return;
        }
        final int initialSelStart = editorInfo.initialSelStart;
        final int initialSelEnd = editorInfo.initialSelEnd;
        int n2;
        if (initialSelStart > initialSelEnd) {
            n2 = initialSelEnd - n;
        }
        else {
            n2 = initialSelStart - n;
        }
        int n3;
        if (initialSelStart > initialSelEnd) {
            n3 = initialSelStart - n;
        }
        else {
            n3 = initialSelEnd - n;
        }
        final int length = charSequence.length();
        if (n < 0 || n2 < 0 || n3 > length) {
            f(editorInfo, null, 0, 0);
            return;
        }
        if (b(editorInfo.inputType)) {
            f(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            f(editorInfo, charSequence, n2, n3);
            return;
        }
        g(editorInfo, charSequence, n2, n3);
    }
    
    public static void e(final EditorInfo editorInfo, final CharSequence charSequence) {
        if (Build$VERSION.SDK_INT >= 30) {
            y.a.a.a(editorInfo, charSequence, 0);
        }
        else {
            d(editorInfo, charSequence, 0);
        }
    }
    
    private static void f(final EditorInfo editorInfo, final CharSequence charSequence, final int n, final int n2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        Object o;
        if (charSequence != null) {
            o = new SpannableStringBuilder(charSequence);
        }
        else {
            o = null;
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", (CharSequence)o);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", n);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", n2);
    }
    
    private static void g(final EditorInfo editorInfo, CharSequence charSequence, int n, final int n2) {
        final int n3 = n2 - n;
        int n4;
        if (n3 > 1024) {
            n4 = 0;
        }
        else {
            n4 = n3;
        }
        final int length = charSequence.length();
        final int n5 = 2048 - n4;
        final int min = Math.min(length - n2, n5 - Math.min(n, (int)(n5 * 0.8)));
        final int min2 = Math.min(n, n5 - min);
        final int n6 = n - min2;
        int n7 = min2;
        n = n6;
        if (a(charSequence, n6, 0)) {
            n = n6 + 1;
            n7 = min2 - 1;
        }
        int n8 = min;
        if (a(charSequence, n2 + min - 1, 1)) {
            n8 = min - 1;
        }
        if (n4 != n3) {
            charSequence = TextUtils.concat(new CharSequence[] { charSequence.subSequence(n, n + n7), charSequence.subSequence(n2, n8 + n2) });
        }
        else {
            charSequence = charSequence.subSequence(n, n7 + n4 + n8 + n);
        }
        n = n7 + 0;
        f(editorInfo, charSequence, n, n4 + n);
    }
    
    private static class a
    {
        static void a(final EditorInfo editorInfo, final CharSequence charSequence, final int n) {
            editorInfo.setInitialSurroundingSubText(charSequence, n);
        }
    }
}
