// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui;

import androidx.fragment.app.c0;
import androidx.fragment.app.Fragment;
import com.firebase.ui.auth.R;
import android.os.Bundle;

public abstract class AppCompatBase extends HelperActivityBase
{
    private void lockOrientation() {
        this.setRequestedOrientation(1);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setTheme(R.style.FirebaseUI);
        this.setTheme(this.getFlowParams().themeId);
        if (this.getFlowParams().lockOrientation) {
            this.lockOrientation();
        }
    }
    
    protected void switchFragment(final Fragment fragment, final int n, final String s) {
        this.switchFragment(fragment, n, s, false, false);
    }
    
    protected void switchFragment(final Fragment fragment, final int n, final String s, final boolean b, final boolean b2) {
        final c0 q = this.getSupportFragmentManager().q();
        if (b) {
            q.s(R.anim.fui_slide_in_right, R.anim.fui_slide_out_left);
        }
        q.r(n, fragment, s);
        if (b2) {
            q.h(null).i();
        }
        else {
            q.m().i();
        }
    }
}
