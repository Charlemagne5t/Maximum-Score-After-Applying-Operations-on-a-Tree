import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        int[][] edges = {
                {0,1},
                {0,2},
                {0,3},
                {2,4},
                {4,5},
        };
        int[] values = {5,2,5,2,1,1};
        long expected = 11;
        long actual = new Solution().maximumScoreAfterOperations(edges, values);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        int[][] edges = {
                {0,1},
                {0,2},
                {1,3},
                {1,4},
                {2,5},
                {2,6},
        };
        int[] values = {20,10,9,7,4,3,5};
        long expected = 40;
        long actual = new Solution().maximumScoreAfterOperations(edges, values);

        Assert.assertEquals(expected, actual);
    }
}
