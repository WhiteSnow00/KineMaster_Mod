// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.view.View;
import android.view.View$OnClickListener;

public final class f implements View$OnClickListener
{
    public final StyledPlayerControlView.d a;
    public final int b;
    
    public f(final StyledPlayerControlView.d a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onClick(final View view) {
        StyledPlayerControlView.d.l(this.a, this.b, view);
    }
}
