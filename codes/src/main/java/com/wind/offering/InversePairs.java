package com.wind.offering;

public class InversePairs {
    public int InversePairs(int [] array) {
        return mergeSort(array, 0, array.length) % 1000000007;
    }

    private int mergeSort(int[] array, int start, int end) {
        if (start+1 < end) {
            int mid = start + (end - 1 - start)/2;
            int left = mergeSort(array, start, mid+1);
            int right = mergeSort(array, mid+1, end);
            return left + right + merge(array, start, mid+1, mid+1, end);
        }
        return 0;
    }

    private int merge(int[] array, int lstart, int lend, int rstart, int rend) {
        int count = 0;
        int[] container = new int[rend - lstart];
        int index = 0;
        int oldstart = lstart;
        while (lstart < lend && rstart < rend) {
            if (array[lstart] > array[rstart]) {
                container[index] = array[rstart];
                rstart ++;
                count += lend - lstart;
                if (count == 1000000007) {
                    count = 0;
                }
            } else {
                container[index] = array[lstart];
                lstart ++;
            }
            index ++;
        }

        while (lstart < lend) {
            container[index ++] = array[lstart ++];
        }

        while (rstart < rend) {
            container[index ++] = array[rstart ++];
        }

        for (int i=0; i!=container.length; i++) {
            array[oldstart ++] = container[i];
        }

        return count;
    }

    // 暴力解法，会超时
    public int violentCompare(int[] array) {
        int count = 0;
        for (int i=0; i!=array.length-1; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[i] > array[j]) {
                    count ++;
                }
            }
        }
        return count%1000000007;
    }

    public int InversePairs2(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;

    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}
