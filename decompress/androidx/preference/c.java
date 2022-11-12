// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.os.Bundle;

public class c extends f
{
    int i;
    private CharSequence[] j;
    private CharSequence[] p;
    
    private ListPreference o4() {
        return (ListPreference)this.g4();
    }
    
    public static c p4(final String s) {
        final c c = new c();
        final Bundle arguments = new Bundle(1);
        arguments.putString("key", s);
        c.setArguments(arguments);
        return c;
    }
    
    @Override
    public void k4(final boolean b) {
        if (b) {
            final int i = this.i;
            if (i >= 0) {
                final String string = this.p[i].toString();
                final ListPreference o4 = this.o4();
                if (o4.c(string)) {
                    o4.h1(string);
                }
            }
        }
    }
    
    @Override
    protected void l4(final androidx.appcompat.app.c.a a) {
        super.l4(a);
        a.k(this.j, this.i, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(this) {
            final c a;
            
            public void onClick(final DialogInterface dialogInterface, final int i) {
                final c a = this.a;
                a.i = i;
                a.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        a.i(null, null);
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            final ListPreference o4 = this.o4();
            if (o4.c1() == null || o4.e1() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.i = o4.b1(o4.f1());
            this.j = o4.c1();
            this.p = o4.e1();
        }
        else {
            this.i = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.j = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.p = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
        }
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.i);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.j);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.p);
    }
}
