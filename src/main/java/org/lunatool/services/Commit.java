/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import org.joda.time.DateTime;

/**
 *
 * @author denis.bardadym
 */
public class Commit {
    private String message;
    
    private User author;
    
    private DateTime date;

    public Commit() {
    }

    public Commit(String message, User author) {
        this.message = message;
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commit other = (Commit) obj;
        if ((this.message == null) ? (other.message != null) : !this.message.equals(other.message)) {
            return false;
        }
        if (this.author != other.author && (this.author == null || !this.author.equals(other.author))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.message != null ? this.message.hashCode() : 0);
        hash = 79 * hash + (this.author != null ? this.author.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Commit{" + "message=" + message + ", author=" + author + '}';
    }
    
    
}
