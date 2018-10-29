public class SimpleHashSet {
    int[] head; // массив голов
    int[] next; // массив ссылок на следующий элемент
    int[] keys; // массив с ключами (вместо int'а следует поставить нужный тип)
    int headNum; // количество голов
    int cnt = 1; // ссылка на место для вставки нового эдемента

     SimpleHashSet(int headNum, int maxSize) {
         this.headNum = headNum;
         head = new int [headNum];
         next = new int [maxSize + 1];
         keys = new int [maxSize + 1];
     }

     boolean add(int x) {
         if (this.contains(x))
                 return false;
         int h = index(hash(x));
         next[cnt] = head[h];
         keys[cnt] = x;
         head[h] = cnt++;
         return true;
     }

     boolean contains(int x) {
         int h = index(hash(x));
         for (int i = head[h]; i != 0; i = next[i])
                 if (keys[i] == x)
                     return true;
         return false;
     }

     int hash(int x) {
         return (x >> 15) ^ x;
     }
     int index(int hash) {
         return Math.abs(hash) % headNum;
     }
}
