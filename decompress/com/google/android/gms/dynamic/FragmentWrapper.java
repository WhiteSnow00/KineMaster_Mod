// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamic;

import com.google.android.gms.common.internal.Preconditions;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class FragmentWrapper extends Stub
{
    private Fragment a;
    
    private FragmentWrapper(final Fragment a) {
        this.a = a;
    }
    
    @KeepForSdk
    public static FragmentWrapper M0(final Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }
    
    public final void D0(final Intent intent) {
        this.a.startActivity(intent);
    }
    
    public final void G0(final Intent intent, final int n) {
        this.a.startActivityForResult(intent, n);
    }
    
    public final void m0(final boolean hasOptionsMenu) {
        this.a.setHasOptionsMenu(hasOptionsMenu);
    }
    
    public final void s0(final boolean menuVisibility) {
        this.a.setMenuVisibility(menuVisibility);
    }
    
    public final boolean zzA() {
        return this.a.isVisible();
    }
    
    public final int zzb() {
        return this.a.getId();
    }
    
    public final int zzc() {
        return this.a.getTargetRequestCode();
    }
    
    public final Bundle zzd() {
        return this.a.getArguments();
    }
    
    public final IFragmentWrapper zze() {
        return M0(this.a.getParentFragment());
    }
    
    public final IFragmentWrapper zzf() {
        return M0(this.a.getTargetFragment());
    }
    
    public final IObjectWrapper zzg() {
        return ObjectWrapper.q1(this.a.getActivity());
    }
    
    public final IObjectWrapper zzh() {
        return ObjectWrapper.q1(this.a.getResources());
    }
    
    public final IObjectWrapper zzi() {
        return ObjectWrapper.q1(this.a.getView());
    }
    
    public final String zzj() {
        return this.a.getTag();
    }
    
    public final void zzk(final IObjectWrapper objectWrapper) {
        final View view = ObjectWrapper.p1(objectWrapper);
        final Fragment a = this.a;
        Preconditions.k(view);
        a.registerForContextMenu(view);
    }
    
    public final void zzn(final boolean retainInstance) {
        this.a.setRetainInstance(retainInstance);
    }
    
    public final void zzo(final boolean userVisibleHint) {
        this.a.setUserVisibleHint(userVisibleHint);
    }
    
    public final void zzr(final IObjectWrapper objectWrapper) {
        final View view = ObjectWrapper.p1(objectWrapper);
        final Fragment a = this.a;
        Preconditions.k(view);
        a.unregisterForContextMenu(view);
    }
    
    public final boolean zzs() {
        return this.a.getRetainInstance();
    }
    
    public final boolean zzt() {
        return this.a.getUserVisibleHint();
    }
    
    public final boolean zzu() {
        return this.a.isAdded();
    }
    
    public final boolean zzv() {
        return this.a.isDetached();
    }
    
    public final boolean zzw() {
        return this.a.isHidden();
    }
    
    public final boolean zzx() {
        return this.a.isInLayout();
    }
    
    public final boolean zzy() {
        return this.a.isRemoving();
    }
    
    public final boolean zzz() {
        return this.a.isResumed();
    }
}
