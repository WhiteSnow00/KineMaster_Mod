// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import android.view.MotionEvent;
import android.os.Bundle;
import android.content.res.Configuration;
import android.content.Intent;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.facebook.proguard.annotations.DoNotStripAny;
import androidx.annotation.Keep;

@Keep
@DoNotStripAny
public interface AudienceNetworkActivityApi
{
    public static final int EXTERNAL_FINISH_REASON = 0;
    
    void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    void finish(final int p0);
    
    void onActivityResult(final int p0, final int p1, final Intent p2);
    
    void onBackPressed();
    
    void onConfigurationChanged(final Configuration p0);
    
    void onCreate(final Bundle p0);
    
    void onDestroy();
    
    void onPause();
    
    void onResume();
    
    void onSaveInstanceState(final Bundle p0);
    
    void onStart();
    
    void onStop();
    
    boolean onTouchEvent(final MotionEvent p0);
}
