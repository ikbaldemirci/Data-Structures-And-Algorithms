
public class QuickFindQuickUnion {
    private int[] id;
    private int exchanges;
    private int finds;

    public QuickFindQuickUnion(int N){
        id = new int[N];
        for(int i=0; i<N; i++)  id[i] = i;
    }

    public int getexchanges(){
        return exchanges;
    }

    public int getfinds(){
        return finds;
    }

    public int find(int p){
        return id[p];
    }

    //  UNION PART

    public void quickfind(int p, int q){
        finds++;
        int pid = id[p];
        int qid = id[q];

        if (qid != pid) {
            exchanges++;

            for(int i=0; i<id.length; i++){
                if (id[i] == pid)   qid = pid;
            }
        }    
    }

    //  UNION PART

    private int root(int i){
        while (i != id[i]){
            i = id[i];
             finds++;
        }
        return i;
    }

    public void quickunion(int p, int q){
        finds++;

        int rootP = root(p);
        int rootQ = root(q);
        if (rootP != rootQ) {
            exchanges++;
            id[rootP] = rootQ;            
        }
    }

    
    //  MAIN CALLER METHOD
    public void findreq(){
        int[] inputData = {0,1,2,3,4,5};
        QuickFindQuickUnion q = new QuickFindQuickUnion(inputData.length);

        //  QUICK FIND RUN
        q.quickfind(0, 1);
        q.quickfind(1, 2);
        q.quickfind(2, 3);

        //  QUICK UNION RUN
        QuickFindQuickUnion q2 = new QuickFindQuickUnion(inputData.length);
        q2.quickunion(0, 1);
        q2.quickunion(1, 2);
        q2.quickunion(2, 3);

        int exchanges = q.getexchanges();
        int finds = q.getfinds();

        System.out.println("Exchanges : " + exchanges);
        System.out.println("Finds : " + finds);

    }

    // MAIN METHOD
    public static void main(String[] args) {
        QuickFindQuickUnion quickFindQuickUnion = new QuickFindQuickUnion(0);
        quickFindQuickUnion.findreq();
    }
}       