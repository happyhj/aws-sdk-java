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
package com.amazonaws.services.opsworks.model.transform;

import static com.amazonaws.stringutil.StringUtils.COMMA_SEPARATOR;
import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.codec.BinaryUtils;
import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.method.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.opsworks.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Update Layer Request Marshaller
 */
public class UpdateLayerRequestMarshaller implements Marshaller<Request<UpdateLayerRequest>, UpdateLayerRequest> {

    public Request<UpdateLayerRequest> marshall(UpdateLayerRequest updateLayerRequest) {
        if (updateLayerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateLayerRequest> request = new DefaultRequest<UpdateLayerRequest>(updateLayerRequest, "AWSOpsWorks");
        String target = "OpsWorks_20130218.UpdateLayer";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (updateLayerRequest.getLayerId() != null) {
                jsonWriter.key("LayerId").value(updateLayerRequest.getLayerId());
            }
            if (updateLayerRequest.getName() != null) {
                jsonWriter.key("Name").value(updateLayerRequest.getName());
            }
            if (updateLayerRequest.getShortname() != null) {
                jsonWriter.key("Shortname").value(updateLayerRequest.getShortname());
            }
            if (updateLayerRequest.getAttributes() != null) {
                jsonWriter.key("Attributes");
                jsonWriter.object();
                for (Map.Entry<String, String> attributesListValue : updateLayerRequest.getAttributes().entrySet()) {
                    if (attributesListValue.getValue() != null) {
                        jsonWriter.key(attributesListValue.getKey());

                        jsonWriter.value(attributesListValue.getValue());
                    }
                }
                jsonWriter.endObject();
            }
            if (updateLayerRequest.getCustomInstanceProfileArn() != null) {
                jsonWriter.key("CustomInstanceProfileArn").value(updateLayerRequest.getCustomInstanceProfileArn());
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<String> customSecurityGroupIdsList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(updateLayerRequest.getCustomSecurityGroupIds());
            if (customSecurityGroupIdsList != null && !(customSecurityGroupIdsList.isAutoConstruct() && customSecurityGroupIdsList.isEmpty())) {

                jsonWriter.key("CustomSecurityGroupIds");
                jsonWriter.array();

                for (String customSecurityGroupIdsListValue : customSecurityGroupIdsList) {
                    if (customSecurityGroupIdsListValue != null) {
                        jsonWriter.value(customSecurityGroupIdsListValue);
                    }
                }
                jsonWriter.endArray();
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<String> packagesList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(updateLayerRequest.getPackages());
            if (packagesList != null && !(packagesList.isAutoConstruct() && packagesList.isEmpty())) {

                jsonWriter.key("Packages");
                jsonWriter.array();

                for (String packagesListValue : packagesList) {
                    if (packagesListValue != null) {
                        jsonWriter.value(packagesListValue);
                    }
                }
                jsonWriter.endArray();
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<VolumeConfiguration> volumeConfigurationsList = (com.amazonaws.internal.ListWithAutoConstructFlag<VolumeConfiguration>)(updateLayerRequest.getVolumeConfigurations());
            if (volumeConfigurationsList != null && !(volumeConfigurationsList.isAutoConstruct() && volumeConfigurationsList.isEmpty())) {

                jsonWriter.key("VolumeConfigurations");
                jsonWriter.array();

                for (VolumeConfiguration volumeConfigurationsListValue : volumeConfigurationsList) {
                    if (volumeConfigurationsListValue != null) {
                        jsonWriter.object();
                        if (volumeConfigurationsListValue.getMountPoint() != null) {
                            jsonWriter.key("MountPoint").value(volumeConfigurationsListValue.getMountPoint());
                        }
                        if (volumeConfigurationsListValue.getRaidLevel() != null) {
                            jsonWriter.key("RaidLevel").value(volumeConfigurationsListValue.getRaidLevel());
                        }
                        if (volumeConfigurationsListValue.getNumberOfDisks() != null) {
                            jsonWriter.key("NumberOfDisks").value(volumeConfigurationsListValue.getNumberOfDisks());
                        }
                        if (volumeConfigurationsListValue.getSize() != null) {
                            jsonWriter.key("Size").value(volumeConfigurationsListValue.getSize());
                        }
                        if (volumeConfigurationsListValue.getVolumeType() != null) {
                            jsonWriter.key("VolumeType").value(volumeConfigurationsListValue.getVolumeType());
                        }
                        if (volumeConfigurationsListValue.getIops() != null) {
                            jsonWriter.key("Iops").value(volumeConfigurationsListValue.getIops());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            if (updateLayerRequest.isEnableAutoHealing() != null) {
                jsonWriter.key("EnableAutoHealing").value(updateLayerRequest.isEnableAutoHealing());
            }
            if (updateLayerRequest.isAutoAssignElasticIps() != null) {
                jsonWriter.key("AutoAssignElasticIps").value(updateLayerRequest.isAutoAssignElasticIps());
            }
            if (updateLayerRequest.isAutoAssignPublicIps() != null) {
                jsonWriter.key("AutoAssignPublicIps").value(updateLayerRequest.isAutoAssignPublicIps());
            }
            Recipes customRecipes = updateLayerRequest.getCustomRecipes();
            if (customRecipes != null) {

                jsonWriter.key("CustomRecipes");
                jsonWriter.object();

                com.amazonaws.internal.ListWithAutoConstructFlag<String> setupList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(customRecipes.getSetup());
                if (setupList != null && !(setupList.isAutoConstruct() && setupList.isEmpty())) {

                    jsonWriter.key("Setup");
                    jsonWriter.array();

                    for (String setupListValue : setupList) {
                        if (setupListValue != null) {
                            jsonWriter.value(setupListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                com.amazonaws.internal.ListWithAutoConstructFlag<String> configureList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(customRecipes.getConfigure());
                if (configureList != null && !(configureList.isAutoConstruct() && configureList.isEmpty())) {

                    jsonWriter.key("Configure");
                    jsonWriter.array();

                    for (String configureListValue : configureList) {
                        if (configureListValue != null) {
                            jsonWriter.value(configureListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                com.amazonaws.internal.ListWithAutoConstructFlag<String> deployList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(customRecipes.getDeploy());
                if (deployList != null && !(deployList.isAutoConstruct() && deployList.isEmpty())) {

                    jsonWriter.key("Deploy");
                    jsonWriter.array();

                    for (String deployListValue : deployList) {
                        if (deployListValue != null) {
                            jsonWriter.value(deployListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                com.amazonaws.internal.ListWithAutoConstructFlag<String> undeployList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(customRecipes.getUndeploy());
                if (undeployList != null && !(undeployList.isAutoConstruct() && undeployList.isEmpty())) {

                    jsonWriter.key("Undeploy");
                    jsonWriter.array();

                    for (String undeployListValue : undeployList) {
                        if (undeployListValue != null) {
                            jsonWriter.value(undeployListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                com.amazonaws.internal.ListWithAutoConstructFlag<String> shutdownList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(customRecipes.getShutdown());
                if (shutdownList != null && !(shutdownList.isAutoConstruct() && shutdownList.isEmpty())) {

                    jsonWriter.key("Shutdown");
                    jsonWriter.array();

                    for (String shutdownListValue : shutdownList) {
                        if (shutdownListValue != null) {
                            jsonWriter.value(shutdownListValue);
                        }
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
            }
            if (updateLayerRequest.isInstallUpdatesOnBoot() != null) {
                jsonWriter.key("InstallUpdatesOnBoot").value(updateLayerRequest.isInstallUpdatesOnBoot());
            }
            if (updateLayerRequest.isUseEbsOptimizedInstances() != null) {
                jsonWriter.key("UseEbsOptimizedInstances").value(updateLayerRequest.isUseEbsOptimizedInstances());
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
