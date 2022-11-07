/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mapstruct.ap.protobuf.test.map;

import org.junit.jupiter.api.Assertions;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageMap;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageMapOrBuilder;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageProto;
import org.mapstruct.ap.protobuf.test._target.ProtoMapListBuilder;
import org.mapstruct.ap.protobuf.test.source.BasicTestBeanList;
import org.mapstruct.ap.protobuf.test.source.BasicTestBeanMap;
import org.mapstruct.ap.protobuf.test.source.BeanMapListBuilder;
import org.mapstruct.ap.spi.AccessorNamingStrategy;
import org.mapstruct.ap.spi.ProtobufAccessorNamingStrategy;
import org.mapstruct.ap.testutil.ProcessorTest;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.WithServiceImplementation;

@WithClasses({ BasicTestBeanMap.class, BasicTestBeanList.class, BeanMapListBuilder.class,
    BasicTestMessageProto.class, BasicTestMessageMapOrBuilder.class, BasicTestMessageMap.class,
    ProtoMapMapper.class })
@WithServiceImplementation(provides = AccessorNamingStrategy.class, value = ProtobufAccessorNamingStrategy.class)
public class ProtoMapTest {

  @ProcessorTest
  public void testToMap() {
    BasicTestBeanMap source = BeanMapListBuilder.getMapFull();
    BasicTestMessageMap actual = ProtoMapMapper.INSTANCE.toMap( source );
    Assertions.assertEquals( ProtoMapListBuilder.getMapFull().getTestStrMapMap(),
        actual.getTestStrMapMap() );
  }

  @ProcessorTest
  public void testUpdateMap() {
    BasicTestBeanMap source = BeanMapListBuilder.getMapFull();
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapNull();
    actual = ProtoMapMapper.INSTANCE.updateMap( actual, source );
    Assertions.assertEquals( ProtoMapListBuilder.getMapFull().getTestStrMapMap(),
        actual.getTestStrMapMap() );
  }

}
