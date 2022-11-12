// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.view.View;
import android.view.View$OnClickListener;

public final class e implements View$OnClickListener
{
    public final StyledPlayerControlView.b a;
    
    public e(final StyledPlayerControlView.b a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        StyledPlayerControlView.b.t(this.a, view);
    }
}
