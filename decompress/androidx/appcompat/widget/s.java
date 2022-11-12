// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.text.Selection;
import android.text.Spannable;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.ClipData;
import androidx.core.view.c;
import android.content.ClipboardManager;
import android.app.Activity;
import android.widget.TextView;
import android.util.Log;
import androidx.core.view.b0;
import android.os.Build$VERSION;
import android.view.DragEvent;
import android.view.View;

final class s
{
    static boolean a(final View view, final DragEvent dragEvent) {
        if (Build$VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null) {
            if (b0.E(view) != null) {
                final Activity c = c(view);
                if (c == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Can't handle drop: no activity: view=");
                    sb.append(view);
                    Log.i("ReceiveContent", sb.toString());
                    return false;
                }
                if (dragEvent.getAction() == 1) {
                    return view instanceof TextView ^ true;
                }
                if (dragEvent.getAction() == 3) {
                    boolean b;
                    if (view instanceof TextView) {
                        b = a.a(dragEvent, (TextView)view, c);
                    }
                    else {
                        b = a.b(dragEvent, view, c);
                    }
                    return b;
                }
            }
        }
        return false;
    }
    
    static boolean b(final TextView textView, int n) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n2 = 0;
        if (sdk_INT < 31 && b0.E((View)textView) != null && (n == 16908322 || n == 16908337)) {
            final ClipboardManager clipboardManager = (ClipboardManager)textView.getContext().getSystemService("clipboard");
            ClipData primaryClip;
            if (clipboardManager == null) {
                primaryClip = null;
            }
            else {
                primaryClip = clipboardManager.getPrimaryClip();
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                final c.a a = new c.a(primaryClip, 1);
                if (n == 16908322) {
                    n = n2;
                }
                else {
                    n = 1;
                }
                b0.f0((View)textView, a.c(n).a());
            }
            return true;
        }
        return false;
    }
    
    static Activity c(final View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper)context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
        }
        return null;
    }
    
    private static final class a
    {
        static boolean a(final DragEvent dragEvent, final TextView textView, final Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            final int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable)textView.getText(), offsetForPosition);
                b0.f0((View)textView, new c.a(dragEvent.getClipData(), 3).a());
                return true;
            }
            finally {
                textView.endBatchEdit();
            }
        }
        
        static boolean b(final DragEvent dragEvent, final View view, final Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            b0.f0(view, new c.a(dragEvent.getClipData(), 3).a());
            return true;
        }
    }
}
