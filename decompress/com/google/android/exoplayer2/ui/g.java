// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.view.View;
import android.view.View$OnClickListener;

public final class g implements View$OnClickListener
{
    public final StyledPlayerControlView.e a;
    
    public g(final StyledPlayerControlView.e a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        StyledPlayerControlView.e.a(this.a, view);
    }
}
