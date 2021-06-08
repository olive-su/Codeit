public class GreatestDifferenceFinder {
    public int greatestDifference(int intArray[]){
        if (intArray.length < 2)
            return 0;
        int max = intArray[0];
        int min = intArray[0];
        for (int i : intArray){
            if (max < i)
                max = i;
            else if (min > i)
                min = i;
        }
        return max - min;
    }
}

