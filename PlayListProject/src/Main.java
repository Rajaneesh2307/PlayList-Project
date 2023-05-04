import java.util.*;

public class Main {
    static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args)
    {
        Album album = new Album("Chalo","Thaman");
        album.AddSong("Choosi Chudangane", 3.22);
        album.AddSong("Ammaye Challo Antu", 4.00);
        album.AddSong("Drunk and Drive", 3.48);
        album.AddSong("Chal Govada", 3.12);
        album.AddSong("Cheppave Balamani", 4.23);
        albums.add(album);

        album = new Album("Malli Malli Idi Rani Roju", "Anirudh");
        album.AddSong("Gathama Gathama", 4.21);
        album.AddSong("Yenno Yenno", 5.12);
        album.AddSong("Choti Zindagi", 4.27);
        album.AddSong("Marhaba", 5.22);
        album.AddSong("Varinche Prema", 3.42);
        albums.add(album);

        LinkedList<Song> PlayList = new LinkedList<>();
        album.AddToPlayList("Varinche Prema", PlayList);
        album.AddToPlayList("Drunk and Drive", PlayList);
        album.AddToPlayList("Choosi Chudangane", PlayList);
        album.AddToPlayList("Gathama Gathama", PlayList);
        album.AddToPlayList("Marhaba", PlayList);
        album.AddToPlayList("Yenno Yenno", PlayList);

        Play(PlayList);
    }
    public static void Play(LinkedList<Song> playlist)
    {
        Scanner sc = new Scanner(System.in);
        boolean Quit = false;
        boolean Forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        while (!Quit)
        {
            int Action = sc.nextInt();
            sc.nextLine();
            switch (Action)
            {
                case 0:
                    System.out.println("PlayList is Complete");
                    Quit = true;
                    break;
                case 1:
                    if (!Forward)
                    {
                        if (listIterator.hasNext())
                            listIterator.next();
                    }
                    Forward = true;
                    if (listIterator.hasNext())
                    {
                        System.out.println("Now we switch to next song the song is " + listIterator.next().toString());
                    }
                    else
                    {
                        System.out.println("Now we reach the end of the playlist.");
                        Forward = false;
                    }
                    break;
                case 2:
                    if (Forward)
                    {
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                    }
                    Forward = false;
                    if (listIterator.hasPrevious())
                    {
                        System.out.println("Now we switch to previous song the song is " + listIterator.previous().toString());
                    }
                    else
                    {
                        System.out.println("Now we are in the First song of playlist.");
                        Forward = false;
                    }
                    break;
                case 3:
                    if (playlist.size() == 0)
                    {
                        System.out.println("In this playlist no such song.");
                    }
                    else {
                        System.out.println("Current Playing song is " + listIterator.next().toString());
                    }
                    break;
                case 4:
                    if (playlist.size() > 0)
                    {
                        listIterator.remove();
                        if (listIterator.hasNext())
                        {
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else
                        {
                            if (listIterator.hasPrevious())
                            {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }
                    }
                    break;
                case 5:
                    PrintList(playlist);
                    break;
                case 6:
                    PrintMenu();
                    break;
            }
        }
    }
    public static void PrintList(LinkedList<Song> playlist)
    {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("----------------------------------------------");
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------------------");
    }
    public static void PrintMenu()
    {
        System.out.println("Available Options");
        System.out.println("Press-0 To Quit..");
        System.out.println("Press-1 To Move to Next Song");
        System.out.println("Press-2 To Move to Previus Song");
        System.out.println("Press-3 To Play Current Song");
        System.out.println("Press-4 To Delete a Song");
        System.out.println("Press-5 To Print the List of Songs in PlayList");
        System.out.println("Press-6 To Print Menu..");
    }
}