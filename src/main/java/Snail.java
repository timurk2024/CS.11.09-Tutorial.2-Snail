public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */

    public static int[] flattenSnail(int[][] array2d)
    {
        // check if the 2D array is square. If it's not, return an empty 1D array.
        if (!isSquare(array2d))
        {
            int[] emptyArr = new int[0];
            return emptyArr;
        }

        int n = array2d.length;
        int[] result = new int[n * n];
        int index = 0;

        // edges of the spiral
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        //iterate through the 2D array until all elements are added to the result 1D array.
        // 4 for loops each represent oen direction of the spiral

        while (index < n * n ) // n * n is just result.length
        {
            // left to right along the top row
            for (int i = left; i <= right; i++)
            {
                result[index++] = array2d[top][i];
            }
            //incrementing top to move the edge down
            top++; //top=1

            //goes from top to bottom along the right column
            for (int i = top; i <= bottom; i++)
            {
                result[index++] = array2d[i][right];
            }
            //decrementing right to move the edge left
            right--; //right =n-2

            // goes from right to left along the bottom row (decrementing bottom to move the edge up)
            if (top <= bottom)
            {
                for (int i = right; i >= left; i--)
                {
                    result[index++] = array2d[bottom][i];
                }
                //decrementing bottom to move the edge up
                bottom--; //bottom = n-2
            }

            if (left <= right)
            {
                for (int i = bottom; i >= top; i--)
                {
                    result[index++] = array2d[i][left];
                }
                // incrementing left to move the edge right
                left++; //left = 1
            }
        }
        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */

    public static int[][] makeSnail(int[] array1d)
    {
        // check if the 1d array's length is a perfect square. If not, return an empty 2D array
        if (!isPerfectSquare(array1d))
        {
            int[][] empty2DArr = new int[0][0];
            return empty2DArr;
        }

        int length = array1d.length;
        int n = (int) Math.sqrt(length);
        int[][] result = new int[n][n];

        int index = 0;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (index < length)
        {
            for (int i = left; i <= right; i++)
            {
                result[top][i] = array1d[index++];
            }
            top++;

            for (int i = top; i <= bottom; i++)
            {
                result[i][right] = array1d[index++];
            }
            right--;

            if (top <= bottom)
            {
                for (int i = right; i >= left; i--)
                {
                    result[bottom][i] = array1d[index++];
                }
                bottom--;
            }

            if (left <= right)
            {
                for (int i = bottom; i >= top; i--)
                {
                    result[i][left] = array1d[index++];
                }
                left++;
            }
        }
        return result;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */

    private static void print1dArray(int[] array1d)
    {
        for (int i : array1d)
        {
            System.out.println(i);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */

    private static void print2dArray(int[][] array2d)
    {
        for (int[] row : array2d)
        {
            print1dArray(row);
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */

    private static boolean isPerfectSquare(int[] array1d)
    {
        int length = array1d.length;
        double root = Math.sqrt(length);
        return root % 1 == 0;
    }

    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */

    private static boolean isSquare(int[][] array2d)
    {
        int height = array2d.length; // as the length gives the number of rows

        for (int[] row : array2d)
        {
            if (row.length != height)
            {
                return false;
            }
        }
        return true;
    }
}
