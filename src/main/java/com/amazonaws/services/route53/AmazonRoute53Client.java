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
package com.amazonaws.services.route53;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.w3c.dom.Node;

import com.amazonaws.authprovider.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.ClientConfiguration;
import com.amazonaws.client.handler.request.HandlerChainFactory;
import com.amazonaws.client.handler.response.DefaultErrorResponseHandler;
import com.amazonaws.client.handler.response.StaxResponseHandler;
import com.amazonaws.client.service.AmazonWebServiceClient;
import com.amazonaws.client.service.ExecutionContext;
import com.amazonaws.credential.AWSCredentials;
import com.amazonaws.credential.AWSCredentialsProvider;
import com.amazonaws.credential.StaticCredentialsProvider;
import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.exception.AmazonServiceException;
import com.amazonaws.network.ResponseMetadata;
import com.amazonaws.network.metrics.util.AWSRequestMetrics;
import com.amazonaws.network.metrics.util.AWSRequestMetrics.Field;
import com.amazonaws.network.metricscollector.RequestMetricCollector;
import com.amazonaws.network.request.AmazonWebServiceRequest;
import com.amazonaws.network.response.Response;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.route53.model.ChangeResourceRecordSetsRequest;
import com.amazonaws.services.route53.model.ChangeResourceRecordSetsResult;
import com.amazonaws.services.route53.model.ChangeTagsForResourceRequest;
import com.amazonaws.services.route53.model.ChangeTagsForResourceResult;
import com.amazonaws.services.route53.model.CreateHealthCheckRequest;
import com.amazonaws.services.route53.model.CreateHealthCheckResult;
import com.amazonaws.services.route53.model.CreateHostedZoneRequest;
import com.amazonaws.services.route53.model.CreateHostedZoneResult;
import com.amazonaws.services.route53.model.DelegationSetNotAvailableException;
import com.amazonaws.services.route53.model.DeleteHealthCheckRequest;
import com.amazonaws.services.route53.model.DeleteHealthCheckResult;
import com.amazonaws.services.route53.model.DeleteHostedZoneRequest;
import com.amazonaws.services.route53.model.DeleteHostedZoneResult;
import com.amazonaws.services.route53.model.GetChangeRequest;
import com.amazonaws.services.route53.model.GetChangeResult;
import com.amazonaws.services.route53.model.GetCheckerIpRangesRequest;
import com.amazonaws.services.route53.model.GetCheckerIpRangesResult;
import com.amazonaws.services.route53.model.GetGeoLocationRequest;
import com.amazonaws.services.route53.model.GetGeoLocationResult;
import com.amazonaws.services.route53.model.GetHealthCheckCountRequest;
import com.amazonaws.services.route53.model.GetHealthCheckCountResult;
import com.amazonaws.services.route53.model.GetHealthCheckRequest;
import com.amazonaws.services.route53.model.GetHealthCheckResult;
import com.amazonaws.services.route53.model.GetHostedZoneRequest;
import com.amazonaws.services.route53.model.GetHostedZoneResult;
import com.amazonaws.services.route53.model.HealthCheckAlreadyExistsException;
import com.amazonaws.services.route53.model.HealthCheckInUseException;
import com.amazonaws.services.route53.model.HealthCheckVersionMismatchException;
import com.amazonaws.services.route53.model.HostedZoneAlreadyExistsException;
import com.amazonaws.services.route53.model.HostedZoneNotEmptyException;
import com.amazonaws.services.route53.model.IncompatibleVersionException;
import com.amazonaws.services.route53.model.InvalidChangeBatchException;
import com.amazonaws.services.route53.model.InvalidDomainNameException;
import com.amazonaws.services.route53.model.InvalidInputException;
import com.amazonaws.services.route53.model.ListGeoLocationsRequest;
import com.amazonaws.services.route53.model.ListGeoLocationsResult;
import com.amazonaws.services.route53.model.ListHealthChecksRequest;
import com.amazonaws.services.route53.model.ListHealthChecksResult;
import com.amazonaws.services.route53.model.ListHostedZonesRequest;
import com.amazonaws.services.route53.model.ListHostedZonesResult;
import com.amazonaws.services.route53.model.ListResourceRecordSetsRequest;
import com.amazonaws.services.route53.model.ListResourceRecordSetsResult;
import com.amazonaws.services.route53.model.ListTagsForResourceRequest;
import com.amazonaws.services.route53.model.ListTagsForResourceResult;
import com.amazonaws.services.route53.model.ListTagsForResourcesRequest;
import com.amazonaws.services.route53.model.ListTagsForResourcesResult;
import com.amazonaws.services.route53.model.NoSuchChangeException;
import com.amazonaws.services.route53.model.NoSuchGeoLocationException;
import com.amazonaws.services.route53.model.NoSuchHealthCheckException;
import com.amazonaws.services.route53.model.NoSuchHostedZoneException;
import com.amazonaws.services.route53.model.PriorRequestNotCompleteException;
import com.amazonaws.services.route53.model.ThrottlingException;
import com.amazonaws.services.route53.model.TooManyHealthChecksException;
import com.amazonaws.services.route53.model.TooManyHostedZonesException;
import com.amazonaws.services.route53.model.UpdateHealthCheckRequest;
import com.amazonaws.services.route53.model.UpdateHealthCheckResult;
import com.amazonaws.services.route53.model.transform.ChangeResourceRecordSetsRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ChangeResourceRecordSetsResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.ChangeTagsForResourceRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ChangeTagsForResourceResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.CreateHealthCheckRequestMarshaller;
import com.amazonaws.services.route53.model.transform.CreateHealthCheckResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.CreateHostedZoneRequestMarshaller;
import com.amazonaws.services.route53.model.transform.CreateHostedZoneResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.DelegationSetNotAvailableExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.DeleteHealthCheckRequestMarshaller;
import com.amazonaws.services.route53.model.transform.DeleteHealthCheckResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.DeleteHostedZoneRequestMarshaller;
import com.amazonaws.services.route53.model.transform.DeleteHostedZoneResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.GetChangeRequestMarshaller;
import com.amazonaws.services.route53.model.transform.GetChangeResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.GetCheckerIpRangesRequestMarshaller;
import com.amazonaws.services.route53.model.transform.GetCheckerIpRangesResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.GetGeoLocationRequestMarshaller;
import com.amazonaws.services.route53.model.transform.GetGeoLocationResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.GetHealthCheckCountRequestMarshaller;
import com.amazonaws.services.route53.model.transform.GetHealthCheckCountResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.GetHealthCheckRequestMarshaller;
import com.amazonaws.services.route53.model.transform.GetHealthCheckResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.GetHostedZoneRequestMarshaller;
import com.amazonaws.services.route53.model.transform.GetHostedZoneResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.HealthCheckAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.HealthCheckInUseExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.HealthCheckVersionMismatchExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.HostedZoneAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.HostedZoneNotEmptyExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.IncompatibleVersionExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.InvalidChangeBatchExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.InvalidDomainNameExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.InvalidInputExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.ListGeoLocationsRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ListGeoLocationsResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.ListHealthChecksRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ListHealthChecksResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.ListHostedZonesRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ListHostedZonesResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.ListResourceRecordSetsRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ListResourceRecordSetsResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.ListTagsForResourceRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ListTagsForResourceResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.ListTagsForResourcesRequestMarshaller;
import com.amazonaws.services.route53.model.transform.ListTagsForResourcesResultStaxUnmarshaller;
import com.amazonaws.services.route53.model.transform.NoSuchChangeExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.NoSuchGeoLocationExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.NoSuchHealthCheckExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.NoSuchHostedZoneExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.PriorRequestNotCompleteExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.ThrottlingExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.TooManyHealthChecksExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.TooManyHostedZonesExceptionUnmarshaller;
import com.amazonaws.services.route53.model.transform.UpdateHealthCheckRequestMarshaller;
import com.amazonaws.services.route53.model.transform.UpdateHealthCheckResultStaxUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Client for accessing AmazonRoute53.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * 
 */
public class AmazonRoute53Client extends AmazonWebServiceClient implements AmazonRoute53 {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonRoute53 exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonRoute53Client() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonRoute53Client(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonRoute53Client(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonRoute53Client(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonRoute53Client(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonRoute53Client(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonRoute53 using the specified AWS account credentials
     * provider, client configuration options, and request metric collector.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonRoute53
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AmazonRoute53Client(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new NoSuchChangeExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyHealthChecksExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HealthCheckAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ThrottlingExceptionUnmarshaller());
        exceptionUnmarshallers.add(new PriorRequestNotCompleteExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HealthCheckInUseExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidInputExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidChangeBatchExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchHostedZoneExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchGeoLocationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HealthCheckVersionMismatchExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HostedZoneAlreadyExistsExceptionUnmarshaller());
        exceptionUnmarshallers.add(new TooManyHostedZonesExceptionUnmarshaller());
        exceptionUnmarshallers.add(new HostedZoneNotEmptyExceptionUnmarshaller());
        exceptionUnmarshallers.add(new IncompatibleVersionExceptionUnmarshaller());
        exceptionUnmarshallers.add(new NoSuchHealthCheckExceptionUnmarshaller());
        exceptionUnmarshallers.add(new DelegationSetNotAvailableExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidDomainNameExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("route53.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/route53/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/route53/request.handler2s"));
    }

    /**
     * <p>
     * To retrieve the delegation set for a hosted zone, send a
     * <code>GET</code> request to the <code>2013-04-01/hostedzone/hosted
     * zone ID </code> resource. The delegation set is the four Route 53 name
     * servers that were assigned to the hosted zone when you created it.
     * </p>
     *
     * @param getHostedZoneRequest Container for the necessary parameters to
     *           execute the GetHostedZone service method on AmazonRoute53.
     * 
     * @return The response from the GetHostedZone service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHostedZoneResult getHostedZone(GetHostedZoneRequest getHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(getHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHostedZoneRequest> request = null;
        Response<GetHostedZoneResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHostedZoneRequestMarshaller().marshall(getHostedZoneRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new GetHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action returns the current status of a change batch request. The
     * status is one of the following values:
     * </p>
     * <p>
     * - <code>PENDING</code> indicates that the changes in this request
     * have not replicated to all Route 53 DNS servers. This is the initial
     * status of all change batch requests.
     * </p>
     * <p>
     * - <code>INSYNC</code> indicates that the changes have replicated to
     * all Amazon Route 53 DNS servers.
     * </p>
     *
     * @param getChangeRequest Container for the necessary parameters to
     *           execute the GetChange service method on AmazonRoute53.
     * 
     * @return The response from the GetChange service method, as returned by
     *         AmazonRoute53.
     * 
     * @throws NoSuchChangeException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetChangeResult getChange(GetChangeRequest getChangeRequest) {
        ExecutionContext executionContext = createExecutionContext(getChangeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetChangeRequest> request = null;
        Response<GetChangeResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetChangeRequestMarshaller().marshall(getChangeRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new GetChangeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of your hosted zones, send a <code>GET</code>
     * request to the <code>2013-04-01/hostedzone</code> resource. The
     * response to this request includes a <code>HostedZones</code> element
     * with zero, one, or multiple <code>HostedZone</code> child elements. By
     * default, the list of hosted zones is displayed on a single page. You
     * can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the hosted zone that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     *
     * @param listHostedZonesRequest Container for the necessary parameters
     *           to execute the ListHostedZones service method on AmazonRoute53.
     * 
     * @return The response from the ListHostedZones service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHostedZonesResult listHostedZones(ListHostedZonesRequest listHostedZonesRequest) {
        ExecutionContext executionContext = createExecutionContext(listHostedZonesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListHostedZonesRequest> request = null;
        Response<ListHostedZonesResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListHostedZonesRequestMarshaller().marshall(listHostedZonesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ListHostedZonesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action updates an existing health check.
     * </p>
     * <p>
     * To update a health check, send a <code>POST</code> request to the
     * <code>2013-05-27/healthcheck/health check ID </code> resource. The
     * request body must include an XML document with an
     * <code>UpdateHealthCheckRequest</code> element. The response returns an
     * <code>UpdateHealthCheckResponse</code> element, which contains
     * metadata about the health check.
     * </p>
     *
     * @param updateHealthCheckRequest Container for the necessary parameters
     *           to execute the UpdateHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the UpdateHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws HealthCheckVersionMismatchException
     * @throws NoSuchHealthCheckException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateHealthCheckResult updateHealthCheck(UpdateHealthCheckRequest updateHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(updateHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateHealthCheckRequest> request = null;
        Response<UpdateHealthCheckResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateHealthCheckRequestMarshaller().marshall(updateHealthCheckRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new UpdateHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a single geo location, send a <code>GET</code> request to
     * the <code>2013-04-01/geolocation</code> resource with one of these
     * options: continentcode | countrycode | countrycode and
     * subdivisioncode.
     * </p>
     *
     * @param getGeoLocationRequest Container for the necessary parameters to
     *           execute the GetGeoLocation service method on AmazonRoute53.
     * 
     * @return The response from the GetGeoLocation service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchGeoLocationException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetGeoLocationResult getGeoLocation(GetGeoLocationRequest getGeoLocationRequest) {
        ExecutionContext executionContext = createExecutionContext(getGeoLocationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetGeoLocationRequest> request = null;
        Response<GetGeoLocationResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetGeoLocationRequestMarshaller().marshall(getGeoLocationRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new GetGeoLocationResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param listTagsForResourcesRequest Container for the necessary
     *           parameters to execute the ListTagsForResources service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTagsForResources service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws ThrottlingException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTagsForResourcesResult listTagsForResources(ListTagsForResourcesRequest listTagsForResourcesRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsForResourcesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsForResourcesRequest> request = null;
        Response<ListTagsForResourcesResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsForResourcesRequestMarshaller().marshall(listTagsForResourcesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ListTagsForResourcesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action deletes a health check. To delete a health check, send a
     * <code>DELETE</code> request to the <code>2013-04-01/healthcheck/health
     * check ID </code> resource.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You can delete a health check only if there are no
     * resource record sets associated with this health check. If resource
     * record sets are associated with this health check, you must
     * disassociate them before you can delete your health check. If you try
     * to delete a health check that is associated with resource record sets,
     * Route 53 will deny your request with a HealthCheckInUse error. For
     * information about disassociating the records from your health check,
     * see ChangeResourceRecordSets.
     * </p>
     *
     * @param deleteHealthCheckRequest Container for the necessary parameters
     *           to execute the DeleteHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the DeleteHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchHealthCheckException
     * @throws HealthCheckInUseException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteHealthCheckResult deleteHealthCheck(DeleteHealthCheckRequest deleteHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteHealthCheckRequest> request = null;
        Response<DeleteHealthCheckResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteHealthCheckRequestMarshaller().marshall(deleteHealthCheckRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new DeleteHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Imagine all the resource record sets in a zone listed out in front of
     * you. Imagine them sorted lexicographically first by DNS name (with the
     * labels reversed, like "com.amazon.www" for example), and secondarily,
     * lexicographically by record type. This operation retrieves at most
     * MaxItems resource record sets from this list, in order, starting at a
     * position specified by the Name and Type arguments:
     * </p>
     * 
     * <ul>
     * <li>If both Name and Type are omitted, this means start the results
     * at the first RRSET in the HostedZone.</li>
     * <li>If Name is specified but Type is omitted, this means start the
     * results at the first RRSET in the list whose name is greater than or
     * equal to Name. </li>
     * <li>If both Name and Type are specified, this means start the results
     * at the first RRSET in the list whose name is greater than or equal to
     * Name and whose type is greater than or equal to Type.</li>
     * <li>It is an error to specify the Type but not the Name.</li>
     * 
     * </ul>
     * <p>
     * Use ListResourceRecordSets to retrieve a single known record set by
     * specifying the record set's name and type, and setting MaxItems = 1
     * </p>
     * <p>
     * To retrieve all the records in a HostedZone, first pause any
     * processes making calls to ChangeResourceRecordSets. Initially call
     * ListResourceRecordSets without a Name and Type to get the first page
     * of record sets. For subsequent calls, set Name and Type to the
     * NextName and NextType values returned by the previous response.
     * </p>
     * <p>
     * In the presence of concurrent ChangeResourceRecordSets calls, there
     * is no consistency of results across calls to ListResourceRecordSets.
     * The only way to get a consistent multi-page snapshot of all RRSETs in
     * a zone is to stop making changes while pagination is in progress.
     * </p>
     * <p>
     * However, the results from ListResourceRecordSets are consistent
     * within a page. If MakeChange calls are taking place concurrently, the
     * result of each one will either be completely visible in your results
     * or not at all. You will not see partial changes, or changes that do
     * not ultimately succeed. (This follows from the fact that MakeChange is
     * atomic)
     * </p>
     * <p>
     * The results from ListResourceRecordSets are strongly consistent with
     * ChangeResourceRecordSets. To be precise, if a single process makes a
     * call to ChangeResourceRecordSets and receives a successful response,
     * the effects of that change will be visible in a subsequent call to
     * ListResourceRecordSets by that process.
     * </p>
     *
     * @param listResourceRecordSetsRequest Container for the necessary
     *           parameters to execute the ListResourceRecordSets service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListResourceRecordSets service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListResourceRecordSetsResult listResourceRecordSets(ListResourceRecordSetsRequest listResourceRecordSetsRequest) {
        ExecutionContext executionContext = createExecutionContext(listResourceRecordSetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListResourceRecordSetsRequest> request = null;
        Response<ListResourceRecordSetsResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListResourceRecordSetsRequestMarshaller().marshall(listResourceRecordSetsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ListResourceRecordSetsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve the health check, send a <code>GET</code> request to the
     * <code>2013-04-01/healthcheck/health check ID </code> resource.
     * </p>
     *
     * @param getHealthCheckRequest Container for the necessary parameters to
     *           execute the GetHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the GetHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchHealthCheckException
     * @throws IncompatibleVersionException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckResult getHealthCheck(GetHealthCheckRequest getHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(getHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHealthCheckRequest> request = null;
        Response<GetHealthCheckResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHealthCheckRequestMarshaller().marshall(getHealthCheckRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new GetHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action deletes a hosted zone. To delete a hosted zone, send a
     * <code>DELETE</code> request to the <code>2013-04-01/hostedzone/hosted
     * zone ID </code> resource.
     * </p>
     * <p>
     * For more information about deleting a hosted zone, see
     * <a href="http://docs.aws.amazon.com/Route53/latest/DeveloperGuide/DeleteHostedZone.html"> Deleting a Hosted Zone </a>
     * in the <i>Amazon Route 53 Developer Guide</i> .
     * </p>
     * <p>
     * <b>IMPORTANT:</b> You can delete a hosted zone only if there are no
     * resource record sets other than the default SOA record and NS resource
     * record sets. If your hosted zone contains other resource record sets,
     * you must delete them before you can delete your hosted zone. If you
     * try to delete a hosted zone that contains other resource record sets,
     * Route 53 will deny your request with a HostedZoneNotEmpty error. For
     * information about deleting records from your hosted zone, see
     * ChangeResourceRecordSets.
     * </p>
     *
     * @param deleteHostedZoneRequest Container for the necessary parameters
     *           to execute the DeleteHostedZone service method on AmazonRoute53.
     * 
     * @return The response from the DeleteHostedZone service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws HostedZoneNotEmptyException
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteHostedZoneResult deleteHostedZone(DeleteHostedZoneRequest deleteHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteHostedZoneRequest> request = null;
        Response<DeleteHostedZoneResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteHostedZoneRequestMarshaller().marshall(deleteHostedZoneRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new DeleteHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of the IP ranges used by Amazon Route 53 health
     * checkers to check the health of your resources, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/checkeripranges</code> resource. You can use these IP
     * addresses to configure router and firewall rules to allow health
     * checkers to check the health of your resources.
     * </p>
     *
     * @param getCheckerIpRangesRequest Container for the necessary
     *           parameters to execute the GetCheckerIpRanges service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetCheckerIpRanges service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetCheckerIpRangesResult getCheckerIpRanges(GetCheckerIpRangesRequest getCheckerIpRangesRequest) {
        ExecutionContext executionContext = createExecutionContext(getCheckerIpRangesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetCheckerIpRangesRequest> request = null;
        Response<GetCheckerIpRangesResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetCheckerIpRangesRequestMarshaller().marshall(getCheckerIpRangesRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new GetCheckerIpRangesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action creates a new hosted zone.
     * </p>
     * <p>
     * To create a new hosted zone, send a <code>POST</code> request to the
     * <code>2013-04-01/hostedzone</code> resource. The request body must
     * include an XML document with a <code>CreateHostedZoneRequest</code>
     * element. The response returns the
     * <code>CreateHostedZoneResponse</code> element that contains metadata
     * about the hosted zone.
     * </p>
     * <p>
     * Route 53 automatically creates a default SOA record and four NS
     * records for the zone. The NS records in the hosted zone are the name
     * servers you give your registrar to delegate your domain to. For more
     * information about SOA and NS records, see
     * <a href="http://docs.aws.amazon.com/Route53/latest/DeveloperGuide/SOA-NSrecords.html"> NS and SOA Records that Route 53 Creates for a Hosted Zone </a>
     * in the <i>Amazon Route 53 Developer Guide</i> .
     * </p>
     * <p>
     * When you create a zone, its initial status is <code>PENDING</code> .
     * This means that it is not yet available on all DNS servers. The status
     * of the zone changes to <code>INSYNC</code> when the NS and SOA records
     * are available on all Route 53 DNS servers.
     * </p>
     *
     * @param createHostedZoneRequest Container for the necessary parameters
     *           to execute the CreateHostedZone service method on AmazonRoute53.
     * 
     * @return The response from the CreateHostedZone service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws TooManyHostedZonesException
     * @throws DelegationSetNotAvailableException
     * @throws InvalidDomainNameException
     * @throws InvalidInputException
     * @throws HostedZoneAlreadyExistsException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateHostedZoneResult createHostedZone(CreateHostedZoneRequest createHostedZoneRequest) {
        ExecutionContext executionContext = createExecutionContext(createHostedZoneRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateHostedZoneRequest> request = null;
        Response<CreateHostedZoneResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateHostedZoneRequestMarshaller().marshall(createHostedZoneRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new CreateHostedZoneResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param listTagsForResourceRequest Container for the necessary
     *           parameters to execute the ListTagsForResource service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ListTagsForResource service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws ThrottlingException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest listTagsForResourceRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsForResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsForResourceRequest> request = null;
        Response<ListTagsForResourceResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsForResourceRequestMarshaller().marshall(listTagsForResourceRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ListTagsForResourceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of your health checks, send a <code>GET</code>
     * request to the <code>2013-04-01/healthcheck</code> resource. The
     * response to this request includes a <code>HealthChecks</code> element
     * with zero, one, or multiple <code>HealthCheck</code> child elements.
     * By default, the list of health checks is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the health check that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     *
     * @param listHealthChecksRequest Container for the necessary parameters
     *           to execute the ListHealthChecks service method on AmazonRoute53.
     * 
     * @return The response from the ListHealthChecks service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws IncompatibleVersionException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHealthChecksResult listHealthChecks(ListHealthChecksRequest listHealthChecksRequest) {
        ExecutionContext executionContext = createExecutionContext(listHealthChecksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListHealthChecksRequest> request = null;
        Response<ListHealthChecksResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListHealthChecksRequestMarshaller().marshall(listHealthChecksRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ListHealthChecksResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * This action creates a new health check.
     * </p>
     * <p>
     * To create a new health check, send a <code>POST</code> request to the
     * <code>2013-04-01/healthcheck</code> resource. The request body must
     * include an XML document with a <code>CreateHealthCheckRequest</code>
     * element. The response returns the
     * <code>CreateHealthCheckResponse</code> element that contains metadata
     * about the health check.
     * </p>
     *
     * @param createHealthCheckRequest Container for the necessary parameters
     *           to execute the CreateHealthCheck service method on AmazonRoute53.
     * 
     * @return The response from the CreateHealthCheck service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws HealthCheckAlreadyExistsException
     * @throws InvalidInputException
     * @throws TooManyHealthChecksException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateHealthCheckResult createHealthCheck(CreateHealthCheckRequest createHealthCheckRequest) {
        ExecutionContext executionContext = createExecutionContext(createHealthCheckRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateHealthCheckRequest> request = null;
        Response<CreateHealthCheckResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateHealthCheckRequestMarshaller().marshall(createHealthCheckRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new CreateHealthCheckResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Use this action to create or change your authoritative DNS
     * information. To use this action, send a <code>POST</code> request to
     * the <code>2013-04-01/hostedzone/hosted Zone ID/rrset</code> resource.
     * The request body must include an XML document with a
     * <code>ChangeResourceRecordSetsRequest</code> element.
     * </p>
     * <p>
     * Changes are a list of change items and are considered transactional.
     * For more information on transactional changes, also known as change
     * batches, see
     * <a href="http://docs.aws.amazon.com/Route53/latest/DeveloperGuide/RRSchanges.html#RRSchanges_API"> Creating, Changing, and Deleting Resource Record Sets Using the Route 53 API </a>
     * in the <i>Amazon Route 53 Developer Guide</i> .
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Due to the nature of transactional changes, you
     * cannot delete the same resource record set more than once in a single
     * change batch. If you attempt to delete the same change batch more than
     * once, Route 53 returns an InvalidChangeBatch error.
     * </p>
     * <p>
     * In response to a <code>ChangeResourceRecordSets</code> request, your
     * DNS data is changed on all Route 53 DNS servers. Initially, the status
     * of a change is <code>PENDING</code> . This means the change has not
     * yet propagated to all the authoritative Route 53 DNS servers. When the
     * change is propagated to all hosts, the change returns a status of
     * <code>INSYNC</code> .
     * </p>
     * <p>
     * Note the following limitations on a
     * <code>ChangeResourceRecordSets</code> request:
     * </p>
     * <p>
     * - A request cannot contain more than 100 Change elements.
     * </p>
     * <p>
     * - A request cannot contain more than 1000 ResourceRecord elements.
     * </p>
     * <p>
     * The sum of the number of characters (including spaces) in all
     * <code>Value</code> elements in a request cannot exceed 32,000
     * characters.
     * </p>
     *
     * @param changeResourceRecordSetsRequest Container for the necessary
     *           parameters to execute the ChangeResourceRecordSets service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ChangeResourceRecordSets service method,
     *         as returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws NoSuchHostedZoneException
     * @throws InvalidInputException
     * @throws InvalidChangeBatchException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ChangeResourceRecordSetsResult changeResourceRecordSets(ChangeResourceRecordSetsRequest changeResourceRecordSetsRequest) {
        ExecutionContext executionContext = createExecutionContext(changeResourceRecordSetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ChangeResourceRecordSetsRequest> request = null;
        Response<ChangeResourceRecordSetsResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ChangeResourceRecordSetsRequestMarshaller().marshall(changeResourceRecordSetsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ChangeResourceRecordSetsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of supported geo locations, send a
     * <code>GET</code> request to the <code>2013-04-01/geolocations</code>
     * resource. The response to this request includes a
     * <code>GeoLocationDetailsList</code> element with zero, one, or
     * multiple <code>GeoLocationDetails</code> child elements. The list is
     * sorted by country code, and then subdivision code, followed by
     * continents at the end of the list.
     * </p>
     * <p>
     * By default, the list of geo locations is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. If the list is truncated,
     * <code>IsTruncated</code> will be set to <i>true</i> and a combination
     * of <code>NextContinentCode, NextCountryCode,
     * NextSubdivisionCode</code> will be populated. You can pass these as
     * parameters to <code>StartContinentCode, StartCountryCode,
     * StartSubdivisionCode</code> to control the geo location that the list
     * begins with.
     * </p>
     *
     * @param listGeoLocationsRequest Container for the necessary parameters
     *           to execute the ListGeoLocations service method on AmazonRoute53.
     * 
     * @return The response from the ListGeoLocations service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListGeoLocationsResult listGeoLocations(ListGeoLocationsRequest listGeoLocationsRequest) {
        ExecutionContext executionContext = createExecutionContext(listGeoLocationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListGeoLocationsRequest> request = null;
        Response<ListGeoLocationsResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListGeoLocationsRequestMarshaller().marshall(listGeoLocationsRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ListGeoLocationsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a count of all your health checks, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/healthcheckcount</code> resource.
     * </p>
     *
     * @param getHealthCheckCountRequest Container for the necessary
     *           parameters to execute the GetHealthCheckCount service method on
     *           AmazonRoute53.
     * 
     * @return The response from the GetHealthCheckCount service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckCountResult getHealthCheckCount(GetHealthCheckCountRequest getHealthCheckCountRequest) {
        ExecutionContext executionContext = createExecutionContext(getHealthCheckCountRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetHealthCheckCountRequest> request = null;
        Response<GetHealthCheckCountResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetHealthCheckCountRequestMarshaller().marshall(getHealthCheckCountRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new GetHealthCheckCountResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param changeTagsForResourceRequest Container for the necessary
     *           parameters to execute the ChangeTagsForResource service method on
     *           AmazonRoute53.
     * 
     * @return The response from the ChangeTagsForResource service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws PriorRequestNotCompleteException
     * @throws NoSuchHealthCheckException
     * @throws ThrottlingException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ChangeTagsForResourceResult changeTagsForResource(ChangeTagsForResourceRequest changeTagsForResourceRequest) {
        ExecutionContext executionContext = createExecutionContext(changeTagsForResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ChangeTagsForResourceRequest> request = null;
        Response<ChangeTagsForResourceResult> response = null;
        
        try {
            
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ChangeTagsForResourceRequestMarshaller().marshall(changeTagsForResourceRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                  awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            response = invoke(request, new ChangeTagsForResourceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * To retrieve a list of your hosted zones, send a <code>GET</code>
     * request to the <code>2013-04-01/hostedzone</code> resource. The
     * response to this request includes a <code>HostedZones</code> element
     * with zero, one, or multiple <code>HostedZone</code> child elements. By
     * default, the list of hosted zones is displayed on a single page. You
     * can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the hosted zone that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     * 
     * @return The response from the ListHostedZones service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHostedZonesResult listHostedZones() throws AmazonServiceException, AmazonClientException {
        return listHostedZones(new ListHostedZonesRequest());
    }
    
    /**
     * <p>
     * To retrieve a single geo location, send a <code>GET</code> request to
     * the <code>2013-04-01/geolocation</code> resource with one of these
     * options: continentcode | countrycode | countrycode and
     * subdivisioncode.
     * </p>
     * 
     * @return The response from the GetGeoLocation service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws NoSuchGeoLocationException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetGeoLocationResult getGeoLocation() throws AmazonServiceException, AmazonClientException {
        return getGeoLocation(new GetGeoLocationRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of the IP ranges used by Amazon Route 53 health
     * checkers to check the health of your resources, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/checkeripranges</code> resource. You can use these IP
     * addresses to configure router and firewall rules to allow health
     * checkers to check the health of your resources.
     * </p>
     * 
     * @return The response from the GetCheckerIpRanges service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetCheckerIpRangesResult getCheckerIpRanges() throws AmazonServiceException, AmazonClientException {
        return getCheckerIpRanges(new GetCheckerIpRangesRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of your health checks, send a <code>GET</code>
     * request to the <code>2013-04-01/healthcheck</code> resource. The
     * response to this request includes a <code>HealthChecks</code> element
     * with zero, one, or multiple <code>HealthCheck</code> child elements.
     * By default, the list of health checks is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. You can use the <code>Marker</code>
     * parameter to control the health check that the list begins with.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon Route 53 returns a maximum of 100 items. If you
     * set MaxItems to a value greater than 100, Amazon Route 53 returns only
     * the first 100.
     * </p>
     * 
     * @return The response from the ListHealthChecks service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws IncompatibleVersionException
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListHealthChecksResult listHealthChecks() throws AmazonServiceException, AmazonClientException {
        return listHealthChecks(new ListHealthChecksRequest());
    }
    
    /**
     * <p>
     * To retrieve a list of supported geo locations, send a
     * <code>GET</code> request to the <code>2013-04-01/geolocations</code>
     * resource. The response to this request includes a
     * <code>GeoLocationDetailsList</code> element with zero, one, or
     * multiple <code>GeoLocationDetails</code> child elements. The list is
     * sorted by country code, and then subdivision code, followed by
     * continents at the end of the list.
     * </p>
     * <p>
     * By default, the list of geo locations is displayed on a single page.
     * You can control the length of the page that is displayed by using the
     * <code>MaxItems</code> parameter. If the list is truncated,
     * <code>IsTruncated</code> will be set to <i>true</i> and a combination
     * of <code>NextContinentCode, NextCountryCode,
     * NextSubdivisionCode</code> will be populated. You can pass these as
     * parameters to <code>StartContinentCode, StartCountryCode,
     * StartSubdivisionCode</code> to control the geo location that the list
     * begins with.
     * </p>
     * 
     * @return The response from the ListGeoLocations service method, as
     *         returned by AmazonRoute53.
     * 
     * @throws InvalidInputException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListGeoLocationsResult listGeoLocations() throws AmazonServiceException, AmazonClientException {
        return listGeoLocations(new ListGeoLocationsRequest());
    }
    
    /**
     * <p>
     * To retrieve a count of all your health checks, send a
     * <code>GET</code> request to the
     * <code>2013-04-01/healthcheckcount</code> resource.
     * </p>
     * 
     * @return The response from the GetHealthCheckCount service method, as
     *         returned by AmazonRoute53.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonRoute53 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetHealthCheckCountResult getHealthCheckCount() throws AmazonServiceException, AmazonClientException {
        return getHealthCheckCount(new GetHealthCheckCountRequest());
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            Unmarshaller<X, StaxUnmarshallerContext> unmarshaller,
            ExecutionContext executionContext)
    {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        for (Entry<String, String> entry : originalRequest.copyPrivateRequestParameters().entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        