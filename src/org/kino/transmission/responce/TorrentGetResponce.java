/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.responce;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import org.kino.transmission.responce.TorrentGetResponce.Arguments;

/**
 *
 * @author kirio
 */

public class TorrentGetResponce  extends  Responce<Arguments> {
 
    /*public static class  TorrentMap  extends HashMap<String, Object> {
        public Long sizeWhenDone;
        public Long id(){
            return double2long((Double)get("id"));
        }
        public Long rateDownload(){
            return double2long((Double)get("rateDownload"));
        }
        
        public Long rateUpload(){
            return double2long((Double)get("rateUpload"));
        }
        
        static private Long double2long(Double val){
            return (val==null?null:val.longValue());
        }
        
        
        public Double percentDone(){
                return (Double)get("percentDone");
        }
    }*/
    
    public static class Torrents {
 public     Long           activityDate            ;//    | number                 ;
 public     Long	   addedDate               ;//    | number                     ;
 public     Long	   bandwidthPriority       ;//    | number     Low (-1), Normal (0) or High (1).            
 public     String	   comment                 ;//    | string     Number of bytes avalable and left to be downloaded.  
 public     Long	   corruptEver             ;//    | number     Number of bytes of corrupt data downloaded.    
 public     String	   creator                 ;//    | string                     ;
 public     Long	   dateCreated             ;//    | number                     ;
 public     Long	   desiredAvailable        ;//    | number                     ;
 public     Long	   doneDate                ;//    | number                     ;
 public     String	   downloadDir             ;//    | string                     ;
 public     Long	   downloadedEver          ;//    | number    Number of bytes of good data downloaded.
 public     Long	   downloadLimit           ;//    | number                     ;
 public     Boolean	   downloadLimited         ;//    | boolean                    ;
 public     Long	   error                   ;//    | number  Kind of error. 0 means OK, 1 means tracker warning, 2 means tracker error, 3 means local error.                   ;
 public     String	   errorString             ;//    | string                     ;
 public     Long	   eta                     ;//    | number  Estimated number of seconds left when downloading or seeding. -1 means not available and -2 means unknown.                   ;
 public     Long	   etaIdle                 ;//    | number                     ;
 public     HashMap<String, Object>[]	   files                   ;//    | array (see below) Aray of file statistics containing bytesCompleted, wanted and priority.        ;
 public     HashMap<String, Object>[]	   fileStats               ;//    | array (see below) Array of file object containing key, bytesCompleted, length and name.        ;
 public     String	   hashString              ;//    | string   Hashstring unique for the torrent even between sessions.                  
 public     Long	   haveUnchecked           ;//    | number   Number of bytes of partial pieces.                   
 public     Long	   haveValid               ;//    | number   Number of bytes of checksum verified data.
 public     Boolean	   honorsSessionLimits     ;//    | boolean  True if session upload limits are honored
 public     Long	   id                      ;//    | number                     ;
 public     Boolean	   isFinished              ;//    | boolean  True if the torrent is finished. Downloaded and seeded.
 public     Boolean	   isPrivate               ;//    | boolean  True if the torrent is private.                ;
 public     Boolean	   isStalled               ;//    | boolean  True if the torrent has stalled (been idle for a long time).                  ;
 public     Long	   leftUntilDone           ;//    | number   Number of bytes left until the download is done
 public     String	   magnetLink              ;//    | string   The magnet link for this torrent.                
 public     Long	   manualAnnounceTime      ;//    | number                     ;
 public     Long	   maxConnectedPeers       ;//    | number                     ;
 public     Double	   metadataPercentComplete ;//    | double   Download progress of metadata. 0.0 to 1.0.
 public     String	   name                    ;//    | string                     ;
 @SerializedName("peer-limit")
 public     Long	   peer_limit              ;//    | number                     ;
 public     HashMap<String, Object>	   peers   ;//    | Array of peer objects.
 public     Long	   peersConnected          ;//    | number  Number of peers we are connected to.
 public     Object	   peersFrom               ;//    | Object containing download peers counts for different peer types.
 public     Long	   peersGettingFromUs      ;//    | Number of peers we are sending data to.
 public     Long	   peersSendingToUs        ;//    | Number of peers sending to us            
 public     Double	   percentDone             ;//    | Download progress of selected files. 0.0 to 1.0.
 public     String	   pieces                  ;//    | String with base64 encoded bitfield indicating finished pieces.
 public     Long	   pieceCount              ;//    | number                     ;
 public     Long	   pieceSize               ;//    | number                     ;f
 public     Long[]	   priorities              ;//    | array (see below)          ;
 public     Long	   queuePosition           ;//    | number                     ;
 public     Long	   rateDownload            ;//    | Download rate in bps.
 public     Long	   rateUpload              ;//    | Upload rate in bps.
 public     Double	   recheckProgress         ;//    | Progress of recheck. 0.0 to 1.0.
 public     Long	   secondsDownloading      ;//    | number                     ;
 public     Long	   secondsSeeding          ;//    | number                     ;
 public     Long	   seedIdleLimit           ;//    | Idle limit in minutes.
 public     Long	   seedIdleMode            ;//    | Use global (0), torrent (1), or unlimited (2) limit.
 public     Double	   seedRatioLimit          ;//    | double                     ;
 public     Long	   seedRatioMode           ;//    | number                     ;
 public     Long	   sizeWhenDone            ;//    | Size of the torrent download in bytes.           
 public     Long	   startDate               ;//    | The date when the torrent was last started.   
 public     Long	   status                  ;//    | number                     ;
 public     HashMap<String, Object>[]	   trackers                ;//    | array (see below)          ;
 public     HashMap<String, Object>[]	   trackerStats            ;//    | array (see below)          ;
 public     Long	   totalSize               ;//    | Total size of the torrent in bytes         
 public     String	   torrentFile             ;//    | Path to .torrent file      
 public     Long	   uploadedEver            ;//    | Number of bytes uploaded, ever.         
 public     Long	   uploadLimit             ;//    | number                     ;
 public     Boolean	   uploadLimited           ;//    | boolean                    ;
 public     Double	   uploadRatio             ;//    | double                     ;
 public     Long[]	    wanted                  ;//    | array (see below)          ;
 public     HashMap<String, Object>[]            webseeds                ;//    | array (see below)          ;
 public     Long	   webseedsSendingToUs     ;//    | number                     ;

        @Override
        public String toString() {
            return "Torrents{" + "\ndownloadDir=" + downloadDir + ",\nerrorString=" + errorString + ",\nid=" + id + ",\nisFinished=" + isFinished + ",\nname=" + name + ",\npercentDone=" + percentDone + ",\nrateDownload=" + rateDownload + ",rateUpload=" + rateUpload + ", secondsDownloading=" + secondsDownloading + ", sizeWhenDone=" + sizeWhenDone + ",\nstatus=" + status +",\nleftUntilDone "+leftUntilDone+'}';
        }

        // Returns the torrent status. Is either one of ‘check pending’, ‘checking’, ‘downloading’, ‘seeding’ or ‘stopped’. The first two is related to verification.
    
    
    
    }
    
    public static class Arguments {
        public Torrents  torrents[];
        
       

         @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("torrent {\n");
            int row = 1;
            for (Torrents torr : torrents) {
                
                sb.append("\n").append(row).append(") ");
                sb.append(torr);
//                 for (Map.Entry<String, Object> entrySet : torr.entrySet()) {
//                        String key = entrySet.getKey();
//                        Object value = entrySet.getValue();
//                        
//                        sb.append(key).append(":").append(value).append(", ");
//                 
//                 }
                        
                
          
                
                
                row++;
            }
            sb.append("}");
            return sb.toString();
            
        } 
        
        
    }
 
    
    public static final String[] ALL_FIELDS = new String[]{
        "activityDate",               
        "addedDate",                   
        "bandwidthPriority",           
        "comment",                     
        "corruptEver",                 
        "creator",                     
        "dateCreated",                 
        "desiredAvailable",            
        "doneDate",                    
        "downloadDir",                 
        "downloadedEver",              
        "downloadLimit",               
        "downloadLimited",             
        "error",                       
        "errorString",                 
        "eta",                         
        "etaIdle",                     
        "files",                       
        "fileStats",                   
        "hashString",                  
        "haveUnchecked",               
        "haveValid",                   
        "honorsSessionLimits",         
        "id",                          
        "isFinished",                  
        "isPrivate",                   
        "isStalled",                   
        "leftUntilDone",               
        "magnetLink",                  
        "manualAnnounceTime",          
        "maxConnectedPeers",           
        "metadataPercentComplete",     
        "name",                        
        "peer-limit",                  
        "peers",                       
        "peersConnected",              
        "peersFrom",                   
        "peersGettingFromUs",          
        "peersSendingToUs",            
        "percentDone",                 
        "pieces",                      
        "pieceCount",                  
        "pieceSize",                   
        "priorities",                  
        "queuePosition",               
        "rateDownload",          
        "rateUpload",            
        "recheckProgress",             
        "secondsDownloading",          
        "secondsSeeding",              
        "seedIdleLimit",               
        "seedIdleMode",                
        "seedRatioLimit",              
        "seedRatioMode",               
        "sizeWhenDone",                
        "startDate",                   
        "status",                      
        "trackers",                    
        "trackerStats",                
        "totalSize",                   
        "torrentFile",                 
        "uploadedEver",                
        "uploadLimit",                 
        "uploadLimited",               
        "uploadRatio",                 
        "wanted",                      
        "webseeds",                    
        "webseedsSendingToUs"         
            };
    // public static Long uploadRate(){}
   
              
}
