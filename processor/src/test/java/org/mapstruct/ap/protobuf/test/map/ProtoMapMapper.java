
package org.mapstruct.ap.protobuf.test.map;

import org.mapstruct.Mapper;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageMap;
import org.mapstruct.ap.protobuf.test.source.BasicTestBeanMap;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProtoMapMapper {

  ProtoMapMapper INSTANCE = Mappers.getMapper(ProtoMapMapper.class);

  BasicTestMessageMap toMap(BasicTestBeanMap beanMap);
}
