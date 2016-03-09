package org.mule.ssl.outbound;

import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.AbstractTemplateTest;
import org.mule.scripts.OutboundSSLPostProcessing;
import org.xml.sax.SAXException;

/**
 * tests HTTP URL-based endpoint targeting HTTPS API
 * @author Miroslav Rusin
 *
 */
public class HttpUrlSSLPostProcessingTest extends AbstractTemplateTest {

		
	@Override
	@Before
	public void prepare() throws IOException{
		LOGGER.info("Testing HTTP URL proxy");
		final Properties props = initGatewayParams();    	
    	apiNameId = props.getProperty("httpUrlApiNameId");
    	apiVersionId = props.getProperty("httpUrlApiVersionId");
    	super.deployHTTPS();      	
    	super.prepare();
	}

	@Test
	public void testProcessing() throws IOException, ParserConfigurationException, SAXException, InterruptedException{
		super.testOutboundProcessing(new OutboundSSLPostProcessing());	
		makeTestRequest(HTTP_PROXY_URL);
	}
	
	@Override
	@After
	public void tearDown() throws IOException{
		super.tearDown();
	}
}