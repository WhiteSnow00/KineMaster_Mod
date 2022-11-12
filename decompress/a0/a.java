// 
// Decompiled by Procyon v0.6.0
// 

package a0;

import android.text.Spanned;
import android.widget.TextView;

public class a
{
    private static boolean a(final CharSequence charSequence, final CharSequence charSequence2) {
        if (charSequence == null != (charSequence2 == null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        final int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i = 0; i < length; ++i) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    
    public static void b(final TextView textView, final CharSequence text) {
        final CharSequence text2 = textView.getText();
        if (text != text2) {
            if (text != null || text2.length() != 0) {
                if (text instanceof Spanned) {
                    if (text.equals(text2)) {
                        return;
                    }
                }
                else if (!a(text, text2)) {
                    return;
                }
                textView.setText(text);
            }
        }
    }
}
