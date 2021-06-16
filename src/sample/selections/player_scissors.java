package sample.selections;

public class player_scissors
{
private String name;
private int select;

    public player_scissors()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public player_scissors(String name, int selection)
    {
        this.name=name;
        this.select=3;
        System.out.println("Scissors has been selected");
    }



}
