class Solution {
    class Car{
        int pos;
        int speed;

        Car(int p, int s){
            this.pos=p;
            this.speed=s;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st=new Stack<>();
        Car cars[]=new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (a,b)->Integer.compare(b.pos,a.pos));

        for(int i=0;i<cars.length;i++){
            double dist=(double)(target-cars[i].pos)/cars[i].speed;
            if(!st.isEmpty() && dist<=st.peek()){
               continue;
            }
            st.push(dist);
        }
        return st.size();
    }
}
