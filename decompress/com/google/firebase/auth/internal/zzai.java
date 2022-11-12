// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.List;
import java.util.Arrays;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;

public final class zzai
{
    public static Status a(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return new Status(17499);
        }
        final String[] split = s.split(":", 2);
        split[0] = split[0].trim();
        if (split.length > 1) {
            final String s2 = split[1];
            if (s2 != null) {
                split[1] = s2.trim();
            }
        }
        final List<String> list = Arrays.asList(split);
        if (list.size() > 1) {
            return b(list.get(0), list.get(1));
        }
        return b(list.get(0), null);
    }
    
    private static Status b(final String s, final String s2) {
        int n = 0;
        Label_1602: {
            switch (s.hashCode()) {
                case 2082564316: {
                    if (s.equals("UNSUPPORTED_TENANT_OPERATION")) {
                        n = 49;
                        break Label_1602;
                    }
                    break;
                }
                case 2063209097: {
                    if (s.equals("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                        n = 63;
                        break Label_1602;
                    }
                    break;
                }
                case 1898790704: {
                    if (s.equals("MISSING_SESSION_INFO")) {
                        n = 35;
                        break Label_1602;
                    }
                    break;
                }
                case 1803454477: {
                    if (s.equals("MISSING_CONTINUE_URI")) {
                        n = 44;
                        break Label_1602;
                    }
                    break;
                }
                case 1497901284: {
                    if (s.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                        n = 21;
                        break Label_1602;
                    }
                    break;
                }
                case 1494923453: {
                    if (s.equals("INVALID_APP_CREDENTIAL")) {
                        n = 19;
                        break Label_1602;
                    }
                    break;
                }
                case 1442968770: {
                    if (s.equals("INVALID_PHONE_NUMBER")) {
                        n = 32;
                        break Label_1602;
                    }
                    break;
                }
                case 1433767024: {
                    if (s.equals("USER_DISABLED")) {
                        n = 5;
                        break Label_1602;
                    }
                    break;
                }
                case 1388786705: {
                    if (s.equals("INVALID_IDENTIFIER")) {
                        n = 6;
                        break Label_1602;
                    }
                    break;
                }
                case 1226505451: {
                    if (s.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                        n = 12;
                        break Label_1602;
                    }
                    break;
                }
                case 1199811910: {
                    if (s.equals("MISSING_CODE")) {
                        n = 33;
                        break Label_1602;
                    }
                    break;
                }
                case 1141576252: {
                    if (s.equals("SESSION_EXPIRED")) {
                        n = 38;
                        break Label_1602;
                    }
                    break;
                }
                case 1107081238: {
                    if (s.equals("<<Network Error>>")) {
                        n = 15;
                        break Label_1602;
                    }
                    break;
                }
                case 1094975491: {
                    if (s.equals("INVALID_PASSWORD")) {
                        n = 11;
                        break Label_1602;
                    }
                    break;
                }
                case 1072360691: {
                    if (s.equals("INVALID_CUSTOM_TOKEN")) {
                        n = 2;
                        break Label_1602;
                    }
                    break;
                }
                case 1034932393: {
                    if (s.equals("INVALID_PENDING_TOKEN")) {
                        n = 3;
                        break Label_1602;
                    }
                    break;
                }
                case 989000548: {
                    if (s.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                        n = 22;
                        break Label_1602;
                    }
                    break;
                }
                case 922685102: {
                    if (s.equals("INVALID_MESSAGE_PAYLOAD")) {
                        n = 26;
                        break Label_1602;
                    }
                    break;
                }
                case 895302372: {
                    if (s.equals("MISSING_CLIENT_IDENTIFIER")) {
                        n = 65;
                        break Label_1602;
                    }
                    break;
                }
                case 886186878: {
                    if (s.equals("REQUIRES_SECOND_FACTOR_AUTH")) {
                        n = 53;
                        break Label_1602;
                    }
                    break;
                }
                case 844240628: {
                    if (s.equals("WEB_CONTEXT_CANCELED")) {
                        n = 48;
                        break Label_1602;
                    }
                    break;
                }
                case 819646646: {
                    if (s.equals("CREDENTIAL_MISMATCH")) {
                        n = 1;
                        break Label_1602;
                    }
                    break;
                }
                case 799258561: {
                    if (s.equals("INVALID_PROVIDER_ID")) {
                        n = 46;
                        break Label_1602;
                    }
                    break;
                }
                case 786916712: {
                    if (s.equals("INVALID_VERIFICATION_PROOF")) {
                        n = 37;
                        break Label_1602;
                    }
                    break;
                }
                case 745638750: {
                    if (s.equals("INVALID_MFA_PENDING_CREDENTIAL")) {
                        n = 56;
                        break Label_1602;
                    }
                    break;
                }
                case 605031096: {
                    if (s.equals("REJECTED_CREDENTIAL")) {
                        n = 52;
                        break Label_1602;
                    }
                    break;
                }
                case 582457886: {
                    if (s.equals("UNVERIFIED_EMAIL")) {
                        n = 59;
                        break Label_1602;
                    }
                    break;
                }
                case 542728406: {
                    if (s.equals("PASSWORD_LOGIN_DISABLED")) {
                        n = 18;
                        break Label_1602;
                    }
                    break;
                }
                case 492072102: {
                    if (s.equals("WEB_STORAGE_UNSUPPORTED")) {
                        n = 43;
                        break Label_1602;
                    }
                    break;
                }
                case 491979549: {
                    if (s.equals("INVALID_ID_TOKEN")) {
                        n = 13;
                        break Label_1602;
                    }
                    break;
                }
                case 483847807: {
                    if (s.equals("EMAIL_EXISTS")) {
                        n = 10;
                        break Label_1602;
                    }
                    break;
                }
                case 429251986: {
                    if (s.equals("UNSUPPORTED_PASSTHROUGH_OPERATION")) {
                        n = 68;
                        break Label_1602;
                    }
                    break;
                }
                case 423563023: {
                    if (s.equals("MISSING_MFA_PENDING_CREDENTIAL")) {
                        n = 54;
                        break Label_1602;
                    }
                    break;
                }
                case 408411681: {
                    if (s.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                        n = 51;
                        break Label_1602;
                    }
                    break;
                }
                case 278802867: {
                    if (s.equals("MISSING_PHONE_NUMBER")) {
                        n = 31;
                        break Label_1602;
                    }
                    break;
                }
                case 269327773: {
                    if (s.equals("INVALID_SENDER")) {
                        n = 27;
                        break Label_1602;
                    }
                    break;
                }
                case 210308040: {
                    if (s.equals("UNSUPPORTED_FIRST_FACTOR")) {
                        n = 62;
                        break Label_1602;
                    }
                    break;
                }
                case 15352275: {
                    if (s.equals("EMAIL_NOT_FOUND")) {
                        n = 8;
                        break Label_1602;
                    }
                    break;
                }
                case -40686718: {
                    if (s.equals("WEAK_PASSWORD")) {
                        n = 16;
                        break Label_1602;
                    }
                    break;
                }
                case -75433118: {
                    if (s.equals("USER_NOT_FOUND")) {
                        n = 9;
                        break Label_1602;
                    }
                    break;
                }
                case -122667194: {
                    if (s.equals("MISSING_MFA_ENROLLMENT_ID")) {
                        n = 55;
                        break Label_1602;
                    }
                    break;
                }
                case -217128228: {
                    if (s.equals("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                        n = 61;
                        break Label_1602;
                    }
                    break;
                }
                case -294485423: {
                    if (s.equals("WEB_INTERNAL_ERROR")) {
                        n = 42;
                        break Label_1602;
                    }
                    break;
                }
                case -333672188: {
                    if (s.equals("OPERATION_NOT_ALLOWED")) {
                        n = 17;
                        break Label_1602;
                    }
                    break;
                }
                case -595928767: {
                    if (s.equals("TIMEOUT")) {
                        n = 14;
                        break Label_1602;
                    }
                    break;
                }
                case -646022241: {
                    if (s.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                        n = 20;
                        break Label_1602;
                    }
                    break;
                }
                case -736207500: {
                    if (s.equals("MISSING_PASSWORD")) {
                        n = 30;
                        break Label_1602;
                    }
                    break;
                }
                case -749743758: {
                    if (s.equals("MFA_ENROLLMENT_NOT_FOUND")) {
                        n = 57;
                        break Label_1602;
                    }
                    break;
                }
                case -828507413: {
                    if (s.equals("NO_SUCH_PROVIDER")) {
                        n = 0;
                        break Label_1602;
                    }
                    break;
                }
                case -863830559: {
                    if (s.equals("INVALID_CERT_HASH")) {
                        n = 40;
                        break Label_1602;
                    }
                    break;
                }
                case -974503964: {
                    if (s.equals("MISSING_OR_INVALID_NONCE")) {
                        n = 66;
                        break Label_1602;
                    }
                    break;
                }
                case -1063710844: {
                    if (s.equals("ADMIN_ONLY_OPERATION")) {
                        n = 58;
                        break Label_1602;
                    }
                    break;
                }
                case -1112393964: {
                    if (s.equals("INVALID_EMAIL")) {
                        n = 7;
                        break Label_1602;
                    }
                    break;
                }
                case -1202691903: {
                    if (s.equals("SECOND_FACTOR_EXISTS")) {
                        n = 60;
                        break Label_1602;
                    }
                    break;
                }
                case -1232010689: {
                    if (s.equals("INVALID_SESSION_INFO")) {
                        n = 36;
                        break Label_1602;
                    }
                    break;
                }
                case -1340100504: {
                    if (s.equals("INVALID_TENANT_ID")) {
                        n = 50;
                        break Label_1602;
                    }
                    break;
                }
                case -1345867105: {
                    if (s.equals("TOKEN_EXPIRED")) {
                        n = 23;
                        break Label_1602;
                    }
                    break;
                }
                case -1421414571: {
                    if (s.equals("INVALID_CODE")) {
                        n = 34;
                        break Label_1602;
                    }
                    break;
                }
                case -1458751677: {
                    if (s.equals("MISSING_EMAIL")) {
                        n = 29;
                        break Label_1602;
                    }
                    break;
                }
                case -1583894766: {
                    if (s.equals("INVALID_OOB_CODE")) {
                        n = 24;
                        break Label_1602;
                    }
                    break;
                }
                case -1587614300: {
                    if (s.equals("EXPIRED_OOB_CODE")) {
                        n = 25;
                        break Label_1602;
                    }
                    break;
                }
                case -1774756919: {
                    if (s.equals("WEB_NETWORK_REQUEST_FAILED")) {
                        n = 41;
                        break Label_1602;
                    }
                    break;
                }
                case -1800638118: {
                    if (s.equals("QUOTA_EXCEEDED")) {
                        n = 39;
                        break Label_1602;
                    }
                    break;
                }
                case -1944433728: {
                    if (s.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                        n = 45;
                        break Label_1602;
                    }
                    break;
                }
                case -2001169389: {
                    if (s.equals("INVALID_IDP_RESPONSE")) {
                        n = 4;
                        break Label_1602;
                    }
                    break;
                }
                case -2005236790: {
                    if (s.equals("INTERNAL_SUCCESS_SIGN_OUT")) {
                        n = 64;
                        break Label_1602;
                    }
                    break;
                }
                case -2014808264: {
                    if (s.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                        n = 47;
                        break Label_1602;
                    }
                    break;
                }
                case -2065866930: {
                    if (s.equals("INVALID_RECIPIENT_EMAIL")) {
                        n = 28;
                        break Label_1602;
                    }
                    break;
                }
                case -2130504259: {
                    if (s.equals("USER_CANCELLED")) {
                        n = 67;
                        break Label_1602;
                    }
                    break;
                }
            }
            n = -1;
        }
        int n2 = 0;
        switch (n) {
            default: {
                n2 = 17499;
                break;
            }
            case 68: {
                n2 = 17095;
                break;
            }
            case 67: {
                n2 = 18001;
                break;
            }
            case 66: {
                n2 = 17094;
                break;
            }
            case 65: {
                n2 = 17093;
                break;
            }
            case 64: {
                n2 = 17091;
                break;
            }
            case 63: {
                n2 = 17090;
                break;
            }
            case 62: {
                n2 = 17089;
                break;
            }
            case 61: {
                n2 = 17088;
                break;
            }
            case 60: {
                n2 = 17087;
                break;
            }
            case 59: {
                n2 = 17086;
                break;
            }
            case 58: {
                n2 = 17085;
                break;
            }
            case 57: {
                n2 = 17084;
                break;
            }
            case 56: {
                n2 = 17083;
                break;
            }
            case 55: {
                n2 = 17082;
                break;
            }
            case 54: {
                n2 = 17081;
                break;
            }
            case 53: {
                n2 = 17078;
                break;
            }
            case 52: {
                n2 = 17075;
                break;
            }
            case 51: {
                n2 = 17074;
                break;
            }
            case 50: {
                n2 = 17079;
                break;
            }
            case 49: {
                n2 = 17073;
                break;
            }
            case 48: {
                n2 = 17058;
                break;
            }
            case 47: {
                n2 = 17057;
                break;
            }
            case 46: {
                n2 = 17071;
                break;
            }
            case 45: {
                n2 = 17068;
                break;
            }
            case 44: {
                n2 = 17040;
                break;
            }
            case 43: {
                n2 = 17065;
                break;
            }
            case 42: {
                n2 = 17062;
                break;
            }
            case 41: {
                n2 = 17061;
                break;
            }
            case 40: {
                n2 = 17064;
                break;
            }
            case 39: {
                n2 = 17052;
                break;
            }
            case 38: {
                n2 = 17051;
                break;
            }
            case 37: {
                n2 = 17049;
                break;
            }
            case 36: {
                n2 = 17046;
                break;
            }
            case 35: {
                n2 = 17045;
                break;
            }
            case 34: {
                n2 = 17044;
                break;
            }
            case 33: {
                n2 = 17043;
                break;
            }
            case 32: {
                n2 = 17042;
                break;
            }
            case 31: {
                n2 = 17041;
                break;
            }
            case 30: {
                n2 = 17035;
                break;
            }
            case 29: {
                n2 = 17034;
                break;
            }
            case 28: {
                n2 = 17033;
                break;
            }
            case 27: {
                n2 = 17032;
                break;
            }
            case 26: {
                n2 = 17031;
                break;
            }
            case 25: {
                n2 = 17029;
                break;
            }
            case 24: {
                n2 = 17030;
                break;
            }
            case 23: {
                n2 = 17021;
                break;
            }
            case 21:
            case 22: {
                n2 = 17010;
                break;
            }
            case 20: {
                n2 = 17014;
                break;
            }
            case 19: {
                n2 = 17028;
                break;
            }
            case 17:
            case 18: {
                n2 = 17006;
                break;
            }
            case 16: {
                n2 = 17026;
                break;
            }
            case 14:
            case 15: {
                n2 = 17020;
                break;
            }
            case 13: {
                n2 = 17017;
                break;
            }
            case 12: {
                n2 = 17025;
                break;
            }
            case 11: {
                n2 = 17009;
                break;
            }
            case 10: {
                n2 = 17007;
                break;
            }
            case 8:
            case 9: {
                n2 = 17011;
                break;
            }
            case 6:
            case 7: {
                n2 = 17008;
                break;
            }
            case 5: {
                n2 = 17005;
                break;
            }
            case 3:
            case 4: {
                n2 = 17004;
                break;
            }
            case 2: {
                n2 = 17000;
                break;
            }
            case 1: {
                n2 = 17002;
                break;
            }
            case 0: {
                n2 = 17016;
                break;
            }
        }
        if (n2 != 17499) {
            return new Status(n2, s2);
        }
        if (s2 != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(":");
            sb.append(s2);
            return new Status(17499, sb.toString());
        }
        return new Status(17499, s);
    }
}
