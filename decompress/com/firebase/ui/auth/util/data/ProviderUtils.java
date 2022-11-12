// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import com.firebase.ui.auth.R;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.AuthCredential;
import com.firebase.ui.auth.IdpResponse;
import java.util.Iterator;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.AuthUI;
import java.util.ArrayList;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Tasks;
import android.text.TextUtils;
import java.util.List;
import com.google.android.gms.tasks.Task;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.auth.FirebaseAuth;

public final class ProviderUtils
{
    private static final String GITHUB_IDENTITY = "https://github.com";
    private static final String PHONE_IDENTITY = "https://phone.firebase";
    
    private ProviderUtils() {
        throw new AssertionError((Object)"No instance for you!");
    }
    
    public static String accountTypeToProviderId(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1721158175: {
                if (!s.equals("https://www.facebook.com")) {
                    break;
                }
                n = 4;
                break;
            }
            case 746549591: {
                if (!s.equals("https://twitter.com")) {
                    break;
                }
                n = 3;
                break;
            }
            case -376862683: {
                if (!s.equals("https://accounts.google.com")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1294469354: {
                if (!s.equals("https://phone.firebase")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1534095099: {
                if (!s.equals("https://github.com")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return null;
            }
            case 4: {
                return "facebook.com";
            }
            case 3: {
                return "twitter.com";
            }
            case 2: {
                return "google.com";
            }
            case 1: {
                return "phone";
            }
            case 0: {
                return "github.com";
            }
        }
    }
    
    public static Task<List<String>> fetchSortedProviders(final FirebaseAuth firebaseAuth, final FlowParameters flowParameters, final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return (Task<List<String>>)Tasks.d((Exception)new NullPointerException("Email cannot be empty"));
        }
        return (Task<List<String>>)firebaseAuth.f(s).m((Continuation)new Continuation<SignInMethodQueryResult, Task<List<String>>>(flowParameters) {
            final FlowParameters val$params;
            
            private void changePriority(final List<String> list, final String s, final boolean b) {
                if (list.remove(s)) {
                    if (b) {
                        list.add(0, s);
                    }
                    else {
                        list.add(s);
                    }
                }
            }
            
            private void reorderPriorities(final List<String> list) {
                this.changePriority(list, "password", true);
                this.changePriority(list, "google.com", true);
                this.changePriority(list, "emailLink", false);
            }
            
            public Task<List<String>> then(final Task<SignInMethodQueryResult> task) {
                List<String> a;
                if ((a = ((SignInMethodQueryResult)task.p()).a()) == null) {
                    a = new ArrayList<String>();
                }
                final ArrayList list = new ArrayList(this.val$params.providers.size());
                final Iterator<AuthUI.IdpConfig> iterator = this.val$params.providers.iterator();
                while (iterator.hasNext()) {
                    list.add(iterator.next().getProviderId());
                }
                final ArrayList list2 = new ArrayList(a.size());
                final Iterator iterator2 = a.iterator();
                while (iterator2.hasNext()) {
                    final String signInMethodToProviderId = ProviderUtils.signInMethodToProviderId((String)iterator2.next());
                    if (list.contains(signInMethodToProviderId)) {
                        list2.add(0, (Object)signInMethodToProviderId);
                    }
                }
                if (list.contains("emailLink") && a.contains("password") && !a.contains("emailLink")) {
                    list2.add(0, (Object)ProviderUtils.signInMethodToProviderId("emailLink"));
                }
                if (task.t() && list2.isEmpty() && !a.isEmpty()) {
                    return (Task<List<String>>)Tasks.d((Exception)new FirebaseUiException(3));
                }
                this.reorderPriorities((List<String>)list2);
                return (Task<List<String>>)Tasks.e((Object)list2);
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<SignInMethodQueryResult>)task);
            }
        });
    }
    
    public static Task<String> fetchTopProvider(final FirebaseAuth firebaseAuth, final FlowParameters flowParameters, final String s) {
        return (Task<String>)fetchSortedProviders(firebaseAuth, flowParameters, s).m((Continuation)new Continuation<List<String>, Task<String>>() {
            public Task<String> then(final Task<List<String>> task) {
                if (!task.t()) {
                    return (Task<String>)Tasks.d(task.o());
                }
                final List list = (List)task.p();
                if (list.isEmpty()) {
                    return (Task<String>)Tasks.e((Object)null);
                }
                return (Task<String>)Tasks.e(list.get(0));
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<List<String>>)task);
            }
        });
    }
    
    public static AuthCredential getAuthCredential(final IdpResponse idpResponse) {
        if (idpResponse.hasCredentialForLinking()) {
            return idpResponse.getCredentialForLinking();
        }
        final String providerType = idpResponse.getProviderType();
        providerType.hashCode();
        if (providerType.equals("google.com")) {
            return GoogleAuthProvider.a(idpResponse.getIdpToken(), null);
        }
        if (!providerType.equals("facebook.com")) {
            return null;
        }
        return FacebookAuthProvider.a(idpResponse.getIdpToken());
    }
    
    public static AuthUI.IdpConfig getConfigFromIdps(final List<AuthUI.IdpConfig> list, final String s) {
        for (final AuthUI.IdpConfig idpConfig : list) {
            if (idpConfig.getProviderId().equals(s)) {
                return idpConfig;
            }
        }
        return null;
    }
    
    public static AuthUI.IdpConfig getConfigFromIdpsOrThrow(final List<AuthUI.IdpConfig> list, final String s) {
        final AuthUI.IdpConfig configFromIdps = getConfigFromIdps(list, s);
        if (configFromIdps != null) {
            return configFromIdps;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Provider ");
        sb.append(s);
        sb.append(" not found.");
        throw new IllegalStateException(sb.toString());
    }
    
    public static String idpResponseToAccountType(final IdpResponse idpResponse) {
        if (idpResponse == null) {
            return null;
        }
        return providerIdToAccountType(idpResponse.getProviderType());
    }
    
    public static String providerIdToAccountType(final String s) {
        int n = 0;
        Label_0153: {
            switch (s.hashCode()) {
                case 1985010934: {
                    if (s.equals("github.com")) {
                        n = 3;
                        break Label_0153;
                    }
                    break;
                }
                case 1216985755: {
                    if (s.equals("password")) {
                        n = 5;
                        break Label_0153;
                    }
                    break;
                }
                case 106642798: {
                    if (s.equals("phone")) {
                        n = 4;
                        break Label_0153;
                    }
                    break;
                }
                case -364826023: {
                    if (s.equals("facebook.com")) {
                        n = 1;
                        break Label_0153;
                    }
                    break;
                }
                case -1536293812: {
                    if (s.equals("google.com")) {
                        n = 0;
                        break Label_0153;
                    }
                    break;
                }
                case -1830313082: {
                    if (s.equals("twitter.com")) {
                        n = 2;
                        break Label_0153;
                    }
                    break;
                }
            }
            n = -1;
        }
        if (n == 0) {
            return "https://accounts.google.com";
        }
        if (n == 1) {
            return "https://www.facebook.com";
        }
        if (n == 2) {
            return "https://twitter.com";
        }
        if (n == 3) {
            return "https://github.com";
        }
        if (n != 4) {
            return null;
        }
        return "https://phone.firebase";
    }
    
    public static String providerIdToProviderName(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2120171958: {
                if (!s.equals("emailLink")) {
                    break;
                }
                n = 6;
                break;
            }
            case 1985010934: {
                if (!s.equals("github.com")) {
                    break;
                }
                n = 5;
                break;
            }
            case 1216985755: {
                if (!s.equals("password")) {
                    break;
                }
                n = 4;
                break;
            }
            case 106642798: {
                if (!s.equals("phone")) {
                    break;
                }
                n = 3;
                break;
            }
            case -364826023: {
                if (!s.equals("facebook.com")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1536293812: {
                if (!s.equals("google.com")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1830313082: {
                if (!s.equals("twitter.com")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return null;
            }
            case 5: {
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_github);
            }
            case 4:
            case 6: {
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_email);
            }
            case 3: {
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_phone);
            }
            case 2: {
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_facebook);
            }
            case 1: {
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_google);
            }
            case 0: {
                return AuthUI.getApplicationContext().getString(R.string.fui_idp_name_twitter);
            }
        }
    }
    
    public static String signInMethodToProviderId(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2120171958: {
                if (!s.equals("emailLink")) {
                    break;
                }
                n = 6;
                break;
            }
            case 1985010934: {
                if (!s.equals("github.com")) {
                    break;
                }
                n = 5;
                break;
            }
            case 1216985755: {
                if (!s.equals("password")) {
                    break;
                }
                n = 4;
                break;
            }
            case 106642798: {
                if (!s.equals("phone")) {
                    break;
                }
                n = 3;
                break;
            }
            case -364826023: {
                if (!s.equals("facebook.com")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1536293812: {
                if (!s.equals("google.com")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1830313082: {
                if (!s.equals("twitter.com")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return s;
            }
            case 6: {
                return "emailLink";
            }
            case 5: {
                return "github.com";
            }
            case 4: {
                return "password";
            }
            case 3: {
                return "phone";
            }
            case 2: {
                return "facebook.com";
            }
            case 1: {
                return "google.com";
            }
            case 0: {
                return "twitter.com";
            }
        }
    }
}
