// 
// Decompiled by Procyon v0.6.0
// 

package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import com.google.protobuf.GeneratedMessageLite;

public final class ClientSignalsProto
{
    private ClientSignalsProto() {
    }
    
    public static final class AppInstanceClaim extends GeneratedMessageLite<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder
    {
        public static final int APP_INSTANCE_ID_FIELD_NUMBER = 1;
        public static final int APP_INSTANCE_TOKEN_FIELD_NUMBER = 2;
        private static final AppInstanceClaim DEFAULT_INSTANCE;
        public static final int GMP_APP_ID_FIELD_NUMBER = 3;
        private static volatile Parser<AppInstanceClaim> PARSER;
        private String appInstanceId_;
        private String appInstanceToken_;
        private String gmpAppId_;
        
        static {
            GeneratedMessageLite.O((Class)AppInstanceClaim.class, (GeneratedMessageLite)(DEFAULT_INSTANCE = new AppInstanceClaim()));
        }
        
        private AppInstanceClaim() {
            this.appInstanceId_ = "";
            this.appInstanceToken_ = "";
            this.gmpAppId_ = "";
        }
        
        static AppInstanceClaim Q() {
            return AppInstanceClaim.DEFAULT_INSTANCE;
        }
        
        protected final Object x(final GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke, final Object o, final Object o2) {
            switch (ClientSignalsProto$a.a[((Enum)generatedMessageLite$MethodToInvoke).ordinal()]) {
                default: {
                    throw new UnsupportedOperationException();
                }
                case 7: {
                    return null;
                }
                case 6: {
                    return 1;
                }
                case 5: {
                    final Parser<AppInstanceClaim> parser;
                    if ((parser = AppInstanceClaim.PARSER) == null) {
                        synchronized (AppInstanceClaim.class) {
                            if (AppInstanceClaim.PARSER == null) {
                                AppInstanceClaim.PARSER = (Parser<AppInstanceClaim>)new GeneratedMessageLite$DefaultInstanceBasedParser((GeneratedMessageLite)AppInstanceClaim.DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return parser;
                }
                case 4: {
                    return AppInstanceClaim.DEFAULT_INSTANCE;
                }
                case 3: {
                    return GeneratedMessageLite.K((MessageLite)AppInstanceClaim.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0208\u0002\u0208\u0003\u0208", new Object[] { "appInstanceId_", "appInstanceToken_", "gmpAppId_" });
                }
                case 2: {
                    return new Builder(null);
                }
                case 1: {
                    return new AppInstanceClaim();
                }
            }
        }
        
        public static final class Builder extends GeneratedMessageLite$Builder<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder
        {
            private Builder() {
                super((GeneratedMessageLite)AppInstanceClaim.Q());
            }
            
            Builder(final ClientSignalsProto$a object) {
                this();
            }
        }
    }
    
    public interface AppInstanceClaimOrBuilder extends MessageLiteOrBuilder
    {
    }
    
    public static final class ClientSignals extends GeneratedMessageLite<ClientSignals, Builder> implements ClientSignalsOrBuilder
    {
        public static final int APP_VERSION_FIELD_NUMBER = 1;
        private static final ClientSignals DEFAULT_INSTANCE;
        public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
        private static volatile Parser<ClientSignals> PARSER;
        public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 4;
        private String appVersion_;
        private String languageCode_;
        private String platformVersion_;
        private String timeZone_;
        
        static {
            GeneratedMessageLite.O((Class)ClientSignals.class, (GeneratedMessageLite)(DEFAULT_INSTANCE = new ClientSignals()));
        }
        
        private ClientSignals() {
            this.appVersion_ = "";
            this.platformVersion_ = "";
            this.languageCode_ = "";
            this.timeZone_ = "";
        }
        
        static ClientSignals Q() {
            return ClientSignals.DEFAULT_INSTANCE;
        }
        
        static void R(final ClientSignals clientSignals, final String s) {
            clientSignals.W(s);
        }
        
        static void S(final ClientSignals clientSignals, final String s) {
            clientSignals.Z(s);
        }
        
        static void T(final ClientSignals clientSignals, final String s) {
            clientSignals.Y(s);
        }
        
        static void U(final ClientSignals clientSignals, final String s) {
            clientSignals.X(s);
        }
        
        public static Builder V() {
            return (Builder)ClientSignals.DEFAULT_INSTANCE.t();
        }
        
        private void W(final String appVersion_) {
            appVersion_.getClass();
            this.appVersion_ = appVersion_;
        }
        
        private void X(final String languageCode_) {
            languageCode_.getClass();
            this.languageCode_ = languageCode_;
        }
        
        private void Y(final String platformVersion_) {
            platformVersion_.getClass();
            this.platformVersion_ = platformVersion_;
        }
        
        private void Z(final String timeZone_) {
            timeZone_.getClass();
            this.timeZone_ = timeZone_;
        }
        
        protected final Object x(final GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke, final Object o, final Object o2) {
            switch (ClientSignalsProto$a.a[((Enum)generatedMessageLite$MethodToInvoke).ordinal()]) {
                default: {
                    throw new UnsupportedOperationException();
                }
                case 7: {
                    return null;
                }
                case 6: {
                    return 1;
                }
                case 5: {
                    final Parser<ClientSignals> parser;
                    if ((parser = ClientSignals.PARSER) == null) {
                        synchronized (ClientSignals.class) {
                            if (ClientSignals.PARSER == null) {
                                ClientSignals.PARSER = (Parser<ClientSignals>)new GeneratedMessageLite$DefaultInstanceBasedParser((GeneratedMessageLite)ClientSignals.DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return parser;
                }
                case 4: {
                    return ClientSignals.DEFAULT_INSTANCE;
                }
                case 3: {
                    return GeneratedMessageLite.K((MessageLite)ClientSignals.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0208\u0002\u0208\u0003\u0208\u0004\u0208", new Object[] { "appVersion_", "platformVersion_", "languageCode_", "timeZone_" });
                }
                case 2: {
                    return new Builder(null);
                }
                case 1: {
                    return new ClientSignals();
                }
            }
        }
        
        public static final class Builder extends GeneratedMessageLite$Builder<ClientSignals, Builder> implements ClientSignalsOrBuilder
        {
            private Builder() {
                super((GeneratedMessageLite)ClientSignals.Q());
            }
            
            Builder(final ClientSignalsProto$a object) {
                this();
            }
            
            public Builder L(final String s) {
                this.C();
                ClientSignals.R((ClientSignals)super.b, s);
                return this;
            }
            
            public Builder M(final String s) {
                this.C();
                ClientSignals.U((ClientSignals)super.b, s);
                return this;
            }
            
            public Builder N(final String s) {
                this.C();
                ClientSignals.T((ClientSignals)super.b, s);
                return this;
            }
            
            public Builder P(final String s) {
                this.C();
                ClientSignals.S((ClientSignals)super.b, s);
                return this;
            }
        }
    }
    
    public interface ClientSignalsOrBuilder extends MessageLiteOrBuilder
    {
    }
}
