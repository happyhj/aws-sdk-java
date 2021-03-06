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
package com.amazonaws.services.autoscaling;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amazonaws.client.ClientConfiguration;
import com.amazonaws.client.handler.request.AsyncHandler;
import com.amazonaws.credential.AWSCredentials;
import com.amazonaws.credential.AWSCredentialsProvider;
import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.exception.AmazonServiceException;
import com.amazonaws.authprovider.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.autoscaling.model.*;

/**
 * Asynchronous client for accessing AmazonAutoScaling.
 * All asynchronous calls made using this client are non-blocking. Callers could either
 * process the result and handle the exceptions in the worker thread by providing a callback handler
 * when making the call, or use the returned Future object to check the result of the call in the calling thread.
 * Auto Scaling <p>
 * Auto Scaling is a web service designed to automatically launch or
 * terminate Amazon Elastic Compute Cloud (Amazon EC2) instances based on
 * user-defined policies, schedules, and health checks. This service is
 * used in conjunction with Amazon CloudWatch and Elastic Load Balancing
 * services.
 * </p>
 * <p>
 * Auto Scaling provides APIs that you can call by submitting a Query
 * Request. Query requests are HTTP or HTTPS requests that use the HTTP
 * verbs GET or POST and a Query parameter named <i>Action</i> or
 * <i>Operation</i> that specifies the API you are calling. Action is
 * used throughout this documentation, although Operation is also
 * supported for backward compatibility with other Amazon Web Services
 * (AWS) Query APIs.
 * </p>
 * <p>
 * Calling the API using a Query request is the most direct way to access
 * the web service, but requires that your application handle low-level
 * details such as generating the hash to sign the request and error
 * handling. The benefit of calling the service using a Query request is
 * that you are assured of having access to the complete functionality of
 * the API. For information about signing a a query request, see
 * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/api_requests.html"> Use Query Requests to Call Auto Scaling APIs </a>
 * 
 * </p>
 * <p>
 * This guide provides detailed information about Auto Scaling actions,
 * data types, parameters, and errors. For detailed information about
 * Auto Scaling features and their associated API actions, go to the
 * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/"> Auto Scaling Developer Guide </a>
 * .
 * </p>
 * <p>
 * This reference is based on the current WSDL, which is available at:
 * </p>
 * <p>
 * 
 * <a href="http://autoscaling.amazonaws.com/doc/2011-01-01/AutoScaling.wsdl"> http://autoscaling.amazonaws.com/doc/2011-01-01/AutoScaling.wsdl </a>
 * 
 * </p>
 * <p>
 * <b>Endpoints</b>
 * </p>
 * <p>
 * The examples in this guide assume that your instances are launched in
 * the US East (Northern Virginia) region and use us-east-1 as the
 * endpoint.
 * </p>
 * <p>
 * You can set up your Auto Scaling infrastructure in other AWS regions.
 * For information about this product's regions and endpoints, see
 * <a href="http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html"> Regions and Endpoints </a>
 * in the Amazon Web Services General Reference.
 * </p>
 */
public class AmazonAutoScalingAsyncClient extends AmazonAutoScalingClient
        implements AmazonAutoScalingAsync {

    /**
     * Executor service for executing asynchronous requests.
     */
    private ExecutorService executorService;

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling.  A credentials provider chain will be used
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
    public AmazonAutoScalingAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling.  A credentials provider chain will be used
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
     *                       client connects to AmazonAutoScaling
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonAutoScalingAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling using the specified AWS account credentials.
     * Default client settings will be used, and a fixed size thread pool will be
     * created for executing the asynchronous tasks.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonAutoScalingAsyncClient(AWSCredentials awsCredentials) {
        this(awsCredentials, Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling using the specified AWS account credentials
     * and executor service.  Default client settings will be used.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonAutoScalingAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {
        super(awsCredentials);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling using the specified AWS account credentials,
     * executor service, and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonAutoScalingAsyncClient(AWSCredentials awsCredentials,
                ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling using the specified AWS account credentials provider.
     * Default client settings will be used, and a fixed size thread pool will be
     * created for executing the asynchronous tasks.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonAutoScalingAsyncClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling using the specified AWS account credentials provider
     * and executor service.  Default client settings will be used.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonAutoScalingAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService) {
        this(awsCredentialsProvider, new ClientConfiguration(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     */
    public AmazonAutoScalingAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
                ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonAutoScaling using the specified AWS account credentials
     * provider, executor service, and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonAutoScalingAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
                ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Returns the executor service used by this async client to execute
     * requests.
     *
     * @return The executor service used by this async client to execute
     *         requests.
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes
     * forcibly terminating all pending asynchronous service calls. Clients who
     * wish to give pending asynchronous service calls time to complete should
     * call getExecutorService().shutdown() followed by
     * getExecutorService().awaitTermination() prior to calling this method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }
            
    /**
     * <p>
     * Returns the limits for the Auto Scaling resources currently allowed
     * for your AWS account.
     * </p>
     * <p>
     * Your AWS account comes with default limits on resources for Auto
     * Scaling. There is a default limit of <code>20</code> Auto Scaling
     * groups and <code>100</code> launch configurations per region.
     * </p>
     * <p>
     * If you reach the limits for the number of Auto Scaling groups or the
     * launch configurations, you can go to the
     * <a href="https://aws.amazon.com/support/"> Support Center </a>
     * and place a request to raise the limits.
     * </p>
     *
     * @param describeAccountLimitsRequest Container for the necessary
     *           parameters to execute the DescribeAccountLimits operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAccountLimits service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAccountLimitsResult> describeAccountLimitsAsync(final DescribeAccountLimitsRequest describeAccountLimitsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAccountLimitsResult>() {
            public DescribeAccountLimitsResult call() throws Exception {
                return describeAccountLimits(describeAccountLimitsRequest);
        }
    });
    }

    /**
     * <p>
     * Returns the limits for the Auto Scaling resources currently allowed
     * for your AWS account.
     * </p>
     * <p>
     * Your AWS account comes with default limits on resources for Auto
     * Scaling. There is a default limit of <code>20</code> Auto Scaling
     * groups and <code>100</code> launch configurations per region.
     * </p>
     * <p>
     * If you reach the limits for the number of Auto Scaling groups or the
     * launch configurations, you can go to the
     * <a href="https://aws.amazon.com/support/"> Support Center </a>
     * and place a request to raise the limits.
     * </p>
     *
     * @param describeAccountLimitsRequest Container for the necessary
     *           parameters to execute the DescribeAccountLimits operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAccountLimits service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAccountLimitsResult> describeAccountLimitsAsync(
            final DescribeAccountLimitsRequest describeAccountLimitsRequest,
            final AsyncHandler<DescribeAccountLimitsRequest, DescribeAccountLimitsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAccountLimitsResult>() {
            public DescribeAccountLimitsResult call() throws Exception {
              DescribeAccountLimitsResult result;
                try {
                result = describeAccountLimits(describeAccountLimitsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeAccountLimitsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns a full description of each Auto Scaling group in the given
     * list. This includes all Amazon EC2 instances that are members of the
     * group. If a list of names is not provided, the service returns the
     * full details of all Auto Scaling groups.
     * </p>
     * <p>
     * This action supports pagination by returning a token if there are
     * more pages to retrieve. To get the next page, call this action again
     * with the returned token as the <code>NextToken</code> parameter.
     * </p>
     *
     * @param describeAutoScalingGroupsRequest Container for the necessary
     *           parameters to execute the DescribeAutoScalingGroups operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAutoScalingGroups service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAutoScalingGroupsResult> describeAutoScalingGroupsAsync(final DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAutoScalingGroupsResult>() {
            public DescribeAutoScalingGroupsResult call() throws Exception {
                return describeAutoScalingGroups(describeAutoScalingGroupsRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a full description of each Auto Scaling group in the given
     * list. This includes all Amazon EC2 instances that are members of the
     * group. If a list of names is not provided, the service returns the
     * full details of all Auto Scaling groups.
     * </p>
     * <p>
     * This action supports pagination by returning a token if there are
     * more pages to retrieve. To get the next page, call this action again
     * with the returned token as the <code>NextToken</code> parameter.
     * </p>
     *
     * @param describeAutoScalingGroupsRequest Container for the necessary
     *           parameters to execute the DescribeAutoScalingGroups operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAutoScalingGroups service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAutoScalingGroupsResult> describeAutoScalingGroupsAsync(
            final DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest,
            final AsyncHandler<DescribeAutoScalingGroupsRequest, DescribeAutoScalingGroupsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAutoScalingGroupsResult>() {
            public DescribeAutoScalingGroupsResult call() throws Exception {
              DescribeAutoScalingGroupsResult result;
                try {
                result = describeAutoScalingGroups(describeAutoScalingGroupsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeAutoScalingGroupsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Enables monitoring of group metrics for the Auto Scaling group
     * specified in <code>AutoScalingGroupName</code> . You can specify the
     * list of enabled metrics with the <code>Metrics</code> parameter.
     * </p>
     * <p>
     * Auto Scaling metrics collection can be turned on only if the
     * <code>InstanceMonitoring</code> flag, in the Auto Scaling group's
     * launch configuration, is set to <code>True</code> .
     * </p>
     *
     * @param enableMetricsCollectionRequest Container for the necessary
     *           parameters to execute the EnableMetricsCollection operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         EnableMetricsCollection service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> enableMetricsCollectionAsync(final EnableMetricsCollectionRequest enableMetricsCollectionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                enableMetricsCollection(enableMetricsCollectionRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Enables monitoring of group metrics for the Auto Scaling group
     * specified in <code>AutoScalingGroupName</code> . You can specify the
     * list of enabled metrics with the <code>Metrics</code> parameter.
     * </p>
     * <p>
     * Auto Scaling metrics collection can be turned on only if the
     * <code>InstanceMonitoring</code> flag, in the Auto Scaling group's
     * launch configuration, is set to <code>True</code> .
     * </p>
     *
     * @param enableMetricsCollectionRequest Container for the necessary
     *           parameters to execute the EnableMetricsCollection operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         EnableMetricsCollection service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> enableMetricsCollectionAsync(
            final EnableMetricsCollectionRequest enableMetricsCollectionRequest,
            final AsyncHandler<EnableMetricsCollectionRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                enableMetricsCollection(enableMetricsCollectionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(enableMetricsCollectionRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Resumes all suspended Auto Scaling processes for an Auto Scaling
     * group. For information on suspending and resuming Auto Scaling
     * process, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/US_SuspendResume.html"> Suspend and Resume Auto Scaling Process </a>
     * .
     * </p>
     *
     * @param resumeProcessesRequest Container for the necessary parameters
     *           to execute the ResumeProcesses operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         ResumeProcesses service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> resumeProcessesAsync(final ResumeProcessesRequest resumeProcessesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                resumeProcesses(resumeProcessesRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Resumes all suspended Auto Scaling processes for an Auto Scaling
     * group. For information on suspending and resuming Auto Scaling
     * process, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/US_SuspendResume.html"> Suspend and Resume Auto Scaling Process </a>
     * .
     * </p>
     *
     * @param resumeProcessesRequest Container for the necessary parameters
     *           to execute the ResumeProcesses operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ResumeProcesses service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> resumeProcessesAsync(
            final ResumeProcessesRequest resumeProcessesRequest,
            final AsyncHandler<ResumeProcessesRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                resumeProcesses(resumeProcessesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(resumeProcessesRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Describes the lifecycle hooks that currently belong to the specified
     * Auto Scaling group.
     * </p>
     *
     * @param describeLifecycleHooksRequest Container for the necessary
     *           parameters to execute the DescribeLifecycleHooks operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLifecycleHooks service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLifecycleHooksResult> describeLifecycleHooksAsync(final DescribeLifecycleHooksRequest describeLifecycleHooksRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLifecycleHooksResult>() {
            public DescribeLifecycleHooksResult call() throws Exception {
                return describeLifecycleHooks(describeLifecycleHooksRequest);
        }
    });
    }

    /**
     * <p>
     * Describes the lifecycle hooks that currently belong to the specified
     * Auto Scaling group.
     * </p>
     *
     * @param describeLifecycleHooksRequest Container for the necessary
     *           parameters to execute the DescribeLifecycleHooks operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLifecycleHooks service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLifecycleHooksResult> describeLifecycleHooksAsync(
            final DescribeLifecycleHooksRequest describeLifecycleHooksRequest,
            final AsyncHandler<DescribeLifecycleHooksRequest, DescribeLifecycleHooksResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLifecycleHooksResult>() {
            public DescribeLifecycleHooksResult call() throws Exception {
              DescribeLifecycleHooksResult result;
                try {
                result = describeLifecycleHooks(describeLifecycleHooksRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeLifecycleHooksRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns descriptions of what each policy does. This action supports
     * pagination. If the response includes a token, there are more records
     * available. To get the additional records, repeat the request with the
     * response token as the <code>NextToken</code> parameter.
     * </p>
     *
     * @param describePoliciesRequest Container for the necessary parameters
     *           to execute the DescribePolicies operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribePolicies service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribePoliciesResult> describePoliciesAsync(final DescribePoliciesRequest describePoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribePoliciesResult>() {
            public DescribePoliciesResult call() throws Exception {
                return describePolicies(describePoliciesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns descriptions of what each policy does. This action supports
     * pagination. If the response includes a token, there are more records
     * available. To get the additional records, repeat the request with the
     * response token as the <code>NextToken</code> parameter.
     * </p>
     *
     * @param describePoliciesRequest Container for the necessary parameters
     *           to execute the DescribePolicies operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribePolicies service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribePoliciesResult> describePoliciesAsync(
            final DescribePoliciesRequest describePoliciesRequest,
            final AsyncHandler<DescribePoliciesRequest, DescribePoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribePoliciesResult>() {
            public DescribePoliciesResult call() throws Exception {
              DescribePoliciesResult result;
                try {
                result = describePolicies(describePoliciesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describePoliciesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns scaling process types for use in the ResumeProcesses and
     * SuspendProcesses actions.
     * </p>
     *
     * @param describeScalingProcessTypesRequest Container for the necessary
     *           parameters to execute the DescribeScalingProcessTypes operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeScalingProcessTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeScalingProcessTypesResult> describeScalingProcessTypesAsync(final DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeScalingProcessTypesResult>() {
            public DescribeScalingProcessTypesResult call() throws Exception {
                return describeScalingProcessTypes(describeScalingProcessTypesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns scaling process types for use in the ResumeProcesses and
     * SuspendProcesses actions.
     * </p>
     *
     * @param describeScalingProcessTypesRequest Container for the necessary
     *           parameters to execute the DescribeScalingProcessTypes operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeScalingProcessTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeScalingProcessTypesResult> describeScalingProcessTypesAsync(
            final DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest,
            final AsyncHandler<DescribeScalingProcessTypesRequest, DescribeScalingProcessTypesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeScalingProcessTypesResult>() {
            public DescribeScalingProcessTypesResult call() throws Exception {
              DescribeScalingProcessTypesResult result;
                try {
                result = describeScalingProcessTypes(describeScalingProcessTypesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeScalingProcessTypesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified LaunchConfiguration.
     * </p>
     * <p>
     * The specified launch configuration must not be attached to an Auto
     * Scaling group. When this call completes, the launch configuration is
     * no longer available for use.
     * </p>
     *
     * @param deleteLaunchConfigurationRequest Container for the necessary
     *           parameters to execute the DeleteLaunchConfiguration operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLaunchConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLaunchConfigurationAsync(final DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteLaunchConfiguration(deleteLaunchConfigurationRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified LaunchConfiguration.
     * </p>
     * <p>
     * The specified launch configuration must not be attached to an Auto
     * Scaling group. When this call completes, the launch configuration is
     * no longer available for use.
     * </p>
     *
     * @param deleteLaunchConfigurationRequest Container for the necessary
     *           parameters to execute the DeleteLaunchConfiguration operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLaunchConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLaunchConfigurationAsync(
            final DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest,
            final AsyncHandler<DeleteLaunchConfigurationRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteLaunchConfiguration(deleteLaunchConfigurationRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteLaunchConfigurationRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new Auto Scaling group with the specified name and other
     * attributes. When the creation request is completed, the Auto Scaling
     * group is ready to be used in other calls.
     * </p>
     * <p>
     * <b>NOTE:</b> The Auto Scaling group name must be unique within the
     * scope of your AWS account.
     * </p>
     *
     * @param createAutoScalingGroupRequest Container for the necessary
     *           parameters to execute the CreateAutoScalingGroup operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createAutoScalingGroupAsync(final CreateAutoScalingGroupRequest createAutoScalingGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                createAutoScalingGroup(createAutoScalingGroupRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Creates a new Auto Scaling group with the specified name and other
     * attributes. When the creation request is completed, the Auto Scaling
     * group is ready to be used in other calls.
     * </p>
     * <p>
     * <b>NOTE:</b> The Auto Scaling group name must be unique within the
     * scope of your AWS account.
     * </p>
     *
     * @param createAutoScalingGroupRequest Container for the necessary
     *           parameters to execute the CreateAutoScalingGroup operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createAutoScalingGroupAsync(
            final CreateAutoScalingGroupRequest createAutoScalingGroupRequest,
            final AsyncHandler<CreateAutoScalingGroupRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                createAutoScalingGroup(createAutoScalingGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createAutoScalingGroupRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Attaches one or more Amazon EC2 instances to an existing Auto Scaling
     * group. After the instance(s) is attached, it becomes a part of the
     * Auto Scaling group.
     * </p>
     * <p>
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/attach-instance-asg.html"> Attach Amazon EC2 Instances to Your Existing Auto Scaling Group </a>
     * in the <i>Auto Scaling Developer Guide</i> .
     * </p>
     *
     * @param attachInstancesRequest Container for the necessary parameters
     *           to execute the AttachInstances operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         AttachInstances service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachInstancesAsync(final AttachInstancesRequest attachInstancesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                attachInstances(attachInstancesRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Attaches one or more Amazon EC2 instances to an existing Auto Scaling
     * group. After the instance(s) is attached, it becomes a part of the
     * Auto Scaling group.
     * </p>
     * <p>
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/attach-instance-asg.html"> Attach Amazon EC2 Instances to Your Existing Auto Scaling Group </a>
     * in the <i>Auto Scaling Developer Guide</i> .
     * </p>
     *
     * @param attachInstancesRequest Container for the necessary parameters
     *           to execute the AttachInstances operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AttachInstances service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> attachInstancesAsync(
            final AttachInstancesRequest attachInstancesRequest,
            final AsyncHandler<AttachInstancesRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                attachInstances(attachInstancesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(attachInstancesRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns the scaling activities for the specified Auto Scaling group.
     * </p>
     * <p>
     * If the specified <code>ActivityIds</code> list is empty, all the
     * activities from the past six weeks are returned. Activities are sorted
     * by the start time. Activities still in progress appear first on the
     * list.
     * </p>
     * <p>
     * This action supports pagination. If the response includes a token,
     * there are more records available. To get the additional records,
     * repeat the request with the response token as the
     * <code>NextToken</code> parameter.
     * </p>
     *
     * @param describeScalingActivitiesRequest Container for the necessary
     *           parameters to execute the DescribeScalingActivities operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeScalingActivities service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeScalingActivitiesResult> describeScalingActivitiesAsync(final DescribeScalingActivitiesRequest describeScalingActivitiesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeScalingActivitiesResult>() {
            public DescribeScalingActivitiesResult call() throws Exception {
                return describeScalingActivities(describeScalingActivitiesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns the scaling activities for the specified Auto Scaling group.
     * </p>
     * <p>
     * If the specified <code>ActivityIds</code> list is empty, all the
     * activities from the past six weeks are returned. Activities are sorted
     * by the start time. Activities still in progress appear first on the
     * list.
     * </p>
     * <p>
     * This action supports pagination. If the response includes a token,
     * there are more records available. To get the additional records,
     * repeat the request with the response token as the
     * <code>NextToken</code> parameter.
     * </p>
     *
     * @param describeScalingActivitiesRequest Container for the necessary
     *           parameters to execute the DescribeScalingActivities operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeScalingActivities service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeScalingActivitiesResult> describeScalingActivitiesAsync(
            final DescribeScalingActivitiesRequest describeScalingActivitiesRequest,
            final AsyncHandler<DescribeScalingActivitiesRequest, DescribeScalingActivitiesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeScalingActivitiesResult>() {
            public DescribeScalingActivitiesResult call() throws Exception {
              DescribeScalingActivitiesResult result;
                try {
                result = describeScalingActivities(describeScalingActivitiesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeScalingActivitiesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns a list of notification actions associated with Auto Scaling
     * groups for specified events.
     * </p>
     *
     * @param describeNotificationConfigurationsRequest Container for the
     *           necessary parameters to execute the DescribeNotificationConfigurations
     *           operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeNotificationConfigurations service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeNotificationConfigurationsResult> describeNotificationConfigurationsAsync(final DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeNotificationConfigurationsResult>() {
            public DescribeNotificationConfigurationsResult call() throws Exception {
                return describeNotificationConfigurations(describeNotificationConfigurationsRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a list of notification actions associated with Auto Scaling
     * groups for specified events.
     * </p>
     *
     * @param describeNotificationConfigurationsRequest Container for the
     *           necessary parameters to execute the DescribeNotificationConfigurations
     *           operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeNotificationConfigurations service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeNotificationConfigurationsResult> describeNotificationConfigurationsAsync(
            final DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest,
            final AsyncHandler<DescribeNotificationConfigurationsRequest, DescribeNotificationConfigurationsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeNotificationConfigurationsResult>() {
            public DescribeNotificationConfigurationsResult call() throws Exception {
              DescribeNotificationConfigurationsResult result;
                try {
                result = describeNotificationConfigurations(describeNotificationConfigurationsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeNotificationConfigurationsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified lifecycle hook. If there are any outstanding
     * lifecycle actions, they are completed first (ABANDON for launching
     * instances, CONTINUE for terminating instances).
     * </p>
     *
     * @param deleteLifecycleHookRequest Container for the necessary
     *           parameters to execute the DeleteLifecycleHook operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLifecycleHook service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DeleteLifecycleHookResult> deleteLifecycleHookAsync(final DeleteLifecycleHookRequest deleteLifecycleHookRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteLifecycleHookResult>() {
            public DeleteLifecycleHookResult call() throws Exception {
                return deleteLifecycleHook(deleteLifecycleHookRequest);
        }
    });
    }

    /**
     * <p>
     * Deletes the specified lifecycle hook. If there are any outstanding
     * lifecycle actions, they are completed first (ABANDON for launching
     * instances, CONTINUE for terminating instances).
     * </p>
     *
     * @param deleteLifecycleHookRequest Container for the necessary
     *           parameters to execute the DeleteLifecycleHook operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLifecycleHook service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DeleteLifecycleHookResult> deleteLifecycleHookAsync(
            final DeleteLifecycleHookRequest deleteLifecycleHookRequest,
            final AsyncHandler<DeleteLifecycleHookRequest, DeleteLifecycleHookResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteLifecycleHookResult>() {
            public DeleteLifecycleHookResult call() throws Exception {
              DeleteLifecycleHookResult result;
                try {
                result = deleteLifecycleHook(deleteLifecycleHookRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteLifecycleHookRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates or updates a lifecycle hook for an Auto Scaling Group.
     * </p>
     * <p>
     * A lifecycle hook tells Auto Scaling that you want to perform an
     * action on an instance that is not actively in service; for example,
     * either when the instance launches or before the instance terminates.
     * </p>
     * <p>
     * This operation is a part of the basic sequence for adding a lifecycle
     * hook to an Auto Scaling group:
     * </p>
     * <ol> <li> Create a notification target. A target can be either an
     * Amazon SQS queue or an Amazon SNS topic. </li>
     * <li> Create an IAM role. This role allows Auto Scaling to publish
     * lifecycle notifications to the designated SQS queue or SNS topic.
     * </li>
     * <li> <b>Create the lifecycle hook. You can create a hook that acts
     * when instances launch or when instances terminate.</b> </li>
     * <li> If necessary, record the lifecycle action heartbeat to keep the
     * instance in a pending state. </li>
     * <li> Complete the lifecycle action. </li>
     * </ol> <p>
     * To learn more, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingPendingState.html"> Auto Scaling Pending State </a> and <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingTerminatingState.html"> Auto Scaling Terminating State </a>
     * .
     * </p>
     *
     * @param putLifecycleHookRequest Container for the necessary parameters
     *           to execute the PutLifecycleHook operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         PutLifecycleHook service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<PutLifecycleHookResult> putLifecycleHookAsync(final PutLifecycleHookRequest putLifecycleHookRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<PutLifecycleHookResult>() {
            public PutLifecycleHookResult call() throws Exception {
                return putLifecycleHook(putLifecycleHookRequest);
        }
    });
    }

    /**
     * <p>
     * Creates or updates a lifecycle hook for an Auto Scaling Group.
     * </p>
     * <p>
     * A lifecycle hook tells Auto Scaling that you want to perform an
     * action on an instance that is not actively in service; for example,
     * either when the instance launches or before the instance terminates.
     * </p>
     * <p>
     * This operation is a part of the basic sequence for adding a lifecycle
     * hook to an Auto Scaling group:
     * </p>
     * <ol> <li> Create a notification target. A target can be either an
     * Amazon SQS queue or an Amazon SNS topic. </li>
     * <li> Create an IAM role. This role allows Auto Scaling to publish
     * lifecycle notifications to the designated SQS queue or SNS topic.
     * </li>
     * <li> <b>Create the lifecycle hook. You can create a hook that acts
     * when instances launch or when instances terminate.</b> </li>
     * <li> If necessary, record the lifecycle action heartbeat to keep the
     * instance in a pending state. </li>
     * <li> Complete the lifecycle action. </li>
     * </ol> <p>
     * To learn more, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingPendingState.html"> Auto Scaling Pending State </a> and <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingTerminatingState.html"> Auto Scaling Terminating State </a>
     * .
     * </p>
     *
     * @param putLifecycleHookRequest Container for the necessary parameters
     *           to execute the PutLifecycleHook operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         PutLifecycleHook service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<PutLifecycleHookResult> putLifecycleHookAsync(
            final PutLifecycleHookRequest putLifecycleHookRequest,
            final AsyncHandler<PutLifecycleHookRequest, PutLifecycleHookResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<PutLifecycleHookResult>() {
            public PutLifecycleHookResult call() throws Exception {
              PutLifecycleHookResult result;
                try {
                result = putLifecycleHook(putLifecycleHookRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(putLifecycleHookRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns a list of all termination policies supported by Auto Scaling.
     * </p>
     *
     * @param describeTerminationPolicyTypesRequest Container for the
     *           necessary parameters to execute the DescribeTerminationPolicyTypes
     *           operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeTerminationPolicyTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeTerminationPolicyTypesResult> describeTerminationPolicyTypesAsync(final DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeTerminationPolicyTypesResult>() {
            public DescribeTerminationPolicyTypesResult call() throws Exception {
                return describeTerminationPolicyTypes(describeTerminationPolicyTypesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a list of all termination policies supported by Auto Scaling.
     * </p>
     *
     * @param describeTerminationPolicyTypesRequest Container for the
     *           necessary parameters to execute the DescribeTerminationPolicyTypes
     *           operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeTerminationPolicyTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeTerminationPolicyTypesResult> describeTerminationPolicyTypesAsync(
            final DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest,
            final AsyncHandler<DescribeTerminationPolicyTypesRequest, DescribeTerminationPolicyTypesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeTerminationPolicyTypesResult>() {
            public DescribeTerminationPolicyTypesResult call() throws Exception {
              DescribeTerminationPolicyTypesResult result;
                try {
                result = describeTerminationPolicyTypes(describeTerminationPolicyTypesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeTerminationPolicyTypesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists the Auto Scaling group tags.
     * </p>
     * <p>
     * You can use filters to limit results when describing tags. For
     * example, you can query for tags of a particular Auto Scaling group.
     * You can specify multiple values for a filter. A tag must match at
     * least one of the specified values for it to be included in the
     * results.
     * </p>
     * <p>
     * You can also specify multiple filters. The result includes
     * information for a particular tag only if it matches all your filters.
     * If there's no match, no special message is returned.
     * </p>
     *
     * @param describeTagsRequest Container for the necessary parameters to
     *           execute the DescribeTags operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeTags service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeTagsResult> describeTagsAsync(final DescribeTagsRequest describeTagsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeTagsResult>() {
            public DescribeTagsResult call() throws Exception {
                return describeTags(describeTagsRequest);
        }
    });
    }

    /**
     * <p>
     * Lists the Auto Scaling group tags.
     * </p>
     * <p>
     * You can use filters to limit results when describing tags. For
     * example, you can query for tags of a particular Auto Scaling group.
     * You can specify multiple values for a filter. A tag must match at
     * least one of the specified values for it to be included in the
     * results.
     * </p>
     * <p>
     * You can also specify multiple filters. The result includes
     * information for a particular tag only if it matches all your filters.
     * If there's no match, no special message is returned.
     * </p>
     *
     * @param describeTagsRequest Container for the necessary parameters to
     *           execute the DescribeTags operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeTags service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeTagsResult> describeTagsAsync(
            final DescribeTagsRequest describeTagsRequest,
            final AsyncHandler<DescribeTagsRequest, DescribeTagsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeTagsResult>() {
            public DescribeTagsResult call() throws Exception {
              DescribeTagsResult result;
                try {
                result = describeTags(describeTagsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeTagsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Removes the specified tags or a set of tags from a set of resources.
     * </p>
     *
     * @param deleteTagsRequest Container for the necessary parameters to
     *           execute the DeleteTags operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteTags service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteTagsAsync(final DeleteTagsRequest deleteTagsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteTags(deleteTagsRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Removes the specified tags or a set of tags from a set of resources.
     * </p>
     *
     * @param deleteTagsRequest Container for the necessary parameters to
     *           execute the DeleteTags operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteTags service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteTagsAsync(
            final DeleteTagsRequest deleteTagsRequest,
            final AsyncHandler<DeleteTagsRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteTags(deleteTagsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteTagsRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Executes the specified policy.
     * </p>
     *
     * @param executePolicyRequest Container for the necessary parameters to
     *           execute the ExecutePolicy operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         ExecutePolicy service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> executePolicyAsync(final ExecutePolicyRequest executePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                executePolicy(executePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Executes the specified policy.
     * </p>
     *
     * @param executePolicyRequest Container for the necessary parameters to
     *           execute the ExecutePolicy operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ExecutePolicy service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> executePolicyAsync(
            final ExecutePolicyRequest executePolicyRequest,
            final AsyncHandler<ExecutePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                executePolicy(executePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(executePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Creates or updates a policy for an Auto Scaling group. To update an
     * existing policy, use the existing policy name and set the parameter(s)
     * you want to change. Any existing parameter not changed in an update to
     * an existing policy is not changed in this update request.
     * </p>
     *
     * @param putScalingPolicyRequest Container for the necessary parameters
     *           to execute the PutScalingPolicy operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         PutScalingPolicy service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<PutScalingPolicyResult> putScalingPolicyAsync(final PutScalingPolicyRequest putScalingPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<PutScalingPolicyResult>() {
            public PutScalingPolicyResult call() throws Exception {
                return putScalingPolicy(putScalingPolicyRequest);
        }
    });
    }

    /**
     * <p>
     * Creates or updates a policy for an Auto Scaling group. To update an
     * existing policy, use the existing policy name and set the parameter(s)
     * you want to change. Any existing parameter not changed in an update to
     * an existing policy is not changed in this update request.
     * </p>
     *
     * @param putScalingPolicyRequest Container for the necessary parameters
     *           to execute the PutScalingPolicy operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         PutScalingPolicy service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<PutScalingPolicyResult> putScalingPolicyAsync(
            final PutScalingPolicyRequest putScalingPolicyRequest,
            final AsyncHandler<PutScalingPolicyRequest, PutScalingPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<PutScalingPolicyResult>() {
            public PutScalingPolicyResult call() throws Exception {
              PutScalingPolicyResult result;
                try {
                result = putScalingPolicy(putScalingPolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(putScalingPolicyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Configures an Auto Scaling group to send notifications when specified
     * events take place. Subscribers to this topic can have messages for
     * events delivered to an endpoint such as a web server or email address.
     * </p>
     * <p>
     * For more information see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/ASGettingNotifications.html"> Get Email Notifications When Your Auto Scaling Group Changes </a>
     * 
     * </p>
     * <p>
     * A new <code>PutNotificationConfiguration</code> overwrites an
     * existing configuration.
     * </p>
     *
     * @param putNotificationConfigurationRequest Container for the necessary
     *           parameters to execute the PutNotificationConfiguration operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         PutNotificationConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putNotificationConfigurationAsync(final PutNotificationConfigurationRequest putNotificationConfigurationRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                putNotificationConfiguration(putNotificationConfigurationRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Configures an Auto Scaling group to send notifications when specified
     * events take place. Subscribers to this topic can have messages for
     * events delivered to an endpoint such as a web server or email address.
     * </p>
     * <p>
     * For more information see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/ASGettingNotifications.html"> Get Email Notifications When Your Auto Scaling Group Changes </a>
     * 
     * </p>
     * <p>
     * A new <code>PutNotificationConfiguration</code> overwrites an
     * existing configuration.
     * </p>
     *
     * @param putNotificationConfigurationRequest Container for the necessary
     *           parameters to execute the PutNotificationConfiguration operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         PutNotificationConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putNotificationConfigurationAsync(
            final PutNotificationConfigurationRequest putNotificationConfigurationRequest,
            final AsyncHandler<PutNotificationConfigurationRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                putNotificationConfiguration(putNotificationConfigurationRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(putNotificationConfigurationRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Move an instance out of Standby mode.
     * </p>
     * <p>
     * To learn more about how to put instances that are in a Standby mode
     * back into service, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingInServiceState.html"> Auto Scaling InService State </a>
     * .
     * </p>
     *
     * @param exitStandbyRequest Container for the necessary parameters to
     *           execute the ExitStandby operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         ExitStandby service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ExitStandbyResult> exitStandbyAsync(final ExitStandbyRequest exitStandbyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ExitStandbyResult>() {
            public ExitStandbyResult call() throws Exception {
                return exitStandby(exitStandbyRequest);
        }
    });
    }

    /**
     * <p>
     * Move an instance out of Standby mode.
     * </p>
     * <p>
     * To learn more about how to put instances that are in a Standby mode
     * back into service, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingInServiceState.html"> Auto Scaling InService State </a>
     * .
     * </p>
     *
     * @param exitStandbyRequest Container for the necessary parameters to
     *           execute the ExitStandby operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ExitStandby service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ExitStandbyResult> exitStandbyAsync(
            final ExitStandbyRequest exitStandbyRequest,
            final AsyncHandler<ExitStandbyRequest, ExitStandbyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ExitStandbyResult>() {
            public ExitStandbyResult call() throws Exception {
              ExitStandbyResult result;
                try {
                result = exitStandby(exitStandbyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(exitStandbyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes a policy created by PutScalingPolicy.
     * </p>
     *
     * @param deletePolicyRequest Container for the necessary parameters to
     *           execute the DeletePolicy operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DeletePolicy service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deletePolicyAsync(final DeletePolicyRequest deletePolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deletePolicy(deletePolicyRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes a policy created by PutScalingPolicy.
     * </p>
     *
     * @param deletePolicyRequest Container for the necessary parameters to
     *           execute the DeletePolicy operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeletePolicy service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deletePolicyAsync(
            final DeletePolicyRequest deletePolicyRequest,
            final AsyncHandler<DeletePolicyRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deletePolicy(deletePolicyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deletePolicyRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Completes the lifecycle action for the associated token initiated
     * under the given lifecycle hook with the specified result.
     * </p>
     * <p>
     * This operation is a part of the basic sequence for adding a lifecycle
     * hook to an Auto Scaling group:
     * </p>
     * <ol> <li> Create a notification target. A target can be either an
     * Amazon SQS queue or an Amazon SNS topic. </li>
     * <li> Create an IAM role. This role allows Auto Scaling to publish
     * lifecycle notifications to the designated SQS queue or SNS topic.
     * </li>
     * <li> Create the lifecycle hook. You can create a hook that acts when
     * instances launch or when instances terminate. </li>
     * <li> If necessary, record the lifecycle action heartbeat to keep the
     * instance in a pending state. </li>
     * <li> <b>Complete the lifecycle action.</b> </li>
     * </ol> <p>
     * To learn more, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingPendingState.html"> Auto Scaling Pending State </a> and <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingTerminatingState.html"> Auto Scaling Terminating State </a>
     * .
     * </p>
     *
     * @param completeLifecycleActionRequest Container for the necessary
     *           parameters to execute the CompleteLifecycleAction operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         CompleteLifecycleAction service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CompleteLifecycleActionResult> completeLifecycleActionAsync(final CompleteLifecycleActionRequest completeLifecycleActionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CompleteLifecycleActionResult>() {
            public CompleteLifecycleActionResult call() throws Exception {
                return completeLifecycleAction(completeLifecycleActionRequest);
        }
    });
    }

    /**
     * <p>
     * Completes the lifecycle action for the associated token initiated
     * under the given lifecycle hook with the specified result.
     * </p>
     * <p>
     * This operation is a part of the basic sequence for adding a lifecycle
     * hook to an Auto Scaling group:
     * </p>
     * <ol> <li> Create a notification target. A target can be either an
     * Amazon SQS queue or an Amazon SNS topic. </li>
     * <li> Create an IAM role. This role allows Auto Scaling to publish
     * lifecycle notifications to the designated SQS queue or SNS topic.
     * </li>
     * <li> Create the lifecycle hook. You can create a hook that acts when
     * instances launch or when instances terminate. </li>
     * <li> If necessary, record the lifecycle action heartbeat to keep the
     * instance in a pending state. </li>
     * <li> <b>Complete the lifecycle action.</b> </li>
     * </ol> <p>
     * To learn more, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingPendingState.html"> Auto Scaling Pending State </a> and <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingTerminatingState.html"> Auto Scaling Terminating State </a>
     * .
     * </p>
     *
     * @param completeLifecycleActionRequest Container for the necessary
     *           parameters to execute the CompleteLifecycleAction operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CompleteLifecycleAction service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CompleteLifecycleActionResult> completeLifecycleActionAsync(
            final CompleteLifecycleActionRequest completeLifecycleActionRequest,
            final AsyncHandler<CompleteLifecycleActionRequest, CompleteLifecycleActionResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CompleteLifecycleActionResult>() {
            public CompleteLifecycleActionResult call() throws Exception {
              CompleteLifecycleActionResult result;
                try {
                result = completeLifecycleAction(completeLifecycleActionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(completeLifecycleActionRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes notifications created by PutNotificationConfiguration.
     * </p>
     *
     * @param deleteNotificationConfigurationRequest Container for the
     *           necessary parameters to execute the DeleteNotificationConfiguration
     *           operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteNotificationConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteNotificationConfigurationAsync(final DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteNotificationConfiguration(deleteNotificationConfigurationRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes notifications created by PutNotificationConfiguration.
     * </p>
     *
     * @param deleteNotificationConfigurationRequest Container for the
     *           necessary parameters to execute the DeleteNotificationConfiguration
     *           operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteNotificationConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteNotificationConfigurationAsync(
            final DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest,
            final AsyncHandler<DeleteNotificationConfigurationRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteNotificationConfiguration(deleteNotificationConfigurationRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteNotificationConfigurationRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Deletes a scheduled action previously created using the
     * PutScheduledUpdateGroupAction.
     * </p>
     *
     * @param deleteScheduledActionRequest Container for the necessary
     *           parameters to execute the DeleteScheduledAction operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteScheduledAction service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteScheduledActionAsync(final DeleteScheduledActionRequest deleteScheduledActionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteScheduledAction(deleteScheduledActionRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes a scheduled action previously created using the
     * PutScheduledUpdateGroupAction.
     * </p>
     *
     * @param deleteScheduledActionRequest Container for the necessary
     *           parameters to execute the DeleteScheduledAction operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteScheduledAction service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteScheduledActionAsync(
            final DeleteScheduledActionRequest deleteScheduledActionRequest,
            final AsyncHandler<DeleteScheduledActionRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteScheduledAction(deleteScheduledActionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteScheduledActionRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Sets the health status of a specified instance that belongs to any of
     * your Auto Scaling groups.
     * </p>
     * <p>
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/as-configure-healthcheck.html"> Configure Health Checks for Your Auto Scaling group </a>
     * .
     * </p>
     *
     * @param setInstanceHealthRequest Container for the necessary parameters
     *           to execute the SetInstanceHealth operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         SetInstanceHealth service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setInstanceHealthAsync(final SetInstanceHealthRequest setInstanceHealthRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                setInstanceHealth(setInstanceHealthRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Sets the health status of a specified instance that belongs to any of
     * your Auto Scaling groups.
     * </p>
     * <p>
     * For more information, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/as-configure-healthcheck.html"> Configure Health Checks for Your Auto Scaling group </a>
     * .
     * </p>
     *
     * @param setInstanceHealthRequest Container for the necessary parameters
     *           to execute the SetInstanceHealth operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SetInstanceHealth service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setInstanceHealthAsync(
            final SetInstanceHealthRequest setInstanceHealthRequest,
            final AsyncHandler<SetInstanceHealthRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                setInstanceHealth(setInstanceHealthRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(setInstanceHealthRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns a list of all notification types that are supported by Auto
     * Scaling.
     * </p>
     *
     * @param describeAutoScalingNotificationTypesRequest Container for the
     *           necessary parameters to execute the
     *           DescribeAutoScalingNotificationTypes operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAutoScalingNotificationTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAutoScalingNotificationTypesResult> describeAutoScalingNotificationTypesAsync(final DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAutoScalingNotificationTypesResult>() {
            public DescribeAutoScalingNotificationTypesResult call() throws Exception {
                return describeAutoScalingNotificationTypes(describeAutoScalingNotificationTypesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a list of all notification types that are supported by Auto
     * Scaling.
     * </p>
     *
     * @param describeAutoScalingNotificationTypesRequest Container for the
     *           necessary parameters to execute the
     *           DescribeAutoScalingNotificationTypes operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAutoScalingNotificationTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAutoScalingNotificationTypesResult> describeAutoScalingNotificationTypesAsync(
            final DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest,
            final AsyncHandler<DescribeAutoScalingNotificationTypesRequest, DescribeAutoScalingNotificationTypesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAutoScalingNotificationTypesResult>() {
            public DescribeAutoScalingNotificationTypesResult call() throws Exception {
              DescribeAutoScalingNotificationTypesResult result;
                try {
                result = describeAutoScalingNotificationTypes(describeAutoScalingNotificationTypesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeAutoScalingNotificationTypesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Suspends Auto Scaling processes for an Auto Scaling group. To suspend
     * specific process types, specify them by name with the
     * <code>ScalingProcesses.member.N</code> parameter. To suspend all
     * process types, omit the <code>ScalingProcesses.member.N</code>
     * parameter.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Suspending either of the two primary process types,
     * Launch or Terminate, can prevent other process types from functioning
     * properly.
     * </p>
     * <p>
     * To resume processes that have been suspended, use ResumeProcesses For
     * more information on suspending and resuming Auto Scaling process, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/US_SuspendResume.html"> Suspend and Resume Auto Scaling Process </a>
     * .
     * </p>
     *
     * @param suspendProcessesRequest Container for the necessary parameters
     *           to execute the SuspendProcesses operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         SuspendProcesses service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> suspendProcessesAsync(final SuspendProcessesRequest suspendProcessesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                suspendProcesses(suspendProcessesRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Suspends Auto Scaling processes for an Auto Scaling group. To suspend
     * specific process types, specify them by name with the
     * <code>ScalingProcesses.member.N</code> parameter. To suspend all
     * process types, omit the <code>ScalingProcesses.member.N</code>
     * parameter.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Suspending either of the two primary process types,
     * Launch or Terminate, can prevent other process types from functioning
     * properly.
     * </p>
     * <p>
     * To resume processes that have been suspended, use ResumeProcesses For
     * more information on suspending and resuming Auto Scaling process, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/US_SuspendResume.html"> Suspend and Resume Auto Scaling Process </a>
     * .
     * </p>
     *
     * @param suspendProcessesRequest Container for the necessary parameters
     *           to execute the SuspendProcesses operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SuspendProcesses service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> suspendProcessesAsync(
            final SuspendProcessesRequest suspendProcessesRequest,
            final AsyncHandler<SuspendProcessesRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                suspendProcesses(suspendProcessesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(suspendProcessesRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Creates new tags or updates existing tags for an Auto Scaling group.
     * </p>
     * <p>
     * <b>NOTE:</b> A tag's definition is composed of a resource ID,
     * resource type, key and value, and the propagate flag. Value and the
     * propagate flag are optional parameters. See the Request Parameters for
     * more information.
     * </p>
     * <p>
     * For information on creating tags for your Auto Scaling group, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/ASTagging.html"> Tag Your Auto Scaling Groups and Amazon EC2 Instances </a>
     * .
     * </p>
     *
     * @param createOrUpdateTagsRequest Container for the necessary
     *           parameters to execute the CreateOrUpdateTags operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         CreateOrUpdateTags service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createOrUpdateTagsAsync(final CreateOrUpdateTagsRequest createOrUpdateTagsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                createOrUpdateTags(createOrUpdateTagsRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Creates new tags or updates existing tags for an Auto Scaling group.
     * </p>
     * <p>
     * <b>NOTE:</b> A tag's definition is composed of a resource ID,
     * resource type, key and value, and the propagate flag. Value and the
     * propagate flag are optional parameters. See the Request Parameters for
     * more information.
     * </p>
     * <p>
     * For information on creating tags for your Auto Scaling group, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/ASTagging.html"> Tag Your Auto Scaling Groups and Amazon EC2 Instances </a>
     * .
     * </p>
     *
     * @param createOrUpdateTagsRequest Container for the necessary
     *           parameters to execute the CreateOrUpdateTags operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateOrUpdateTags service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createOrUpdateTagsAsync(
            final CreateOrUpdateTagsRequest createOrUpdateTagsRequest,
            final AsyncHandler<CreateOrUpdateTagsRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                createOrUpdateTags(createOrUpdateTagsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createOrUpdateTagsRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Using <code>DetachInstances</code> , you can remove an instance from
     * an Auto Scaling group. After the instances are detached, you can
     * manage them independently from the rest of the Auto Scaling group.
     * </p>
     * <p>
     * To learn more about detaching instances, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/detach-instance-asg.html"> Detach Amazon EC2 Instances From Your Auto Scaling Group </a>
     * .
     * </p>
     *
     * @param detachInstancesRequest Container for the necessary parameters
     *           to execute the DetachInstances operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DetachInstances service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DetachInstancesResult> detachInstancesAsync(final DetachInstancesRequest detachInstancesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DetachInstancesResult>() {
            public DetachInstancesResult call() throws Exception {
                return detachInstances(detachInstancesRequest);
        }
    });
    }

    /**
     * <p>
     * Using <code>DetachInstances</code> , you can remove an instance from
     * an Auto Scaling group. After the instances are detached, you can
     * manage them independently from the rest of the Auto Scaling group.
     * </p>
     * <p>
     * To learn more about detaching instances, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/detach-instance-asg.html"> Detach Amazon EC2 Instances From Your Auto Scaling Group </a>
     * .
     * </p>
     *
     * @param detachInstancesRequest Container for the necessary parameters
     *           to execute the DetachInstances operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DetachInstances service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DetachInstancesResult> detachInstancesAsync(
            final DetachInstancesRequest detachInstancesRequest,
            final AsyncHandler<DetachInstancesRequest, DetachInstancesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DetachInstancesResult>() {
            public DetachInstancesResult call() throws Exception {
              DetachInstancesResult result;
                try {
                result = detachInstances(detachInstancesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(detachInstancesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns a description of each Auto Scaling instance in the
     * <code>InstanceIds</code> list. If a list is not provided, the service
     * returns the full details of all instances up to a maximum of 50. By
     * default, the service returns a list of 20 items.
     * </p>
     * <p>
     * This action supports pagination by returning a token if there are
     * more pages to retrieve. To get the next page, call this action again
     * with the returned token as the <code>NextToken</code> parameter.
     * </p>
     *
     * @param describeAutoScalingInstancesRequest Container for the necessary
     *           parameters to execute the DescribeAutoScalingInstances operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAutoScalingInstances service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAutoScalingInstancesResult> describeAutoScalingInstancesAsync(final DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAutoScalingInstancesResult>() {
            public DescribeAutoScalingInstancesResult call() throws Exception {
                return describeAutoScalingInstances(describeAutoScalingInstancesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a description of each Auto Scaling instance in the
     * <code>InstanceIds</code> list. If a list is not provided, the service
     * returns the full details of all instances up to a maximum of 50. By
     * default, the service returns a list of 20 items.
     * </p>
     * <p>
     * This action supports pagination by returning a token if there are
     * more pages to retrieve. To get the next page, call this action again
     * with the returned token as the <code>NextToken</code> parameter.
     * </p>
     *
     * @param describeAutoScalingInstancesRequest Container for the necessary
     *           parameters to execute the DescribeAutoScalingInstances operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAutoScalingInstances service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAutoScalingInstancesResult> describeAutoScalingInstancesAsync(
            final DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest,
            final AsyncHandler<DescribeAutoScalingInstancesRequest, DescribeAutoScalingInstancesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAutoScalingInstancesResult>() {
            public DescribeAutoScalingInstancesResult call() throws Exception {
              DescribeAutoScalingInstancesResult result;
                try {
                result = describeAutoScalingInstances(describeAutoScalingInstancesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeAutoScalingInstancesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates a new launch configuration. The launch configuration name
     * must be unique within the scope of the client's AWS account. The
     * maximum limit of launch configurations, which by default is 100, must
     * not yet have been met; otherwise, the call will fail. When created,
     * the new launch configuration is available for immediate use.
     * </p>
     *
     * @param createLaunchConfigurationRequest Container for the necessary
     *           parameters to execute the CreateLaunchConfiguration operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLaunchConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createLaunchConfigurationAsync(final CreateLaunchConfigurationRequest createLaunchConfigurationRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                createLaunchConfiguration(createLaunchConfigurationRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Creates a new launch configuration. The launch configuration name
     * must be unique within the scope of the client's AWS account. The
     * maximum limit of launch configurations, which by default is 100, must
     * not yet have been met; otherwise, the call will fail. When created,
     * the new launch configuration is available for immediate use.
     * </p>
     *
     * @param createLaunchConfigurationRequest Container for the necessary
     *           parameters to execute the CreateLaunchConfiguration operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLaunchConfiguration service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createLaunchConfigurationAsync(
            final CreateLaunchConfigurationRequest createLaunchConfigurationRequest,
            final AsyncHandler<CreateLaunchConfigurationRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                createLaunchConfiguration(createLaunchConfigurationRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(createLaunchConfigurationRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Move instances in an Auto Scaling group into a Standby mode.
     * </p>
     * <p>
     * To learn more about how to put instances into a Standby mode, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingInServiceState.html"> Auto Scaling InService State </a>
     * .
     * </p>
     *
     * @param enterStandbyRequest Container for the necessary parameters to
     *           execute the EnterStandby operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         EnterStandby service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<EnterStandbyResult> enterStandbyAsync(final EnterStandbyRequest enterStandbyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<EnterStandbyResult>() {
            public EnterStandbyResult call() throws Exception {
                return enterStandby(enterStandbyRequest);
        }
    });
    }

    /**
     * <p>
     * Move instances in an Auto Scaling group into a Standby mode.
     * </p>
     * <p>
     * To learn more about how to put instances into a Standby mode, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingInServiceState.html"> Auto Scaling InService State </a>
     * .
     * </p>
     *
     * @param enterStandbyRequest Container for the necessary parameters to
     *           execute the EnterStandby operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         EnterStandby service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<EnterStandbyResult> enterStandbyAsync(
            final EnterStandbyRequest enterStandbyRequest,
            final AsyncHandler<EnterStandbyRequest, EnterStandbyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<EnterStandbyResult>() {
            public EnterStandbyResult call() throws Exception {
              EnterStandbyResult result;
                try {
                result = enterStandby(enterStandbyRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(enterStandbyRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Describes the available types of lifecycle hooks.
     * </p>
     *
     * @param describeLifecycleHookTypesRequest Container for the necessary
     *           parameters to execute the DescribeLifecycleHookTypes operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLifecycleHookTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLifecycleHookTypesResult> describeLifecycleHookTypesAsync(final DescribeLifecycleHookTypesRequest describeLifecycleHookTypesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLifecycleHookTypesResult>() {
            public DescribeLifecycleHookTypesResult call() throws Exception {
                return describeLifecycleHookTypes(describeLifecycleHookTypesRequest);
        }
    });
    }

    /**
     * <p>
     * Describes the available types of lifecycle hooks.
     * </p>
     *
     * @param describeLifecycleHookTypesRequest Container for the necessary
     *           parameters to execute the DescribeLifecycleHookTypes operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLifecycleHookTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLifecycleHookTypesResult> describeLifecycleHookTypesAsync(
            final DescribeLifecycleHookTypesRequest describeLifecycleHookTypesRequest,
            final AsyncHandler<DescribeLifecycleHookTypesRequest, DescribeLifecycleHookTypesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLifecycleHookTypesResult>() {
            public DescribeLifecycleHookTypesResult call() throws Exception {
              DescribeLifecycleHookTypesResult result;
                try {
                result = describeLifecycleHookTypes(describeLifecycleHookTypesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeLifecycleHookTypesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Deletes the specified Auto Scaling group if the group has no
     * instances and no scaling activities in progress.
     * </p>
     * <p>
     * <b>NOTE:</b> To remove all instances before calling
     * DeleteAutoScalingGroup, you can call UpdateAutoScalingGroup to set the
     * minimum and maximum size of the AutoScalingGroup to zero.
     * </p>
     *
     * @param deleteAutoScalingGroupRequest Container for the necessary
     *           parameters to execute the DeleteAutoScalingGroup operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAutoScalingGroupAsync(final DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteAutoScalingGroup(deleteAutoScalingGroupRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Deletes the specified Auto Scaling group if the group has no
     * instances and no scaling activities in progress.
     * </p>
     * <p>
     * <b>NOTE:</b> To remove all instances before calling
     * DeleteAutoScalingGroup, you can call UpdateAutoScalingGroup to set the
     * minimum and maximum size of the AutoScalingGroup to zero.
     * </p>
     *
     * @param deleteAutoScalingGroupRequest Container for the necessary
     *           parameters to execute the DeleteAutoScalingGroup operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteAutoScalingGroupAsync(
            final DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest,
            final AsyncHandler<DeleteAutoScalingGroupRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                deleteAutoScalingGroup(deleteAutoScalingGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(deleteAutoScalingGroupRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Disables monitoring of group metrics for the Auto Scaling group
     * specified in <code>AutoScalingGroupName</code> . You can specify the
     * list of affected metrics with the <code>Metrics</code> parameter.
     * </p>
     *
     * @param disableMetricsCollectionRequest Container for the necessary
     *           parameters to execute the DisableMetricsCollection operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DisableMetricsCollection service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> disableMetricsCollectionAsync(final DisableMetricsCollectionRequest disableMetricsCollectionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disableMetricsCollection(disableMetricsCollectionRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Disables monitoring of group metrics for the Auto Scaling group
     * specified in <code>AutoScalingGroupName</code> . You can specify the
     * list of affected metrics with the <code>Metrics</code> parameter.
     * </p>
     *
     * @param disableMetricsCollectionRequest Container for the necessary
     *           parameters to execute the DisableMetricsCollection operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DisableMetricsCollection service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> disableMetricsCollectionAsync(
            final DisableMetricsCollectionRequest disableMetricsCollectionRequest,
            final AsyncHandler<DisableMetricsCollectionRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                disableMetricsCollection(disableMetricsCollectionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(disableMetricsCollectionRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Updates the configuration for the specified AutoScalingGroup.
     * </p>
     * <p>
     * <b>NOTE:</b> To update an Auto Scaling group with a launch
     * configuration that has the InstanceMonitoring flag set to False, you
     * must first ensure that collection of group metrics is disabled.
     * Otherwise, calls to UpdateAutoScalingGroup will fail. If you have
     * previously enabled group metrics collection, you can disable
     * collection of all group metrics by calling DisableMetricsCollection.
     * </p>
     * <p>
     * The new settings are registered upon the completion of this call. Any
     * launch configuration settings take effect on any triggers after this
     * call returns. Scaling activities that are currently in progress aren't
     * affected.
     * </p>
     * <p>
     * <b>NOTE:</b> If a new value is specified for MinSize without
     * specifying the value for DesiredCapacity, and if the new MinSize is
     * larger than the current size of the Auto Scaling Group, there will be
     * an implicit call to SetDesiredCapacity to set the group to the new
     * MinSize. If a new value is specified for MaxSize without specifying
     * the value for DesiredCapacity, and the new MaxSize is smaller than the
     * current size of the Auto Scaling Group, there will be an implicit call
     * to SetDesiredCapacity to set the group to the new MaxSize. All other
     * optional parameters are left unchanged if not passed in the request.
     * </p>
     *
     * @param updateAutoScalingGroupRequest Container for the necessary
     *           parameters to execute the UpdateAutoScalingGroup operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAutoScalingGroupAsync(final UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateAutoScalingGroup(updateAutoScalingGroupRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Updates the configuration for the specified AutoScalingGroup.
     * </p>
     * <p>
     * <b>NOTE:</b> To update an Auto Scaling group with a launch
     * configuration that has the InstanceMonitoring flag set to False, you
     * must first ensure that collection of group metrics is disabled.
     * Otherwise, calls to UpdateAutoScalingGroup will fail. If you have
     * previously enabled group metrics collection, you can disable
     * collection of all group metrics by calling DisableMetricsCollection.
     * </p>
     * <p>
     * The new settings are registered upon the completion of this call. Any
     * launch configuration settings take effect on any triggers after this
     * call returns. Scaling activities that are currently in progress aren't
     * affected.
     * </p>
     * <p>
     * <b>NOTE:</b> If a new value is specified for MinSize without
     * specifying the value for DesiredCapacity, and if the new MinSize is
     * larger than the current size of the Auto Scaling Group, there will be
     * an implicit call to SetDesiredCapacity to set the group to the new
     * MinSize. If a new value is specified for MaxSize without specifying
     * the value for DesiredCapacity, and the new MaxSize is smaller than the
     * current size of the Auto Scaling Group, there will be an implicit call
     * to SetDesiredCapacity to set the group to the new MaxSize. All other
     * optional parameters are left unchanged if not passed in the request.
     * </p>
     *
     * @param updateAutoScalingGroupRequest Container for the necessary
     *           parameters to execute the UpdateAutoScalingGroup operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         UpdateAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> updateAutoScalingGroupAsync(
            final UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest,
            final AsyncHandler<UpdateAutoScalingGroupRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                updateAutoScalingGroup(updateAutoScalingGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(updateAutoScalingGroupRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns a full description of the launch configurations, or the
     * specified launch configurations, if they exist.
     * </p>
     * <p>
     * If no name is specified, then the full details of all launch
     * configurations are returned.
     * </p>
     *
     * @param describeLaunchConfigurationsRequest Container for the necessary
     *           parameters to execute the DescribeLaunchConfigurations operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLaunchConfigurations service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLaunchConfigurationsResult> describeLaunchConfigurationsAsync(final DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLaunchConfigurationsResult>() {
            public DescribeLaunchConfigurationsResult call() throws Exception {
                return describeLaunchConfigurations(describeLaunchConfigurationsRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a full description of the launch configurations, or the
     * specified launch configurations, if they exist.
     * </p>
     * <p>
     * If no name is specified, then the full details of all launch
     * configurations are returned.
     * </p>
     *
     * @param describeLaunchConfigurationsRequest Container for the necessary
     *           parameters to execute the DescribeLaunchConfigurations operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLaunchConfigurations service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLaunchConfigurationsResult> describeLaunchConfigurationsAsync(
            final DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest,
            final AsyncHandler<DescribeLaunchConfigurationsRequest, DescribeLaunchConfigurationsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLaunchConfigurationsResult>() {
            public DescribeLaunchConfigurationsResult call() throws Exception {
              DescribeLaunchConfigurationsResult result;
                try {
                result = describeLaunchConfigurations(describeLaunchConfigurationsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeLaunchConfigurationsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Returns policy adjustment types for use in the PutScalingPolicy
     * action.
     * </p>
     *
     * @param describeAdjustmentTypesRequest Container for the necessary
     *           parameters to execute the DescribeAdjustmentTypes operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAdjustmentTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAdjustmentTypesResult> describeAdjustmentTypesAsync(final DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAdjustmentTypesResult>() {
            public DescribeAdjustmentTypesResult call() throws Exception {
                return describeAdjustmentTypes(describeAdjustmentTypesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns policy adjustment types for use in the PutScalingPolicy
     * action.
     * </p>
     *
     * @param describeAdjustmentTypesRequest Container for the necessary
     *           parameters to execute the DescribeAdjustmentTypes operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeAdjustmentTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeAdjustmentTypesResult> describeAdjustmentTypesAsync(
            final DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest,
            final AsyncHandler<DescribeAdjustmentTypesRequest, DescribeAdjustmentTypesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAdjustmentTypesResult>() {
            public DescribeAdjustmentTypesResult call() throws Exception {
              DescribeAdjustmentTypesResult result;
                try {
                result = describeAdjustmentTypes(describeAdjustmentTypesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeAdjustmentTypesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Lists all the actions scheduled for your Auto Scaling group that
     * haven't been executed. To see a list of actions already executed, see
     * the activity record returned in DescribeScalingActivities.
     * </p>
     *
     * @param describeScheduledActionsRequest Container for the necessary
     *           parameters to execute the DescribeScheduledActions operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeScheduledActions service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeScheduledActionsResult> describeScheduledActionsAsync(final DescribeScheduledActionsRequest describeScheduledActionsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeScheduledActionsResult>() {
            public DescribeScheduledActionsResult call() throws Exception {
                return describeScheduledActions(describeScheduledActionsRequest);
        }
    });
    }

    /**
     * <p>
     * Lists all the actions scheduled for your Auto Scaling group that
     * haven't been executed. To see a list of actions already executed, see
     * the activity record returned in DescribeScalingActivities.
     * </p>
     *
     * @param describeScheduledActionsRequest Container for the necessary
     *           parameters to execute the DescribeScheduledActions operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeScheduledActions service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeScheduledActionsResult> describeScheduledActionsAsync(
            final DescribeScheduledActionsRequest describeScheduledActionsRequest,
            final AsyncHandler<DescribeScheduledActionsRequest, DescribeScheduledActionsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeScheduledActionsResult>() {
            public DescribeScheduledActionsResult call() throws Exception {
              DescribeScheduledActionsResult result;
                try {
                result = describeScheduledActions(describeScheduledActionsRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeScheduledActionsRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Records a heartbeat for the lifecycle action associated with a
     * specific token. This extends the timeout by the length of time defined
     * by the <code>HeartbeatTimeout</code> parameter of the PutLifecycleHook
     * operation.
     * </p>
     * <p>
     * This operation is a part of the basic sequence for adding a lifecycle
     * hook to an Auto Scaling group:
     * </p>
     * <ol> <li> Create a notification target. A target can be either an
     * Amazon SQS queue or an Amazon SNS topic. </li>
     * <li> Create an IAM role. This role allows Auto Scaling to publish
     * lifecycle notifications to the designated SQS queue or SNS topic.
     * </li>
     * <li> Create the lifecycle hook. You can create a hook that acts when
     * instances launch or when instances terminate. </li>
     * <li> <b>If necessary, record the lifecycle action heartbeat to keep
     * the instance in a pending state.</b> </li>
     * <li> Complete the lifecycle action. </li>
     * </ol> <p>
     * To learn more, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingPendingState.html"> Auto Scaling Pending State </a> and <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingTerminatingState.html"> Auto Scaling Terminating State </a>
     * .
     * </p>
     *
     * @param recordLifecycleActionHeartbeatRequest Container for the
     *           necessary parameters to execute the RecordLifecycleActionHeartbeat
     *           operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         RecordLifecycleActionHeartbeat service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<RecordLifecycleActionHeartbeatResult> recordLifecycleActionHeartbeatAsync(final RecordLifecycleActionHeartbeatRequest recordLifecycleActionHeartbeatRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<RecordLifecycleActionHeartbeatResult>() {
            public RecordLifecycleActionHeartbeatResult call() throws Exception {
                return recordLifecycleActionHeartbeat(recordLifecycleActionHeartbeatRequest);
        }
    });
    }

    /**
     * <p>
     * Records a heartbeat for the lifecycle action associated with a
     * specific token. This extends the timeout by the length of time defined
     * by the <code>HeartbeatTimeout</code> parameter of the PutLifecycleHook
     * operation.
     * </p>
     * <p>
     * This operation is a part of the basic sequence for adding a lifecycle
     * hook to an Auto Scaling group:
     * </p>
     * <ol> <li> Create a notification target. A target can be either an
     * Amazon SQS queue or an Amazon SNS topic. </li>
     * <li> Create an IAM role. This role allows Auto Scaling to publish
     * lifecycle notifications to the designated SQS queue or SNS topic.
     * </li>
     * <li> Create the lifecycle hook. You can create a hook that acts when
     * instances launch or when instances terminate. </li>
     * <li> <b>If necessary, record the lifecycle action heartbeat to keep
     * the instance in a pending state.</b> </li>
     * <li> Complete the lifecycle action. </li>
     * </ol> <p>
     * To learn more, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingPendingState.html"> Auto Scaling Pending State </a> and <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingTerminatingState.html"> Auto Scaling Terminating State </a>
     * .
     * </p>
     *
     * @param recordLifecycleActionHeartbeatRequest Container for the
     *           necessary parameters to execute the RecordLifecycleActionHeartbeat
     *           operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         RecordLifecycleActionHeartbeat service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<RecordLifecycleActionHeartbeatResult> recordLifecycleActionHeartbeatAsync(
            final RecordLifecycleActionHeartbeatRequest recordLifecycleActionHeartbeatRequest,
            final AsyncHandler<RecordLifecycleActionHeartbeatRequest, RecordLifecycleActionHeartbeatResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<RecordLifecycleActionHeartbeatResult>() {
            public RecordLifecycleActionHeartbeatResult call() throws Exception {
              RecordLifecycleActionHeartbeatResult result;
                try {
                result = recordLifecycleActionHeartbeat(recordLifecycleActionHeartbeatRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(recordLifecycleActionHeartbeatRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Creates or updates a scheduled scaling action for an Auto Scaling
     * group. When updating a scheduled scaling action, if you leave a
     * parameter unspecified, the corresponding value remains unchanged in
     * the affected Auto Scaling group.
     * </p>
     * <p>
     * For information on creating or updating a scheduled action for your
     * Auto Scaling group, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/schedule_time.html"> Scale Based on a Schedule </a>
     * .
     * </p>
     * <p>
     * <b>NOTE:</b> Auto Scaling supports the date and time expressed in
     * "YYYY-MM-DDThh:mm:ssZ" format in UTC/GMT only.
     * </p>
     *
     * @param putScheduledUpdateGroupActionRequest Container for the
     *           necessary parameters to execute the PutScheduledUpdateGroupAction
     *           operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         PutScheduledUpdateGroupAction service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putScheduledUpdateGroupActionAsync(final PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                putScheduledUpdateGroupAction(putScheduledUpdateGroupActionRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Creates or updates a scheduled scaling action for an Auto Scaling
     * group. When updating a scheduled scaling action, if you leave a
     * parameter unspecified, the corresponding value remains unchanged in
     * the affected Auto Scaling group.
     * </p>
     * <p>
     * For information on creating or updating a scheduled action for your
     * Auto Scaling group, see
     * <a href="http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/schedule_time.html"> Scale Based on a Schedule </a>
     * .
     * </p>
     * <p>
     * <b>NOTE:</b> Auto Scaling supports the date and time expressed in
     * "YYYY-MM-DDThh:mm:ssZ" format in UTC/GMT only.
     * </p>
     *
     * @param putScheduledUpdateGroupActionRequest Container for the
     *           necessary parameters to execute the PutScheduledUpdateGroupAction
     *           operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         PutScheduledUpdateGroupAction service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> putScheduledUpdateGroupActionAsync(
            final PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest,
            final AsyncHandler<PutScheduledUpdateGroupActionRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                putScheduledUpdateGroupAction(putScheduledUpdateGroupActionRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(putScheduledUpdateGroupActionRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Returns a list of metrics and a corresponding list of granularities
     * for each metric.
     * </p>
     * <p>
     * <b>NOTE:</b> The GroupStandbyInstances metric is not returned by
     * default. You must explicitly request it when calling
     * EnableMetricsCollection.
     * </p>
     *
     * @param describeMetricCollectionTypesRequest Container for the
     *           necessary parameters to execute the DescribeMetricCollectionTypes
     *           operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeMetricCollectionTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeMetricCollectionTypesResult> describeMetricCollectionTypesAsync(final DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeMetricCollectionTypesResult>() {
            public DescribeMetricCollectionTypesResult call() throws Exception {
                return describeMetricCollectionTypes(describeMetricCollectionTypesRequest);
        }
    });
    }

    /**
     * <p>
     * Returns a list of metrics and a corresponding list of granularities
     * for each metric.
     * </p>
     * <p>
     * <b>NOTE:</b> The GroupStandbyInstances metric is not returned by
     * default. You must explicitly request it when calling
     * EnableMetricsCollection.
     * </p>
     *
     * @param describeMetricCollectionTypesRequest Container for the
     *           necessary parameters to execute the DescribeMetricCollectionTypes
     *           operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeMetricCollectionTypes service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeMetricCollectionTypesResult> describeMetricCollectionTypesAsync(
            final DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest,
            final AsyncHandler<DescribeMetricCollectionTypesRequest, DescribeMetricCollectionTypesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeMetricCollectionTypesResult>() {
            public DescribeMetricCollectionTypesResult call() throws Exception {
              DescribeMetricCollectionTypesResult result;
                try {
                result = describeMetricCollectionTypes(describeMetricCollectionTypesRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(describeMetricCollectionTypesRequest, result);
                 return result;
        }
    });
    }
    
    /**
     * <p>
     * Sets the desired size of the specified AutoScalingGroup.
     * </p>
     *
     * @param setDesiredCapacityRequest Container for the necessary
     *           parameters to execute the SetDesiredCapacity operation on
     *           AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         SetDesiredCapacity service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setDesiredCapacityAsync(final SetDesiredCapacityRequest setDesiredCapacityRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                setDesiredCapacity(setDesiredCapacityRequest);
                return null;
        }
    });
    }

    /**
     * <p>
     * Sets the desired size of the specified AutoScalingGroup.
     * </p>
     *
     * @param setDesiredCapacityRequest Container for the necessary
     *           parameters to execute the SetDesiredCapacity operation on
     *           AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SetDesiredCapacity service method, as returned by AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setDesiredCapacityAsync(
            final SetDesiredCapacityRequest setDesiredCapacityRequest,
            final AsyncHandler<SetDesiredCapacityRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
              try {
                setDesiredCapacity(setDesiredCapacityRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(setDesiredCapacityRequest, null);
                 return null;
        }
    });
    }
    
    /**
     * <p>
     * Terminates the specified instance. Optionally, the desired group size
     * can be adjusted.
     * </p>
     * <p>
     * <b>NOTE:</b> This call simply registers a termination request. The
     * termination of the instance cannot happen immediately.
     * </p>
     *
     * @param terminateInstanceInAutoScalingGroupRequest Container for the
     *           necessary parameters to execute the
     *           TerminateInstanceInAutoScalingGroup operation on AmazonAutoScaling.
     * 
     * @return A Java Future object containing the response from the
     *         TerminateInstanceInAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<TerminateInstanceInAutoScalingGroupResult> terminateInstanceInAutoScalingGroupAsync(final TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<TerminateInstanceInAutoScalingGroupResult>() {
            public TerminateInstanceInAutoScalingGroupResult call() throws Exception {
                return terminateInstanceInAutoScalingGroup(terminateInstanceInAutoScalingGroupRequest);
        }
    });
    }

    /**
     * <p>
     * Terminates the specified instance. Optionally, the desired group size
     * can be adjusted.
     * </p>
     * <p>
     * <b>NOTE:</b> This call simply registers a termination request. The
     * termination of the instance cannot happen immediately.
     * </p>
     *
     * @param terminateInstanceInAutoScalingGroupRequest Container for the
     *           necessary parameters to execute the
     *           TerminateInstanceInAutoScalingGroup operation on AmazonAutoScaling.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         TerminateInstanceInAutoScalingGroup service method, as returned by
     *         AmazonAutoScaling.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonAutoScaling indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<TerminateInstanceInAutoScalingGroupResult> terminateInstanceInAutoScalingGroupAsync(
            final TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest,
            final AsyncHandler<TerminateInstanceInAutoScalingGroupRequest, TerminateInstanceInAutoScalingGroupResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<TerminateInstanceInAutoScalingGroupResult>() {
            public TerminateInstanceInAutoScalingGroupResult call() throws Exception {
              TerminateInstanceInAutoScalingGroupResult result;
                try {
                result = terminateInstanceInAutoScalingGroup(terminateInstanceInAutoScalingGroupRequest);
              } catch (Exception ex) {
                  asyncHandler.onError(ex);
            throw ex;
              }
              asyncHandler.onSuccess(terminateInstanceInAutoScalingGroupRequest, result);
                 return result;
        }
    });
    }
    
}
        