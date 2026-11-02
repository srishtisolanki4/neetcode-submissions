class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cnt[]=new int[26];
        for(char ch:tasks){
            cnt[ch-'A']++;
        }

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int f:cnt){
            if(f>0){
                maxHeap.add(f);
            }
        }

        Queue<int[]> q= new LinkedList<>();//rem_cnt,time+n
        int time=0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time=q.peek()[1];
            }else{
                int count=maxHeap.poll();
                int rem_cnt=count-1;
                if(rem_cnt>0){
                    q.add(new int[]{rem_cnt,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
