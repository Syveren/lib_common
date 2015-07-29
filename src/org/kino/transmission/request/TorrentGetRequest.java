/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.request;

/**
 *
 * @author kirio
 */
public class TorrentGetRequest {
    public String[] fields;
    public Long[] ids;  //recently-active string not suppoerted

    public TorrentGetRequest(String[] fields) {
        this.fields = fields;
    }

    public TorrentGetRequest(String[] fields, Long[] ids) {
        this.fields = fields;
        this.ids = ids;
    }
        
}
