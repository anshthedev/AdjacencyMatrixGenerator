public class FleuryAlgorithim{

    // 0  1  1  0
    // 1  0  1  0
    // 1  1  0  1
    // 0  0  1  0


    // +-----+
    //   \+/ 
    //    |
    //    +

    static int[][] array = {{0,1,1,0},{1,0,1,0},{1,1,0,1}, {0,0,1,0}};
    public static void main(String[] args) {
        // int numberOfOddVertices = findNumberOddVertices(array);
        
        // if(numberOfOddVertices == 0){
        //     possibleCircut(array);
        // }else if(numberOfOddVertices == 2){
        //     // possiblePath(array, numberOfOddVertices);
        // }else{
        //     System.out.println("No Paths or Circuts");
        // }

        System.out.println(canReachAllVertices(array));


        
    }

    // public static int[][] possiblePath(int[][] array, int numberOfOddVertices){
    //     oddVerticesLocation(array, numberOfOddVertices);

    // }

    // public static int[][] possibleCircut(int[][] array){
    //     int[][] result = array.clone();


    // }

    public static boolean canReachAllVertices(int[][] array, int startingVertex){
        boolean result = false;
        int safeVertex = 0;
        int[][] pathsCompleted = array.clone();

        for (int i = 0; i < pathsCompleted.length; i++) {
            for (int j = 0; j < pathsCompleted.length; j++) {
                if(array[i][j]==1){
                    i=j;
                    safeVertex = array[i][j];
                }
            }
        }




        return result;
    }

    public static int[] oddVerticesLocation(int[][] array, int numberOfOddVertices){
        int[] result = new int[numberOfOddVertices];
        int sumOfDegree = 0;
        int resultLocation = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j]==1){
                    sumOfDegree++;
                }
            }
            if(sumOfDegree%2 == 1){
                result[resultLocation] = i+1;
                resultLocation++;
            }
            sumOfDegree = 0;
        }

        return result;

    }

    public static int findNumberOddVertices(int[][] array){
        int sumOfDegree = 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j]==1){
                    sumOfDegree++;
                }
            }
            if(sumOfDegree%2 == 1){
                result++;
            }
            sumOfDegree = 0;

        }
        return result;
    }
}