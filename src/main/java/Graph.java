

public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private char[] temp_arr = new char[10];
    private char[] temp_rez = new char[10];
    private int size;
    private Stack stack;
    private Queue queue;

    public Graph(){
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }

        }
    }

    //Сделал на массивах - очередь долго реализовывать.

    /*private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] > 0 && vertexList[i].wasVisited == false){
                //tempMat
                return adjMat[ver][i];
            }
        }

        return -1;
    }*/

    public void dfs(){
        //queue = new Queue();
        vertexList[0].wasVisited = true;

        int glob_temp = -1;
        int glob_rez = 0;
        for (int j = 0; j < size - 1; j++) {
            if(adjMat[0][j] > 0) {
                //Добавление букв маршрута
                arrAdd(vertexList[0].label);
                arrAdd(vertexList[j].label);
                vertexList[j].wasVisited = true;
                glob_rez = adjMat[0][j] + getPuth(j);
                if (glob_temp == -1) {
                    glob_temp = glob_rez;
                    arrCopy();//Копирование массива букв маршрута
                }else if (glob_temp > glob_rez) {
                    glob_temp = glob_rez;
                    arrCopy();//Копирование массива букв маршрута
                }
                arrClear();
            }
        }
        System.out.println("Кратчайший маршрут:");
        for (int i = 0; i < temp_arr.length; i++) {
            if(temp_arr[i] == '\u0000')
                break;
            System.out.println(temp_arr[i]);
        }
        System.out.println("Длина: " + glob_temp);
        for(int i=0; i<size; i++) // Сброс флагов
            vertexList[i].wasVisited = false;
    }

    public int getPuth(int arg) {
        int temp = 0;
        int i = arg;
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j] > 0 && vertexList[j].wasVisited == false) {
                    if(j < 9) {//Если не финиш, то дальше
                        vertexList[j].wasVisited = true;
                        arrAdd(vertexList[j].label);
                        temp = adjMat[i][j] + getPuth(j);
                    }else {//Если финиш то возвращаем значение
                        temp = adjMat[i][j];
                        arrAdd(vertexList[j].label);
                    }
                }
            }
        return temp;
    }

    public void arrAdd(char arg) {
        for (int k = 0; k < 10; k++) {
            if (temp_rez[k] == '\u0000') {
                temp_rez[k] = arg;
                break;
            }
        }
    }

    public void arrCopy() {

        for (int k = 0; k < 10; k++)
            temp_arr[k] = temp_rez[k];

        arrClear();
    }

    public void arrClear() {

        for (int k = 0; k < 10; k++)
            temp_rez[k] = '\u0000';

    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int ves){
        adjMat[start][end] = ves;
        adjMat[end][start] = ves;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }

}
