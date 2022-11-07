
package org.mapstruct.ap.protobuf.test.map;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageMap;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageMapOrBuilder;
import org.mapstruct.ap.protobuf.test._target.BasicTestMessageProto;
import org.mapstruct.ap.protobuf.test.source.BasicTestBeanList;
import org.mapstruct.ap.protobuf.test.source.BasicTestBeanMap;
import org.mapstruct.ap.protobuf.test.source.BeanMapListBuilder;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.ProcessorTest;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.GeneratedSource;

@WithClasses({ BasicTestBeanMap.class, BasicTestBeanList.class, BeanMapListBuilder.class,
     BasicTestMessageProto.class, BasicTestMessageMapOrBuilder.class,BasicTestMessageMap.class,
    ProtoMapMapper.class })
@IssueKey("108")
public class ProtoMapTest {

  @RegisterExtension
  final GeneratedSource generatedSource = new GeneratedSource()
      .addComparisonToFixtureFor(ProtoMapMapper.class);

  @ProcessorTest
  public void test() {
    // com.google.protobuf.ByteString
    BasicTestBeanMap source = BeanMapListBuilder.getMapFull();
    BasicTestMessageMap dto = ProtoMapMapper.INSTANCE.toMap(source);
  }

}
