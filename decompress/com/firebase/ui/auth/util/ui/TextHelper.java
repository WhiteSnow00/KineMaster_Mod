// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui;

import android.text.style.StyleSpan;
import android.text.SpannableStringBuilder;

public class TextHelper
{
    public static void boldAllOccurencesOfText(final SpannableStringBuilder spannableStringBuilder, final String s, final String s2) {
        int n;
        for (int i = 0; i < s.length(); i = n + 1) {
            final int index = s.indexOf(s2, i);
            n = s2.length() + index;
            if (index == -1) {
                break;
            }
            if (n > s.length()) {
                break;
            }
            spannableStringBuilder.setSpan((Object)new StyleSpan(1), index, n, 17);
        }
    }
}
