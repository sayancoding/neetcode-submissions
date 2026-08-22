class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 0) return 0;

        double[][] cars = new double[n][2];
        for(int i = 0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b)-> Double.compare(a[0], b[0]));

        Stack<Double> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            double time = ( target - cars[i][0] ) / cars[i][1] ;
            if(st.isEmpty() || time > st.peek()) st.push(time);
        }

        return st.size();
    }
}
