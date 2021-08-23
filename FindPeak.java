import java.util.Scanner;

class FindPeak {
    public static int findPeakElement(int[] nums) {
        
    	int n = nums.length;
        if(n == 1)
            return 0;
        if(n == 2)
        {
            return nums[0]>nums[1]?0:1;
        }
        
        int end = n-1;
        int beg = 0;
        int mid = 0;
        while(beg<=end)
        {
            mid=(beg+end)/2;
            if(mid-1>=0 && nums[mid]>nums[mid-1] && mid+1<n && nums[mid]>nums[mid+1])
            {
                return mid;
            }
            else if(mid-1>=0 && nums[mid]<nums[mid-1])
                end=mid-1;
            else
                beg=mid+1;
            
        }
        return beg-1;
    }
    
    public static void main(String args[])
    {
    	Scanner sc= new Scanner(System.in);
    
    	int n = sc.nextInt();
    	int a[] = new int[n];
    	for(int i=0;i<n;i++)
    	{
    		a[i] = sc.nextInt();
    	}
    	
    	System.out.print(findPeakElement(a));
    	
    	sc.close();
    }
}