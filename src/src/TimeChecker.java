/* Name: Group 6

   Member names & IU code
    Trần Văn Đạt - ITITIU21173
    Nguyễn Phạm Đức Anh - ITITIU21033
    Phạm Thế Thiện - ITDSIU20084
    Trịnh Tiến Đạt - ITDSIU20109

    Purpose: Minesweeper, a puzzle game about uncovering safe areas while avoiding hidden mines. It's a test of logic and quick decision-making.
*/

/**

 * This interface has a static method to convert milliseconds to a string representation of the
 * corresponding time.
 */
public interface TimeChecker
{
    /**
     * This static method could return a string representation of the cost time by the given running time.
     * @param time the running time between the game starts and ends.
     * @return a string representation of the cost time.
     */
    static String calculateTime(long time)
    {
        int CONVERT_TO_SEC = 1000;
        int CONVERT_TO_OTHERS = 60;

        int ms = (int) time;
        int sec = ms / CONVERT_TO_SEC;
        int min = sec / CONVERT_TO_OTHERS; // Seconds convert to minutes.
        int hr = min / CONVERT_TO_OTHERS; // Minutes convert to hours.

        if (hr == 0)
        {
            if(min == 0)
            {
                if (sec == 0)
                    return ms + " ms";
                else
                    return sec + " sec " + ms % 1000 + " ms";
            } else
                return min + " min " + sec % CONVERT_TO_OTHERS + " sec " + ms % CONVERT_TO_SEC + " ms";
        } else
            return hr + " hour " + min % CONVERT_TO_OTHERS + " min " + sec % CONVERT_TO_OTHERS + " sec " + ms % CONVERT_TO_SEC + " ms";
    }
}