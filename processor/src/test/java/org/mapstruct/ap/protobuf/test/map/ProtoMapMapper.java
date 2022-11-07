
package org.mapstruct.ap.protobuf.test.map;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageMap;
import org.mapstruct.ap.protobuf.test.source.BasicTestBeanMap;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProtoMapMapper {

  ProtoMapMapper INSTANCE = Mappers.getMapper(ProtoMapMapper.class);

  BasicTestMessageMap toMap(BasicTestBeanMap beanMap);

  /**
   * Map Update Proto Map Message.
   */
  default BasicTestMessageMap updateMap(BasicTestMessageMap msgMap, BasicTestBeanMap beanMap) {
    BasicTestMessageMap.Builder builder = msgMap.toBuilder();
    updateMap(builder, beanMap);
    return builder.build();
  }

  void updateMap(@MappingTarget BasicTestMessageMap.Builder msgMap, BasicTestBeanMap beanMap);
}
