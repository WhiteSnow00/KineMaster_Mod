// 
// Decompiled by Procyon v0.6.0
// 

package y;

import androidx.core.view.b0;
import android.content.ClipData;
import android.content.ClipData$Item;
import android.util.Log;
import android.os.Parcelable;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.util.h;
import android.os.Bundle;
import android.view.View;

public final class c
{
    public static boolean a(final View view, final d d, final int n, final Bundle bundle) {
        return e(view, d, n, bundle);
    }
    
    private static b b(final View view) {
        h.g(view);
        return (b)new y.b(view);
    }
    
    public static InputConnection c(final View view, final InputConnection inputConnection, final EditorInfo editorInfo) {
        return d(inputConnection, editorInfo, b(view));
    }
    
    @Deprecated
    public static InputConnection d(final InputConnection inputConnection, final EditorInfo editorInfo, final b b) {
        androidx.core.util.c.d(inputConnection, "inputConnection must be non-null");
        androidx.core.util.c.d(editorInfo, "editorInfo must be non-null");
        androidx.core.util.c.d(b, "onCommitContentListener must be non-null");
        return (InputConnection)new InputConnectionWrapper(inputConnection, false, b) {
            final b a;
            
            public boolean commitContent(final InputContentInfo inputContentInfo, final int n, final Bundle bundle) {
                return this.a.a(d.f(inputContentInfo), n, bundle) || super.commitContent(inputContentInfo, n, bundle);
            }
        };
    }
    
    private static boolean e(final View view, final d d, final int n, Bundle bundle) {
        boolean b = true;
        Bundle bundle2 = bundle;
        if ((n & 0x1) != 0x0) {
            try {
                d.d();
                final InputContentInfo inputContentInfo = (InputContentInfo)d.e();
                if (bundle == null) {
                    bundle = new Bundle();
                }
                else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", (Parcelable)inputContentInfo);
                bundle2 = bundle;
            }
            catch (final Exception ex) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", (Throwable)ex);
                return false;
            }
        }
        if (b0.f0(view, new androidx.core.view.c.a(new ClipData(d.b(), new ClipData$Item(d.a())), 2).d(d.c()).b(bundle2).a()) != null) {
            b = false;
        }
        return b;
    }
    
    public interface b
    {
        boolean a(final d p0, final int p1, final Bundle p2);
    }
}
