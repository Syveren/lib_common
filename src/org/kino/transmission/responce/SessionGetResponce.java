/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kino.transmission.responce;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author kirio
 */
public class SessionGetResponce extends  Responce<SessionGetResponce.Arguments>{
    public static class Arguments {
        @SerializedName("alt-speed-down")
        public Long  alt_speed_down ;                          // number     | max global download speed (KBps)

        @SerializedName("alt-speed-enabled")
        public Boolean   alt_speed_enabled;                  // boolean    | true means use the alt speeds

        @SerializedName("alt-speed-time-begin")
        public Long  alt_speed_time_begin;        // number     | when to turn on alt speeds (units: minutes after midnight)

        @SerializedName("alt-speed-time-enabled")
        public Boolean   alt_speed_time_enabled;      // boolean    | true means the scheduled on/off times are used

        @SerializedName("alt-speed-time-end")
        public Long  alt_speed_time_end;          // number     | when to turn off alt speeds (units: same)

        @SerializedName("alt-speed-time-day")
        public Long  alt_speed_time_day;          // number     | what day(s) to turn on alt speeds (look at tr_sched_day)

        @SerializedName("alt-speed-up")
        public Long  alt_speed_up;                // number     | max global upload speed (KBps)

        @SerializedName("blocklist-url")
        public String   blocklist_url;               // string     | location of the blocklist to use for "blocklist_update"

        @SerializedName("blocklist-enabled")
        public Boolean   blocklist_enabled;           // boolean       | true means enabled

        @SerializedName("blocklist-size")
        public Long  blocklist_size;              // number     | number of rules in the blocklist

        @SerializedName("cache-size-mb")
        public Long  cache_size_mb;               // number     | maximum size of the disk cache (MB)

        @SerializedName("config-dir")
        public String   config_dir;                  // string     | location of transmission's configuration directory

        @SerializedName("download-dir")
        public String   download_dir;                // string     | default path to download torrents

        @SerializedName("download-queue-size")
        public Long  download_queue_size;         // number     | max number of torrents to download at once (see download_queue_enabled)

        @SerializedName("download-queue-enabled")
        public Boolean   download_queue_enabled;      // boolean    | if true, limit how many torrents can be downloaded at once

        @SerializedName("dht-enabled")
        public Boolean   dht_enabled;                 // boolean    | true means allow dht in public torrents

        @SerializedName("encryption")
        public String   encryption;                  // string     | "required", "preferred", "tolerated"

        @SerializedName("idle-seeding-limit")
        public Long  idle_seeding_limit;          // number     | torrents we're seeding will be stopped if they're idle for this long

        @SerializedName("idle-seeding-limit-enabled")
        public Boolean   idle_seeding_limit_enabled;  // boolean    | true if the seeding inactivity limit is honored by default

        @SerializedName("incomplete-dir")
        public String   incomplete_dir;              // string     | path for incomplete torrents, when enabled

        @SerializedName("incomplete-dir-enabled")
        public Boolean   incomplete_dir_enabled;      // boolean    | true means keep torrents in incomplete_dir until done

        @SerializedName("lpd-enabled")
        public Boolean   lpd_enabled;                 // boolean    | true means allow Local Peer Discovery in public torrents

        @SerializedName("peer-limit-global")
        public Long  peer_limit_global;           // number     | maximum global number of peers

        @SerializedName("peer-limit-per-torrent")
        public Long  peer_limit_per_torrent;      // number     | maximum global number of peers

        @SerializedName("pex-enabled")
        public Boolean   pex_enabled;                 // boolean    | true means allow pex in public torrents

        @SerializedName("peer-port")
        public Long  peer_port;                   // number     | port number

        @SerializedName("peer-port-random-on-start")
        public Boolean   peer_port_random_on_start;   // boolean    | true means pick a random peer port on launch

        @SerializedName("port-forwarding-enabled")
        public Boolean   port_forwarding_enabled;     // boolean    | true means enabled

        @SerializedName("queue-stalled-enabled")
        public Boolean   queue_stalled_enabled;       // boolean    | whether or not to consider idle torrents as stalled

        @SerializedName("queue-stalled-minutes")
        public Long  queue_stalled_minutes;       // number     | torrents that are idle for N minuets aren't counted toward seed_queue_size or download_queue_size

        @SerializedName("rename-partial-files")
        public Boolean   rename_partial_files;        // boolean    | true means append ".part" to incomplete files

        @SerializedName("rpc-version")
        public Long  rpc_version;                 // number     | the current RPC API version

        @SerializedName("rpc-version-minimum")
        public Long  rpc_version_minimum;         // number     | the minimum RPC API version supported

        @SerializedName("script-torrent-done-filename")
        public String   script_torrent_done_filename; // string     | filename of the script to run

        @SerializedName("script-torrent-done-enabled")
        public Boolean   script_torrent_done_enabled; // boolean    | whether or not to call the "done" script

        @SerializedName("seedRatioLimit")
        public Long  seedRatioLimit;              // double     | the default seed ratio for torrents to use

        @SerializedName("seedRatioLimited")
        public Boolean   seedRatioLimited;            // boolean    | true if seedRatioLimit is honored by default

        @SerializedName("seed-queue-size")
        public Long  seed_queue_size;             // number     | max number of torrents to uploaded at once (see seed_queue_enabled)

        @SerializedName("seed-queue-enabled")
        public Boolean   seed_queue_enabled;          // boolean    | if true, limit how many torrents can be uploaded at once

        @SerializedName("speed-limit-down")
        public Long  speed_limit_down;            // number     | max global download speed (KBps)

        @SerializedName("speed-limit-down-enabled")
        public Boolean   speed_limit_down_enabled;    // boolean    | true means enabled

        @SerializedName("speed-limit-up")
        public Long  speed_limit_up;              // number     | max global upload speed (KBps)

        @SerializedName("speed-limit-up-enabled")
        public Boolean   speed_limit_up_enabled;      // boolean    | true means enabled

        @SerializedName("start-added-torrents")
        public Boolean   start_added_torrents;        // boolean    | true means added torrents will be started right away

        @SerializedName("trash-original-torrent-files")
        public Boolean    trash_original_torrent_files; // boolean    | true means the .torrent file of added torrents will be deleted

        @SerializedName("units")
        public Object   units;                       // object     | see below

        @SerializedName("utp-enabled")
        public Boolean   utp_enabled;                 // boolean    | true means allow utp

        @SerializedName("version")
        public String   version;                     // string     | long version string "$version ($revision)"
    }
}
