package exam.linear;

public class TheCardGame {
    static boolean booleanTran(boolean value){
        return !value;
    }

    public static void main(String[] args){
        boolean[] cards = new boolean[52];
        for (int i = 0; i < 52; i++){
            cards[i] = true;
        }
        for (int i = 2; i <= 52; i++){
            int currentCard = 0;
            while (currentCard + i <=52){
                currentCard += i;
                cards[currentCard-1] = booleanTran(cards[currentCard-1]);
            }
        }
        System.out.print("正面朝上的牌是：");
        for (int i = 0; i < 52; i++){
            if (cards[i]){
                System.out.print(i+1 + " ");
            }
        }
    }
}
