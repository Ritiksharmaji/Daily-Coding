package src.Intermediate_1.Day_7_Lab_Session_on_Prefix_Sum_and_Carry_Forward.ClassVideo;
/*
## --------- Problem-5: Closest Min & Max(given an array find length of smallest subarray which
 contain both min and max of array
(related to Carry-forward) -----
 */
public class Problem_5 {

    // Brute Force
    public static int closestMinMaxBF(int[] array){

        int n=array.length;

        int min=array[0];
        int max=array[0];

        for(int i=1;i<n;i++){
            min=Math.min(min,array[i]);
            max=Math.max(max,array[i]);
        }

        if(min==max)
            return 1;

        int ans=Integer.MAX_VALUE;

        for(int start=0;start<n;start++){

            for(int end=start;end<n;end++){

                boolean minFound=false;
                boolean maxFound=false;

                for(int k=start;k<=end;k++){

                    if(array[k]==min)
                        minFound=true;

                    if(array[k]==max)
                        maxFound=true;

                }

                if(minFound && maxFound){

                    ans=Math.min(ans,
                            end-start+1);

                }

            }

        }

        return ans;
    }

    // Optimized
    public static int closestMinMaxOptimize(int[] array){

        int n=array.length;

        int min=array[0];
        int max=array[0];

        for(int i=1;i<n;i++){

            min=Math.min(min,array[i]);
            max=Math.max(max,array[i]);

        }

        if(min==max)
            return 1;

        int lastMin=-1;
        int lastMax=-1;

        int ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            if(array[i]==min){

                lastMin=i;

                if(lastMax!=-1){

                    ans=Math.min(ans,
                            i-lastMax+1);

                }

            }

            if(array[i]==max){

                lastMax=i;

                if(lastMin!=-1){

                    ans=Math.min(ans,
                            i-lastMin+1);

                }

            }

        }

        return ans;
    }

    public static void main(String[] args){

        int[] array={2,6,1,6,9,1,9};

        System.out.println(
                "Brute Force : "
                        +closestMinMaxBF(array));

        System.out.println(
                "Optimized : "
                        +closestMinMaxOptimize(array));

    }
}
