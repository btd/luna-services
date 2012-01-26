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

/**
 *
 * @author denis.bardadym
 */
public class RecipientListBean {

    public void processAdditionalHeaders(@Body Event body, @Headers Map<String, Object> headers) {
        List<String> recipientList = new ArrayList<String>();
        for (String serviceName: body.services()) {
            recipientList.add("seda:" + serviceName + "Output");
            headers.putAll(body.headersFor(serviceName));//in common it is bad, but for first version it is ok, replace this later
        }
        headers.put("recipientList", recipientList);
    }
}
