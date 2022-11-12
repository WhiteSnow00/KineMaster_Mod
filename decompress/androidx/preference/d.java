// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import java.util.ArrayList;
import java.util.Collection;
import android.content.DialogInterface;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import androidx.appcompat.app.c;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class d extends f
{
    Set<String> i;
    boolean j;
    CharSequence[] p;
    CharSequence[] w;
    
    public d() {
        this.i = new HashSet<String>();
    }
    
    private MultiSelectListPreference o4() {
        return (MultiSelectListPreference)this.g4();
    }
    
    public static d p4(final String s) {
        final d d = new d();
        final Bundle arguments = new Bundle(1);
        arguments.putString("key", s);
        d.setArguments(arguments);
        return d;
    }
    
    @Override
    public void k4(final boolean b) {
        if (b && this.j) {
            final MultiSelectListPreference o4 = this.o4();
            if (o4.c(this.i)) {
                o4.e1(this.i);
            }
        }
        this.j = false;
    }
    
    @Override
    protected void l4(final androidx.appcompat.app.c.a a) {
        super.l4(a);
        final int length = this.w.length;
        final boolean[] array = new boolean[length];
        for (int i = 0; i < length; ++i) {
            array[i] = this.i.contains(this.w[i].toString());
        }
        a.e(this.p, array, (DialogInterface$OnMultiChoiceClickListener)new DialogInterface$OnMultiChoiceClickListener(this) {
            final d a;
            
            public void onClick(final DialogInterface dialogInterface, final int n, final boolean b) {
                if (b) {
                    final d a = this.a;
                    a.j |= a.i.add(a.w[n].toString());
                }
                else {
                    final d a2 = this.a;
                    a2.j |= a2.i.remove(a2.w[n].toString());
                }
            }
        });
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            final MultiSelectListPreference o4 = this.o4();
            if (o4.b1() == null || o4.c1() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.i.clear();
            this.i.addAll(o4.d1());
            this.j = false;
            this.p = o4.b1();
            this.w = o4.c1();
        }
        else {
            this.i.clear();
            this.i.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.j = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.p = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.w = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
        }
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList((Collection<? extends E>)this.i));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.j);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.p);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.w);
    }
}
