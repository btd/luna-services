/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.camel.Body;
import org.apache.camel.Headers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author denis.bardadym
 */
public class RecipientListBean {

	private static final Logger log = LoggerFactory.getLogger(RecipientListBean.class);

    public void processAdditionalHeaders(@Body Event body, @Headers Map<String, Object> headers) {

    	log.debug(body == null ? "null" : body.toString());

    	headers.clear();//XXX

        List<String> recipientList = new ArrayList<String>();
        for (Map.Entry<String, Map<String, String>> serviceEntry : body.services().entrySet()) {
            recipientList.add("seda:" + serviceEntry.getKey() + "Output");
            headers.putAll(serviceEntry.getValue());//in common it is bad, but for first version it is ok, replace this later
        }
        headers.put("recipientList", recipientList);
    }
}
