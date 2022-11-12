// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import java.util.Iterator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;

final class b extends Preference
{
    private long a0;
    
    b(final Context context, final List<Preference> list, final long n) {
        super(context);
        this.V0();
        this.W0(list);
        this.a0 = n + 1000000L;
    }
    
    private void V0() {
        this.F0(androidx.preference.p.a);
        this.B0(n.a);
        this.M0(q.b);
        this.J0(999);
    }
    
    private void W0(final List<Preference> list) {
        final ArrayList list2 = new ArrayList();
        final Iterator<Preference> iterator = list.iterator();
        CharSequence string = null;
        while (iterator.hasNext()) {
            final Preference preference = iterator.next();
            final CharSequence i = preference.I();
            final boolean b = preference instanceof PreferenceGroup;
            if (b && !TextUtils.isEmpty(i)) {
                list2.add(preference);
            }
            if (list2.contains(preference.w())) {
                if (!b) {
                    continue;
                }
                list2.add(preference);
            }
            else {
                if (TextUtils.isEmpty(i)) {
                    continue;
                }
                if (string == null) {
                    string = i;
                }
                else {
                    string = this.l().getString(q.e, new Object[] { string, i });
                }
            }
        }
        this.K0(string);
    }
    
    @Override
    public void Y(final l l) {
        super.Y(l);
        l.e(false);
    }
    
    @Override
    long p() {
        return this.a0;
    }
}
