// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.ObjectStreamException;
import java.lang.reflect.Field;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType>
{
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap;
    protected int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;
    
    static {
        GeneratedMessageLite.defaultInstanceMap = new ConcurrentHashMap<Object, GeneratedMessageLite<?, ?>>();
    }
    
    public GeneratedMessageLite() {
        this.unknownFields = UnknownFieldSetLite.e();
        this.memoizedSerializedSize = -1;
    }
    
    protected static Object A(final MessageLite messageLite, final String s, final Object[] array) {
        return new h0(messageLite, s, array);
    }
    
    protected static <T extends GeneratedMessageLite<T, ?>> T B(final T t, final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return m((T)E((T)t, byteString, extensionRegistryLite));
    }
    
    protected static <T extends GeneratedMessageLite<T, ?>> T C(final T t, final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return m((T)F((T)t, CodedInputStream.f(inputStream), extensionRegistryLite));
    }
    
    protected static <T extends GeneratedMessageLite<T, ?>> T D(final T t, final byte[] array, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return m((T)G((T)t, array, 0, array.length, extensionRegistryLite));
    }
    
    private static <T extends GeneratedMessageLite<T, ?>> T E(T f, final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            final CodedInputStream codedInput = byteString.newCodedInput();
            f = F(f, codedInput, extensionRegistryLite);
            try {
                codedInput.a(0);
                return f;
            }
            catch (final InvalidProtocolBufferException ex) {
                throw ex.setUnfinishedMessage(f);
            }
        }
        catch (final InvalidProtocolBufferException ex2) {
            throw ex2;
        }
    }
    
    static <T extends GeneratedMessageLite<T, ?>> T F(T unfinishedMessage, final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        unfinishedMessage = (T)unfinishedMessage.o(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            final j0<T> e = f0.a().e(unfinishedMessage);
            e.i(unfinishedMessage, g.P(codedInputStream), extensionRegistryLite);
            e.b(unfinishedMessage);
            return unfinishedMessage;
        }
        catch (final RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
        catch (final IOException ex2) {
            if (ex2.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex2.getCause();
            }
            throw new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(unfinishedMessage);
        }
    }
    
    static <T extends GeneratedMessageLite<T, ?>> T G(T t, final byte[] array, final int n, final int n2, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        t = (T)t.o(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            final j0<T> e = f0.a().e(t);
            e.h(t, array, n, n + n2, new c.b(extensionRegistryLite));
            e.b(t);
            if (t.memoizedHashCode == 0) {
                return t;
            }
            throw new RuntimeException();
        }
        catch (final IndexOutOfBoundsException ex) {
            throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(t);
        }
        catch (final IOException ex2) {
            if (ex2.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex2.getCause();
            }
            throw new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(t);
        }
    }
    
    protected static <T extends GeneratedMessageLite<?, ?>> void H(final Class<T> clazz, final T t) {
        GeneratedMessageLite.defaultInstanceMap.put(clazz, t);
    }
    
    private static <T extends GeneratedMessageLite<T, ?>> T m(final T unfinishedMessage) throws InvalidProtocolBufferException {
        if (unfinishedMessage != null && !unfinishedMessage.isInitialized()) {
            throw unfinishedMessage.h().asInvalidProtocolBufferException().setUnfinishedMessage(unfinishedMessage);
        }
        return unfinishedMessage;
    }
    
    protected static <E> Internal.ProtobufList<E> r() {
        return (Internal.ProtobufList<E>)g0.e();
    }
    
    static <T extends GeneratedMessageLite<?, ?>> T t(final Class<T> clazz) {
        GeneratedMessageLite<?, ?> generatedMessageLite;
        if ((generatedMessageLite = GeneratedMessageLite.defaultInstanceMap.get(clazz)) == null) {
            try {
                Class.forName(clazz.getName(), true, clazz.getClassLoader());
                generatedMessageLite = GeneratedMessageLite.defaultInstanceMap.get(clazz);
            }
            catch (final ClassNotFoundException ex) {
                throw new IllegalStateException("Class initialization cannot fail.", ex);
            }
        }
        Object u;
        if ((u = generatedMessageLite) == null) {
            u = ((GeneratedMessageLite<GeneratedMessageLite<?, ?>, BuilderType>)q0.j(clazz)).u();
            if (u == null) {
                throw new IllegalStateException();
            }
            GeneratedMessageLite.defaultInstanceMap.put(clazz, (GeneratedMessageLite<?, ?>)u);
        }
        return (T)u;
    }
    
    static Object v(final Method method, final Object o, final Object... array) {
        try {
            return method.invoke(o, array);
        }
        catch (final InvocationTargetException ex) {
            final Throwable cause = ex.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException)cause;
            }
            if (cause instanceof Error) {
                throw (Error)cause;
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
        catch (final IllegalAccessException ex2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", ex2);
        }
    }
    
    protected static final <T extends GeneratedMessageLite<T, ?>> boolean w(final T t, final boolean b) {
        final byte byteValue = (byte)t.o(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED);
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        final boolean c = f0.a().e(t).c(t);
        if (b) {
            final MethodToInvoke set_MEMOIZED_IS_INITIALIZED = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
            GeneratedMessageLite<T, ?> generatedMessageLite;
            if (c) {
                generatedMessageLite = t;
            }
            else {
                generatedMessageLite = null;
            }
            t.p(set_MEMOIZED_IS_INITIALIZED, generatedMessageLite);
        }
        return c;
    }
    
    protected static <E> Internal.ProtobufList<E> y(final Internal.ProtobufList<E> list) {
        final int size = list.size();
        int n;
        if (size == 0) {
            n = 10;
        }
        else {
            n = size * 2;
        }
        return list.d(n);
    }
    
    public final BuilderType I() {
        final Builder builder = (Builder)this.o(MethodToInvoke.NEW_BUILDER);
        builder.z(this);
        return (BuilderType)builder;
    }
    
    @Override
    int a() {
        return this.memoizedSerializedSize;
    }
    
    @Override
    public /* bridge */ MessageLite d() {
        return this.u();
    }
    
    @Override
    public void e(final CodedOutputStream codedOutputStream) throws IOException {
        f0.a().e(this).j(this, h.P(codedOutputStream));
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (this.u().getClass().isInstance(o) && f0.a().e(this).g(this, (GeneratedMessageLite)o));
    }
    
    @Override
    public final Parser<MessageType> getParserForType() {
        return (Parser)this.o(MethodToInvoke.GET_PARSER);
    }
    
    @Override
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = f0.a().e(this).d(this);
        }
        return this.memoizedSerializedSize;
    }
    
    @Override
    public int hashCode() {
        final int memoizedHashCode = super.memoizedHashCode;
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        return super.memoizedHashCode = f0.a().e(this).f(this);
    }
    
    @Override
    void i(final int memoizedSerializedSize) {
        this.memoizedSerializedSize = memoizedSerializedSize;
    }
    
    @Override
    public final boolean isInitialized() {
        return w(this, true);
    }
    
    Object l() throws Exception {
        return this.o(MethodToInvoke.BUILD_MESSAGE_INFO);
    }
    
    protected final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType n() {
        return (BuilderType)this.o(MethodToInvoke.NEW_BUILDER);
    }
    
    @Override
    public /* bridge */ MessageLite.Builder newBuilderForType() {
        return this.z();
    }
    
    protected Object o(final MethodToInvoke methodToInvoke) {
        return this.q(methodToInvoke, null, null);
    }
    
    protected Object p(final MethodToInvoke methodToInvoke, final Object o) {
        return this.q(methodToInvoke, o, null);
    }
    
    protected abstract Object q(final MethodToInvoke p0, final Object p1, final Object p2);
    
    @Override
    public /* bridge */ MessageLite.Builder toBuilder() {
        return this.I();
    }
    
    @Override
    public String toString() {
        return y.e(this, super.toString());
    }
    
    public final MessageType u() {
        return (MessageType)this.o(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }
    
    protected void x() {
        f0.a().e(this).b(this);
    }
    
    public final BuilderType z() {
        return (BuilderType)this.o(MethodToInvoke.NEW_BUILDER);
    }
    
    public abstract static class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType>
    {
        private final MessageType a;
        protected MessageType b;
        protected boolean c;
        
        protected Builder(final MessageType a) {
            this.a = a;
            this.b = (MessageType)a.o(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            this.c = false;
        }
        
        private void C(final MessageType messageType, final MessageType messageType2) {
            f0.a().e(messageType).a(messageType, messageType2);
        }
        
        public BuilderType A(final byte[] array, final int n, final int n2) throws InvalidProtocolBufferException {
            return this.B(array, n, n2, ExtensionRegistryLite.b());
        }
        
        public BuilderType B(final byte[] array, final int n, final int n2, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.u();
            try {
                f0.a().e(this.b).h(this.b, array, n, n + n2, new c.b(extensionRegistryLite));
                return (BuilderType)this;
            }
            catch (final IOException ex) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", ex);
            }
            catch (final IndexOutOfBoundsException ex2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            catch (final InvalidProtocolBufferException ex3) {
                throw ex3;
            }
        }
        
        @Override
        public /* bridge */ MessageLite build() {
            return this.p();
        }
        
        public /* bridge */ Object clone() throws CloneNotSupportedException {
            return this.r();
        }
        
        @Override
        public /* bridge */ MessageLite d() {
            return this.w();
        }
        
        @Override
        public /* bridge */ AbstractMessageLite.Builder f() {
            return this.r();
        }
        
        @Override
        protected /* bridge */ AbstractMessageLite.Builder h(final AbstractMessageLite abstractMessageLite) {
            return this.x((MessageType)abstractMessageLite);
        }
        
        @Override
        public /* bridge */ AbstractMessageLite.Builder j(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return this.y(codedInputStream, extensionRegistryLite);
        }
        
        @Override
        public /* bridge */ MessageLite k() {
            return this.q();
        }
        
        @Override
        public /* bridge */ AbstractMessageLite.Builder n(final byte[] array, final int n, final int n2) throws InvalidProtocolBufferException {
            return this.A(array, n, n2);
        }
        
        public final MessageType p() {
            final GeneratedMessageLite<MessageType, BuilderType> q = (GeneratedMessageLite<MessageType, BuilderType>)this.q();
            if (q.isInitialized()) {
                return (MessageType)q;
            }
            throw AbstractMessageLite.Builder.o(q);
        }
        
        public MessageType q() {
            if (this.c) {
                return this.b;
            }
            this.b.x();
            this.c = true;
            return this.b;
        }
        
        public BuilderType r() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: invokevirtual   com/google/crypto/tink/shaded/protobuf/GeneratedMessageLite$Builder.w:()Lcom/google/crypto/tink/shaded/protobuf/GeneratedMessageLite;
            //     4: invokevirtual   com/google/crypto/tink/shaded/protobuf/GeneratedMessageLite.z:()Lcom/google/crypto/tink/shaded/protobuf/GeneratedMessageLite$Builder;
            //     7: astore_1       
            //     8: aload_1        
            //     9: aload_0        
            //    10: invokevirtual   com/google/crypto/tink/shaded/protobuf/GeneratedMessageLite$Builder.q:()Lcom/google/crypto/tink/shaded/protobuf/GeneratedMessageLite;
            //    13: invokevirtual   com/google/crypto/tink/shaded/protobuf/GeneratedMessageLite$Builder.z:(Lcom/google/crypto/tink/shaded/protobuf/GeneratedMessageLite;)Lcom/google/crypto/tink/shaded/protobuf/GeneratedMessageLite$Builder;
            //    16: pop            
            //    17: aload_1        
            //    18: areturn        
            //    Signature:
            //  ()TBuilderType;
            // 
            // The error that occurred was:
            // 
            // java.lang.UnsupportedOperationException: The requested operation is not supported.
            //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
            //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
            //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
            //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
            //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:211)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
            //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:211)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
            //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
            //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
            //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2689)
            //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
            //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
            //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
            //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
            //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
            //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
            //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
            //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
            //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
            //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1670)
            //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
            //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
            //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
            //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
            //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
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
        
        protected final void u() {
            if (this.c) {
                this.v();
                this.c = false;
            }
        }
        
        protected void v() {
            final GeneratedMessageLite b = (GeneratedMessageLite)this.b.o(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            this.C((MessageType)b, this.b);
            this.b = (MessageType)b;
        }
        
        public MessageType w() {
            return this.a;
        }
        
        protected BuilderType x(final MessageType messageType) {
            return this.z(messageType);
        }
        
        public BuilderType y(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            this.u();
            try {
                f0.a().e(this.b).i(this.b, g.P(codedInputStream), extensionRegistryLite);
                return (BuilderType)this;
            }
            catch (final RuntimeException ex) {
                if (ex.getCause() instanceof IOException) {
                    throw (IOException)ex.getCause();
                }
                throw ex;
            }
        }
        
        public BuilderType z(final MessageType messageType) {
            this.u();
            this.C(this.b, messageType);
            return (BuilderType)this;
        }
    }
    
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T>
    {
        private final T b;
        
        public DefaultInstanceBasedParser(final T b) {
            this.b = b;
        }
        
        @Override
        public /* bridge */ Object a(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.g(codedInputStream, extensionRegistryLite);
        }
        
        public T g(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.F(this.b, codedInputStream, extensionRegistryLite);
        }
    }
    
    public abstract static class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType>
    {
        public final MessageType D() {
            if (super.c) {
                return (MessageType)super.b;
            }
            ((ExtendableMessage)super.b).extensions.s();
            return super.q();
        }
        
        @Override
        public /* bridge */ MessageLite k() {
            return this.D();
        }
        
        @Override
        public /* bridge */ GeneratedMessageLite q() {
            return this.D();
        }
        
        @Override
        protected void v() {
            super.v();
            final ExtendableMessage<MessageType, BuilderType> b = (ExtendableMessage<MessageType, BuilderType>)super.b;
            b.extensions = b.extensions.b();
        }
    }
    
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder
    {
    }
    
    public abstract static class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType>
    {
        protected FieldSet<a> extensions;
        
        public ExtendableMessage() {
            this.extensions = FieldSet.h();
        }
        
        FieldSet<a> J() {
            if (this.extensions.n()) {
                this.extensions = this.extensions.b();
            }
            return this.extensions;
        }
        
        protected class ExtensionWriter
        {
        }
    }
    
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type>
    {
        final MessageLite a;
        final a b;
        
        public WireFormat.FieldType a() {
            return this.b.b();
        }
        
        public MessageLite b() {
            return this.a;
        }
        
        public int c() {
            return this.b.getNumber();
        }
        
        public boolean d() {
            return this.b.d;
        }
    }
    
    public enum MethodToInvoke
    {
        private static final MethodToInvoke[] $VALUES;
        
        BUILD_MESSAGE_INFO, 
        GET_DEFAULT_INSTANCE, 
        GET_MEMOIZED_IS_INITIALIZED, 
        GET_PARSER, 
        NEW_BUILDER, 
        NEW_MUTABLE_INSTANCE, 
        SET_MEMOIZED_IS_INITIALIZED;
    }
    
    protected static final class SerializedForm implements Serializable
    {
        private static final long serialVersionUID = 0L;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;
        
        SerializedForm(final MessageLite messageLite) {
            final Class<? extends MessageLite> class1 = messageLite.getClass();
            this.messageClass = class1;
            this.messageClassName = class1.getName();
            this.asBytes = messageLite.c();
        }
        
        @Deprecated
        private Object a() throws ObjectStreamException {
            try {
                final Field declaredField = this.b().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite)declaredField.get(null)).newBuilderForType().s(this.asBytes).k();
            }
            catch (final InvalidProtocolBufferException ex) {
                throw new RuntimeException("Unable to understand proto buffer", ex);
            }
            catch (final IllegalAccessException ex2) {
                throw new RuntimeException("Unable to call parsePartialFrom", ex2);
            }
            catch (final SecurityException ex3) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to call defaultInstance in ");
                sb.append(this.messageClassName);
                throw new RuntimeException(sb.toString(), ex3);
            }
            catch (final NoSuchFieldException ex4) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to find defaultInstance in ");
                sb2.append(this.messageClassName);
                throw new RuntimeException(sb2.toString(), ex4);
            }
            catch (final ClassNotFoundException ex5) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to find proto buffer class: ");
                sb3.append(this.messageClassName);
                throw new RuntimeException(sb3.toString(), ex5);
            }
        }
        
        private Class<?> b() throws ClassNotFoundException {
            Class<?> clazz = this.messageClass;
            if (clazz == null) {
                clazz = Class.forName(this.messageClassName);
            }
            return clazz;
        }
        
        public static SerializedForm of(final MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }
        
        protected Object readResolve() throws ObjectStreamException {
            try {
                final Field declaredField = this.b().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite)declaredField.get(null)).newBuilderForType().s(this.asBytes).k();
            }
            catch (final InvalidProtocolBufferException ex) {
                throw new RuntimeException("Unable to understand proto buffer", ex);
            }
            catch (final IllegalAccessException ex2) {
                throw new RuntimeException("Unable to call parsePartialFrom", ex2);
            }
            catch (final SecurityException ex3) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to call DEFAULT_INSTANCE in ");
                sb.append(this.messageClassName);
                throw new RuntimeException(sb.toString(), ex3);
            }
            catch (final NoSuchFieldException ex4) {
                return this.a();
            }
            catch (final ClassNotFoundException ex5) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to find proto buffer class: ");
                sb2.append(this.messageClassName);
                throw new RuntimeException(sb2.toString(), ex5);
            }
        }
    }
    
    static final class a implements FieldDescriptorLite<a>
    {
        final Internal.EnumLiteMap<?> a;
        final int b;
        final WireFormat.FieldType c;
        final boolean d;
        final boolean e;
        
        @Override
        public MessageLite.Builder D(final MessageLite.Builder builder, final MessageLite messageLite) {
            return ((Builder)builder).z((GeneratedMessageLite)messageLite);
        }
        
        public int a(final a a) {
            return this.b - a.b;
        }
        
        @Override
        public WireFormat.FieldType b() {
            return this.c;
        }
        
        public Internal.EnumLiteMap<?> c() {
            return this.a;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((a)o);
        }
        
        @Override
        public WireFormat.JavaType e() {
            return this.c.getJavaType();
        }
        
        @Override
        public int getNumber() {
            return this.b;
        }
        
        @Override
        public boolean isPacked() {
            return this.e;
        }
        
        @Override
        public boolean isRepeated() {
            return this.d;
        }
    }
}
