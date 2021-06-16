package sample.selections;

public class player_paper
{
private String name;
private int select;

    public player_paper()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public player_paper(String name, int selection)
    {
        this.name=name;
        this.select=2;
        System.out.println("Paper has been selected");
    }



}
