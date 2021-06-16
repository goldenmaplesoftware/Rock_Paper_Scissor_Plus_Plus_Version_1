package sample.selections;

import java.util.Objects;

public class player_rock
{
private String name;
private int select;

    public player_rock()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public player_rock(String name, int selection)
    {
        this.name=name;
        this.select=1;
        System.out.println("Rock has been selected");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        player_rock that = (player_rock) o;
        return select == that.select && Objects.equals(name, that.name);
    }

}
