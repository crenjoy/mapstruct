/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mapstruct.ap.protobuf.test.map;

import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.ProtocolStringList;

import java.util.List;

import org.mapstruct.MappingTarget;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageList;
import org.mapstruct.ap.protobuf.test.source.BasicTestBeanList;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface ProtoListMapper {

  ProtoListMapper INSTANCE = Mappers.getMapper( ProtoListMapper.class );

  BasicTestMessageList toList(BasicTestBeanList beanList);

  /**
   * List Update Proto List Message.
   */
  default BasicTestMessageList updateList(BasicTestMessageList msgList,
      BasicTestBeanList beanList) {
    BasicTestMessageList.Builder builder = msgList.toBuilder();
    updateList( builder, beanList );
    return builder.build();
  }

  void updateList(@MappingTarget BasicTestMessageList.Builder msgList, BasicTestBeanList beanList);
  
  /** ProtocolStringList is List String SubClass. */
  default List<String> toListString(ProtocolStringList value) {
    return (List<String>) value;
  }
  
  /** List String To ProtocolStringList. */
  default ProtocolStringList toListString(List<String> value) {
    ProtocolStringList protoList = new LazyStringArrayList();
    protoList.addAll(value);
    return protoList;
  }
  
}
