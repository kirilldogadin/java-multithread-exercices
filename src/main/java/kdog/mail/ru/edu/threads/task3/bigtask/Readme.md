Создать свой "планировщик задач". *
Нужно имплементировать интерфейс

Требования:
Реализовать все методы в интерфейсе
1. Задачи должны быть отменяемыми
Этот пункт самый важный, можно использовать механизмы Прерывания изученные ранее
public void run() {
  while (Thread.currentThread().isInterrupted()) {
    someHeavyComputations();
  }
}

2. Должна быть возможность именовать задачи и пулы
*3. Должна быть возможность один раз дать название для всех задач в пуле, например Task + порядковый номер или время запуска
2. Должно быть мягкое завершение - отмена новых задач, и доделывание старых
4. Должно быть жесткое завершение - завершение всех задач
5. Логика/метод который дает время на "мягкое завершение", если оно не происходит , то выполнить жесткое
"5. Доложен быть некий монитор статуса/статистики выполнения потоков
6. ДОлжен быть система обнаружения "зависших задач"
7. Ошибки должны логироваться
7* должна быть какая-то реакция на ошибки/перезапуск(определенное кол-во раз)
8. Действия должны логироваться(задача запущена, отменена, выполнена) - 
должно быть информативное именование , осмысленное название пула и потока
8. Должна быть возможность отложенного запуска задач