/*
 * Copyright 2019 IBM Corporation
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
package com.ibm.cos;

import java.io.InputStream;

import com.ibm.cloud.objectstorage.AmazonServiceException;
import com.ibm.cloud.objectstorage.SdkClientException;
import com.ibm.cloud.objectstorage.services.s3.AmazonS3;
import com.ibm.cloud.objectstorage.services.s3.model.ObjectMetadata;
import com.ibm.cloud.objectstorage.services.s3.model.PutObjectResult;

public class BucketImpl implements Bucket {

    private final AmazonS3 s3;
    private final String name;

    public BucketImpl(final AmazonS3 s3, final String name) {
        this.s3 = s3;
        this.name = name;
    }

    @Override
    public PutObjectResult putObject(String key, InputStream input, ObjectMetadata metadata)
            throws SdkClientException, AmazonServiceException {
        return s3.putObject(name, key, input, metadata);
    }

}

