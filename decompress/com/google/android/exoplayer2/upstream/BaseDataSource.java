// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;

public abstract class BaseDataSource implements DataSource
{
    private final boolean a;
    private final ArrayList<TransferListener> b;
    private int c;
    private DataSpec d;
    
    protected BaseDataSource(final boolean a) {
        this.a = a;
        this.b = new ArrayList<TransferListener>(1);
    }
    
    @Override
    public final void e(final TransferListener transferListener) {
        Assertions.e(transferListener);
        if (!this.b.contains(transferListener)) {
            this.b.add(transferListener);
            ++this.c;
        }
    }
    
    protected final void s(final int n) {
        final DataSpec dataSpec = Util.j(this.d);
        for (int i = 0; i < this.c; ++i) {
            this.b.get(i).f(this, dataSpec, this.a, n);
        }
    }
    
    protected final void t() {
        final DataSpec dataSpec = Util.j(this.d);
        for (int i = 0; i < this.c; ++i) {
            this.b.get(i).b(this, dataSpec, this.a);
        }
        this.d = null;
    }
    
    protected final void u(final DataSpec dataSpec) {
        for (int i = 0; i < this.c; ++i) {
            this.b.get(i).i(this, dataSpec, this.a);
        }
    }
    
    protected final void v(final DataSpec d) {
        this.d = d;
        for (int i = 0; i < this.c; ++i) {
            this.b.get(i).h(this, d, this.a);
        }
    }
}
