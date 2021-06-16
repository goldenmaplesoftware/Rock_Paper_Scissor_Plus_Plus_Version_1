package sample.selections;

public class player_fire
{
private String name;
private int select;

    public player_fire()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public player_fire(String name, int selection)
    {
        this.name=name;
        this.select=4;
        System.out.println("Fire has been selected");
    }



}
