package sample.selections;

public class player_wind
{
private String name;
private int select;

    public player_wind()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public player_wind(String name, int selection)
    {
        this.name=name;
        this.select=6;
        System.out.println("Wind has been selected");
    }



}
