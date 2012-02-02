/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 *
 * @author denis.bardadym
 */
public class GsonDeserialization extends CamelTestSupport {

    
    

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        
        final GsonDataFormat df = new GsonDataFormat(PushEvent.class.getName());
        
        return new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from("mock:input").unmarshal(df).to("mock:output");
            }
        };
    }
    

    @Test
    public void testMoveFile() throws Exception {
        PushEvent event = new PushEvent();
        
        Map mailHeaders = new HashMap();
        mailHeaders.put("To", "some@example.org");
        
        Map headers = new HashMap();       
        headers.put("mail", mailHeaders);
        
        event.setServices(headers);
        event.setCommits(Arrays.asList(new Commit("Commit message1", new User("user1", "user1@example.org")),
                new Commit("Commit message2", new User("user2", "user2@example.org"))));
        event.setPusher(new User("pusher", "his email"));
        event.setGitPusher(new User("jgit pusher", "other email"));
        event.setRepository(new Repository("repo"));
        
        Gson gson = new Gson();
        
        template.sendBody("mock:input", gson.toJson(event));
        
        Thread.sleep(1000);
        
        MockEndpoint endpoint = this.getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(event);

    }
}
