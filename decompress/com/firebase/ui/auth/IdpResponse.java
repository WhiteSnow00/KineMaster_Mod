// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

import android.text.TextUtils;
import com.google.firebase.auth.AuthResult;
import android.content.Intent;
import android.os.Parcel;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.AuthCredential;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class IdpResponse implements Parcelable
{
    public static final Parcelable$Creator<IdpResponse> CREATOR;
    private final FirebaseUiException mException;
    private final boolean mIsNewUser;
    private final AuthCredential mPendingCredential;
    private final String mSecret;
    private final String mToken;
    private final User mUser;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<IdpResponse>() {
            public IdpResponse createFromParcel(final Parcel parcel) {
                final User user = (User)parcel.readParcelable(User.class.getClassLoader());
                final String string = parcel.readString();
                final String string2 = parcel.readString();
                final int int1 = parcel.readInt();
                boolean b = true;
                if (int1 != 1) {
                    b = false;
                }
                return new IdpResponse(user, string, string2, b, (FirebaseUiException)parcel.readSerializable(), (AuthCredential)parcel.readParcelable(AuthCredential.class.getClassLoader()), null);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public IdpResponse[] newArray(final int n) {
                return new IdpResponse[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private IdpResponse(final FirebaseUiException ex) {
        this(null, null, null, false, ex, null);
    }
    
    private IdpResponse(final User user, final String s, final String s2, final AuthCredential authCredential, final boolean b) {
        this(user, s, s2, b, null, authCredential);
    }
    
    IdpResponse(final User user, final String s, final String s2, final AuthCredential authCredential, final boolean b, final IdpResponse$1 parcelable$Creator) {
        this(user, s, s2, authCredential, b);
    }
    
    private IdpResponse(final User mUser, final String mToken, final String mSecret, final boolean mIsNewUser, final FirebaseUiException mException, final AuthCredential mPendingCredential) {
        this.mUser = mUser;
        this.mToken = mToken;
        this.mSecret = mSecret;
        this.mIsNewUser = mIsNewUser;
        this.mException = mException;
        this.mPendingCredential = mPendingCredential;
    }
    
    IdpResponse(final User user, final String s, final String s2, final boolean b, final FirebaseUiException ex, final AuthCredential authCredential, final IdpResponse$1 parcelable$Creator) {
        this(user, s, s2, b, ex, authCredential);
    }
    
    private IdpResponse(final AuthCredential authCredential, final FirebaseUiException ex) {
        this(null, null, null, false, ex, authCredential);
    }
    
    IdpResponse(final AuthCredential authCredential, final FirebaseUiException ex, final IdpResponse$1 parcelable$Creator) {
        this(authCredential, ex);
    }
    
    static User access$100(final IdpResponse idpResponse) {
        return idpResponse.mUser;
    }
    
    static String access$200(final IdpResponse idpResponse) {
        return idpResponse.mToken;
    }
    
    static String access$300(final IdpResponse idpResponse) {
        return idpResponse.mSecret;
    }
    
    static boolean access$400(final IdpResponse idpResponse) {
        return idpResponse.mIsNewUser;
    }
    
    static AuthCredential access$500(final IdpResponse idpResponse) {
        return idpResponse.mPendingCredential;
    }
    
    public static IdpResponse from(final Exception ex) {
        if (ex instanceof FirebaseUiException) {
            return new IdpResponse((FirebaseUiException)ex);
        }
        if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
            return ((FirebaseAuthAnonymousUpgradeException)ex).getResponse();
        }
        if (ex instanceof FirebaseUiUserCollisionException) {
            final FirebaseUiUserCollisionException ex2 = (FirebaseUiUserCollisionException)ex;
            return new IdpResponse(new User.Builder(ex2.getProviderId(), ex2.getEmail()).build(), null, null, false, new FirebaseUiException(ex2.getErrorCode(), ex2.getMessage()), ex2.getCredential());
        }
        final FirebaseUiException ex3 = new FirebaseUiException(0, ex.getMessage());
        ex3.setStackTrace(ex.getStackTrace());
        return new IdpResponse(ex3);
    }
    
    public static IdpResponse fromResultIntent(final Intent intent) {
        if (intent != null) {
            return (IdpResponse)intent.getParcelableExtra("extra_idp_response");
        }
        return null;
    }
    
    public static Intent getErrorIntent(final Exception ex) {
        return from(ex).toIntent();
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final IdpResponse idpResponse = (IdpResponse)o;
            final User mUser = this.mUser;
            if (mUser == null) {
                if (idpResponse.mUser != null) {
                    return false;
                }
            }
            else if (!mUser.equals(idpResponse.mUser)) {
                return false;
            }
            final String mToken = this.mToken;
            if (mToken == null) {
                if (idpResponse.mToken != null) {
                    return false;
                }
            }
            else if (!mToken.equals(idpResponse.mToken)) {
                return false;
            }
            final String mSecret = this.mSecret;
            if (mSecret == null) {
                if (idpResponse.mSecret != null) {
                    return false;
                }
            }
            else if (!mSecret.equals(idpResponse.mSecret)) {
                return false;
            }
            if (this.mIsNewUser == idpResponse.mIsNewUser) {
                final FirebaseUiException mException = this.mException;
                if (mException == null) {
                    if (idpResponse.mException != null) {
                        return false;
                    }
                }
                else if (!mException.equals(idpResponse.mException)) {
                    return false;
                }
                final AuthCredential mPendingCredential = this.mPendingCredential;
                if (mPendingCredential == null) {
                    if (idpResponse.mPendingCredential == null) {
                        return b;
                    }
                }
                else if (mPendingCredential.K1().equals(idpResponse.mPendingCredential.K1())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    public AuthCredential getCredentialForLinking() {
        return this.mPendingCredential;
    }
    
    public String getEmail() {
        final User mUser = this.mUser;
        String email;
        if (mUser != null) {
            email = mUser.getEmail();
        }
        else {
            email = null;
        }
        return email;
    }
    
    public FirebaseUiException getError() {
        return this.mException;
    }
    
    public String getIdpSecret() {
        return this.mSecret;
    }
    
    public String getIdpToken() {
        return this.mToken;
    }
    
    public String getPhoneNumber() {
        final User mUser = this.mUser;
        String phoneNumber;
        if (mUser != null) {
            phoneNumber = mUser.getPhoneNumber();
        }
        else {
            phoneNumber = null;
        }
        return phoneNumber;
    }
    
    public String getProviderType() {
        final User mUser = this.mUser;
        String providerId;
        if (mUser != null) {
            providerId = mUser.getProviderId();
        }
        else {
            providerId = null;
        }
        return providerId;
    }
    
    public User getUser() {
        return this.mUser;
    }
    
    public boolean hasCredentialForLinking() {
        return this.mPendingCredential != null;
    }
    
    @Override
    public int hashCode() {
        final User mUser = this.mUser;
        int hashCode = 0;
        int hashCode2;
        if (mUser == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = mUser.hashCode();
        }
        final String mToken = this.mToken;
        int hashCode3;
        if (mToken == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = mToken.hashCode();
        }
        final String mSecret = this.mSecret;
        int hashCode4;
        if (mSecret == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = mSecret.hashCode();
        }
        final int mIsNewUser = this.mIsNewUser ? 1 : 0;
        final FirebaseUiException mException = this.mException;
        int hashCode5;
        if (mException == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = mException.hashCode();
        }
        final AuthCredential mPendingCredential = this.mPendingCredential;
        if (mPendingCredential != null) {
            hashCode = mPendingCredential.K1().hashCode();
        }
        return ((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + mIsNewUser) * 31 + hashCode5) * 31 + hashCode;
    }
    
    public boolean isNewUser() {
        return this.mIsNewUser;
    }
    
    public boolean isRecoverableErrorResponse() {
        return this.mPendingCredential != null || this.getEmail() != null;
    }
    
    public boolean isSuccessful() {
        return this.mException == null;
    }
    
    public Builder mutate() {
        if (this.isSuccessful()) {
            return new Builder(this);
        }
        throw new IllegalStateException("Cannot mutate an unsuccessful response.");
    }
    
    public Intent toIntent() {
        return new Intent().putExtra("extra_idp_response", (Parcelable)this);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("IdpResponse{mUser=");
        sb.append(this.mUser);
        sb.append(", mToken='");
        sb.append(this.mToken);
        sb.append('\'');
        sb.append(", mSecret='");
        sb.append(this.mSecret);
        sb.append('\'');
        sb.append(", mIsNewUser='");
        sb.append(this.mIsNewUser);
        sb.append('\'');
        sb.append(", mException=");
        sb.append(this.mException);
        sb.append(", mPendingCredential=");
        sb.append(this.mPendingCredential);
        sb.append('}');
        return sb.toString();
    }
    
    public IdpResponse withResult(final AuthResult authResult) {
        return this.mutate().setNewUser(authResult.d1().isNewUser()).build();
    }
    
    public void writeToParcel(final Parcel p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0        
        //     2: getfield        com/firebase/ui/auth/IdpResponse.mUser:Lcom/firebase/ui/auth/data/model/User;
        //     5: iload_2        
        //     6: invokevirtual   android/os/Parcel.writeParcelable:(Landroid/os/Parcelable;I)V
        //     9: aload_1        
        //    10: aload_0        
        //    11: getfield        com/firebase/ui/auth/IdpResponse.mToken:Ljava/lang/String;
        //    14: invokevirtual   android/os/Parcel.writeString:(Ljava/lang/String;)V
        //    17: aload_1        
        //    18: aload_0        
        //    19: getfield        com/firebase/ui/auth/IdpResponse.mSecret:Ljava/lang/String;
        //    22: invokevirtual   android/os/Parcel.writeString:(Ljava/lang/String;)V
        //    25: aload_1        
        //    26: aload_0        
        //    27: getfield        com/firebase/ui/auth/IdpResponse.mIsNewUser:Z
        //    30: invokevirtual   android/os/Parcel.writeInt:(I)V
        //    33: aconst_null    
        //    34: astore          5
        //    36: aconst_null    
        //    37: astore          6
        //    39: aload           6
        //    41: astore_3       
        //    42: new             Ljava/io/ObjectOutputStream;
        //    45: astore          4
        //    47: aload           6
        //    49: astore_3       
        //    50: new             Ljava/io/ByteArrayOutputStream;
        //    53: astore          7
        //    55: aload           6
        //    57: astore_3       
        //    58: aload           7
        //    60: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    63: aload           6
        //    65: astore_3       
        //    66: aload           4
        //    68: aload           7
        //    70: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    73: aload           4
        //    75: aload_0        
        //    76: getfield        com/firebase/ui/auth/IdpResponse.mException:Lcom/firebase/ui/auth/FirebaseUiException;
        //    79: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //    82: aload_1        
        //    83: aload_0        
        //    84: getfield        com/firebase/ui/auth/IdpResponse.mException:Lcom/firebase/ui/auth/FirebaseUiException;
        //    87: invokevirtual   android/os/Parcel.writeSerializable:(Ljava/io/Serializable;)V
        //    90: aload           4
        //    92: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    95: goto            238
        //    98: astore_1       
        //    99: aload           4
        //   101: astore_3       
        //   102: goto            248
        //   105: astore_3       
        //   106: goto            113
        //   109: astore_1       
        //   110: goto            248
        //   113: aload           4
        //   115: astore_3       
        //   116: new             Lcom/firebase/ui/auth/FirebaseUiException;
        //   119: astore          5
        //   121: aload           4
        //   123: astore_3       
        //   124: new             Ljava/lang/StringBuilder;
        //   127: astore          6
        //   129: aload           4
        //   131: astore_3       
        //   132: aload           6
        //   134: invokespecial   java/lang/StringBuilder.<init>:()V
        //   137: aload           4
        //   139: astore_3       
        //   140: aload           6
        //   142: ldc_w           "Exception serialization error, forced wrapping. Original: "
        //   145: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: pop            
        //   149: aload           4
        //   151: astore_3       
        //   152: aload           6
        //   154: aload_0        
        //   155: getfield        com/firebase/ui/auth/IdpResponse.mException:Lcom/firebase/ui/auth/FirebaseUiException;
        //   158: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   161: pop            
        //   162: aload           4
        //   164: astore_3       
        //   165: aload           6
        //   167: ldc_w           ", original cause: "
        //   170: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: pop            
        //   174: aload           4
        //   176: astore_3       
        //   177: aload           6
        //   179: aload_0        
        //   180: getfield        com/firebase/ui/auth/IdpResponse.mException:Lcom/firebase/ui/auth/FirebaseUiException;
        //   183: invokevirtual   java/lang/Exception.getCause:()Ljava/lang/Throwable;
        //   186: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   189: pop            
        //   190: aload           4
        //   192: astore_3       
        //   193: aload           5
        //   195: iconst_0       
        //   196: aload           6
        //   198: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   201: invokespecial   com/firebase/ui/auth/FirebaseUiException.<init>:(ILjava/lang/String;)V
        //   204: aload           4
        //   206: astore_3       
        //   207: aload           5
        //   209: aload_0        
        //   210: getfield        com/firebase/ui/auth/IdpResponse.mException:Lcom/firebase/ui/auth/FirebaseUiException;
        //   213: invokevirtual   java/lang/Exception.getStackTrace:()[Ljava/lang/StackTraceElement;
        //   216: invokevirtual   java/lang/Exception.setStackTrace:([Ljava/lang/StackTraceElement;)V
        //   219: aload           4
        //   221: astore_3       
        //   222: aload_1        
        //   223: aload           5
        //   225: invokevirtual   android/os/Parcel.writeSerializable:(Ljava/io/Serializable;)V
        //   228: aload           4
        //   230: ifnull          238
        //   233: aload           4
        //   235: invokevirtual   java/io/ObjectOutputStream.close:()V
        //   238: aload_1        
        //   239: aload_0        
        //   240: getfield        com/firebase/ui/auth/IdpResponse.mPendingCredential:Lcom/google/firebase/auth/AuthCredential;
        //   243: iconst_0       
        //   244: invokevirtual   android/os/Parcel.writeParcelable:(Landroid/os/Parcelable;I)V
        //   247: return         
        //   248: aload_3        
        //   249: ifnull          256
        //   252: aload_3        
        //   253: invokevirtual   java/io/ObjectOutputStream.close:()V
        //   256: aload_1        
        //   257: athrow         
        //   258: astore_3       
        //   259: aload           5
        //   261: astore          4
        //   263: goto            113
        //   266: astore_3       
        //   267: goto            238
        //   270: astore_3       
        //   271: goto            256
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  42     47     258    266    Ljava/io/IOException;
        //  42     47     109    113    Any
        //  50     55     258    266    Ljava/io/IOException;
        //  50     55     109    113    Any
        //  58     63     258    266    Ljava/io/IOException;
        //  58     63     109    113    Any
        //  66     73     258    266    Ljava/io/IOException;
        //  66     73     109    113    Any
        //  73     90     105    109    Ljava/io/IOException;
        //  73     90     98     105    Any
        //  90     95     266    270    Ljava/io/IOException;
        //  116    121    109    113    Any
        //  124    129    109    113    Any
        //  132    137    109    113    Any
        //  140    149    109    113    Any
        //  152    162    109    113    Any
        //  165    174    109    113    Any
        //  177    190    109    113    Any
        //  193    204    109    113    Any
        //  207    219    109    113    Any
        //  222    228    109    113    Any
        //  233    238    266    270    Ljava/io/IOException;
        //  252    256    270    274    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 139, Size: 139
        //     at java.util.ArrayList.rangeCheck(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static class Builder
    {
        private boolean mIsNewUser;
        private AuthCredential mPendingCredential;
        private String mSecret;
        private String mToken;
        private User mUser;
        
        public Builder() {
        }
        
        public Builder(final IdpResponse idpResponse) {
            this.mUser = IdpResponse.access$100(idpResponse);
            this.mToken = IdpResponse.access$200(idpResponse);
            this.mSecret = IdpResponse.access$300(idpResponse);
            this.mIsNewUser = IdpResponse.access$400(idpResponse);
            this.mPendingCredential = IdpResponse.access$500(idpResponse);
        }
        
        public Builder(final User mUser) {
            this.mUser = mUser;
        }
        
        public IdpResponse build() {
            if (this.mPendingCredential != null && this.mUser == null) {
                return new IdpResponse(this.mPendingCredential, new FirebaseUiException(5), null);
            }
            final String providerId = this.mUser.getProviderId();
            if (AuthUI.SOCIAL_PROVIDERS.contains(providerId) && TextUtils.isEmpty((CharSequence)this.mToken)) {
                throw new IllegalStateException("Token cannot be null when using a non-email provider.");
            }
            if (providerId.equals("twitter.com") && TextUtils.isEmpty((CharSequence)this.mSecret)) {
                throw new IllegalStateException("Secret cannot be null when using the Twitter provider.");
            }
            return new IdpResponse(this.mUser, this.mToken, this.mSecret, this.mPendingCredential, this.mIsNewUser, null);
        }
        
        public Builder setNewUser(final boolean mIsNewUser) {
            this.mIsNewUser = mIsNewUser;
            return this;
        }
        
        public Builder setPendingCredential(final AuthCredential mPendingCredential) {
            this.mPendingCredential = mPendingCredential;
            return this;
        }
        
        public Builder setSecret(final String mSecret) {
            this.mSecret = mSecret;
            return this;
        }
        
        public Builder setToken(final String mToken) {
            this.mToken = mToken;
            return this;
        }
    }
}
