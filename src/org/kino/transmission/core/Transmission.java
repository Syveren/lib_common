/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.core;

import org.kino.transmission.request.TorrentAddRequst;
import org.kino.transmission.request.Method;
import org.kino.transmission.responce.TorrentGetResponce;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.MatchResult;
import javax.imageio.IIOException;
import org.apache.commons.codec.binary.Base64;
import org.kino.transmission.request.TorrentGetRequest;
import org.kino.transmission.responce.Responce;
import org.kino.transmission.responce.SessionGetResponce;
import org.kino.transmission.responce.SessionStatsResponce;
import org.kino.transmission.responce.TorrentAddResponce;
 

/**
 *
 * @author kirio
 */
public class Transmission {

    /*

    ВАЖНО!!!
    Для работы нужно использовать hashString, а не id  
    
    (т.к id в трансмишне не постоянные и могут меняться =(
    from transmission src code:
    > @brief Returns this torrent's unique ID.
    > IDs are good as simple lookup keys, but are not persistent
    > between sessions.  If you need that, use tr_info.hash or
    > tr_info.hashString.
    )
    */
    
    
    
    
   
    
    
    
    
    
    
    
    public Transmission(String host, Integer port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }
    
    
    
     final   static private Gson gson = new Gson();
 
     
     
    public final  static String ACT_TORRENT_START="torrent-start";    
    public final  static String ACT_TORRENT_START_NOW="torrent-start-now";
    public final  static String ACT_TORRENT_STOP="torrent-stop";
    public final  static String ACT_TORRENT_VERIFY="torrent-verify";
    public final  static String ACT_TORRENT_REANNOUNCE="torrent-reannounce";
     
 
    //test
    
     public  void torrent_rename_path(String torrent_hash,String path,String newName) throws IOException {
         
        Long id = getIdByHashString(torrent_hash);
        if(id==null)
            return;
        torrent_rename_path(id, path, newName);
    
    }
     
    private void torrent_rename_path(long id,String path,String newName) throws IOException {
     
 
        HashMap<String,Object> arguments = new HashMap<>();
        arguments.put("ids", new Long[]{id});
        arguments.put("path", path);
        arguments.put("name", newName);
        Method method = new Method("torrent-rename-path", arguments);
        String toJson = gson.toJson(method);
 
        String responce = sendRequest(toJson);
        System.out.println("responce:"+responce);
      //  return gson.fromJson(responce, TorrentGetResponce.class);
    
    }
    
    public void torrent_action(String action,String torren_hash) throws IOException{
        Long[] ids = null;
        if(torren_hash!=null)
         {
            Long id = getIdByHashString(torren_hash);
            if(id==null)
                return;
            ids = new Long[]{id};
         }
         torrent_action(action,ids);
     }
    
    private void torrent_action(String action,Long[] ids) throws IOException{
         switch(action)
         {
             case ACT_TORRENT_START:
             case ACT_TORRENT_START_NOW:     
             case ACT_TORRENT_STOP:
             case ACT_TORRENT_VERIFY: 
             case ACT_TORRENT_REANNOUNCE: 
                 break;
             default: throw new IllegalArgumentException();

         }
         HashMap<String,Object> arguments = new HashMap<>();
         if(ids!=null)
            arguments.put("ids", ids);
         Method method = new Method(action, arguments);
         
         String responce = sendRequest(gson.toJson(method));
         System.out.println(responce);
         
     }
     public Responce session_set(HashMap<String,Object> arguments)throws IOException{
         Method method = new Method("session-set", arguments);
        String responce = sendRequest(gson.toJson(method));
        return gson.fromJson(responce, Responce.class);
 
     
     }
     public SessionGetResponce session_get()throws IOException{
        Method method = new Method("session-get", null);
        String responce = sendRequest(gson.toJson(method));
        return gson.fromJson(responce, SessionGetResponce.class);
 
     
     }
     public Responce set_download_upload_limit(long download,long upload) throws IOException{
        HashMap<String,Object> arguments = new HashMap<>();
        arguments.put("speed-limit-down-enabled", download>=0);
        if(download>=0)
            arguments.put("speed-limit-down", download);
        arguments.put("speed-limit-up-enabled", upload>=0);
        if(upload>=0)
            arguments.put("speed-limit-up", upload);
        return session_set(arguments);
     }
   
     
    // Получить id торрента по его хештрингу
    public Long getIdByHashString(String hashString) throws IOException {
        TorrentGetResponce torrent_get = torrent_get(new String[]{"id","hashString"},(Long[])null);
        if(!"success".equals(torrent_get.result))
             throw new IOException("torrent-get return error: "+torrent_get.result);
        for(TorrentGetResponce.Torrents torrent:torrent_get.arguments.torrents){
            if(torrent.hashString.equals(hashString))
                return torrent.id;
        
        }
        return null; // not found
    }
    
    public TorrentGetResponce torrent_get(String [] fieds,String torrent_hash) throws IOException{
         Long[] ids = null;
         if(torrent_hash!=null)
         {
            Long id = getIdByHashString(torrent_hash);
            if(id==null)
             return null;
            ids = new Long[]{id};
         }
         return torrent_get(fieds, ids);
    }
    
    private TorrentGetResponce torrent_get(String [] fieds,Long ... ids) throws IOException{
        
         TorrentGetRequest arguments = new TorrentGetRequest(fieds);
         arguments.ids = ids; 
       
        Method method = new Method("torrent-get", arguments);
 
        String toJson = gson.toJson(method);
               
        String responce = sendRequest(toJson);
        System.out.println(responce);
        return gson.fromJson(responce, TorrentGetResponce.class);
    }
     
    
    
    
     public TorrentAddResponce torrent_add(TorrentAddRequst requst) throws IOException{
        String toJson = gson.toJson(new Method("torrent-add", requst));
        String responce = sendRequest(toJson);
        return gson.fromJson(responce, TorrentAddResponce.class);
         
     }

    public TorrentAddResponce torrent_add(String path_to_torrent,String download_dir) throws IOException{
    
        TorrentAddRequst requst = new TorrentAddRequst();
        Path path = Paths.get(path_to_torrent);
        byte[] data = Files.readAllBytes(path);
        requst.metainfo =  Base64.encodeBase64String(data);
        requst.download_dir= download_dir;
        return torrent_add(requst);
 
    
    }
      public TorrentAddResponce torrent_add(String path_to_torrent) throws IOException{
    
        TorrentAddRequst requst = new TorrentAddRequst();
        Path path = Paths.get(path_to_torrent);
        byte[] data = Files.readAllBytes(path);
        requst.metainfo =  Base64.encodeBase64String(data);
        return torrent_add(requst);
 
    
    }
      
     public Responce torrent_remove(String torrent_hash,boolean delete_local_data) throws IOException{
         Long id = getIdByHashString(torrent_hash);
         if(id==null)
               return null;
      
         return torrent_remove(new Long[]{id}, delete_local_data);
         
     } 
      
     private Responce torrent_remove(Long[] ids,boolean delete_local_data) throws IOException{
 
        HashMap<String,Object> arguments = new HashMap<>();
        arguments.put("ids", ids);
        arguments.put("delete-local-data", delete_local_data);
        Method method = new Method("torrent-remove", arguments);
        String toJson = gson.toJson(method);
 
        String responce = sendRequest(toJson);
        
        Responce resp = gson.fromJson(responce, Responce.class);
        return resp;
        //System.out.println("responce:"+responce);

    
    }
    
    
    public SessionStatsResponce getSessionStats() throws IOException {

        Method method = new Method("session-stats", null);
        String toJson = gson.toJson(method);
        String responce = sendRequest(toJson);
        SessionStatsResponce raw_responce = gson.fromJson(responce, SessionStatsResponce.class);
        return raw_responce;

    }
    
    
    
    
    final private String host;
    final private Integer port;
    final private String user;
    final private String password;
    
    
    
    private String sendRequest(String command) throws IOException{
        
        try {
 	
                String url = host+":"+port+"/transmission/rpc/";
		URL obj = new URL(url);
                
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
             
		con.setRequestMethod("POST");  
                con.setRequestProperty("Authorization", "Basic " + Base64.encodeBase64String((user+":"+password).getBytes()));

		con.setDoOutput(true);
                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.writeBytes(command);
                    wr.flush();
                }
 
		int responseCode = con.getResponseCode();
                if(responseCode==409)
                {
                    // PARSE RESPONSE FOR 409 
                    //<h1>409: Conflict</h1><p>Your request had an invalid session-id header.</p>
                    //<p>To fix this, follow these steps:<ol><li>
                    //When reading a response, get its X-Transmission-Session-Id header and remember it<li> 
                    //Add the updated header to your outgoing requests<li> 
                    //When you get this 409 error message, resend your request with the updated header</ol></p><p>
                    //This requirement has been added to help prevent <a href="http://en.wikipedia.org/wiki/Cross-site_request_forgery">CSRF</a> attacks.</p><p>
                    //<code>X-Transmission-Session-Id: vESIDDI52XfBn0e74aPw8Idnnmg0v4kpsJU7jcZBtCidcJtX</code></p>
                
                    String x_transmission_session_id;
                 
                    try (Scanner scanner = new Scanner(con.getErrorStream())) {
                        
                        scanner.findWithinHorizon("<code>X-Transmission-Session-Id:\\s*(\\w+)</code>", 0);
                        MatchResult result = scanner.match();
                        x_transmission_session_id = (result.groupCount()!=1?null:result.group(1));
                    }
                    if(x_transmission_session_id==null)
                            throw new NullPointerException("X-Transmission-Session-Id not found");
                    con = (HttpURLConnection) obj.openConnection();
               
                    //add reuqest header
                    con.setRequestMethod("POST");  
                
                    con.setRequestProperty("Authorization", "Basic " + Base64.encodeBase64String((user+":"+password).getBytes()));
                     con.setRequestProperty("X-Transmission-Session-Id", x_transmission_session_id);
                    con.setDoOutput(true);
                    try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                        wr.writeBytes(command);
                        wr.flush();
                    }
                    responseCode = con.getResponseCode();
                
                
                }
                
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + command);
		System.out.println("Response Code : " + responseCode);

                StringBuffer response;
                try (BufferedReader in = new BufferedReader(new InputStreamReader(responseCode==200?con.getInputStream(): con.getErrorStream()))) {
                    String inputLine;
                    response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
                    }
                }
                if(responseCode!=200)
                {
                    throw  new IOException(response.toString());
                }
		//print result
		return response.toString();
 
        }catch(Throwable e){
        
            System.out.println(e);
            throw  new IIOException(e.getLocalizedMessage());
        }
    
    }
    
}
