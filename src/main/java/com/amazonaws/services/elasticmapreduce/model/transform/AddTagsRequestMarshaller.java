/*
 * Copyright 2010-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.elasticmapreduce.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.elasticmapreduce.model.AddTagsRequest;
import com.amazonaws.services.elasticmapreduce.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Add Tags Request Marshaller
 */
public class AddTagsRequestMarshaller implements Marshaller<Request<AddTagsRequest>, AddTagsRequest> {

    public Request<AddTagsRequest> marshall(AddTagsRequest addTagsRequest) {
        if (addTagsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<AddTagsRequest> request = new DefaultRequest<AddTagsRequest>(addTagsRequest, "AmazonElasticMapReduce");
        String target = "ElasticMapReduce.AddTags";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (addTagsRequest.getResourceId() != null) {
                jsonWriter.key("ResourceId").value(addTagsRequest.getResourceId());
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Tag> tagsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Tag>)(addTagsRequest.getTags());
            if (tagsList != null && !(tagsList.isAutoConstruct() && tagsList.isEmpty())) {

                jsonWriter.key("Tags");
                jsonWriter.array();

                for (Tag tagsListValue : tagsList) {
                    if (tagsListValue != null) {
                        jsonWriter.object();
                        if (tagsListValue.getKey() != null) {
                            jsonWriter.key("Key").value(tagsListValue.getKey());
                        }
                        if (tagsListValue.getValue() != null) {
                            jsonWriter.key("Value").value(tagsListValue.getValue());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
