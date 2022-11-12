// 
// Decompiled by Procyon v0.6.0
// 

package h;

import android.graphics.Rect;
import android.view.View;
import android.content.Context;
import java.util.Locale;
import android.text.method.TransformationMethod;

public class a implements TransformationMethod
{
    private Locale a;
    
    public a(final Context context) {
        this.a = context.getResources().getConfiguration().locale;
    }
    
    public CharSequence getTransformation(final CharSequence charSequence, final View view) {
        String upperCase;
        if (charSequence != null) {
            upperCase = charSequence.toString().toUpperCase(this.a);
        }
        else {
            upperCase = null;
        }
        return upperCase;
    }
    
    public void onFocusChanged(final View view, final CharSequence charSequence, final boolean b, final int n, final Rect rect) {
    }
}
