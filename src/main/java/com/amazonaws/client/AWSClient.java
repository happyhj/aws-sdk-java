package com.amazonaws.client;

import java.net.URI;

import com.amazonaws.client.handler.request.RequestHandler;
import com.amazonaws.client.handler.request.RequestHandler2;
import com.amazonaws.client.service.AmazonWebServiceClient;
import com.amazonaws.network.metricscollector.RequestMetricCollector;

public interface AWSClient {

    /**
     * Overrides the default endpoint for this client. Callers can use this
     * method to control which AWS region they want to work with.
     * <p>
     * <b>This method is not threadsafe. Endpoints should be configured when the
     * client is created and before any service requests are made. Changing it
     * afterwards creates inevitable race conditions for any service requests in
     * transit.</b>
     * <p>
     * Callers can pass in just the endpoint (ex: "ec2.amazonaws.com") or a full
     * URL, including the protocol (ex: "https://ec2.amazonaws.com"). If the
     * protocol is not specified here, the default protocol from this client's
     * {@link ClientConfiguration} will be used, which by default is HTTPS.
     * <p>
     * For more information on using AWS regions with the AWS SDK for Java, and
     * a complete list of all available endpoints for all AWS services, see:
     * <a href="http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912">
     * http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912</a>
     *
     * @param endpoint
     *            The endpoint (ex: "ec2.amazonaws.com") or a full URL,
     *            including the protocol (ex: "https://ec2.amazonaws.com") of
     *            the region specific AWS endpoint this client will communicate
     *            with.
     * @throws IllegalArgumentException
     *             If any problems are detected with the specified endpoint.
     */
    public void setEndpoint(String endpoint) throws IllegalArgumentException;

    /**
     * An internal method that is not expected to be normally
     * called except for AWS internal development purposes.
     * <p>
     * Overrides the default endpoint for this client
     * ("http://dynamodb.us-east-1.amazonaws.com/") and explicitly provides an
     * AWS region ID and AWS service name to use when the client calculates a
     * signature for requests. In almost all cases, this region ID and service
     * name are automatically determined from the endpoint, and callers should
     * use the simpler one-argument form of setEndpoint instead of this method.
     * <p>
     * Callers can pass in just the endpoint (ex:
     * "dynamodb.us-east-1.amazonaws.com/") or a full URL, including the
     * protocol (ex: "http://dynamodb.us-east-1.amazonaws.com/"). If the
     * protocol is not specified here, the default protocol from this client's
     * {@link ClientConfiguration} will be used, which by default is HTTPS.
     * <p>
     * For more information on using AWS regions with the AWS SDK for Java, and
     * a complete list of all available endpoints for all AWS services, see: <a
     * href=
     * "http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912"
     * > http://developer.amazonwebservices.com/connect/entry.jspa?externalID=
     * 3912</a>
     *
     * @param endpoint
     *            The endpoint (ex: "dynamodb.us-east-1.amazonaws.com/") or a
     *            full URL, including the protocol (ex:
     *            "http://dynamodb.us-east-1.amazonaws.com/") of the region
     *            specific AWS endpoint this client will communicate with.
     * @param serviceName
     *            This parameter is ignored.
     * @param regionId
     *            The ID of the region in which this service resides AND the
     *            overriding region for signing purposes.
     *
     * @throws IllegalArgumentException
     *             If any problems are detected with the specified endpoint.
     * @deprecated
     */
    @Deprecated
    public void setEndpoint(String endpoint, String serviceName, String regionId);


    /**
     * Returns the signer based on the given URI and the current AWS client
     * configuration. Currently only the SQS client can have different region on
     * a per request basis. For other AWS clients, the region remains the same
     * on a per AWS client level.
     * <p>
     * Note, however, the signer returned for S3 is incomplete at this stage as
     * the information on the S3 bucket and key is not yet known.
     */
    public Signer getSignerByURI(URI uri);

    /**
     * An alternative to {@link AmazonWebServiceClient#setEndpoint(String)}, sets the
     * regional endpoint for this client's service calls. Callers can use this
     * method to control which AWS region they want to work with.
     * <p>
     * <b>This method is not threadsafe. A region should be configured when the
     * client is created and before any service requests are made. Changing it
     * afterwards creates inevitable race conditions for any service requests in
     * transit or retrying.</b>
     * <p>
     * By default, all service endpoints in all regions use the https protocol.
     * To use http instead, specify it in the {@link ClientConfiguration}
     * supplied at construction.
     *
     * @param region
     *            The region this client will communicate with. See
     *            {@link Region#getRegion(com.amazonaws.client.regions.Regions)} for
     *            accessing a given region.
     * @throws java.lang.IllegalArgumentException
     *             If the given region is null, or if this service isn't
     *             available in the given region. See
     *             {@link Region#isServiceSupported(String)}
     * @see Region#getRegion(com.amazonaws.client.regions.Regions)
     * @see Region#createClient(Class, com.amazonaws.auth.AWSCredentialsProvider, ClientConfiguration)
     */
    public void setRegion(Region region) throws IllegalArgumentException;

    /**
     * @deprecated by client configuration via the constructor.
     * This method will be removed later on.
     */
    @Deprecated
    public void setConfiguration(ClientConfiguration clientConfiguration);

    /**
     * Shuts down this client object, releasing any resources that might be held
     * open. This is an optional method, and callers are not expected to call
     * it, but can if they want to explicitly release any open resources. Once a
     * client has been shutdown, it should not be used to make any more
     * requests.
     */
    public void shutdown();

    /**
     * @deprecated by {@link #addRequestHandler(RequestHandler2)}.
     *
     * Appends a request handler to the list of registered handlers that are run
     * as part of a request's lifecycle.
     *
     * @param requestHandler
     *            The new handler to add to the current list of request
     *            handlers.
     */
    @Deprecated
    public void addRequestHandler(RequestHandler requestHandler);

    /**
     * Appends a request handler to the list of registered handlers that are run
     * as part of a request's lifecycle.
     *
     * @param requestHandler2
     *            The new handler to add to the current list of request
     *            handlers.
     */
    public void addRequestHandler(RequestHandler2 requestHandler2);

    /**
     * Removes a request handler from the list of registered handlers that are run
     * as part of a request's lifecycle.
     *
     * @param requestHandler
     *            The handler to remove from the current list of request
     *            handlers.
     */
    public void removeRequestHandler(RequestHandler requestHandler);

    public void removeRequestHandler(RequestHandler2 requestHandler2);

    /**
     * Sets the optional value for time offset for this client.  This
     * value will be applied to all requests processed through this client.
     * Value is in seconds, positive values imply the current clock is "fast",
     * negative values imply clock is slow.
     *
     * @param timeOffset
     *            The optional value for time offset (in seconds) for this client.
     */
    public void setTimeOffset(int timeOffset);

    /**
     * Sets the optional value for time offset for this client.  This
     * value will be applied to all requests processed through this client.
     * Value is in seconds, positive values imply the current clock is "fast",
     * negative values imply clock is slow.
     *
     * @param timeOffset
     *            The optional value for time offset (in seconds) for this client.
     *
     * @return the updated web service client
     */
    public AWSClient withTimeOffset(int timeOffset);
//    public AmazonWebServiceClient withTimeOffset(int timeOffset);

    /**
     * Returns the optional value for time offset for this client.  This
     * value will be applied to all requests processed through this client.
     * Value is in seconds, positive values imply the current clock is "fast",
     * negative values imply clock is slow.
     *
     * @return The optional value for time offset (in seconds) for this client.
     */
    public int getTimeOffset();

    /**
     * Returns the client specific {@link RequestMetricCollector}; or null if
     * there is none.
     */
    public RequestMetricCollector getRequestMetricsCollector();

    /**
     * Returns the service abbreviation for this service, used for identifying
     * service endpoints by region, identifying the necessary signer, etc.
     * Used to be call "getServiceAbbreviation".
     */
    public String getServiceName();

    /**
     * An internal method used to explicitly override the service name
     * computed by the default implementation. This method is not expected to be
     * normally called except for AWS internal development purposes.
     */
    public void setServiceNameIntern(String serviceName);

    /**
     * Returns the signer region override.
     *
     * @see #setSignerRegionOverride(String).
     */
    public String getSignerRegionOverride();

    /**
     * An internal method used to explicitly override the internal signer region
     * computed by the default implementation. This method is not expected to be
     * normally called except for AWS internal development purposes.
     */
    public void setSignerRegionOverride(String signerRegionOverride);
}
