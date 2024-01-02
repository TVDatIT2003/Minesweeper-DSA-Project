/* Name: Group 6

   Member names & IU code
    Trần Văn Đạt - ITITIU21173
    Nguyễn Phạm Đức Anh - ITITIU21033
    Phạm Thế Thiện - ITDSIU20084
    Trịnh Tiến Đạt - ITDSIU20109

    Purpose: Minesweeper, a puzzle game about uncovering safe areas while avoiding hidden mines. It's a test of logic and quick decision-making.
*/

import java.util.Random;

public class ProduceBombs extends Bomb
{

    public ProduceBombs(GameBoard board, int number)
    {

        super(board);

        int count =0;

        do {
            reproduceBomb();
            count++;
        }while (count < number);
    }

    /**
     * This method produce bombs on random square. If the assigned square has already contained a bomb, then
     * reassign a square to receive this bomb by invoking itself.
     */
    public void reproduceBomb()
    {
        Random r = new Random();

        int xLocation = r.nextInt(boardWidth);
        int yLocation = r.nextInt(boardHeight);

        SmartSquare square = (SmartSquare) board.getSquareAt(xLocation, yLocation);

        if (!square.getBombExist())
        {
            // mark this square as it has a bomb and been traversed.
            square.setBombExist(true);
            square.setTraverse(true);
        } else {
            reproduceBomb();
        }
    }
}