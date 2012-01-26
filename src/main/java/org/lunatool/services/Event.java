/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import java.util.List;
import java.util.Map;

/**
 *
 * @author denis.bardadym
 */
public interface Event {
    Map<String, Map<String, String>> allHeaders();
    
    List<String> services();
    
    Map<String, String> headersFor(String service);
}
