class Educator {

    public static void main(String []args){
        AI start = new AI(new float[]{1,0,-1,1,0,-1,0,0.1f,0,0.5f,0,-0.4f,0,1,0,0,-0.001f,0});

        int res = result(start);
        while(res<100000){
            AI best = start;
            for(int i=0; i<3000; i++){
                AI child = new AI(start, 50f);
                int child_res = result(child);
                if(res<child_res){
                    res=child_res;
                    best=child;
                }
            }
            start = best;
            start.output();
            System.out.println(res);
        }
    }

    static int result(AI ai){
        int res = 0;
        for (int i=0; i<5; i++){
            res += new Simulator(ai).run();
        }
        return res/5;
    }
}
