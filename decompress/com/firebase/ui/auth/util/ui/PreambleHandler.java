// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui;

import android.net.Uri;
import android.view.View;
import android.util.TypedValue;
import androidx.browser.customtabs.d;
import java.lang.ref.WeakReference;
import android.text.style.URLSpan;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.text.TextUtils;
import androidx.core.content.a;
import com.firebase.ui.auth.R;
import android.text.style.ForegroundColorSpan;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import android.text.SpannableStringBuilder;

public class PreambleHandler
{
    private static final String BTN_TARGET = "%BTN%";
    private static final int NO_BUTTON = -1;
    private static final String PP_TARGET = "%PP%";
    private static final String TOS_TARGET = "%TOS%";
    private SpannableStringBuilder mBuilder;
    private final int mButtonText;
    private final Context mContext;
    private final FlowParameters mFlowParameters;
    private final ForegroundColorSpan mLinkSpan;
    
    private PreambleHandler(final Context mContext, final FlowParameters mFlowParameters, final int mButtonText) {
        this.mContext = mContext;
        this.mFlowParameters = mFlowParameters;
        this.mButtonText = mButtonText;
        this.mLinkSpan = new ForegroundColorSpan(a.getColor(mContext, R.color.fui_linkColor));
    }
    
    private String getPreambleStringWithTargets(final int n, final boolean b) {
        final boolean empty = TextUtils.isEmpty((CharSequence)this.mFlowParameters.termsOfServiceUrl);
        final boolean empty2 = TextUtils.isEmpty((CharSequence)this.mFlowParameters.privacyPolicyUrl);
        if ((empty ^ true) && (empty2 ^ true)) {
            Object[] array;
            if (b) {
                array = new Object[] { "%BTN%", "%TOS%", "%PP%" };
            }
            else {
                array = new Object[] { "%TOS%", "%PP%" };
            }
            return this.mContext.getString(n, array);
        }
        return null;
    }
    
    private void initPreamble(final int n) {
        final String preambleStringWithTargets = this.getPreambleStringWithTargets(n, this.mButtonText != -1);
        if (preambleStringWithTargets == null) {
            return;
        }
        this.mBuilder = new SpannableStringBuilder((CharSequence)preambleStringWithTargets);
        this.replaceTarget("%BTN%", this.mButtonText);
        this.replaceUrlTarget("%TOS%", R.string.fui_terms_of_service, this.mFlowParameters.termsOfServiceUrl);
        this.replaceUrlTarget("%PP%", R.string.fui_privacy_policy, this.mFlowParameters.privacyPolicyUrl);
    }
    
    private void replaceTarget(final String s, final int n) {
        final int index = this.mBuilder.toString().indexOf(s);
        if (index != -1) {
            this.mBuilder.replace(index, s.length() + index, (CharSequence)this.mContext.getString(n));
        }
    }
    
    private void replaceUrlTarget(final String s, int n, final String s2) {
        final int index = this.mBuilder.toString().indexOf(s);
        if (index != -1) {
            final String string = this.mContext.getString(n);
            this.mBuilder.replace(index, s.length() + index, (CharSequence)string);
            n = string.length() + index;
            this.mBuilder.setSpan((Object)this.mLinkSpan, index, n, 0);
            this.mBuilder.setSpan((Object)new CustomTabsSpan(this.mContext, s2), index, n, 0);
        }
    }
    
    private void setPreamble(final TextView textView) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText((CharSequence)this.mBuilder);
    }
    
    public static void setup(final Context context, final FlowParameters flowParameters, final int n, final int n2, final TextView preamble) {
        final PreambleHandler preambleHandler = new PreambleHandler(context, flowParameters, n);
        preambleHandler.initPreamble(n2);
        preambleHandler.setPreamble(preamble);
    }
    
    public static void setup(final Context context, final FlowParameters flowParameters, final int n, final TextView textView) {
        setup(context, flowParameters, -1, n, textView);
    }
    
    private static final class CustomTabsSpan extends URLSpan
    {
        private final WeakReference<Context> mContext;
        private final d mCustomTabsIntent;
        private final String mUrl;
        
        public CustomTabsSpan(final Context context, final String mUrl) {
            super(mUrl);
            this.mContext = new WeakReference<Context>(context);
            this.mUrl = mUrl;
            final TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            this.mCustomTabsIntent = new d.a().e(typedValue.data).d(true).a();
        }
        
        public void onClick(final View view) {
            final Context context = this.mContext.get();
            if (context != null) {
                this.mCustomTabsIntent.a(context, Uri.parse(this.mUrl));
            }
        }
    }
}
