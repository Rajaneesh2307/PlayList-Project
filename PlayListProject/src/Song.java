public class Song 
{
    private String Title;
    private Double Duration;
    public Song(String title, Double duration)
    {
        Title = title;
        Duration = duration;
    }
    public Song()
    {

    }
    public String getTitle()
    {
        return Title;
    }
    public Double getDuration()
    {
        return Duration;
    }
    @Override
    public String toString()
    {
        return "Song{" +
                "Title='" + Title + '\'' +
                ", Duration=" + Duration +
                '}';
    }
}
