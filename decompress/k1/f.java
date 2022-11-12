// 
// Decompiled by Procyon v0.6.0
// 

package k1;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import o1.a;
import android.content.Context;
import e1.h;

public class f extends c<Boolean>
{
    private static final String i;
    
    static {
        i = e1.h.f("StorageNotLowTracker");
    }
    
    public f(final Context context, final a a) {
        super(context, a);
    }
    
    @Override
    public /* bridge */ Object b() {
        return this.i();
    }
    
    @Override
    public IntentFilter g() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }
    
    @Override
    public void h(final Context context, final Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        e1.h.c().a(f.i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        final String action = intent.getAction();
        action.hashCode();
        if (!action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                this.d(Boolean.TRUE);
            }
        }
        else {
            this.d(Boolean.FALSE);
        }
    }
    
    public Boolean i() {
        final Intent registerReceiver = super.b.registerReceiver((BroadcastReceiver)null, this.g());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        final String action = registerReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return null;
        }
        return Boolean.TRUE;
    }
}
