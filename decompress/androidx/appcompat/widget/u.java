// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import androidx.core.util.h;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

final class u
{
    private TextView a;
    private TextClassifier b;
    
    u(final TextView textView) {
        this.a = h.g(textView);
    }
    
    public TextClassifier a() {
        TextClassifier textClassifier;
        if ((textClassifier = this.b) == null) {
            textClassifier = u.a.a(this.a);
        }
        return textClassifier;
    }
    
    public void b(final TextClassifier b) {
        this.b = b;
    }
    
    private static final class a
    {
        static TextClassifier a(final TextView textView) {
            final TextClassificationManager textClassificationManager = (TextClassificationManager)textView.getContext().getSystemService((Class)TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }
}
