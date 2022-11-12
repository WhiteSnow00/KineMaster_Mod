// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;
import android.text.style.ClickableSpan;

public final class a extends ClickableSpan
{
    private final int a;
    private final d b;
    private final int c;
    
    public a(final int a, final d b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void onClick(final View view) {
        final Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.H(this.c, bundle);
    }
}
