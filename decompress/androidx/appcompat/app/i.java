// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.c;

public class i extends c
{
    public i() {
    }
    
    public i(final int n) {
        super(n);
    }
    
    @Override
    public Dialog onCreateDialog(final Bundle bundle) {
        return new h(this.getContext(), this.getTheme());
    }
    
    @Override
    public void setupDialog(final Dialog dialog, final int n) {
        if (dialog instanceof h) {
            final h h = (h)dialog;
            if (n != 1 && n != 2) {
                if (n != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            h.h(1);
        }
        else {
            super.setupDialog(dialog, n);
        }
    }
}
