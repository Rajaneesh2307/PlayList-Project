import java.util.ArrayList;
import java.util.LinkedList;

public class Album
{
    private String AlbumName;
    private String Artist;
    static ArrayList<Song> Songs = new ArrayList<>();
    public Album(String AlbumName, String artist)
    {
        AlbumName = AlbumName;
        Artist = artist;
    }
    public Album()
    {

    }
    public static Song FindSong(String Title)
    {
        for (Song CheckedSong : Songs)
        {
            if (CheckedSong.getTitle().equals(Title))
            {
                return CheckedSong;
            }
        }
        return null;
    }
    public static boolean AddSong(String SongName, Double Duration)
    {
        if (FindSong(SongName) == null)
        {
            Songs.add(new Song(SongName, Duration));
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean AddToPlayList(int TrackNumber, LinkedList<Song> PlayList)
    {
        int Index = TrackNumber - 1;
        if (Index > 0 && Index <= Songs.size())
        {
            PlayList.add(Songs.get(Index));
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean AddToPlayList(String SongName, LinkedList<Song> PlayList)
    {
        for (Song CheckedSong : Songs)
        {
            if (CheckedSong.getTitle().equals(SongName)) {
                PlayList.add(CheckedSong);
                return true;
            }
        }
        return false;
    }
}
