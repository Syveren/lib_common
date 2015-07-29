/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.responce;

 
import com.google.gson.annotations.SerializedName;
import org.kino.transmission.responce.SessionStatsResponce.Arguments;

/**
 *
 * @author kirio
 */
public class SessionStatsResponce extends  Responce<Arguments>  {
   // SessionStatsResponce
    
    
    
    public static class CumulativeStats
    {
            public Long uploadedBytes;
            public Long downloadedBytes;
            public Long filesAdded;
            public Long sessionCount;
            public Long secondsActive;

            @Override
            public String toString() {
                return "CumulativeStats{" + "uploadedBytes=" + uploadedBytes + ", downloadedBytes=" + downloadedBytes + ", filesAdded=" + filesAdded + ", sessionCount=" + sessionCount + ", secondsActive=" + secondsActive + '}';
            }
            
    }
    
    
    public static class CurrentStats{
        
            public Long uploadedBytes;
            public Long downloadedBytes;
            public Long filesAdded;
            public Long sessionCount;
            public Long secondsActive;

        @Override
        public String toString() {
            return "CurrentStats{" + "uploadedBytes=" + uploadedBytes + ", downloadedBytes=" + downloadedBytes + ", filesAdded=" + filesAdded + ", sessionCount=" + sessionCount + ", secondsActive=" + secondsActive + '}';
        }
            
    
    }
    public static class Arguments {
            public Long activeTorrentCount;
            public Long downloadSpeed;
            public Long pausedTorrentCount;
            public Long torrentCount;
            public Long uploadSpeed;
            @SerializedName("cumulative-stats")
            public CumulativeStats cumulativeStats;

            @SerializedName("current-stats")
            public CurrentStats currentStats;

        @Override
        public String toString() {
            return "Arguments{" + "activeTorrentCount=" + activeTorrentCount + ", downloadSpeed=" + downloadSpeed + ", pausedTorrentCount=" + pausedTorrentCount + ", torrentCount=" + torrentCount + ", uploadSpeed=" + uploadSpeed + ", cumulativeStats=" + cumulativeStats + ", currentStats=" + currentStats + '}';
        }
            
    }
    
 
 

   
    
    
  
}
