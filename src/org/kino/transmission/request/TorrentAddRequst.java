/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.request;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author kirio
 */

public class TorrentAddRequst {

          public String   cookies; 
          @SerializedName("download-dir")
          public String download_dir; 
          public String filename;
          public String metainfo;
          public Boolean paused;
          @SerializedName("peer-limit")
          public Long peer_limit;
          
          public Long bandwidthPriority;
          @SerializedName("files-wanted")
          public Object files_wanted;
          @SerializedName("files-unwanted")
          public Object files_unwanted;
          @SerializedName("priority-high")
          public Object priority_high;
          @SerializedName("priority-low")
          public Object priority_low;
          @SerializedName("priority-normal")
          public Object priority_normal;

 
 
}
