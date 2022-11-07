/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mapstruct.ap.protobuf.test.source;

import java.util.Map;

/**
 * Basic Map.
 *
 * @author CGD
 *
 */
public class BasicTestBeanMap {

  Map<String, String> testStrMap;

  public Map<String, String> getTestStrMap() {
    return testStrMap;
  }

  public void setTestStrMap(Map<String, String> testStrMap) {
    this.testStrMap = testStrMap;
  }

}
