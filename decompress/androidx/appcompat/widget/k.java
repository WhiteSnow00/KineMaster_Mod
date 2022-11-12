// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.ViewParent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

class k
{
    static InputConnection a(final InputConnection inputConnection, final EditorInfo editorInfo, final View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = viewParent.getParent()) {
                if (viewParent instanceof x0) {
                    editorInfo.hintText = ((x0)viewParent).a();
                    break;
                }
            }
        }
        return inputConnection;
    }
}
