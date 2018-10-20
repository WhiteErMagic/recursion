import java.util.Scanner;

public class Main {
    private static String[] knapsack;
    private static float[] sum_weight;
    private static int temp = 0;
    private static int knapsack_number;
    private static String[] items = {"Гитара1500", "Магнитовон2200", "Ноутбук3000", "Фотоаппарат1000", "Часы500"};
    private static int[] items_weight = {1, 3, 2, 1, 1};

    public static void main(String[] args) {

        //Возведение в степень
        System.out.println("Возведение в степень");
        System.out.println("Введите цифру для возведения в степень:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Введите степень:");
        int stepen = scanner.nextInt();
        System.out.println(vstepen(number, stepen));


        //Заполняем рюкзак
        System.out.println();
        System.out.println("Заполняем рюкзак");
        int items_sum[] = {1500, 2200, 3000, 1000, 500};
        sum_weight = new float[5];

        //Заполним массив стоимость на вес
        for (int i = 0; i < 5; i++) {
            sum_weight[i] = items_sum[i]/items_weight[i];
        }

        //Сортируем по убыванию
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                if (sum_weight[i] < sum_weight[j]) {
                    float temp = sum_weight[i];
                    sum_weight[i] = sum_weight[j];
                    sum_weight[j] = temp;

                    //Приводим в соответствие массив товаров
                    String strtemp = items[i];
                    items[i] = items[j];
                    items[j] = strtemp;

                    //Приводим в соответствие массив весов
                    int weighttemp = items_weight[i];
                    items_weight[i] = items_weight[j];
                    items_weight[j] = weighttemp;

                    //Приводим в соответствие массив стоимостей
                    int sumtemp = items_sum[i];
                    items_sum[i] = items_sum[j];
                    items_sum[j] = sumtemp;
                }
            }
        }

        System.out.println("Задайте объем рюкзака (1-5):");
        Scanner scanner_knapsack = new Scanner(System.in);
        knapsack_number = scanner_knapsack.nextInt();

        knapsack = new String[knapsack_number];
        addItem(0, 0);

        System.out.println("Посмотрим рюкзак");
        for (int i = 0; i < knapsack_number; i++) {
            if (knapsack[i] != null)
                System.out.println(knapsack[i]);
        }
    }

    //Рекурсия сборка рюкзака
    public static void addItem(int ind_i, int ind_j) {
        for (int i = ind_i; i < items.length; i++) {
            if (temp < knapsack_number) {
                if (temp + items_weight[i] <= knapsack_number) {
                    temp = temp + items_weight[i];
                    knapsack[ind_j] = items[i];
                    addItem(++i, ++ind_j);
                }
            } else
                return;
        }
    }

    //Рекурсия возведения в степень
    public static int vstepen(int number, int stepen){
        if(stepen > 1) {
            return number * vstepen(number, stepen - 1);
        }else {
            return number;
        }
    }
}
