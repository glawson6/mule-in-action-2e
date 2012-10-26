package com.muleinaction.exception;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.transport.NullPayload;

public class ExceptionStrategiesChoiceTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "exception/exception-strategies-choice.xml";
    }

    // TODO
    @Test
    @Ignore("Response doesn't seem to work with JMS")
    public void testCatchStrategy() throws Exception
    {
    	MuleClient muleClient = new MuleClient(muleContext);

    	MuleMessage result = muleClient.send("vm://calculateShippingCost.in", 0, null);

    	assertThat(result.getExceptionPayload(), is(not(instanceOf(NullPayload.class))));
    	System.out.println("XXX" +result.getPayloadAsString());
  }
    
}