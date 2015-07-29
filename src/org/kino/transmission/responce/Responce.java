/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.responce;

import com.google.gson.Gson;

/**
 *
 * @author kirio
 */
public class Responce<T> {
    
    public String tag;
    public String result;
    public T arguments;

    @Override
    public String toString() {
        return "Responce{" + "tag=" + tag + ", result=" + result + ", arguments=" + arguments + '}';
    }
    
   
    
    
}
