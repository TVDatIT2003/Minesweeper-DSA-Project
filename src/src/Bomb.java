/* Name: Group 6

   Member names & IU code
    Trần Văn Đạt - ITITIU21173
    Nguyễn Phạm Đức Anh - ITITIU21033
    Phạm Thế Thiện - ITDSIU20084
    Trịnh Tiến Đạt - ITDSIU20109

    Purpose: Minesweeper, a puzzle game about uncovering safe areas while avoiding hidden mines. It's a test of logic and quick decision-making.
*/

/**
 * This class is abstract and should be extended to provide the domain specific functionality.
 */
public abstract class Bomb
{
    /** The GameBoard instance**/
    protected GameBoard board;

    /** The height of this GameBoard instance**/
    protected int boardHeight;

    /** The width of this GameBoard instance**/
    protected int boardWidth;

    /**
     * Create bombs, which can be placed on a GameBoard.
     * @param board the GameBoard upon which user clicks on.
     */
    public Bomb(GameBoard board)
    {
        this.board = board;
        // Both height and width of the board should remove its padding values.
        boardHeight = (board.getHeight() - 20) / 20;
        boardWidth = (board.getWidth() - 20) / 20;
    }

    /**
     * A method that is invoked when producing bombs on the game board.
     */
    protected abstract void reproduceBomb();

}