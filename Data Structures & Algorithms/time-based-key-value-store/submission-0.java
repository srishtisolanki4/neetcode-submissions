class TimeMap {
    Map<String,List<Pair<Integer,String>>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k-> new ArrayList<>()).add(new Pair<>       (timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> val=map.getOrDefault(key,new ArrayList<>());
        int l=0,r=val.size()-1;
        String res="";

        while(l<=r){
            int mid=l+(r-l)/2;
            if(val.get(mid).getKey()<=timestamp){
                res=val.get(mid).getValue();
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}
