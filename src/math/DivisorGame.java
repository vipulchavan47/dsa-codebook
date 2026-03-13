package math;
/*
Alice and Bob take turns playing a game, with Alice starting first.
Initially, there is a number n on the chalkboard. On each player's turn,
that player makes a move consisting of:

Choosing any integer x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.

Return true if and only if Alice wins the game, assuming both players play optimally.
 */


/*
Game theory principle:
A position is winning if you can move to a losing position.
A position is losing if all moves lead to winning positions.
 */
public class DivisorGame {
    public boolean divisorGame(int n) {
        if(n % 2 == 0){
            return true;
        }

        return false;
    }
}

/*
Example 1: n = 1
Divisors less than 1? None.
No move → lose.
So:
n = 1 → Losing position.

Example 2: n = 2
Divisors of 2 less than 2 → only 1.
Alice subtracts 1 → n = 1
Bob gets 1 → and we already know 1 is losing.
So Bob loses → Alice wins.
n = 2 → Winning.

Example 3: n = 3
Divisors less than 3 → only 1.
Alice subtracts 1 → n = 2
Bob gets 2 → which is a winning position.
So Bob wins → Alice loses.
n = 3 → Losing.

Example 4: n = 4
Divisors less than 4 → 1, 2.
Alice has options.
If she subtracts 1 → n = 3 (losing position).
If she subtracts 2 → n = 2 (winning position).
Smart players choose losing positions for opponents.
So she subtracts 1 → gives 3 to Bob.
3 is losing → Bob loses.
n = 4 → Winning.

Example 5: n = 5
Divisors less than 5 → only 1.
Alice subtracts 1 → n = 4 (winning position).
Bob wins → Alice loses.
n = 5 → Losing.

Now look at the pattern:
1 → L
2 → W
3 → L
4 → W
5 → L
6 → W
7 → L
8 → W

Every even number is Winning.
Every odd number is Losing.

Why this keeps happening:
    Odd numbers only have odd divisors.
    Odd − odd = even.

So if you start odd, you must give even to opponent.
If you start even, you can always subtract 1 (which is valid), giving odd to opponent.
 */