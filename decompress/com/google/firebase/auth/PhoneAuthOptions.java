// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import java.util.concurrent.TimeUnit;
import com.google.firebase.auth.internal.zzag;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.common.internal.Preconditions;
import android.app.Activity;
import java.util.concurrent.Executor;

public final class PhoneAuthOptions
{
    private final FirebaseAuth a;
    private Long b;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks c;
    private Executor d;
    private String e;
    private Activity f;
    private PhoneAuthProvider.ForceResendingToken g;
    private MultiFactorSession h;
    private PhoneMultiFactorInfo i;
    private boolean j;
    
    PhoneAuthOptions(final FirebaseAuth a, final Long b, final PhoneAuthProvider.OnVerificationStateChangedCallbacks c, final Executor d, final String e, final Activity f, final PhoneAuthProvider.ForceResendingToken g, final MultiFactorSession h, final PhoneMultiFactorInfo i, final boolean j, final zzaf zzaf) {
        this.a = a;
        this.e = e;
        this.b = b;
        this.c = c;
        this.f = f;
        this.d = d;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public static Builder a(final FirebaseAuth firebaseAuth) {
        return new Builder(firebaseAuth);
    }
    
    public final Activity b() {
        return this.f;
    }
    
    public final FirebaseAuth c() {
        return this.a;
    }
    
    public final MultiFactorSession d() {
        return this.h;
    }
    
    public final PhoneAuthProvider.ForceResendingToken e() {
        return this.g;
    }
    
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks f() {
        return this.c;
    }
    
    public final PhoneMultiFactorInfo g() {
        return this.i;
    }
    
    public final Long h() {
        return this.b;
    }
    
    public final String i() {
        return this.e;
    }
    
    public final Executor j() {
        return this.d;
    }
    
    public final boolean k() {
        return this.j;
    }
    
    public final boolean l() {
        return this.h != null;
    }
    
    public static final class Builder
    {
        private final FirebaseAuth a;
        private String b;
        private Long c;
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks d;
        private Executor e;
        private Activity f;
        private PhoneAuthProvider.ForceResendingToken g;
        private MultiFactorSession h;
        private PhoneMultiFactorInfo i;
        private boolean j;
        
        public Builder(final FirebaseAuth firebaseAuth) {
            this.a = Preconditions.k(firebaseAuth);
        }
        
        public PhoneAuthOptions a() {
            Preconditions.l(this.a, "FirebaseAuth instance cannot be null");
            Preconditions.l(this.c, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            Preconditions.l(this.d, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            Preconditions.l(this.f, "You must specify an Activity on your PhoneAuthOptions. Please call #setActivity()");
            this.e = TaskExecutors.a;
            if (this.c >= 0L && this.c <= 120L) {
                final MultiFactorSession h = this.h;
                final boolean b = false;
                final boolean b2 = false;
                boolean b3 = false;
                if (h == null) {
                    Preconditions.h(this.b, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                    Preconditions.b(this.j ^ true, "You cannot require sms validation without setting a multi-factor session.");
                    if (this.i == null) {
                        b3 = true;
                    }
                    Preconditions.b(b3, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                }
                else if (((zzag)h).zze()) {
                    Preconditions.g(this.b);
                    boolean b4 = b;
                    if (this.i == null) {
                        b4 = true;
                    }
                    Preconditions.b(b4, "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.");
                }
                else {
                    Preconditions.b(this.i != null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                    boolean b5 = b2;
                    if (this.b == null) {
                        b5 = true;
                    }
                    Preconditions.b(b5, "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.");
                }
                return new PhoneAuthOptions(this.a, this.c, this.d, this.e, this.b, this.f, this.g, this.h, this.i, this.j, null);
            }
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        
        public Builder b(final Activity f) {
            this.f = f;
            return this;
        }
        
        public Builder c(final PhoneAuthProvider.OnVerificationStateChangedCallbacks d) {
            this.d = d;
            return this;
        }
        
        public Builder d(final PhoneAuthProvider.ForceResendingToken g) {
            this.g = g;
            return this;
        }
        
        public Builder e(final String b) {
            this.b = b;
            return this;
        }
        
        public Builder f(final Long n, final TimeUnit timeUnit) {
            this.c = TimeUnit.SECONDS.convert(n, timeUnit);
            return this;
        }
    }
}
