/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mapstruct.ap.protobuf.test.source;

import java.util.List;

/**
 * Basic Map.
 *
 * @author CGD
 *
 */
public class BasicTestBeanList {

  List<String> testStrList;

  public List<String> getTestStrList() {
    return testStrList;
  }

  public void setTestStrList(List<String> testStrList) {
    this.testStrList = testStrList;
  }

}
