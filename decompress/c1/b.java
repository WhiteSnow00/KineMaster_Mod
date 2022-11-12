// 
// Decompiled by Procyon v0.6.0
// 

package c1;

import android.view.ViewGroup;
import android.view.View;

public class b
{
    public static <T extends View> T a(View viewById, final int n) {
        if (!(viewById instanceof ViewGroup)) {
            return null;
        }
        final ViewGroup viewGroup = (ViewGroup)viewById;
        for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
            viewById = viewGroup.getChildAt(i).findViewById(n);
            if (viewById != null) {
                return (T)viewById;
            }
        }
        return null;
    }
}
