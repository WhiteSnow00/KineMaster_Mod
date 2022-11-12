// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.view.View;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.Player;
import android.view.View$OnClickListener;

public final class i implements View$OnClickListener
{
    public final StyledPlayerControlView.j a;
    public final Player b;
    public final TrackGroup c;
    public final StyledPlayerControlView.i d;
    
    public i(final StyledPlayerControlView.j a, final Player b, final TrackGroup c, final StyledPlayerControlView.i d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void onClick(final View view) {
        StyledPlayerControlView.j.l(this.a, this.b, this.c, this.d, view);
    }
}
