package binarysearch.medium;
/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked (the number I picked stays the same throughout the game).

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.
 */
public class GuessNumbeHigherOrLower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int ans = guess(mid);

            if(ans == 0){
                return mid;
            }
            else if(ans == 1){
                left = mid+1;
            }
            else if(ans == -1){
                right = mid-1;
            }
        }

        return 0;
    }

    int guess(int num){
        int pick = 10;
        if(num == pick){
            return 0;
        }
        else if(num > pick){
            return -1;
        }
        else {
            return 1;
        }
    }
}
