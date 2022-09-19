package providers;

import java.util.Arrays;

public class Result {

    private char[] chars;
    private int data;

    public Result(char[] chars,int data)
    {
        setChars(chars);
        setData(data);
    }

    public char[] getChars()
    {
        return Arrays.copyOf(chars, chars.length);
    }

    public void setChars(char[] newChars)
    {
        chars = Arrays.copyOf(newChars, newChars.length);
    }

    public int getData()
    {
        return data;
    }

    public void setData(int newData)
    {
        data = newData;
    }

    public String toString()
    {
        return String.format(Arrays.toString(chars), data);
    }

}
