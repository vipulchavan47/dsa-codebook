package array.easy;


// Use selection sort to find the tallest person and swap (swap both the height and person)
public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;

        for(int i=0; i < n; i++){
            int maxIndex = i;

            for(int j = i + 1; j < n; j++){
                if(heights[j] > heights[maxIndex ])
                    maxIndex  = j;
            }

            int tempHeight = heights[maxIndex];
            heights[maxIndex] = heights[i];
            heights[i] = tempHeight;

            String tempName = names[maxIndex];
            names[maxIndex] = names[i];
            names[i] = tempName;

        }

        return names;
    }
}
