// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

public final class a implements Runnable
{
    public final DownloadService.b a;
    public final DownloadService b;
    
    public a(final DownloadService.b a, final DownloadService b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        DownloadService.b.c(this.a, this.b);
    }
}
