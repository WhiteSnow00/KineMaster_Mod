// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.internal.firebase_auth_api.zzvr;
import com.google.android.gms.internal.firebase_auth_api.zzuj;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzay;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.internal.firebase_auth_api.zztu;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzan;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.internal.firebase_auth_api.zztz;
import com.google.android.gms.internal.firebase_auth_api.zzxd;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.internal.firebase_auth_api.zzvh;
import android.app.Activity;
import com.google.firebase.auth.internal.zzag;
import androidx.annotation.Keep;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.internal.InternalTokenResult;
import android.util.Log;
import com.google.android.gms.internal.firebase-auth-api.zzwq;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CopyOnWriteArrayList;
import com.google.firebase.auth.internal.zzbj;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.inject.Provider;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzbm;
import com.google.firebase.auth.internal.zzbg;
import com.google.firebase.auth.internal.zzw;
import com.google.android.gms.internal.firebase-auth-api.zztq;
import java.util.List;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;

public abstract class FirebaseAuth implements InternalAuthProvider
{
    private FirebaseApp a;
    private final List b;
    private final List c;
    private List d;
    private zztq e;
    private FirebaseUser f;
    private zzw g;
    private final Object h;
    private String i;
    private final Object j;
    private String k;
    private final zzbg l;
    private final zzbm m;
    private final zzf n;
    private final Provider o;
    private zzbi p;
    private zzbj q;
    
    public FirebaseAuth(final FirebaseApp firebaseApp, final Provider o) {
        final com.google.android.gms.internal.firebase_auth_api.zztq zztq = new com.google.android.gms.internal.firebase_auth_api.zztq(firebaseApp);
        final zzbg zzbg = new zzbg(firebaseApp.l(), firebaseApp.q());
        final zzbm c = zzbm.c();
        final zzf b = zzf.b();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.h = new Object();
        this.j = new Object();
        this.q = zzbj.a();
        this.a = Preconditions.k(firebaseApp);
        this.e = (zztq)Preconditions.k(zztq);
        final zzbg l = Preconditions.k(zzbg);
        this.l = l;
        this.g = new zzw();
        final zzbm m = Preconditions.k(c);
        this.m = m;
        this.n = Preconditions.k(b);
        this.o = o;
        final FirebaseUser a = l.a();
        this.f = a;
        if (a != null) {
            final zzwq b2 = l.b(a);
            if (b2 != null) {
                G(this, this.f, b2, false, false);
            }
        }
        m.e(this);
    }
    
    static /* bridge */ List A(final FirebaseAuth firebaseAuth) {
        return firebaseAuth.b;
    }
    
    static /* bridge */ List B(final FirebaseAuth firebaseAuth) {
        return firebaseAuth.c;
    }
    
    public static void E(final FirebaseAuth firebaseAuth, final FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            final String s1 = firebaseUser.S1();
            final StringBuilder sb = new StringBuilder();
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(s1);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        }
        else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        firebaseAuth.q.execute(new d(firebaseAuth));
    }
    
    public static void F(final FirebaseAuth firebaseAuth, final FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            final String s1 = firebaseUser.S1();
            final StringBuilder sb = new StringBuilder();
            sb.append("Notifying id token listeners about user ( ");
            sb.append(s1);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        }
        else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        String zze;
        if (firebaseUser != null) {
            zze = firebaseUser.zze();
        }
        else {
            zze = null;
        }
        firebaseAuth.q.execute(new c(firebaseAuth, new InternalTokenResult(zze)));
    }
    
    @VisibleForTesting
    static void G(final FirebaseAuth firebaseAuth, FirebaseUser f, final zzwq zzwq, final boolean b, final boolean b2) {
        Preconditions.k(f);
        Preconditions.k(zzwq);
        final FirebaseUser f2 = firebaseAuth.f;
        final int n = 0;
        int n2 = 1;
        final boolean b3 = f2 != null && f.S1().equals(firebaseAuth.f.S1());
        if (!b3 && b2) {
            return;
        }
        final FirebaseUser f3 = firebaseAuth.f;
        boolean b4;
        if (f3 == null) {
            b4 = true;
        }
        else {
            final boolean equals = ((com.google.android.gms.internal.firebase_auth_api.zzwq)f3.b2()).zze().equals(((com.google.android.gms.internal.firebase_auth_api.zzwq)zzwq).zze());
            if (b3 && !(equals ^ true)) {
                n2 = n;
            }
            else {
                n2 = 1;
            }
            b4 = (true ^ b3);
        }
        Preconditions.k(f);
        final FirebaseUser f4 = firebaseAuth.f;
        if (f4 == null) {
            firebaseAuth.f = f;
        }
        else {
            f4.a2(f.Q1());
            if (!f.T1()) {
                firebaseAuth.f.Z1();
            }
            firebaseAuth.f.d2(f.N1().a());
        }
        if (b) {
            firebaseAuth.l.d(firebaseAuth.f);
        }
        if (n2 != 0) {
            final FirebaseUser f5 = firebaseAuth.f;
            if (f5 != null) {
                f5.c2(zzwq);
            }
            F(firebaseAuth, firebaseAuth.f);
        }
        if (b4) {
            E(firebaseAuth, firebaseAuth.f);
        }
        if (b) {
            firebaseAuth.l.e(f, zzwq);
        }
        f = firebaseAuth.f;
        if (f != null) {
            X(firebaseAuth).e(f.b2());
        }
    }
    
    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks K(final String s, final PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        if (this.g.d() && s != null && s.equals(this.g.a())) {
            return new h(this, onVerificationStateChangedCallbacks);
        }
        return onVerificationStateChangedCallbacks;
    }
    
    private final boolean L(final String s) {
        final ActionCodeUrl c = ActionCodeUrl.c(s);
        return c != null && !TextUtils.equals((CharSequence)this.k, (CharSequence)c.d());
    }
    
    static /* bridge */ FirebaseUser S(final FirebaseAuth firebaseAuth) {
        return firebaseAuth.f;
    }
    
    static /* bridge */ PhoneAuthProvider.OnVerificationStateChangedCallbacks T(final FirebaseAuth firebaseAuth, final String s, final PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return firebaseAuth.K(s, onVerificationStateChangedCallbacks);
    }
    
    static /* bridge */ zztq U(final FirebaseAuth firebaseAuth) {
        return firebaseAuth.e;
    }
    
    static /* bridge */ zzw V(final FirebaseAuth firebaseAuth) {
        return firebaseAuth.g;
    }
    
    public static zzbi X(final FirebaseAuth firebaseAuth) {
        if (firebaseAuth.p == null) {
            firebaseAuth.p = new zzbi(Preconditions.k(firebaseAuth.a));
        }
        return firebaseAuth.p;
    }
    
    static /* bridge */ String Z(final FirebaseAuth firebaseAuth) {
        return firebaseAuth.i;
    }
    
    @Keep
    public static FirebaseAuth getInstance() {
        return FirebaseApp.m().j(FirebaseAuth.class);
    }
    
    @Keep
    public static FirebaseAuth getInstance(final FirebaseApp firebaseApp) {
        return firebaseApp.j(FirebaseAuth.class);
    }
    
    static /* bridge */ List z(final FirebaseAuth firebaseAuth) {
        return firebaseAuth.d;
    }
    
    public final void C() {
        Preconditions.k(this.l);
        final FirebaseUser f = this.f;
        if (f != null) {
            final zzbg l = this.l;
            Preconditions.k(f);
            l.c(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", f.S1()));
            this.f = null;
        }
        this.l.c("com.google.firebase.auth.FIREBASE_USER");
        F(this, null);
        E(this, null);
    }
    
    public final void D(final FirebaseUser firebaseUser, final zzwq zzwq, final boolean b) {
        G(this, firebaseUser, zzwq, true, false);
    }
    
    public final void H(final PhoneAuthOptions phoneAuthOptions) {
        if (phoneAuthOptions.l()) {
            final FirebaseAuth c = phoneAuthOptions.c();
            String s;
            if (Preconditions.k(phoneAuthOptions.d()).zze()) {
                s = Preconditions.g(phoneAuthOptions.i());
            }
            else {
                s = Preconditions.g(Preconditions.k(phoneAuthOptions.g()).O1());
            }
            if (phoneAuthOptions.e() == null || !zzvh.zzd(s, phoneAuthOptions.f(), (Activity)Preconditions.k(phoneAuthOptions.b()), phoneAuthOptions.j())) {
                c.n.a(c, phoneAuthOptions.i(), Preconditions.k(phoneAuthOptions.b()), c.J()).c((OnCompleteListener)new g(c, phoneAuthOptions));
            }
        }
        else {
            final FirebaseAuth c2 = phoneAuthOptions.c();
            final String g = Preconditions.g(phoneAuthOptions.i());
            final long longValue = phoneAuthOptions.h();
            final TimeUnit seconds = TimeUnit.SECONDS;
            final PhoneAuthProvider.OnVerificationStateChangedCallbacks f = phoneAuthOptions.f();
            final Activity activity = Preconditions.k(phoneAuthOptions.b());
            final Executor j = phoneAuthOptions.j();
            final boolean b = phoneAuthOptions.e() != null;
            if (b || !zzvh.zzd(g, f, activity, j)) {
                c2.n.a(c2, g, activity, c2.J()).c((OnCompleteListener)new f(c2, g, longValue, seconds, f, activity, j, b));
            }
        }
    }
    
    public final void I(final String s, long convert, final TimeUnit timeUnit, final PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, final Activity activity, final Executor executor, final boolean b, final String s2, final String s3) {
        convert = TimeUnit.SECONDS.convert(convert, timeUnit);
        if (convert >= 0L && convert <= 120L) {
            ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzO(this.a, (com.google.android.gms.internal.firebase-auth-api.zzxd)new zzxd(s, convert, b, this.i, this.k, s2, this.J(), s3), this.K(s, onVerificationStateChangedCallbacks), activity, executor);
            return;
        }
        throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
    }
    
    @VisibleForTesting
    final boolean J() {
        return zztz.zza(this.g().l());
    }
    
    public final Task M(final FirebaseUser firebaseUser) {
        Preconditions.k(firebaseUser);
        return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zze(firebaseUser, (zzan)new a(this, firebaseUser));
    }
    
    public final Task N(final FirebaseUser firebaseUser, final boolean b) {
        if (firebaseUser == null) {
            return Tasks.d((Exception)zztu.zza(new Status(17495)));
        }
        final zzwq b2 = firebaseUser.b2();
        if (((com.google.android.gms.internal.firebase_auth_api.zzwq)b2).zzj() && !b) {
            return Tasks.e((Object)zzay.a(((com.google.android.gms.internal.firebase_auth_api.zzwq)b2).zze()));
        }
        return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzi(this.a, firebaseUser, ((com.google.android.gms.internal.firebase_auth_api.zzwq)b2).zzf(), (zzbk)new e(this));
    }
    
    public final Task O(final FirebaseUser firebaseUser, final AuthCredential authCredential) {
        Preconditions.k(authCredential);
        Preconditions.k(firebaseUser);
        return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzj(this.a, firebaseUser, authCredential.L1(), (zzbk)new j(this));
    }
    
    public final Task P(final FirebaseUser firebaseUser, AuthCredential l1) {
        Preconditions.k(firebaseUser);
        Preconditions.k(l1);
        l1 = l1.L1();
        if (l1 instanceof EmailAuthCredential) {
            final EmailAuthCredential emailAuthCredential = (EmailAuthCredential)l1;
            if ("password".equals(emailAuthCredential.M1())) {
                return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzp(this.a, firebaseUser, emailAuthCredential.zzd(), Preconditions.g(emailAuthCredential.zze()), firebaseUser.R1(), (zzbk)new j(this));
            }
            if (this.L(Preconditions.g(emailAuthCredential.zzf()))) {
                return Tasks.d((Exception)zztu.zza(new Status(17072)));
            }
            return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzn(this.a, firebaseUser, emailAuthCredential, (zzbk)new j(this));
        }
        else {
            if (l1 instanceof PhoneAuthCredential) {
                return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzr(this.a, firebaseUser, (PhoneAuthCredential)l1, this.k, (zzbk)new j(this));
            }
            return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzl(this.a, firebaseUser, l1, firebaseUser.R1(), (zzbk)new j(this));
        }
    }
    
    public final Task Q(final Activity activity, final FederatedAuthProvider federatedAuthProvider, final FirebaseUser firebaseUser) {
        Preconditions.k(activity);
        Preconditions.k(federatedAuthProvider);
        Preconditions.k(firebaseUser);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.m.j(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.d((Exception)zztu.zza(new Status(17057)));
        }
        this.m.h(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.a(activity);
        return taskCompletionSource.a();
    }
    
    public final Task R(final FirebaseUser firebaseUser, final UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.k(firebaseUser);
        Preconditions.k(userProfileChangeRequest);
        return ((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzK(this.a, firebaseUser, userProfileChangeRequest, (zzbk)new j(this));
    }
    
    @VisibleForTesting
    public final zzbi W() {
        synchronized (this) {
            return X(this);
        }
    }
    
    public final Provider Y() {
        return this.o;
    }
    
    @Override
    public final Task a(final boolean b) {
        return this.N(this.f, b);
    }
    
    @KeepForSdk
    @Override
    public void b(final com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.k(idTokenListener);
        this.c.add(idTokenListener);
        this.W().d(this.c.size());
    }
    
    public void c(final AuthStateListener authStateListener) {
        this.d.add(authStateListener);
        this.q.execute(new b(this, authStateListener));
    }
    
    public Task<ActionCodeResult> d(final String s) {
        Preconditions.g(s);
        return (Task<ActionCodeResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzb(this.a, s, this.k);
    }
    
    public Task<AuthResult> e(final String s, final String s2) {
        Preconditions.g(s);
        Preconditions.g(s2);
        return (Task<AuthResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzd(this.a, s, s2, this.k, (zzg)new i(this));
    }
    
    public Task<SignInMethodQueryResult> f(final String s) {
        Preconditions.g(s);
        return (Task<SignInMethodQueryResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzf(this.a, s, this.k);
    }
    
    public FirebaseApp g() {
        return this.a;
    }
    
    public FirebaseUser h() {
        return this.f;
    }
    
    public FirebaseAuthSettings i() {
        return this.g;
    }
    
    public String j() {
        synchronized (this.h) {
            return this.i;
        }
    }
    
    public Task<AuthResult> k() {
        return (Task<AuthResult>)this.m.a();
    }
    
    public String l() {
        synchronized (this.j) {
            return this.k;
        }
    }
    
    public boolean m(final String s) {
        return EmailAuthCredential.O1(s);
    }
    
    public Task<Void> n(final String s) {
        Preconditions.g(s);
        return this.o(s, null);
    }
    
    public Task<Void> o(final String s, final ActionCodeSettings actionCodeSettings) {
        Preconditions.g(s);
        ActionCodeSettings s2 = actionCodeSettings;
        if (actionCodeSettings == null) {
            s2 = ActionCodeSettings.S1();
        }
        final String i = this.i;
        if (i != null) {
            s2.T1(i);
        }
        s2.U1(1);
        return (Task<Void>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzu(this.a, s, s2, this.k);
    }
    
    public Task<Void> p(final String s, final ActionCodeSettings actionCodeSettings) {
        Preconditions.g(s);
        Preconditions.k(actionCodeSettings);
        if (actionCodeSettings.K1()) {
            final String i = this.i;
            if (i != null) {
                actionCodeSettings.T1(i);
            }
            return (Task<Void>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzv(this.a, s, actionCodeSettings, this.k);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }
    
    public Task<Void> q(final String s) {
        return (Task<Void>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzw(s);
    }
    
    public void r(final String k) {
        Preconditions.g(k);
        synchronized (this.j) {
            this.k = k;
        }
    }
    
    public Task<AuthResult> s() {
        final FirebaseUser f = this.f;
        if (f != null && f.T1()) {
            final zzx zzx = (zzx)this.f;
            zzx.l2(false);
            return (Task<AuthResult>)Tasks.e((Object)new zzr(zzx));
        }
        return (Task<AuthResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzx(this.a, (zzg)new i(this), this.k);
    }
    
    public Task<AuthResult> t(AuthCredential l1) {
        Preconditions.k(l1);
        l1 = l1.L1();
        if (l1 instanceof EmailAuthCredential) {
            final EmailAuthCredential emailAuthCredential = (EmailAuthCredential)l1;
            if (!emailAuthCredential.zzg()) {
                return (Task<AuthResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzA(this.a, emailAuthCredential.zzd(), Preconditions.g(emailAuthCredential.zze()), this.k, (zzg)new i(this));
            }
            if (this.L(Preconditions.g(emailAuthCredential.zzf()))) {
                return (Task<AuthResult>)Tasks.d((Exception)zztu.zza(new Status(17072)));
            }
            return (Task<AuthResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzB(this.a, emailAuthCredential, (zzg)new i(this));
        }
        else {
            if (l1 instanceof PhoneAuthCredential) {
                return (Task<AuthResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzC(this.a, (PhoneAuthCredential)l1, this.k, (zzg)new i(this));
            }
            return (Task<AuthResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzy(this.a, l1, this.k, (zzg)new i(this));
        }
    }
    
    public Task<AuthResult> u(final String s, final String s2) {
        Preconditions.g(s);
        Preconditions.g(s2);
        return (Task<AuthResult>)((com.google.android.gms.internal.firebase_auth_api.zztq)this.e).zzA(this.a, s, s2, this.k, (zzg)new i(this));
    }
    
    public void v() {
        this.C();
        final zzbi p = this.p;
        if (p != null) {
            p.c();
        }
    }
    
    public Task<AuthResult> w(final Activity activity, final FederatedAuthProvider federatedAuthProvider) {
        Preconditions.k(federatedAuthProvider);
        Preconditions.k(activity);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.m.i(activity, taskCompletionSource, this)) {
            return (Task<AuthResult>)Tasks.d((Exception)zztu.zza(new Status(17057)));
        }
        this.m.g(activity.getApplicationContext(), this);
        federatedAuthProvider.b(activity);
        return (Task<AuthResult>)taskCompletionSource.a();
    }
    
    public void x() {
        synchronized (this.h) {
            this.i = zzuj.zza();
        }
    }
    
    public void y(final String s, final int n) {
        Preconditions.g(s);
        boolean b = false;
        if (n >= 0) {
            b = b;
            if (n <= 65535) {
                b = true;
            }
        }
        Preconditions.b(b, "Port number must be in the range 0-65535");
        zzvr.zzf(this.a, s, n);
    }
    
    public interface AuthStateListener
    {
        void a(final FirebaseAuth p0);
    }
    
    public interface IdTokenListener
    {
        void a(final FirebaseAuth p0);
    }
}
