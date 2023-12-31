/*
 * Copyright 2021 IBM Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.eventstreams.connect.cossink.partitionwriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.ibm.eventstreams.connect.cossink.COSSinkConnectorConfig;


/**
 * This is a superclass for other tests that performs common
 * preparatory tasks.
 * 
 * If you don't need this stuff you don't have to subclass it
 * in the actual test classes
 */
public abstract class AbstractTest {
  static final String schemaDir = "src/test/resources/schemas";
  static final String schemaFile = "01.FHIRCoding.json";
  
  public Map<String,String> testConfigMap() {
    Map<String,String> map = new HashMap<String,String>();
    map.put(COSSinkConnectorConfig.CONFIG_NAME_COS_API_KEY, "bogus");
    map.put(COSSinkConnectorConfig.CONFIG_NAME_COS_SERVICE_CRN, "bogus");
    map.put(COSSinkConnectorConfig.CONFIG_NAME_COS_BUCKET_LOCATION, "us-east");
    map.put(COSSinkConnectorConfig.CONFIG_NAME_COS_BUCKET_NAME, "bogus");
    map.put(COSSinkConnectorConfig.CONFIG_NAME_COS_BUCKET_RESILIENCY, COSSinkConnectorConfig.CONFIG_VALUE_COS_BUCKET_RESILIENCY_REGIONAL);
    Path absPath = FileSystems.getDefault()
    .getPath(schemaDir)
    .normalize()
    .toAbsolutePath();
    map.put(
      COSSinkConnectorConfig.CONFIG_NAME_COS_WRITER_SCHEMA_URI, 
      Paths.get(absPath.toString(), schemaFile).toUri().toString()
    );
    return map;    
  } 
}
