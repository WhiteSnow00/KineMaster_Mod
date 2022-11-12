// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import androidx.fragment.app.FragmentManager;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.DialogInterface$OnDismissListener;
import com.google.android.gms.common.internal.Preconditions;
import android.content.DialogInterface$OnCancelListener;
import android.app.Dialog;
import androidx.fragment.app.c;

public class SupportErrorDialogFragment extends c
{
    private Dialog a;
    private DialogInterface$OnCancelListener b;
    private Dialog c;
    
    public static SupportErrorDialogFragment g4(Dialog a, final DialogInterface$OnCancelListener b) {
        final SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        a = Preconditions.l(a, "Cannot display null dialog");
        a.setOnCancelListener((DialogInterface$OnCancelListener)null);
        a.setOnDismissListener((DialogInterface$OnDismissListener)null);
        supportErrorDialogFragment.a = a;
        if (b != null) {
            supportErrorDialogFragment.b = b;
        }
        return supportErrorDialogFragment;
    }
    
    @Override
    public void onCancel(final DialogInterface dialogInterface) {
        final DialogInterface$OnCancelListener b = this.b;
        if (b != null) {
            b.onCancel(dialogInterface);
        }
    }
    
    @Override
    public Dialog onCreateDialog(final Bundle bundle) {
        Dialog dialog;
        if ((dialog = this.a) == null) {
            this.setShowsDialog(false);
            if (this.c == null) {
                this.c = (Dialog)new AlertDialog$Builder((Context)Preconditions.k(this.getContext())).create();
            }
            dialog = this.c;
        }
        return dialog;
    }
    
    @Override
    public void show(final FragmentManager fragmentManager, final String s) {
        super.show(fragmentManager, s);
    }
}
