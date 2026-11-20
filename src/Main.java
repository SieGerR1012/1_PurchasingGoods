import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Молоко", "Хлеб", "Гречневая крупа", "Яблоки"};
        int[] prices = {50, 14, 80, 110};

        int[] basket = new int[products.length];    // Массив для хранения количества выбранных товаров

        int sumProducts = 0;                        // Переменная для итоговой суммы чека

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        // 3. Цикл ввода покупок
        while (true) {
            System.out.println("Выберите товар и количество.");
            System.out.println("Для завершения работы введите введите `end` или 'конец'");
            String inputString = scanner.nextLine();

            if (inputString.equals("end") || inputString.equals("конец")) {
                break;
            }

            // Разделение введённой строку по пробелу на две части
            String[] parts = inputString.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1; // Вычитаем 1, т.к. индексация с 0
            int productCount = Integer.parseInt(parts[1]);

            basket[productNumber] += productCount;              // Добавление кол-ва в ячейку корзины

            int currentPrice = prices[productNumber];
            sumProducts += currentPrice * productCount;
        }

        // 4. Вывод корзины и итоговой суммы
        System.out.println("Ваша корзина:");
        System.out.println("Наименование товара | Количество | Цена/за.ед | Общая стоимость");
        for (int i = 0; i < products.length; i++) {
            // Выводим только те товары, которые пользователь положил в корзину
            if (basket[i] > 0) {
                int totalProductPrice = basket[i] * prices[i];
                System.out.println(products[i] + " " + basket[i] + " " + prices[i] + " " + totalProductPrice);
            }
        }
        System.out.println("Итого " + sumProducts);
    }
}
