// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.app.FragmentManager;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.DialogInterface$OnDismissListener;
import com.google.android.gms.common.internal.Preconditions;
import android.content.DialogInterface$OnCancelListener;
import android.app.Dialog;
import android.app.DialogFragment;

public class ErrorDialogFragment extends DialogFragment
{
    private Dialog a;
    private DialogInterface$OnCancelListener b;
    private Dialog c;
    
    public static ErrorDialogFragment a(Dialog a, final DialogInterface$OnCancelListener b) {
        final ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        a = Preconditions.l(a, "Cannot display null dialog");
        a.setOnCancelListener((DialogInterface$OnCancelListener)null);
        a.setOnDismissListener((DialogInterface$OnDismissListener)null);
        errorDialogFragment.a = a;
        if (b != null) {
            errorDialogFragment.b = b;
        }
        return errorDialogFragment;
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        final DialogInterface$OnCancelListener b = this.b;
        if (b != null) {
            b.onCancel(dialogInterface);
        }
    }
    
    public Dialog onCreateDialog(final Bundle bundle) {
        Dialog dialog;
        if ((dialog = this.a) == null) {
            this.setShowsDialog(false);
            if (this.c == null) {
                this.c = (Dialog)new AlertDialog$Builder((Context)Preconditions.k((Context)this.getActivity())).create();
            }
            dialog = this.c;
        }
        return dialog;
    }
    
    public void show(final FragmentManager fragmentManager, final String s) {
        super.show(fragmentManager, s);
    }
}
