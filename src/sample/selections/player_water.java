package sample.selections;

public class player_water
{
private String name;
private int select;

    public player_water()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public player_water(String name, int selection)
    {
        this.name=name;
        this.select=5;
        System.out.println("Water has been selected");
    }



}
