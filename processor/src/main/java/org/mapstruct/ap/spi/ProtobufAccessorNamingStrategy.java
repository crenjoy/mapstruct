/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.spi;

import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import org.mapstruct.util.Experimental;

/**
 * @author Thomas Kratz
 * @author Filip Hrisafov
 */
@Experimental("The Protobuf accessor naming strategy might change in a subsequent release")
public class ProtobufAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    public static final String PROTOBUF_MESSAGE_OR_BUILDER = "com.google.protobuf.MessageOrBuilder";
    public static final String LIST_SUFFIX = "List";
    public static final String MAP_SUFFIX = "Map";
    protected TypeMirror protobufType;

    @Override
    public void init(MapStructProcessingEnvironment processingEnvironment) {
        super.init( processingEnvironment );
        TypeElement typeElement = elementUtils.getTypeElement( PROTOBUF_MESSAGE_OR_BUILDER );
        if (typeElement != null) {
            protobufType = typeElement.asType();
        }
    }

    @Override
    public boolean isGetterMethod(ExecutableElement method) {
        boolean getterMethod =  super.isGetterMethod( method );
        if (!isProtoBufMethod( method )) {
          return getterMethod;
        }
        String methodName = method.getSimpleName().toString();
        String returnTypeName = typeUtils.erasure( method.getReturnType() ).toString();
        if (getterMethod && isProtoBufMethod( method ) && !methodName.endsWith( "List" )
            && returnTypeName.equals( List.class.getName() )) {
            return false;
        }
        if (getterMethod && isProtoBufMethod( method ) && !methodName.endsWith( "Map" )
            && returnTypeName.equals( Map.class.getName() )) {
            return false;
        }
        return getterMethod;
    }

    @Override
    public String getPropertyName(ExecutableElement getterOrSetterMethod) {
        String propertyName = super.getPropertyName( getterOrSetterMethod );
        if (!isProtoBufMethod( getterOrSetterMethod )) {
          return propertyName;
        }

        String returnTypeName = typeUtils.erasure( getterOrSetterMethod.getReturnType() ).toString();
        if (isProtoBufMethod( getterOrSetterMethod ) && propertyName.endsWith( "List" )
            && returnTypeName.equals( List.class.getName() )) {
            propertyName = propertyName.substring( 0, propertyName.length() - 4 );
            return propertyName;
        }
        if (isProtoBufMethod( getterOrSetterMethod ) && propertyName.endsWith( "Map" )
            && returnTypeName.equals( Map.class.getName() )) {
            propertyName = propertyName.substring( 0, propertyName.length() - 3 );
            return propertyName;
        }
        return propertyName;
    }

    /**
     * is protobuf method?
     * @param method
     * @return
     */
    protected boolean isProtoBufMethod(ExecutableElement method) {
        Element receiver = method.getEnclosingElement();
        if (receiver != null && protobufType != null && typeUtils.isAssignable( receiver.asType(), protobufType )) {
            return true;
        }
        return false;
    }

}
