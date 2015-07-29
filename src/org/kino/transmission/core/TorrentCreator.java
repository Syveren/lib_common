/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author kirio
 */
public class TorrentCreator {
    
    // timeconsuming operation !!!
     public void generateTorrentFile(String src,String torrentFileName,String trackerUrl,boolean isPrivate) throws Exception {
         ProcessBuilder pb = new ProcessBuilder("transmission-create",isPrivate?"-p":"","-t",trackerUrl,"-o",torrentFileName,src);
         Process proc = pb.start();
         try {
             proc.waitFor(); //!!!! processing for huge files takes several minutes or even HOURS !!!
             
         } catch (InterruptedException ex) {
             throw  new Exception("create torrent file interrupted");
         }
         int exitValue = proc.exitValue();
         if(exitValue!=0)
         {
             try (BufferedReader br = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {
                 StringBuilder builder = new StringBuilder();
                 char[] buff = new char[8096];
                 int len = 0;
                 while ((len = br.read(buff,0,buff.length)) != -1) {
                     builder.append(buff,0,len);
                 }
                 builder.toString();
                 throw new Exception("cant generate torrent-file:"+builder.toString());
             }
         }
         else {
              try (BufferedReader br = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {
                 StringBuilder builder = new StringBuilder();
                 char[] buff = new char[8096];
                 int len = 0;
                 while ((len = br.read(buff,0,buff.length)) != -1) {
                     builder.append(buff,0,len);
                 }
                 builder.toString();
                 // transmission-create show error in stdout
                 if(builder.length()!=0)
                      throw new Exception("cant generate torrent-file:"+builder.toString());
                
             }
         }
     
     
     }
}
