<#--

    Copyright MapStruct Authors.

    Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0

-->
<#-- @ftlvariable name="" type="org.mapstruct.ap.internal.model.assignment.GetterWrapperForCollectionsAndMaps" -->
<#import "../macro/CommonMacros.ftl" as lib>
<@lib.sourceLocalVarAssignment/>
if ( ${ext.targetBeanName}.${ext.targetWriteAccessorName}<@lib.handleWriteAccesing /> != null ) {
    <@lib.handleExceptions>
      <#if ext.existingInstanceMapping>
        <#if "${ext.targetWriteAccessorName}" == "get${ext.targetPropertyName?cap_first}Map" || "${ext.targetWriteAccessorName}" == "get${ext.targetPropertyName?cap_first}List" >
        ${ext.targetBeanName}.clear${ext.targetPropertyName?cap_first}();
        <#else>
        ${ext.targetBeanName}.${ext.targetWriteAccessorName}<@lib.handleWriteAccesing />.clear();
        </#if>
      </#if>
      <@lib.handleLocalVarNullCheck needs_explicit_local_var=false>
        <#if "${ext.targetWriteAccessorName}" == "get${ext.targetPropertyName?cap_first}Map" || "${ext.targetWriteAccessorName}" == "get${ext.targetPropertyName?cap_first}List" >
        ${ext.targetBeanName}.<#if ext.targetType.collectionType>addAll${ext.targetPropertyName?cap_first}<#else>putAll${ext.targetPropertyName?cap_first}</#if>( <@lib.handleWithAssignmentOrNullCheckVar/> );
        <#else>
        ${ext.targetBeanName}.${ext.targetWriteAccessorName}<@lib.handleWriteAccesing />.<#if ext.targetType.collectionType>addAll<#else>putAll</#if>( <@lib.handleWithAssignmentOrNullCheckVar/> );
        </#if>
      </@lib.handleLocalVarNullCheck>
    </@lib.handleExceptions>
}
