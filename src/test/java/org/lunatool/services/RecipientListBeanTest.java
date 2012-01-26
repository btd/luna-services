/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author denis.bardadym
 */
public class RecipientListBeanTest {

    /**
     * Test of processAdditionalHeaders method, of class RecipientListBean.
     */
    @Test
    public void testProcessAdditionalHeaders() {
        Map<String, Map<String, String>> additionalHeaders = new HashMap<String, Map<String, String>>();

        Map<String, String> mailHeaders = new HashMap<String, String>();
        mailHeaders.put("To", "Claus Ibsen <davsclaus@apache.org>");
        mailHeaders.put("From", "James Strachan <jstrachan@apache.org>");
        mailHeaders.put("Subject", "Camel is cool");
        additionalHeaders.put("mail", mailHeaders);

        PushEvent body = new PushEvent();
        body.setServices(Arrays.asList("mail"));
        body.setAdditionalHeaders(additionalHeaders);

        Map<String, Object> headers = new HashMap<String, Object>();
        RecipientListBean instance = new RecipientListBean();
        instance.processAdditionalHeaders(body, headers);
        
        assertEquals(headers.get("recipientList"), Arrays.asList("seda:mailOutput"));
        assertEquals(headers.get("To"), "Claus Ibsen <davsclaus@apache.org>");
        assertEquals(headers.get("From"), "James Strachan <jstrachan@apache.org>");
        assertEquals(headers.get("Subject"), "Camel is cool");
    }
}
