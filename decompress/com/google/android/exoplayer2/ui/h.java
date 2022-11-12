// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.view.View;
import android.view.View$OnClickListener;

public final class h implements View$OnClickListener
{
    public final StyledPlayerControlView.h a;
    
    public h(final StyledPlayerControlView.h a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        StyledPlayerControlView.h.t(this.a, view);
    }
}
