package cn.suiseiseki.www.floatingcloud.model;

/**
 * Created by Suiseiseki on 2016/3/14.
 */
public class Music {
    private String title; // Music Name
    private String album; // Music album
    private long albumId;// album Id
    private String artist; //
    private long duration; // duration of Music
    private long size; // size of Music
    private String sizeStr;// size of Music in String
    private String path; // path of Music;
    private int type; // 0 -> Local 1 -> Internet
    private String albumUrl; // photo url of album
    private String downUrl;// download path of Music
    private boolean valid;// whether the music is Valid
    private long playProgress;//Meaning as name

    /**
     *
     * return surplus progress of music
     */
    public int getSurplusProgress() {
        int surplusProgress = (int) (duration - playProgress);
        if (surplusProgress < 0) {
            surplusProgress = 0;
        }
        return surplusProgress;
    }

    /**
     * a set of Getter and Setter :)
     * @return
     */
    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getSizeStr() {
        return sizeStr;
    }

    public void setSizeStr(String sizeStr) {
        this.sizeStr = sizeStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }



}
