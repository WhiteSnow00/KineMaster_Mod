// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import com.firebase.ui.auth.util.ui.PreambleHandler;
import android.widget.TextView;
import android.content.Context;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;

public class PrivacyDisclosureUtils
{
    private static final int NO_TOS_OR_PP = -1;
    
    private static int getGlobalTermsFooterStringResource(final FlowParameters flowParameters) {
        final boolean termsOfServiceUrlProvided = flowParameters.isTermsOfServiceUrlProvided();
        final boolean privacyPolicyUrlProvided = flowParameters.isPrivacyPolicyUrlProvided();
        if (termsOfServiceUrlProvided && privacyPolicyUrlProvided) {
            return R.string.fui_tos_and_pp_footer;
        }
        return -1;
    }
    
    private static int getGlobalTermsStringResource(final FlowParameters flowParameters) {
        final boolean termsOfServiceUrlProvided = flowParameters.isTermsOfServiceUrlProvided();
        final boolean privacyPolicyUrlProvided = flowParameters.isPrivacyPolicyUrlProvided();
        if (termsOfServiceUrlProvided && privacyPolicyUrlProvided) {
            return R.string.fui_tos_and_pp;
        }
        return -1;
    }
    
    private static int getTermsSmsStringResource(final FlowParameters flowParameters) {
        final boolean termsOfServiceUrlProvided = flowParameters.isTermsOfServiceUrlProvided();
        final boolean privacyPolicyUrlProvided = flowParameters.isPrivacyPolicyUrlProvided();
        if (termsOfServiceUrlProvided && privacyPolicyUrlProvided) {
            return R.string.fui_sms_terms_of_service_and_privacy_policy_extended;
        }
        return -1;
    }
    
    public static void setupTermsOfServiceAndPrivacyPolicySmsText(final Context context, final FlowParameters flowParameters, final TextView textView) {
        PreambleHandler.setup(context, flowParameters, R.string.fui_verify_phone_number, getTermsSmsStringResource(flowParameters), textView);
    }
    
    public static void setupTermsOfServiceAndPrivacyPolicyText(final Context context, final FlowParameters flowParameters, final TextView textView) {
        PreambleHandler.setup(context, flowParameters, getGlobalTermsStringResource(flowParameters), textView);
    }
    
    public static void setupTermsOfServiceFooter(final Context context, final FlowParameters flowParameters, final TextView textView) {
        PreambleHandler.setup(context, flowParameters, getGlobalTermsFooterStringResource(flowParameters), textView);
    }
}
