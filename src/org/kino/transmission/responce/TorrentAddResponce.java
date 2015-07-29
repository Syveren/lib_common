/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.responce;

 
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/**
 *
 * @author kirio
 */
public class TorrentAddResponce  extends  Responce<TorrentAddResponce.Arguments> {
 
         //String t; //"torrent-added" or "torrent-dublicate
    
    
    static public class AddedData{
        public Long id;
        public String name;
        public String hashString;

        @Override
        public String toString() {
            return "{" + "id=" + id + ", name=" + name + ", hashString=" + hashString + '}';
        }
        
    
    }
    
    public static class Arguments {     
         @SerializedName("torrent-duplicate")
         private AddedData torrent_dublicate;
         
         @SerializedName("torrent-added")
         private AddedData torrent_added;
         
        
         public boolean isAddingSuccess(){
            return (torrent_added!=null);
         }
         public AddedData getData(){
             return (isAddingSuccess()? torrent_added:torrent_dublicate);
         
         }
         
        @Override
        public String toString() {
            return  (isAddingSuccess()?"torrent-add:":"torrent-dublicate:")+getData();
        }
    }    
         
 
}
