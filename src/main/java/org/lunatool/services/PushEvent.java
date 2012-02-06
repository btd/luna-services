/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author denis.bardadym
 */
public class PushEvent implements Event {

    private List<String> newBranches = new ArrayList<String>();
    private List<String> deletedBranches = new ArrayList<String>();

    private Map<String, List<Commit>> changedHistory = new HashMap<String, List<Commit>>();
    private User gitPusher; //this is information from JGit
    private Map<String, Map<String, String>> services = new HashMap<String, Map<String, String>>();
    
    private Repository repository;


    public PushEvent() {
    }

    public Map<String, List<Commit>> getChangedHistory() {
        return changedHistory;
    }

    public void setChangedHistory(Map<String, List<Commit>> changedHistory) {
        this.changedHistory = changedHistory;
    }

    public List<String> getDeletedBranches() {
        return deletedBranches;
    }

    public void setDeletedBranches(List<String> deletedBranches) {
        this.deletedBranches = deletedBranches;
    }

    public User getGitPusher() {
        return gitPusher;
    }

    public void setGitPusher(User gitPusher) {
        this.gitPusher = gitPusher;
    }

    public List<String> getNewBranches() {
        return newBranches;
    }

    public void setNewBranches(List<String> newBranches) {
        this.newBranches = newBranches;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Map<String, Map<String, String>> getServices() {
        return services;
    }

    public void setServices(Map<String, Map<String, String>> services) {
        this.services = services;
    }

    
  
    @Override
    public Map<String, Map<String, String>> services() {
        return services;
    }


    @Override
    public Map<String, String> headersFor(String service) {
        return services().get(service);
    }
    
    
}
