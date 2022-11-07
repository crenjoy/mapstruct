/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mapstruct.ap.protobuf.test._target;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bean Map List Builder.
 *
 * @author CGD
 *
 */
public class ProtoMapListBuilder {

  protected ProtoMapListBuilder() {
    throw new UnsupportedOperationException();
  }

  /** Null Map . */
  public static BasicTestMessageMap getMapNull() {
    return BasicTestMessageMap.newBuilder().build();
  }

  /** Empty Map . */
  public static BasicTestMessageMap getMapEmpty() {
    return BasicTestMessageMap.newBuilder().putAllTestStrMap( Collections.emptyMap() ).build();
  }

  /** Full Map . */
  public static BasicTestMessageMap getMapFull() {
    Map<String, String> maps = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put( "a", "a----a" );
        put( "b", "b----b" );
        put( "c", "c----c" );
      }
    };
    BasicTestMessageMap map = BasicTestMessageMap.newBuilder().putAllTestStrMap( maps ).build();
    return map;
  }

  /** Default Map . */
  public static BasicTestMessageMap getMapDefault() {
    Map<String, String> maps = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put( "a", "a----a" );
        put( "b", "b----b" );
        put( "c", "c----c" );
        put( "d", "" );
        put( "", "IS NULL" );
      }
    };
    BasicTestMessageMap map = BasicTestMessageMap.newBuilder().putAllTestStrMap( maps ).build();
    return map;
  }

  public static BasicTestMessageList getListNull() {
    return BasicTestMessageList.newBuilder().build();
  }

  public static BasicTestMessageList getListEmpty() {
    return BasicTestMessageList.newBuilder().addAllTestStrList( Collections.emptyList() ).build();
  }

  public static BasicTestMessageList getListFull() {
    List<String> list = Arrays.asList( "a", "b", "c" );
    return BasicTestMessageList.newBuilder().addAllTestStrList( list ).build();
  }

  public static BasicTestMessageList getListDefault() {
    List<String> list = Arrays.asList( "a", "b", "c", "" );
    return BasicTestMessageList.newBuilder().addAllTestStrList( list ).build();
  }
}
