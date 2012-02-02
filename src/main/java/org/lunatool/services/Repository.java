/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

/**
 *
 * @author denis.bardadym
 */
public class Repository {
    private String name;

    public Repository(String name) {
        this.name = name;
    }

    public Repository() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Repository other = (Repository) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Repository{" + "name=" + name + '}';
    }
    
    
}
