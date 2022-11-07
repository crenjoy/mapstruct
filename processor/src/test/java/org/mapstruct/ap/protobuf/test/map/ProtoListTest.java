/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mapstruct.ap.protobuf.test.map;

import org.junit.jupiter.api.Assertions;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageList;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageListOrBuilder;
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
    BasicTestMessageProto.class, BasicTestMessageListOrBuilder.class, BasicTestMessageList.class,
    ProtoListMapper.class })
@WithServiceImplementation(provides = AccessorNamingStrategy.class, value = ProtobufAccessorNamingStrategy.class)
public class ProtoListTest {

  @ProcessorTest
  public void testToList() {
    BasicTestBeanList source = BeanMapListBuilder.getListFull();
    BasicTestMessageList actual = ProtoListMapper.INSTANCE.toList( source );
    Assertions.assertEquals( ProtoMapListBuilder.getListFull().getTestStrListList(),
        actual.getTestStrListList() );
  }

  @ProcessorTest
  public void testUpdateList() {
    BasicTestBeanList source = BeanMapListBuilder.getListFull();
    BasicTestMessageList actual = ProtoMapListBuilder.getListNull();
    actual = ProtoListMapper.INSTANCE.updateList( actual, source );
    Assertions.assertEquals( ProtoMapListBuilder.getListFull().getTestStrListList(),
        actual.getTestStrListList() );
  }

}
