import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        task1();

        System.out.println("\nЗадача 2");
        task2();

        System.out.println("\nЗадача 3");
        int year = 1201;
        task3(year);

        System.out.println("\nЗадача 4");
        var random = new Random();
        int deliveryDistance = random.nextInt(120);
        System.out.println("randomly generated delivery distance: " + deliveryDistance);
        task4(deliveryDistance);

        System.out.println("\nЗадача 5");
        int monthNumber = 5;
        task5(monthNumber);
    }

    //Задача 1
    //У банка появилось мобильное приложение. Поэтому теперь, когда пользователь заходит на сайт с телефона, ему предлагается скачать приложение с учетом того, какая операционная система у пользователя.
    //
    //Напишите программу, которая определяет, чем пользуется клиент (iOS или Android), и выдает соответствующее сообщение:
    //
    //Для iOS — «Установите версию приложения для iOS по ссылке».
    //Для Android — «Установите версию приложения для Android по ссылке».
    //Объявите переменную clientOS, которая равна 0 или 1 (0 — iOS, 1 — Android).
    public static void task1() {
        int osId = 0;

        var phone = new Phone(osId); //Существует ли в Джаве возможность задать дефолтное значение для аргумента? Или прописать его в конструкотре - норм? (речь про поле clientDeviceYear)
        if (phone.getDeviceOS() == null) {
            System.out.println("Упс! Похоже, ваш телефон не поддерживается :(");
        } else {
            System.out.printf("Установите версию приложения для %s по ссылке\n", phone.getDeviceOS());
        }
    }

    //Задача 2
    //Усложним предыдущую задачу. Теперь нам нужно знать не только операционную систему телефона, но и год его создания.
    //Ваша задача — написать программу, которая выдает соответствующее сообщение клиенту при наличии двух условий.
    //Если год выпуска ранее 2015 года, то к сообщению об установке нужно добавить информацию об облегченной версии:
    //Для iOS оно будет звучать так: «Установите облегченную версию приложения для iOS по ссылке».
    //Для Android: «Установите облегченную версию приложения для Android по ссылке».
    //Для пользователей телефонов 2015 года выпуска и позже нужно вывести обычное предложение об установке приложения.
    //Для года создания телефона используйте переменную clientDeviceYear, в которой необходимо указать 2015 год.
    //Важно: вложенность больше двух этажей не допускается (условный оператор внутри условного оператора).
    public static void task2() {
        int outOfSupport = 2005;
        int oldPhoneCotOffPoint = 2015;
        Phone phone = new Phone(1, 2017);

        if (phone.getDeviceYear() < outOfSupport || phone.getDeviceOS() == null) {
            System.out.println("Упс! Похоже, ваш телефон не поддерживается :(");
        } else if (phone.getDeviceYear() < oldPhoneCotOffPoint) {
            System.out.printf("Установите облегченную версию приложения для %s по ссылке\n", phone.getDeviceOS());
        } else {
            System.out.printf("Установите версию приложения для %s по ссылке\n", phone.getDeviceOS());
        }
    }

    //Задача 3
    //Напишите программу, которая определяет, является ли год високосным или нет.
    //Переменную года назовите year, в которую можно подставить значение интересующего нас года. Например, 2021.
    //Программа должна определять, високосный год или нет, и выводить соответствующее сообщение: « …. год является
    //високосным» или «... год не является високосным».
    //Небольшая справка: високосным является каждый четвертый год, но не является каждый сотый. Также високосным
    //является каждый четырехсотый год.
    public static void task3(int year) {
        int leapYearPeriod = 4;
        int leapYearException = 100;
        int leapYearExceptionOverride = 400;

        if (year % leapYearPeriod == 0 && year % leapYearException != 0 || year % leapYearExceptionOverride == 0) {
            System.out.printf("%s год - високосный\n", year);
        } else {
            System.out.printf("%s год - не високосный\n", year);
        }
    }

    //Задача 4
    //В банке для клиентов организовывается доставка карт на дом. Чтобы известить клиента о том, когда будет доставлена
    //его карта, нужно знать расстояние от офиса до адреса доставки.
    //Правила доставки такие:
    //Доставка в пределах 20 км занимает сутки.
    //Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
    //Доставка в пределах 60 км до 100 км добавляет еще одни сутки.
    //Свыше 100 км доставки нет.
    //То есть с каждым следующим интервалом доставки срок увеличивается на 1 день.
    //Напишите программу, которая выдает сообщение в консоль: "Потребуется дней: " + срок доставки.
    //Объявите целочисленную переменную deliveryDistance = 95, которая содержит дистанцию до клиента.

    public static void task4(int deliveryDistance) {
        int firstLimit = 20;
        int secondLimit = 60;
        int thirdLimit = 100;
        int deliveryTime = 1;

        if (deliveryDistance <= firstLimit) {
            System.out.println("Доставка займет " + deliveryTime + " день");
        } else if (deliveryDistance <= secondLimit) {
            deliveryTime += 1;
            System.out.println("Доставка займет " + deliveryTime + " дня");
        } else if (deliveryDistance <= thirdLimit) {
            deliveryTime += 2;
            System.out.println("Доставка займет " + deliveryTime + " дня");
        } else {
            System.out.println("Слишком далеко, доставки нет.");
        }
    }

    //Задача 5
    //Напишите программу, которая определяет по номеру месяца в году, к какому сезону этот месяц принадлежит.
    //Например, 1-й месяц (он же январь) принадлежит к сезону зима.
    //Для написания программы используйте оператор switch. Для обозначения номера месяца используйте переменную monthNumber = 12.
    //Пропишите условие, при котором программа не будет выполняться (номер месяца больше 12).
    public static void task5(int monthNumber) {
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                System.out.println(Month.getMonthName(monthNumber) + " - зимний месяц");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println(Month.getMonthName(monthNumber) + " - весенний месяц");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(Month.getMonthName(monthNumber) + " - летний месяц");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(Month.getMonthName(monthNumber) + " - осенний месяц");
                break;
            default:
                System.out.println("Нет такого месяца");
        }
    }
}