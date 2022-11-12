// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.view.MotionEvent;
import android.os.Bundle;
import android.content.res.Configuration;
import android.content.Intent;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import androidx.annotation.Keep;
import android.app.Activity;

@Keep
public class AudienceNetworkActivity extends Activity
{
    private AudienceNetworkActivityApi mAudienceNetworkActivityApi;
    private final AudienceNetworkActivityApi mAudienceNetworkActivityParentApi;
    
    public AudienceNetworkActivity() {
        this.mAudienceNetworkActivityParentApi = new AudienceNetworkActivityApi() {
            final AudienceNetworkActivity a;
            
            @Override
            public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
                AudienceNetworkActivity.access$1201(this.a, s, fileDescriptor, printWriter, array);
            }
            
            @Override
            public void finish(final int n) {
                AudienceNetworkActivity.access$601(this.a);
            }
            
            @Override
            public void onActivityResult(final int n, final int n2, final Intent intent) {
                AudienceNetworkActivity.access$1101(this.a, n, n2, intent);
            }
            
            @Override
            public void onBackPressed() {
                AudienceNetworkActivity.access$801(this.a);
            }
            
            @Override
            public void onConfigurationChanged(final Configuration configuration) {
                AudienceNetworkActivity.access$901(this.a, configuration);
            }
            
            @Override
            public void onCreate(final Bundle bundle) {
                AudienceNetworkActivity.access$001(this.a, bundle);
            }
            
            @Override
            public void onDestroy() {
                AudienceNetworkActivity.access$701(this.a);
            }
            
            @Override
            public void onPause() {
                AudienceNetworkActivity.access$201(this.a);
            }
            
            @Override
            public void onResume() {
                AudienceNetworkActivity.access$301(this.a);
            }
            
            @Override
            public void onSaveInstanceState(final Bundle bundle) {
                AudienceNetworkActivity.access$501(this.a, bundle);
            }
            
            @Override
            public void onStart() {
                AudienceNetworkActivity.access$101(this.a);
            }
            
            @Override
            public void onStop() {
                AudienceNetworkActivity.access$401(this.a);
            }
            
            @Override
            public boolean onTouchEvent(final MotionEvent motionEvent) {
                return AudienceNetworkActivity.access$1001(this.a, motionEvent);
            }
        };
    }
    
    static void access$001(final AudienceNetworkActivity audienceNetworkActivity, final Bundle bundle) {
        audienceNetworkActivity.onCreate(bundle);
    }
    
    static boolean access$1001(final AudienceNetworkActivity audienceNetworkActivity, final MotionEvent motionEvent) {
        return audienceNetworkActivity.onTouchEvent(motionEvent);
    }
    
    static void access$101(final AudienceNetworkActivity audienceNetworkActivity) {
        audienceNetworkActivity.onStart();
    }
    
    static void access$1101(final AudienceNetworkActivity audienceNetworkActivity, final int n, final int n2, final Intent intent) {
        audienceNetworkActivity.onActivityResult(n, n2, intent);
    }
    
    static void access$1201(final AudienceNetworkActivity audienceNetworkActivity, final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        audienceNetworkActivity.dump(s, fileDescriptor, printWriter, array);
    }
    
    static void access$201(final AudienceNetworkActivity audienceNetworkActivity) {
        audienceNetworkActivity.onPause();
    }
    
    static void access$301(final AudienceNetworkActivity audienceNetworkActivity) {
        audienceNetworkActivity.onResume();
    }
    
    static void access$401(final AudienceNetworkActivity audienceNetworkActivity) {
        audienceNetworkActivity.onStop();
    }
    
    static void access$501(final AudienceNetworkActivity audienceNetworkActivity, final Bundle bundle) {
        audienceNetworkActivity.onSaveInstanceState(bundle);
    }
    
    static void access$601(final AudienceNetworkActivity audienceNetworkActivity) {
        audienceNetworkActivity.finish();
    }
    
    static void access$701(final AudienceNetworkActivity audienceNetworkActivity) {
        audienceNetworkActivity.onDestroy();
    }
    
    static void access$801(final AudienceNetworkActivity audienceNetworkActivity) {
        audienceNetworkActivity.onBackPressed();
    }
    
    static void access$901(final AudienceNetworkActivity audienceNetworkActivity, final Configuration configuration) {
        audienceNetworkActivity.onConfigurationChanged(configuration);
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        this.mAudienceNetworkActivityApi.dump(s, fileDescriptor, printWriter, array);
    }
    
    public void finish() {
        this.mAudienceNetworkActivityApi.finish(0);
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        this.mAudienceNetworkActivityApi.onActivityResult(n, n2, intent);
    }
    
    public void onBackPressed() {
        this.mAudienceNetworkActivityApi.onBackPressed();
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.mAudienceNetworkActivityApi.onConfigurationChanged(configuration);
    }
    
    public void onCreate(final Bundle bundle) {
        (this.mAudienceNetworkActivityApi = DynamicLoaderFactory.makeLoader((Context)this).createAudienceNetworkActivity(this, this.mAudienceNetworkActivityParentApi)).onCreate(bundle);
    }
    
    protected void onDestroy() {
        this.mAudienceNetworkActivityApi.onDestroy();
    }
    
    public void onPause() {
        this.mAudienceNetworkActivityApi.onPause();
    }
    
    public void onResume() {
        this.mAudienceNetworkActivityApi.onResume();
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        this.mAudienceNetworkActivityApi.onSaveInstanceState(bundle);
    }
    
    public void onStart() {
        this.mAudienceNetworkActivityApi.onStart();
    }
    
    protected void onStop() {
        this.mAudienceNetworkActivityApi.onStop();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return this.mAudienceNetworkActivityApi.onTouchEvent(motionEvent);
    }
}
