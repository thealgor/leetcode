/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth = Integer.MIN_VALUE;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        findDepth(nestedList,1);
        return depthSum(nestedList, 0);
    }


    public int depthSum(List<NestedInteger> nestedList, int depth){
        int ret=0;
        for(NestedInteger n: nestedList){
            ret += n.isInteger()? n.getInteger()*(maxDepth-depth): depthSum(n.getList(),depth+1);
        }
        return ret;
    }


    public void findDepth(List<NestedInteger> nestedList, int depth){
        for(NestedInteger n: nestedList){
            if(n.isInteger()){
                maxDepth = Math.max(depth, maxDepth);
            }
            else{
                findDepth(n.getList(),depth+1);
            }
        }
    }


}