// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.ui.ImeHelper;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.content.Intent;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.view.View;
import java.util.Locale;
import android.app.Activity;
import com.firebase.ui.auth.R;
import android.os.Bundle;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import android.text.TextUtils;
import com.firebase.ui.auth.data.model.PhoneNumber;
import android.widget.Button;
import android.widget.ProgressBar;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.FragmentBase;

public class CheckPhoneNumberFragment extends FragmentBase implements View$OnClickListener
{
    public static final String TAG = "VerifyPhoneFragment";
    private boolean mCalled;
    private CheckPhoneHandler mCheckPhoneHandler;
    private CountryListSpinner mCountryListSpinner;
    private TextView mFooterText;
    private EditText mPhoneEditText;
    private TextInputLayout mPhoneInputLayout;
    private ProgressBar mProgressBar;
    private TextView mSmsTermsText;
    private Button mSubmitButton;
    private PhoneNumberVerificationHandler mVerificationHandler;
    
    static void access$000(final CheckPhoneNumberFragment checkPhoneNumberFragment) {
        checkPhoneNumberFragment.onNext();
    }
    
    static void access$100(final CheckPhoneNumberFragment checkPhoneNumberFragment, final PhoneNumber phoneNumber) {
        checkPhoneNumberFragment.start(phoneNumber);
    }
    
    static TextInputLayout access$200(final CheckPhoneNumberFragment checkPhoneNumberFragment) {
        return checkPhoneNumberFragment.mPhoneInputLayout;
    }
    
    private String getPseudoValidPhoneNumber() {
        final String string = this.mPhoneEditText.getText().toString();
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        return PhoneNumberUtils.format(string, this.mCountryListSpinner.getSelectedCountryInfo());
    }
    
    public static CheckPhoneNumberFragment newInstance(final Bundle bundle) {
        final CheckPhoneNumberFragment checkPhoneNumberFragment = new CheckPhoneNumberFragment();
        final Bundle arguments = new Bundle();
        arguments.putBundle("extra_params", bundle);
        checkPhoneNumberFragment.setArguments(arguments);
        return checkPhoneNumberFragment;
    }
    
    private void onNext() {
        final String pseudoValidPhoneNumber = this.getPseudoValidPhoneNumber();
        if (pseudoValidPhoneNumber == null) {
            this.mPhoneInputLayout.setError((CharSequence)this.getString(R.string.fui_invalid_phone_number));
        }
        else {
            this.mVerificationHandler.verifyPhoneNumber(this.requireActivity(), pseudoValidPhoneNumber, false);
        }
    }
    
    private void setCountryCode(final PhoneNumber phoneNumber) {
        this.mCountryListSpinner.setSelectedForCountry(new Locale("", phoneNumber.getCountryIso()), phoneNumber.getCountryCode());
    }
    
    private void setDefaultCountryForSpinner() {
        final Bundle bundle = this.getArguments().getBundle("extra_params");
        String string = null;
        String string2;
        String string3;
        if (bundle != null) {
            string = bundle.getString("extra_phone_number");
            string2 = bundle.getString("extra_country_iso");
            string3 = bundle.getString("extra_national_number");
        }
        else {
            string3 = null;
            string2 = null;
        }
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.start(PhoneNumberUtils.getPhoneNumber(string));
        }
        else if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string3)) {
            this.start(PhoneNumberUtils.getPhoneNumber(string2, string3));
        }
        else if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.setCountryCode(new PhoneNumber("", string2, String.valueOf(PhoneNumberUtils.getCountryCode(string2))));
        }
        else if (this.getFlowParams().enableHints) {
            this.mCheckPhoneHandler.fetchCredential();
        }
    }
    
    private void setupCountrySpinner() {
        this.mCountryListSpinner.init(this.getArguments().getBundle("extra_params"));
        this.mCountryListSpinner.setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final CheckPhoneNumberFragment this$0;
            
            public void onClick(final View view) {
                CheckPhoneNumberFragment.access$200(this.this$0).setError((CharSequence)null);
            }
        });
    }
    
    private void setupPrivacyDisclosures() {
        final FlowParameters flowParams = this.getFlowParams();
        final boolean b = flowParams.isTermsOfServiceUrlProvided() && flowParams.isPrivacyPolicyUrlProvided();
        if (!flowParams.shouldShowProviderChoice() && b) {
            PrivacyDisclosureUtils.setupTermsOfServiceAndPrivacyPolicySmsText(this.requireContext(), flowParams, this.mSmsTermsText);
        }
        else {
            PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), flowParams, this.mFooterText);
            this.mSmsTermsText.setText((CharSequence)this.getString(R.string.fui_sms_terms_of_service, new Object[] { this.getString(R.string.fui_verify_phone_number) }));
        }
    }
    
    private void start(final PhoneNumber countryCode) {
        if (!PhoneNumber.isValid(countryCode)) {
            this.mPhoneInputLayout.setError((CharSequence)this.getString(R.string.fui_invalid_phone_number));
            return;
        }
        this.mPhoneEditText.setText((CharSequence)countryCode.getPhoneNumber());
        this.mPhoneEditText.setSelection(countryCode.getPhoneNumber().length());
        final String countryIso = countryCode.getCountryIso();
        if (PhoneNumber.isCountryValid(countryCode) && this.mCountryListSpinner.isValidIso(countryIso)) {
            this.setCountryCode(countryCode);
            this.onNext();
        }
    }
    
    public void hideProgress() {
        this.mSubmitButton.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        ((OperableViewModel<I, Resource<T>>)this.mCheckPhoneHandler).getOperation().observe(this.getViewLifecycleOwner(), (a0<? super Resource<T>>)new ResourceObserver<PhoneNumber>(this, this) {
            final CheckPhoneNumberFragment this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
            }
            
            @Override
            protected void onSuccess(final PhoneNumber phoneNumber) {
                CheckPhoneNumberFragment.access$100(this.this$0, phoneNumber);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((PhoneNumber)o);
            }
        });
        if (bundle == null) {
            if (!this.mCalled) {
                this.mCalled = true;
                this.setDefaultCountryForSpinner();
            }
        }
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        this.mCheckPhoneHandler.onActivityResult(n, n2, intent);
    }
    
    public void onClick(final View view) {
        this.onNext();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mVerificationHandler = new o0(this.requireActivity()).a(PhoneNumberVerificationHandler.class);
        this.mCheckPhoneHandler = new o0(this).a(CheckPhoneHandler.class);
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_phone_layout, viewGroup, false);
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
        this.mProgressBar = (ProgressBar)view.findViewById(R.id.top_progress_bar);
        this.mSubmitButton = (Button)view.findViewById(R.id.send_code);
        this.mCountryListSpinner = (CountryListSpinner)view.findViewById(R.id.country_list);
        this.mPhoneInputLayout = (TextInputLayout)view.findViewById(R.id.phone_layout);
        this.mPhoneEditText = (EditText)view.findViewById(R.id.phone_number);
        this.mSmsTermsText = (TextView)view.findViewById(R.id.send_sms_tos);
        this.mFooterText = (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text);
        this.mSmsTermsText.setText((CharSequence)this.getString(R.string.fui_sms_terms_of_service, new Object[] { this.getString(R.string.fui_verify_phone_number) }));
        if (this.getFlowParams().enableHints) {
            this.mPhoneEditText.setImportantForAutofill(2);
        }
        this.requireActivity().setTitle((CharSequence)this.getString(R.string.fui_verify_phone_number_title));
        ImeHelper.setImeOnDoneListener(this.mPhoneEditText, (ImeHelper.DonePressedListener)new ImeHelper.DonePressedListener(this) {
            final CheckPhoneNumberFragment this$0;
            
            @Override
            public void onDonePressed() {
                CheckPhoneNumberFragment.access$000(this.this$0);
            }
        });
        this.mSubmitButton.setOnClickListener((View$OnClickListener)this);
        this.setupPrivacyDisclosures();
        this.setupCountrySpinner();
    }
    
    public void showProgress(final int n) {
        this.mSubmitButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
}
