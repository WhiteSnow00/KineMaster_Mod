// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.annotations.Encodable$Field;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.DataEncoder;
import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;

@Encodable
@AutoValue
public abstract class BatchedLogRequest
{
    public static BatchedLogRequest a(final List<LogRequest> list) {
        return new b(list);
    }
    
    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().j(AutoBatchedLogRequestEncoder.a).k(true).i();
    }
    
    @Encodable$Field
    public abstract List<LogRequest> c();
}
