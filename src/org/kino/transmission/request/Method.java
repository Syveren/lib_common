/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.request;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author kirio
 */
public class Method {
    String method;
    Object arguments;
    Long tag;
    public Method(String method, Object arguments) {
        this.method = method;
        this.arguments = arguments;
        this.tag = tag_auto.incrementAndGet();
    }
    
    final static private AtomicLong tag_auto = new AtomicLong(0);
    public Method setTag(Long tag){
        this.tag = tag;
        return this;
    
    }
    
}
