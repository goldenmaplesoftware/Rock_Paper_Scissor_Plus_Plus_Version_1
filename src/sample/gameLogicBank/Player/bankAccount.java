package sample.gameLogicBank.Player;
/**
 * THIS IS THE OBJECT THAT DISPLAYS BUT ALSO DICTATES HOW MUCH MONEY THE PLAYER HAS
 */
public class bankAccount
{
    public double balance;
    public double moneyWon;
    public double moneyLost;
    public double wager;
    public double wagerBet;
    public double winningMultiple;

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        balance=5.00;
        this.balance = balance;
    }

    public double getMoneyWon()
    {
        return moneyWon;
    }

    public void setMoneyWon(double moneyWon)
    {
        this.moneyWon = moneyWon;
    }

    public double getMoneyLost()
    {
        return moneyLost;
    }

    public void setMoneyLost(double moneyLost)
    {
        this.moneyLost = moneyLost;
    }

    public double getWager()
    {
        return wager;
    }

    public void setWager(double wager)
    {
        this.wager = wager;
    }

    public double getWagerBet()
    {
        return wagerBet;
    }

    public void setWagerBet(double wagerBet)
    {
        this.wagerBet = wagerBet;
    }

    public double getWinningMultiple() {
        return winningMultiple;
    }

    public void setWinningMultiple(double winningMultiple)
    {
        this.winningMultiple = winningMultiple;
    }
}
