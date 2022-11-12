// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.view.inputmethod.InputMethodManager;
import android.content.ClipData;
import androidx.core.content.a;
import android.content.ClipboardManager;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import com.firebase.ui.auth.data.model.State;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import com.firebase.ui.auth.viewmodel.phone.PhoneProviderResponseHandler;
import android.app.Activity;
import android.view.View;
import android.view.View$OnClickListener;
import android.text.TextWatcher;
import android.widget.EditText;
import com.firebase.ui.auth.util.ui.BucketedTextChangeListener;
import java.util.concurrent.TimeUnit;
import com.firebase.ui.auth.R;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.os.Handler;
import android.widget.TextView;
import com.firebase.ui.auth.ui.FragmentBase;

public class SubmitConfirmationCodeFragment extends FragmentBase
{
    private static final String EXTRA_MILLIS_UNTIL_FINISHED = "millis_until_finished";
    private static final long RESEND_WAIT_MILLIS = 60000L;
    public static final String TAG = "SubmitConfirmationCodeFragment";
    private static final long TICK_INTERVAL_MILLIS = 500L;
    private static final int VERIFICATION_CODE_LENGTH = 6;
    private SpacedEditText mConfirmationCodeEditText;
    private TextView mCountDownTextView;
    private final Runnable mCountdown;
    private PhoneNumberVerificationHandler mHandler;
    private boolean mHasResumed;
    private final Handler mLooper;
    private long mMillisUntilFinished;
    private String mPhoneNumber;
    private TextView mPhoneTextView;
    private ProgressBar mProgressBar;
    private TextView mResendCodeTextView;
    
    public SubmitConfirmationCodeFragment() {
        this.mLooper = new Handler();
        this.mCountdown = new Runnable() {
            final SubmitConfirmationCodeFragment this$0;
            
            @Override
            public void run() {
                SubmitConfirmationCodeFragment.access$000(this.this$0);
            }
        };
        this.mMillisUntilFinished = 60000L;
    }
    
    static void access$000(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        submitConfirmationCodeFragment.processCountdownTick();
    }
    
    static SpacedEditText access$100(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        return submitConfirmationCodeFragment.mConfirmationCodeEditText;
    }
    
    static void access$200(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        submitConfirmationCodeFragment.submitCode();
    }
    
    static String access$300(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        return submitConfirmationCodeFragment.mPhoneNumber;
    }
    
    static PhoneNumberVerificationHandler access$400(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        return submitConfirmationCodeFragment.mHandler;
    }
    
    static TextView access$500(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        return submitConfirmationCodeFragment.mResendCodeTextView;
    }
    
    static TextView access$600(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        return submitConfirmationCodeFragment.mCountDownTextView;
    }
    
    static long access$702(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment, final long mMillisUntilFinished) {
        return submitConfirmationCodeFragment.mMillisUntilFinished = mMillisUntilFinished;
    }
    
    static Runnable access$800(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        return submitConfirmationCodeFragment.mCountdown;
    }
    
    static Handler access$900(final SubmitConfirmationCodeFragment submitConfirmationCodeFragment) {
        return submitConfirmationCodeFragment.mLooper;
    }
    
    public static SubmitConfirmationCodeFragment newInstance(final String s) {
        final SubmitConfirmationCodeFragment submitConfirmationCodeFragment = new SubmitConfirmationCodeFragment();
        final Bundle arguments = new Bundle();
        arguments.putString("extra_phone_number", s);
        submitConfirmationCodeFragment.setArguments(arguments);
        return submitConfirmationCodeFragment;
    }
    
    private void processCountdownTick() {
        final long mMillisUntilFinished = this.mMillisUntilFinished - 500L;
        this.mMillisUntilFinished = mMillisUntilFinished;
        if (mMillisUntilFinished <= 0L) {
            this.mCountDownTextView.setText((CharSequence)"");
            this.mCountDownTextView.setVisibility(8);
            this.mResendCodeTextView.setVisibility(0);
        }
        else {
            this.mCountDownTextView.setText((CharSequence)String.format(this.getString(R.string.fui_resend_code_in), TimeUnit.MILLISECONDS.toSeconds(this.mMillisUntilFinished) + 1L));
            this.mLooper.postDelayed(this.mCountdown, 500L);
        }
    }
    
    private void setupConfirmationCodeEditText() {
        ((EditText)this.mConfirmationCodeEditText).setText((CharSequence)"------");
        final SpacedEditText mConfirmationCodeEditText;
        ((EditText)mConfirmationCodeEditText).addTextChangedListener((TextWatcher)new BucketedTextChangeListener((EditText)(mConfirmationCodeEditText = this.mConfirmationCodeEditText), 6, "-", (BucketedTextChangeListener.ContentChangeCallback)new BucketedTextChangeListener.ContentChangeCallback(this) {
            final SubmitConfirmationCodeFragment this$0;
            
            @Override
            public void whenComplete() {
                SubmitConfirmationCodeFragment.access$200(this.this$0);
            }
            
            @Override
            public void whileIncomplete() {
            }
        }));
    }
    
    private void setupEditPhoneNumberTextView() {
        this.mPhoneTextView.setText((CharSequence)this.mPhoneNumber);
        this.mPhoneTextView.setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final SubmitConfirmationCodeFragment this$0;
            
            public void onClick(final View view) {
                this.this$0.requireActivity().getSupportFragmentManager().g1();
            }
        });
    }
    
    private void setupResendConfirmationCodeTextView() {
        this.mResendCodeTextView.setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final SubmitConfirmationCodeFragment this$0;
            
            public void onClick(final View view) {
                SubmitConfirmationCodeFragment.access$400(this.this$0).verifyPhoneNumber(this.this$0.requireActivity(), SubmitConfirmationCodeFragment.access$300(this.this$0), true);
                SubmitConfirmationCodeFragment.access$500(this.this$0).setVisibility(8);
                SubmitConfirmationCodeFragment.access$600(this.this$0).setVisibility(0);
                SubmitConfirmationCodeFragment.access$600(this.this$0).setText((CharSequence)String.format(this.this$0.getString(R.string.fui_resend_code_in), 60L));
                SubmitConfirmationCodeFragment.access$702(this.this$0, 60000L);
                SubmitConfirmationCodeFragment.access$900(this.this$0).postDelayed(SubmitConfirmationCodeFragment.access$800(this.this$0), 500L);
            }
        });
    }
    
    private void submitCode() {
        this.mHandler.submitVerificationCode(this.mPhoneNumber, this.mConfirmationCodeEditText.getUnspacedText().toString());
    }
    
    @Override
    public void hideProgress() {
        this.mProgressBar.setVisibility(4);
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        ((OperableViewModel<I, Resource<T>>)new o0(this.requireActivity()).a(PhoneProviderResponseHandler.class)).getOperation().observe(this.getViewLifecycleOwner(), (a0<? super Resource<T>>)new a0<Resource<IdpResponse>>(this) {
            final SubmitConfirmationCodeFragment this$0;
            
            @Override
            public void onChanged(final Resource<IdpResponse> resource) {
                if (resource.getState() == State.FAILURE) {
                    ((EditText)SubmitConfirmationCodeFragment.access$100(this.this$0)).setText((CharSequence)"");
                }
            }
            
            @Override
            public /* bridge */ void onChanged(final Object o) {
                this.onChanged((Resource<IdpResponse>)o);
            }
        });
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new o0(this.requireActivity()).a(PhoneNumberVerificationHandler.class);
        this.mPhoneNumber = this.getArguments().getString("extra_phone_number");
        if (bundle != null) {
            this.mMillisUntilFinished = bundle.getLong("millis_until_finished");
        }
    }
    
    @Override
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_confirmation_code_layout, viewGroup, false);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mLooper.removeCallbacks(this.mCountdown);
    }
    
    @Override
    public void onResume() {
        super.onResume();
        if (!this.mHasResumed) {
            this.mHasResumed = true;
            return;
        }
        final ClipData primaryClip = a.getSystemService(this.requireContext(), ClipboardManager.class).getPrimaryClip();
        while (true) {
            if (primaryClip == null || primaryClip.getItemCount() != 1) {
                break Label_0088;
            }
            final CharSequence text = primaryClip.getItemAt(0).getText();
            if (text == null || text.length() != 6) {
                break Label_0088;
            }
            try {
                Integer.parseInt(text.toString());
                ((EditText)this.mConfirmationCodeEditText).setText(text);
                this.mLooper.removeCallbacks(this.mCountdown);
                this.mLooper.postDelayed(this.mCountdown, 500L);
            }
            catch (final NumberFormatException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        this.mLooper.removeCallbacks(this.mCountdown);
        bundle.putLong("millis_until_finished", this.mMillisUntilFinished);
    }
    
    @Override
    public void onStart() {
        super.onStart();
        ((EditText)this.mConfirmationCodeEditText).requestFocus();
        ((InputMethodManager)this.requireActivity().getSystemService("input_method")).showSoftInput((View)this.mConfirmationCodeEditText, 0);
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        this.mProgressBar = (ProgressBar)view.findViewById(R.id.top_progress_bar);
        this.mPhoneTextView = (TextView)view.findViewById(R.id.edit_phone_number);
        this.mCountDownTextView = (TextView)view.findViewById(R.id.ticker);
        this.mResendCodeTextView = (TextView)view.findViewById(R.id.resend_code);
        this.mConfirmationCodeEditText = (SpacedEditText)view.findViewById(R.id.confirmation_code);
        this.requireActivity().setTitle((CharSequence)this.getString(R.string.fui_verify_your_phone_title));
        this.processCountdownTick();
        this.setupConfirmationCodeEditText();
        this.setupEditPhoneNumberTextView();
        this.setupResendConfirmationCodeTextView();
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), this.getFlowParams(), (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    @Override
    public void showProgress(final int n) {
        this.mProgressBar.setVisibility(0);
    }
}
