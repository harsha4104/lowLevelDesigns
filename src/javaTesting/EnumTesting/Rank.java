package javaTesting.EnumTesting;

public enum Rank {

    FIRST(1, "first"), SECOND(2, "second"), THIRD(3, "third"), FORTH(4, "fourth");

    int rankValue;

    String rankString;

    Rank(int value, String rankString){
        this.rankValue = value;
        this.rankString = rankString;
    }

    public int getRankValue() {
        return this.rankValue;
    }

    public String getRankString(){
        return this.rankString;
    }
}
