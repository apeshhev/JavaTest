public class DeckOfCardsTest
{
    public static void main( String args[] )
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();

        for ( int i = 0; i < 13; i++ )
        {
            System.out.printf( "%-20s%-20s%-20s%-20s\n",
                    myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
                    myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
        }
    }
}