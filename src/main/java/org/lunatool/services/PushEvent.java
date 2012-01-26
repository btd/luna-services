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

    private List<String> services = new ArrayList<String>();
    private List<Commit> commits = new ArrayList<Commit>();
    private User gitPusher; //this is information from JGit
    private Map<String, Map<String, String>> additionalHeaders = new HashMap<String, Map<String, String>>();
    
    private Repository repository;
    private User pusher;//this is from DB

    public PushEvent() {
    }

    public Map<String, Map<String, String>> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public void setAdditionalHeaders(Map<String, Map<String, String>> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    public User getGitPusher() {
        return gitPusher;
    }

    public void setGitPusher(User gitPusher) {
        this.gitPusher = gitPusher;
    }

    public User getPusher() {
        return pusher;
    }

    public void setPusher(User pusher) {
        this.pusher = pusher;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "PushEvent{" + "services=" + services + ", commits=" + commits + ", gitPusher=" + gitPusher + ", additionalHeaders=" + additionalHeaders + ", repository=" + repository + ", pusher=" + pusher + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PushEvent other = (PushEvent) obj;
        if (this.services != other.services && (this.services == null || !this.services.equals(other.services))) {
            return false;
        }
        if (this.commits != other.commits && (this.commits == null || !this.commits.equals(other.commits))) {
            return false;
        }
        if (this.gitPusher != other.gitPusher && (this.gitPusher == null || !this.gitPusher.equals(other.gitPusher))) {
            return false;
        }
        if (this.additionalHeaders != other.additionalHeaders && (this.additionalHeaders == null || !this.additionalHeaders.equals(other.additionalHeaders))) {
            return false;
        }
        if (this.repository != other.repository && (this.repository == null || !this.repository.equals(other.repository))) {
            return false;
        }
        if (this.pusher != other.pusher && (this.pusher == null || !this.pusher.equals(other.pusher))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.services != null ? this.services.hashCode() : 0);
        hash = 97 * hash + (this.commits != null ? this.commits.hashCode() : 0);
        hash = 97 * hash + (this.gitPusher != null ? this.gitPusher.hashCode() : 0);
        hash = 97 * hash + (this.additionalHeaders != null ? this.additionalHeaders.hashCode() : 0);
        hash = 97 * hash + (this.repository != null ? this.repository.hashCode() : 0);
        hash = 97 * hash + (this.pusher != null ? this.pusher.hashCode() : 0);
        return hash;
    }

    @Override
    public Map<String, Map<String, String>> allHeaders() {
        return additionalHeaders;
    }

    @Override
    public List<String> services() {
        return services;
    }

    @Override
    public Map<String, String> headersFor(String service) {
        return allHeaders().get(service);
    }
    
    
}
