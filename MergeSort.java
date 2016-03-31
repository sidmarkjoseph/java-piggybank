
public class MergeSort {
    
	int a[] = new int[100];
	void setA(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			this.a[i] = a[i];
		}
	}
	void sort(int lowerindex,int higherindex)
	{
		if(lowerindex< higherindex)
		{
			int middle=lowerindex+(higherindex-lowerindex)/2;
			sort(lowerindex,middle);
			sort(middle+1,higherindex);
			merge(lowerindex,middle,higherindex);
		}
       
	}
	void merge(int low,int middle,int high)
	{
		int temparr[]= new int[high+1];
		for(int i=low;i<=high;i++)
		{
			temparr[i] = a[i]; 
		}
		int i=low;
		int j=middle+1;
		int k = low;
		while(i<=middle && j<=high)
		{
			if(temparr[i]>temparr[j])
			{
				a[k] = temparr[j];
				j++;
			}
			else
			{
				a[k]=temparr[i];
				i++;
			}
			k++;
		}
		while(i<=middle)
		{
			a[k]=temparr[i];
			k++;
			i++;
		}
		while(j<=high)
		{
			a[k]=temparr[j];
			k++;
			j++;
		}
	}
	void display()
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args)
	{
		int a[]={2,1,3,5,4};
		MergeSort obj = new MergeSort();
		obj.setA(a);
		obj.sort(0,a.length-1);
		obj.display();
		
		
	}
	

}
